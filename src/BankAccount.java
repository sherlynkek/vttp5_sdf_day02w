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
        return balance;
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
