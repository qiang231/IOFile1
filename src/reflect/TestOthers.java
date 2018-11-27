package reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class TestOthers {
    //调用运行时类中指定的方法
    @Test
    public void test5() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Person.class;
        Method m1 = clazz.getMethod("show");       //我是一个人
        Person p = (Person)clazz.newInstance();

        //调用指定的方法：invoke(Object obj,)
        System.out.println(m1.invoke(p));                //null

        Method m2 = clazz.getMethod("toString");
        System.out.println(m2.invoke(p));                //Person{name='null', age=0}

        Method m3 = clazz.getMethod("show1");
        m3.invoke(Person.class);

        Method m4 = clazz.getDeclaredMethod("display",String.class);
        //添加访问的权限
        m4.setAccessible(true);
        m4.invoke(p,"CHN");
    }

    @Test
    public void test6() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String className = "reflect.Person";
        Class clazz = Class.forName(className);

        Constructor cons = clazz.getConstructor(String.class,int.class);
        cons.setAccessible(true);
        Person p = (Person) cons.newInstance("罗维",20);
        System.out.println(p);
    }









    @Test
    public void test4() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Person.class;
        //1.获取指定的属性
        Field name = clazz.getField("name");
        //2.创建运行是类的对象
        Person p = (Person)clazz.newInstance();
        System.out.println(p);
        //3.将运行时类指定的属性赋值
        name.set(p,"jerry");
        System.out.println(p);
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(p,10);
        System.out.println(p);

    }


    //6.获取注解
    @Test
    public void test3(){
        Class clazz = Person.class;
        Annotation[] anns = clazz.getAnnotations();
        for (Annotation a : anns ){
            System.out.println(a);
        }
    }


    //5.获取所在的包
    @Test
    public void test2(){
        Class clazz =Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }


    //4.获取实现的接口
    @Test
    public void test1(){
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class i:interfaces
             ) {
            System.out.println(i);
        }
    }


    //3.获取父类的泛型
    @Test
    public void test(){
        Class clazz = Person.class;
        Type type = clazz.getGenericSuperclass();
        ParameterizedType para = (ParameterizedType)type;
        Type[] ars = para.getActualTypeArguments();
        System.out.println(((Class)ars[0]).getName());


    }

}
