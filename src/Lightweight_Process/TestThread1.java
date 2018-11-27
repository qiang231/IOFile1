package Lightweight_Process;

class SubThread2 extends Thread{

    public void run(){
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() +":" + i);
            }
        }
    }
}
class SubThread3 extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class TestThread1 {
    public static void main(String[] args) {
        SubThread2 t1 = new SubThread2();
        SubThread3 t2 = new SubThread3();

        t1.start();
        t2.start();
        new Thread(){
            public void run(){
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+":" + "qwer");
                }
            }
        }.start();
        for (int i = 0; i < 50; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }



    }


}
