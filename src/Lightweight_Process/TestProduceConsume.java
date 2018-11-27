package Lightweight_Process;

/**
 * �����ߺ�������
 *
 */
class Clerk{
    int product;
    public synchronized void addProduct(){
        if (product >= 20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName()+"�����˵�"+ product+ "����Ʒ");
            product++;
            notifyAll();
        }

    }
    public synchronized void consumeProduct(){
        if (product <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName() + ":�����˵�" + product +"����Ʒ");
            product--;
            notifyAll();
        }

    }

}

class Producer implements Runnable{

    Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    public void run(){
        System.out.println("�����߿�ʼ������Ʒ��");
        while (true){
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}

class Consumer implements Runnable{
    Clerk clerk;
    public Consumer (Clerk clerk){
        this.clerk = clerk;
    }
    public void run(){
        System.out.println("���������Ѳ�Ʒ��");
        while (true){
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }

}


public class TestProduceConsume {
    public static void main(String[] args) {
        Clerk c = new Clerk();
        Producer p1 = new Producer(c);
        Consumer c1 = new Consumer(c);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);
        Thread t3 = new Thread(p1);
        t1.setName("������1");
        t2.setName("������1");
        t3.setName("������2");

        t1.start();
        t2.start();
        t3.start();


    }

}
