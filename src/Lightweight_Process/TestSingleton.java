package Lightweight_Process;

/**
 * 懒汉式线程安全问题
 * 对于一般的方法内，使用同步代码块，可以考虑使用this
 * 对于静态方法而言，使用当前类充当对象
 */
class Singleton{
    private Singleton(){

    }
    private static Singleton instance = null;
    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class TestSingleton {
    public static void main(String[] args) {
        Singleton s1 =Singleton.getInstance();
        Singleton s2 =Singleton.getInstance();
        Singleton s3 =Singleton.getInstance();
        System.out.println(s1 == s2);

    }

}
