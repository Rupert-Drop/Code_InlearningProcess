package cn.Domin;

/**
 * 辅助完成反射以及注解部分案例的实体类
 */
public class Person {
    /*成员变量*/
    private String name;
    private int age;

    public String a;
    protected String b;
    String c;
    private String d;

    /*构造方法*/
    public Person() {
    }

    public Person(String name, int age, String a, String b, String c, String d) {
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /*成员方法a区*/
    public static void eat() {
        System.out.println("吃(●ˇ∀ˇ●)");
    }

    void wear() {
        System.out.println("穿（〃｀ 3′〃）");
    }

    private void run() {
        System.out.println("跑ε=ε=ε=(~￣▽￣)~");
    }


    /*/*成员方法b区————get/set方法*/

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

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
    /*重写toString方法*/

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
