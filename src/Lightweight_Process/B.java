package Lightweight_Process;
public class B {
    public static B  b1 = new B();
    public static B  b2 = new B();

    {
        System.out.println("�����");

    }
    static {
        System.out.println("��̬��");
    }
    public static void main(String[] args) {
        B t = new B();
    }
}
