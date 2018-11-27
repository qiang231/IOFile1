package Lightweight_Process;


class PrintNum1 implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":"+ i);
        }
    }
}

public class TestThread2 {
    public static void main(String[] args) {
        PrintNum1 p = new PrintNum1();
        Thread t1 = new Thread(p);
        t1.start();
    }
}
