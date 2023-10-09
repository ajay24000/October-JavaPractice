package Week2;


public class BankAccount {
    private double balance;
    BankAccount(){
        this.balance=0;
    }
    BankAccount(double accountBalance){
        this.balance=accountBalance;
    }
    public double getAccountBalance() {
        return balance;
    }
    public void setAccountBalance(double accountBalance) {
        this.balance = accountBalance;
    }


    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount(4500);
        account2.setAccountBalance(1000);
        System.out.println("Account 1 balance :"+account1.getAccountBalance());
        System.out.println("Account 1 balance :"+account2.getAccountBalance());
    }
}
