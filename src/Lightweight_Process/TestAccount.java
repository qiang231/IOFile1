package Lightweight_Process;

import java.util.concurrent.RejectedExecutionHandler;

class Account{
    double balance;
    public Account(){

    }
    public synchronized void despoit(double amt){
        balance += amt;
        System.out.println(Thread.currentThread().getName() + ":" + balance);
    }
}

class Customer extends Thread{
    Account account;

    public Customer(Account account) {
        this.account = account;
    }
    Object object = new Object();


    public void run() {
        for (int i = 0; i < 3; i++) {
            account.despoit(1000);
        }
    }
}
public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account();
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("¼×");
        c2.setName("ÒÒ");
        c1.start();
        c2.start();

    }


}
