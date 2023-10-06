package Week2;


public class BankAccount {
    private double balance;
    BankAccount(){
        this.balance=0;
    }
    BankAccount(double accountBalance){
        this.balance=accountBalance;
    }
    double getAccountBalance() {
        return balance;
    }
    public void setAccountBalance(double accountBalance) {
        this.balance = accountBalance;
    }


    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount(4500);
        account2.setAccountBalance(1000);
        System.out.println(account1.getAccountBalance());
        System.out.println(account2.getAccountBalance());
    }
}
