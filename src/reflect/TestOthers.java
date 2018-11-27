package reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class TestOthers {
    //��������ʱ����ָ���ķ���
    @Test
    public void test5() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Person.class;
        Method m1 = clazz.getMethod("show");       //����һ����
        Person p = (Person)clazz.newInstance();

        //����ָ���ķ�����invoke(Object obj,)
        System.out.println(m1.invoke(p));                //null

        Method m2 = clazz.getMethod("toString");
        System.out.println(m2.invoke(p));                //Person{name='null', age=0}

        Method m3 = clazz.getMethod("show1");
        m3.invoke(Person.class);

        Method m4 = clazz.getDeclaredMethod("display",String.class);
        //��ӷ��ʵ�Ȩ��
        m4.setAccessible(true);
        m4.invoke(p,"CHN");
    }

    @Test
    public void test6() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String className = "reflect.Person";
        Class clazz = Class.forName(className);

        Constructor cons = clazz.getConstructor(String.class,int.class);
        cons.setAccessible(true);
        Person p = (Person) cons.newInstance("��ά",20);
        System.out.println(p);
    }









    @Test
    public void test4() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        //1.��ȡָ��������
        Field name = clazz.getField("name");
        //2.������������Ķ���
        Person p = (Person)clazz.newInstance();
        System.out.println(p);
        //3.������ʱ��ָ�������Ը�ֵ
        name.set(p,"jerry");
        System.out.println(p);
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(p,10);
        System.out.println(p);

    }


    //6.��ȡע��
    @Test
    public void test3(){
        Class clazz = Person.class;
        Annotation[] anns = clazz.getAnnotations();
        for (Annotation a : anns ){
            System.out.println(a);
        }
    }


    //5.��ȡ���ڵİ�
    @Test
    public void test2(){
        Class clazz =Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }


    //4.��ȡʵ�ֵĽӿ�
    @Test
    public void test1(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class i:interfaces
             ) {
            System.out.println(i);
        }
    }


    //3.��ȡ����ķ���
    @Test
    public void test(){
        Class clazz = Person.class;
        Type type = clazz.getGenericSuperclass();
        ParameterizedType para = (ParameterizedType)type;
        Type[] ars = para.getActualTypeArguments();
        System.out.println(((Class)ars[0]).getName());


    }

}
