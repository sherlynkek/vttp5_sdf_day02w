package src;

public class App {
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
}
