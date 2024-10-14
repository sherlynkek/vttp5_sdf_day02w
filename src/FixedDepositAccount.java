package src;

public class FixedDepositAccount extends BankAccount {
    
    private float interest;
    private int duration;
    private boolean isModified = false; // To track if interest/duration has been modified
    private boolean balanceSet = false; // To track if balance has been set (cannot change after being set)

    // Constructor with default interest and duration
    public FixedDepositAccount(String holderName, float balance) {
        super(holderName, balance);
        this.interest = 3.0f;   // Default interest rate
        this.duration = 6;      // Default duration in months
        this.balanceSet = true;
    }

    // Constructor with balance and interest
    public FixedDepositAccount(String holderName, float balance, float interest) {
        super(holderName, balance);
        this.interest = interest;
        this.duration = 6;      // Default duration in months
        this.balanceSet = true;
        this.isModified = true; // Mark as modified
    }

    // Constructor with balance, interest, and duration
    public FixedDepositAccount(String holderName, float balance, float interest, int duration) {
        super(holderName, balance);
        this.interest = interest;
        this.duration = duration;
        this.balanceSet = true;
        this.isModified = true; // Mark as modified
    }

    // Override the getBalance method to include interest
    @Override
    public float getBalance() {
        // Balance plus interest applied to it
        return super.getBalance() * (1 + (interest / 100));
    }

    // Prevent any changes to balance (no operation)
    @Override
    public void deposit(float amount) {
        // Do nothing (No operation)
        System.out.println("Cannot deposit to a fixed deposit account.");
    }

    // Prevent any withdrawal (no operation)
    @Override
    public void withdraw(float amount) {
        // Do nothing (No operation)
        System.out.println("Cannot withdraw from a fixed deposit account.");
    }

    // Method to modify interest and duration (can only modify once)
    public void modifyInterestAndDuration(float interest, int duration) {
        if (isModified) {
            throw new IllegalArgumentException("Interest and duration can only be changed once.");
        }
        this.interest = interest;
        this.duration = duration;
        this.isModified = true; // Mark as modified
    }
}

