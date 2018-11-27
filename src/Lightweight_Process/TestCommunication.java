package Lightweight_Process;

/**
 * 线程通信:如下的三个关键字使用的话，都得在同步代码块或同步方法中
 * wait():释放当前的资源
 * notify()/notifyAll():唤醒一个或所有的其他的线程
 */
class PrintNum implements Runnable{

    int num = 1;

    @Override
    public void run() {

        while (true){
            synchronized (this) {
                notify();
                if (num <= 100){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                }
                else break;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class TestCommunication {
    public static void main(String[] args) {
        PrintNum p = new PrintNum();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        t1.setName("甲");
        t2.setName("乙");
        t1.start();
        t2.start();
    }
}
