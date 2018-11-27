package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human1{
    void info();
    void fly();
}

class Superman1 implements Human1{

    @Override
    public void info() {
        System.out.println("我是超人");
    }

    @Override
    public void fly() {
        System.out.println("I can fly！");
    }
}

class HumanUntil1{
    public void method1(){
        System.out.println("=======方法一======");
    }
    public void method2(){
        System.out.println("=======方法二=======");
    }
}

class MyInvocationHandler2 implements InvocationHandler{
    Object obj;

    public void setObj(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUntil1 h1 = new HumanUntil1();
        h1.method1();

        Object returnValue = method.invoke(obj,args);
        h1.method2();
        return returnValue;

    }

}

//动态的创建一个代理类
class Myproxy1{
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler2 handler2 = new MyInvocationHandler2();
        handler2.setObj(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler2);
    }

}
public class TestAOP {
    public static void main(String[] args) {
       Superman1 s1 = new Superman1();
       Object obj = Myproxy1.getProxyInstance(s1);
       Human1 hu = (Human1)obj;
       hu.info();
       System.out.println();
       hu.fly();
        System.out.println();

        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory factory = (ClothFactory)Myproxy1.getProxyInstance(nike);
        factory.productCloth();
    }
}
