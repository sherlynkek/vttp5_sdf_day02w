package bank;

public class Account {

    private String accName;
    private String accNumber;
    private float balance;
    private boolean closed;
    private Integer createAcc;
    private Integer closeAcc;


    public Account(String accName) {
        this.accName = accName;
    }

    

    public Account(String accNumber, float balance) {
        this.accNumber = accNumber;
        this.balance = balance;
    }



    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Integer getCreateAcc() {
        return createAcc;
    }

    public void setCreateAcc(Integer createAcc) {
        this.createAcc = createAcc;
    }

    public Integer getCloseAcc() {
        return closeAcc;
    }

    public void setCloseAcc(Integer closeAcc) {
        this.closeAcc = closeAcc;
    }

    
    
}