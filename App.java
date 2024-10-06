public class App {
    public static void main(String[] args) {
        BankAccount fredAccount = new BankAccount("Fred");
        fredAccount.deposit(100.0f);

        BankAccount juneAccount = new BankAccount("June", 500.0f);

        fredAccount.toString();
        juneAccount.toString();
        juneAccount.withdraw(550.0f);
        juneAccount.withdraw(100.0f);
        fredAccount.deposit(100.f);
        fredAccount.toString();
        juneAccount.toString();

        FixedDeposit deanDepositAccount = new FixedDeposit("Dean", 1000.0f);
        deanDepositAccount.withdraw(1000.0f);
        deanDepositAccount.deposit(100000.0f);
        deanDepositAccount.showAccountInfo();
    }
}
