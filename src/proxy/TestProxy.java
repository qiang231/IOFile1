package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理的使用
interface Subject{
    void action();
}
//被代理类
class RealSubject implements Subject{

    @Override
    public void action() {
        System.out.println("我是被代理类");
    }
}

class MyInvocationHandler implements InvocationHandler{
    Object obj; //实现拿了接口的被代理类的对象的声明

    //1.给被代理的对象实例化  2.返回一个代理类的对象
    public Object blind(Object obj){
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(obj,args);
        return returnValue;
    }
}


public class TestProxy {
    public static void main(String[] args) {
        //1.被代理类的对象
        RealSubject real = new RealSubject();
        //2.创建了一个实现了InvocationHandle接口的类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        //3.调用blind防范，动态的返回一个同样实现了real所在类实现的接口Subject的代理类的对象
        Object obj = handler.blind(real);
        Subject sub = (Subject)obj;
        sub.action();

        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory cf = (ClothFactory)handler.blind(nike);
        cf.productCloth();

    }
}
