package Lightweight_Process;

/**
 * ����һ�����߳����1-100֮����Ȼ������������߳�Ҳ����ͬ���Ĳ���
 */

//1.����һ���̳���Thread��ķ���
class SubThread extends Thread{
    //2.��дThread���run()����
    public  void run(){

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+ ":"+ i);
        }
    }

}
public class TestThread {
    public static void main(String[] args) {
        //3.����һ���������
        SubThread st = new SubThread();

        //4.�����̵߳�start()�������������̣߳�����run()����
        st.setName("���߳�1");
        st.setPriority(Thread.MAX_PRIORITY);
        st.start();
        Thread.currentThread().setName("========���߳�");
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
