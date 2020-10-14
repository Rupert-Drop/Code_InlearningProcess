package cn.Domin;

/**
 * 辅助完成反射以及注解部分案例的实体类
 */
public class Student {
    private String name;
    private int age;
    private String active;

    public void activity() {
        System.out.println("运动");
    }

    private void study() {
        System.out.println("学习");
    }
}
