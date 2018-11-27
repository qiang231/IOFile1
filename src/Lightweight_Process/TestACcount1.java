package Lightweight_Process;

//class Account1{
//    double balance;
//    public void Account(){}
//    public void despoit1(double amt){
//        balance += amt;
//        System.out.println(Thread.currentThread().getName() + ":" + balance);
//    }
//}
//class Customer1 implements Runnable{
//
//    Account account ;
//
//    public Customer1(Account1 account1) {
//        this.account = account;
//    }
//
//    public void run(){
//        for (int i = 0; i < 3; i++) {
//            account.despoit(1000);
//        }
//    }
//}
//
//public class TestACcount1 {
//    public static void main(String[] args) {
//        Account1 account = new Account1();
//        Customer1 c1 = new Customer1(account);
//        Thread t1 = new Thread(c1);
//        Thread t2 = new Thread(c1);
//        t1.start();
//        t2.start();
//    }
//
//
//}
