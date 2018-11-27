package Lightweight_Process;

/**
 * �߳�ͨ��:���µ������ؼ���ʹ�õĻ���������ͬ��������ͬ��������
 * wait():�ͷŵ�ǰ����Դ
 * notify()/notifyAll():����һ�������е��������߳�
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
        t1.setName("��");
        t2.setName("��");
        t1.start();
        t2.start();
    }
}
