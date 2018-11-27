package reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * java.lang.Class:�Ƿ����Դͷ
 * ���Ǵ�����һ���࣬ͨ�����루java.exe��,����.class�ļ�,֮������ʹ��java.exe���أ�JVM��
 */
public class TestREfkectuon {


    @Test
    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String className = "reflect.Person";
        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        Person p = (Person)obj;
        System.out.println(p);
    }




    //��λ�ȡClass���ʵ��

    @Test
    public void test5() throws ClassNotFoundException {
        //1.�����������౾���.class����
        Class aClass = Person.class;
        System.out.println(aClass.getName());

        Class aclass1 = String.class;
        System.out.println(aclass1.getName());

        //2.ͨ������ʱ��Ķ����ȡ
        Person p = new Person();
        Class clazz = p.getClass();
        System.out.println(clazz.getName());

        //3.ͨ��Class�ľ�̬������ȡ
        String className = "reflect.Person";
        Class clazz4 = Class.forName(className);
        System.out.println(clazz4.getName());


        //4.tͨ����ļ�����

        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz5 = classLoader.loadClass(className);
        System.out.println(clazz5);                     //class reflect.Person

    }

    //���˷��䣬��ô����һ����Ķ���
    @Test
    public void test1() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        Class c = Person.class;
        //1.����c�Ķ�Ӧ������ʱ��Person��Ķ���
        Person p = (Person)c.newInstance();
        //2.ͨ�������������ʱ���ָ������
        Field f = c.getField("name");
        f.set(p,"liudehua");
        System.out.println(p);

        Field f1 = c.getDeclaredField("age");
        f1.setAccessible(true);
        f1.set(p,12);
        System.out.println(p);

        //3.ͨ�����������ָ���ķ���
        Method m = c.getMethod("show");
        m.invoke(p);

        Method m1 = c.getMethod("display", String.class);
        m1.invoke(p,"CHN");
    }


    @Test
    public void test4(){
        Person person = new Person();
        Class clazz = person.getClass();
        System.out.println(clazz);

    }

    @Test
    public void test3(){
        Class clazz = Person.class;
        Field[] fields = clazz.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }

        Field[] fields1 = clazz.getDeclaredFields();
        for (int i = 0; i < fields1.length; i++) {
            System.out.println(fields1[i]);
        }

    }

    //���з�����ǰ����δ���һ����Ķ��󣬲��������еķ���������
    @Test
    public void test(){
        Person p = new Person();
        p.setName("�ܽ���");
        p.setAge(30);
        System.out.println(p);
        p.show();
        p.display("�й�");
    }

    @Test
    public void test6(){
        Class clazz = Person.class;
        Field[] fields =clazz.getDeclaredFields();
        for (Field f:fields
             ) {
            //��ȡ���Ե�Ȩ�����η�
            int i = f.getModifiers();
            System.out.print(i);String str = Modifier.toString(i);
            System.out.print("\t" + str);
            //��ȡ���Ե�����
            Class type = f.getType();
            System.out.print("  " + type +"  ");
            //��ȡ������
            System.out.print("  " + f.getName());
            System.out.println();

        }

    }

    @Test
    public void test7(){

        Class clazz = Person.class;
        Method[] methods = clazz.getMethods();
        for (Method m:methods
             ) {
//            System.out.println(m);
        }

        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method m:methods1
             ) {
            //1.ע��
            Annotation[] ann = m.getAnnotations();
            for (Annotation a : ann
                 ) {
                System.out.println(a);
            }
            //2.Ȩ�����η�
            System.out.print(Modifier.toString(m.getModifiers()) + "  ");
            //3.����ֵ����
            System.out.print(m.getReturnType().getName() + "  ");
            //4.������
            System.out.print(m.getName()+ "   ");
            //5.�β��б�
            System.out.print("(");
            Class[] params = m.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getName() +"  "  + "args-" + i + "  ");
            }
            System.out.print(")");
            //6.�쳣
            Class[] exps = m.getExceptionTypes();
            for (int i = 0; i < exps.length; i++) {
                System.out.print(exps[i]);
            }
            System.out.println();
        }
    }



}
