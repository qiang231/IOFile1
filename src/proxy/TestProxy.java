package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//��̬�����ʹ��
interface Subject{
    void action();
}
//��������
class RealSubject implements Subject{

    @Override
    public void action() {
        System.out.println("���Ǳ�������");
    }
}

class MyInvocationHandler implements InvocationHandler{
    Object obj; //ʵ�����˽ӿڵı�������Ķ��������

    //1.��������Ķ���ʵ����  2.����һ��������Ķ���
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
        //1.��������Ķ���
        RealSubject real = new RealSubject();
        //2.������һ��ʵ����InvocationHandle�ӿڵ���Ķ���
        MyInvocationHandler handler = new MyInvocationHandler();
        //3.����blind��������̬�ķ���һ��ͬ��ʵ����real������ʵ�ֵĽӿ�Subject�Ĵ�����Ķ���
        Object obj = handler.blind(real);
        Subject sub = (Subject)obj;
        sub.action();

        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory cf = (ClothFactory)handler.blind(nike);
        cf.productCloth();

    }
}
