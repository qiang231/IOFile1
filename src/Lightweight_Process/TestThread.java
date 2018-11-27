package Lightweight_Process;

/**
 * 创建一个子线程完成1-100之间自然数的输出，主线程也进行同样的操作
 */

//1.创建一个继承于Thread类的方法
class SubThread extends Thread{
    //2.重写Thread类的run()方法
    public  void run(){

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+ ":"+ i);
        }
    }

}
public class TestThread {
    public static void main(String[] args) {
        //3.创建一个子类对象
        SubThread st = new SubThread();

        //4.调用线程的start()方法，启动此线程，运行run()方法
        st.setName("子线程1");
        st.setPriority(Thread.MAX_PRIORITY);
        st.start();
        Thread.currentThread().setName("========主线程");
        for (int i = 0; i < 100; i++) {
//            try {
//                Thread.currentThread().sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority() +":" + i);

//            if (i % 10 == 0){
//                Thread.currentThread().yield();
//            }
//            if (i == 20){
//                try {
//                    st.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
