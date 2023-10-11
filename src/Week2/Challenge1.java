package Week2;

class BankAccount {
    private double accountBalance;

    public BankAccount() {
        accountBalance = 0;
    }

    public BankAccount(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}

public class Challenge1 {

    public static void main(String[] args){

        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount(1500);
        account2.setAccountBalance(1000);

        System.out.println("Account 1 balance is: " + account1.getAccountBalance());
        System.out.println("Account 2 balance is: " + account2.getAccountBalance());

    }

}
