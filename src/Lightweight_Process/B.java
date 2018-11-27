package Lightweight_Process;
public class B {
    public static B  b1 = new B();
    public static B  b2 = new B();

    {
        System.out.println("¹¹Ôì¿é");

    }
    static {
        System.out.println("¾²Ì¬¿é");
    }
    public static void main(String[] args) {
        B t = new B();
    }
}
