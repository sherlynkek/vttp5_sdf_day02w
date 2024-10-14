package src;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BankAccount {
    
    private final String holderName;
    private String accNo;
    private float balance;
    private List<String> transactions;
    private boolean isClosed;
    private Date createDate;
    private Date closedDate;

    public static void main(String[] args) {
        // Creating a new bank account with default balance
        BankAccount account1 = new BankAccount("Mary");
        System.out.println(account1); // Output the account details
 
        // Depositing money into the account
        account1.deposit(1000.50f);
        System.out.println("After deposit: " + account1.getBalance());
        
        // Withdraw money from the account
        account1.withdraw(200.00f);
        System.out.println("After withdrawal: " + account1.getBalance());
 
        // Check transaction history
        System.out.println("Transactions: " + account1.getTransactions());
 
        // Close the account
        account1.setClosed(true);
        System.out.println("Account status: " + (account1.isClosed() ? "Closed" : "Open"));
 
        // Try depositing money into a closed account (should throw exception)
        try {
            account1.deposit(500.00f);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
 
        // Check the final state of the account
        System.out.println(account1);
 
        // Creating a second bank account with initial balance
        BankAccount account2 = new BankAccount("Alex", 500.00f);
        System.out.println(account2);
 
        // Withdraw from the second account
        account2.withdraw(150.00f);
        System.out.println("After withdrawal: " + account2.getBalance());
        System.out.println("Transactions: " + account2.getTransactions());
     }

    public BankAccount(String holderName) {
        this.holderName = holderName;
        this.accNo = generateAccNo();
        this.balance = 0.00f;

        ZoneId defaultZone = ZoneId.systemDefault();
        this.createDate = Date.from(LocalDate.now().atStartOfDay(defaultZone).toInstant());

        
        transactions = new ArrayList<>();
        
    }

    public BankAccount(String holderName, float balance) {
        this.holderName = holderName;
        this.accNo = generateAccNo();
        this.balance = balance;

        transactions = new ArrayList<>();
    }

    private String generateAccNo() {
        int startAsciiNo = 65;
        int endAsciiNo = 90;
        int accLengthNo = 10;

        Random random = new Random();
        String accNo = "";

        for (int i = 0; i < accLengthNo; i++) {
            int randomValue = startAsciiNo + (int) (random.nextFloat() * (endAsciiNo - startAsciiNo + 1));
            accNo = accNo + (char) randomValue;
        }
        
        return accNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getAccNo() {
        return accNo;
    }

    public float getBalance() {
        return this.balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public void setClosed(boolean isClosed) {
        
        if (isClosed && !this.isClosed) {
            ZoneId defaultZone = ZoneId.systemDefault();
            this.closedDate = Date.from(LocalDate.now().atStartOfDay(defaultZone).toInstant());

        }
        this.isClosed = isClosed;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }
    
    public void deposit(float amount) {

        if (!this.isClosed) {
            if (amount > 0.00f) {
                this.balance = this.balance + amount;
                this.balance += amount;

                transactions.add("deposit amount $" + amount + " at " + LocalDate.now().toString());
            }
            else {
                throw new IllegalArgumentException("Deposit amount must be greater than 0");
            }
        }
        else {
            throw new IllegalArgumentException("Account is closed. Transaction aborted");
        }
    }

    public void withdraw(float amount) {
        if (!this.isClosed) {
            if (amount > 0.00f && amount <= this.balance) {
                this.balance = this.balance - amount;

                transactions.add("withdraw amount $" + amount + " at " + LocalDate.now().toString());
            }
            else {
                throw new IllegalArgumentException("Withdraw amount cannot be more than balance");
            }
        }
        else {
            throw new IllegalArgumentException("Account is closed. Transaction aborted");
        }
    }
    
    @Override
    public String toString() {
        return "BankAccount {" + "holderName=' " + holderName + '\'' + ", accNo='" + accNo + '\'' +
           ", balance=" + balance +
           ", transactions=" + transactions +
           ", isClosed=" + isClosed +
           ", createDate=" + createDate +
           ", closedDate=" + closedDate +
           '}';
    }
}
