package reflect;

import java.util.Comparator;

public class Person extends Creature<String> implements Comparable ,MyInterface{
    public String name;
    private int age;
    double id;
    public Person() {
    }


    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("我是一个人");
    }
    public void display(String nation){
        System.out.println("我的国籍是：" + nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public static void show1(){
        System.out.println("中国人");
    }
}
