package Lightweight_Process;

/**
 * 生产者和消费者
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
            System.out.println(Thread.currentThread().getName()+"生产了第"+ product+ "个产品");
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
            System.out.println(Thread.currentThread().getName() + ":消费了第" + product +"个产品");
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
        System.out.println("生产者开始生产产品：");
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
        System.out.println("消费者消费产品：");
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
        t1.setName("生产者1");
        t2.setName("消费者1");
        t3.setName("生产者2");

        t1.start();
        t2.start();
        t3.start();


    }

}
