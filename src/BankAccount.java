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

        if(transactions == null) {
            transactions = new ArrayList<>();
        }

    }

    public BankAccount(String holderName, float balance) {
        this.holderName = holderName;
        this.accNo = generateAccNo();
        this.balance = balance;

        if(transactions == null) {
            transactions = new ArrayList<>();
        }
    }

    private String generateAccNo() {
        int startAsciiNo = 65;
        int endAsciiNo = 90;
        int accLengthNo = 10;

        Random random = new Random();
        String accNo = "";

        for (int i = 0; accLengthNo < 10; i++) {
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
        this.isClosed = isClosed;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }
    
    
    
}
