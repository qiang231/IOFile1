package reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * java.lang.Class:是反射的源头
 * 我们创建了一个类，通过编译（java.exe）,生成.class文件,之后我们使用java.exe加载（JVM）
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




    //如何获取Class类的实例

    @Test
    public void test5() throws ClassNotFoundException {
        //1.调用运行是类本身的.class属性
        Class aClass = Person.class;
        System.out.println(aClass.getName());

        Class aclass1 = String.class;
        System.out.println(aclass1.getName());

        //2.通过运行时类的对象获取
        Person p = new Person();
        Class clazz = p.getClass();
        System.out.println(clazz.getName());

        //3.通过Class的静态方法获取
        String className = "reflect.Person";
        Class clazz4 = Class.forName(className);
        System.out.println(clazz4.getName());


        //4.t通过类的加载器

        ClassLoader classLoader = this.getClass().getClassLoader();
        Class clazz5 = classLoader.loadClass(className);
        System.out.println(clazz5);                     //class reflect.Person

    }

    //有了反射，怎么创建一个类的对象
    @Test
    public void test1() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        Class c = Person.class;
        //1.创建c的对应的运行时类Person类的对象
        Person p = (Person)c.newInstance();
        //2.通过反射调用运行时类的指定属性
        Field f = c.getField("name");
        f.set(p,"liudehua");
        System.out.println(p);

        Field f1 = c.getDeclaredField("age");
        f1.setAccessible(true);
        f1.set(p,12);
        System.out.println(p);

        //3.通过反射调用类指定的方法
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

    //在有反射以前，如何创建一个类的对象，并调用其中的方法、属性
    @Test
    public void test(){
        Person p = new Person();
        p.setName("周杰伦");
        p.setAge(30);
        System.out.println(p);
        p.show();
        p.display("中国");
    }

    @Test
    public void test6(){
        Class clazz = Person.class;
        Field[] fields =clazz.getDeclaredFields();
        for (Field f:fields
             ) {
            //获取属性的权限修饰符
            int i = f.getModifiers();
            System.out.print(i);String str = Modifier.toString(i);
            System.out.print("\t" + str);
            //获取属性的类型
            Class type = f.getType();
            System.out.print("  " + type +"  ");
            //获取属性名
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
            //1.注解
            Annotation[] ann = m.getAnnotations();
            for (Annotation a : ann
                 ) {
                System.out.println(a);
            }
            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "  ");
            //3.返回值类型
            System.out.print(m.getReturnType().getName() + "  ");
            //4.方法名
            System.out.print(m.getName()+ "   ");
            //5.形参列表
            System.out.print("(");
            Class[] params = m.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getName() +"  "  + "args-" + i + "  ");
            }
            System.out.print(")");
            //6.异常
            Class[] exps = m.getExceptionTypes();
            for (int i = 0; i < exps.length; i++) {
                System.out.print(exps[i]);
            }
            System.out.println();
        }
    }



}
