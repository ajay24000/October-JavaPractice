package Week2;

public class BankAccount {
    private int balance;
    BankAccount(){
        this.balance=0;
    }
    BankAccount(int accountBalance){
        this.balance=accountBalance;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount();
    }
}
