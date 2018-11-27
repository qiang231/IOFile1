package Lightweight_Process;

class Windows1 implements Runnable{
    int ticket = 100;
    public void run(){
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName()+ "��Ʊ��Ʊ��Ϊ��" + ticket--);
            }else {
                break;
            }
        }
    }
}

class Windows extends Thread{

    static int ticket = 100;
    Object obj = new Object();
//    static Object obj = new Object();   //����Ǽ̳е�ʱ���õ�
    public synchronized void show(){
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName()+ "��Ʊ��Ʊ��Ϊ��" + ticket--);
        }

    }

//    public void run(){
//        while (true){
//            show();
//        }
//    }
    public  void run(){

        while (true){
            synchronized (this) {
                if (ticket > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ "��Ʊ��Ʊ��Ϊ��" + ticket--);
                }else {
                    break;
                }
            }
        }
    }
}

public class TestWindows {
    public static void main(String[] args) {

        Windows1 w1 = new Windows1();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();

//        Windows w1 = new Windows();
//        Windows w2 = new Windows();
//        Windows w3 = new Windows();
//
//        w1.setName("����1");
//        w2.setName("����2");
//        w3.setName("����3");
//
//        w1.start();
//        w2.start();
//        w3.start();



    }
}
