package cn.Rubter;
/**
 * 编译期异常
 */

import java.util.Scanner;

public class RegisterDemo {
    static String[] usernames = {"张三", "李四", "王五", "赵六"};

    public static void main(String[] args) throws RegisterException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.next();
        //调用方法和usernames数组中的用户名进行比较，查看是否已存在
        isRegister(username);
    }

    public static void isRegister(String username) throws RegisterException {
        for (String s : usernames) {
            if (username.equals(s)) {//拿注册名来与已存在的用户名比较
                //已存在：抛出异常；“亲，该用户名已被使用！”
                throw new RegisterException("亲，该用户名已被使用！");
            }
        }
        //若不存在，输出：恭喜，注册成功！
        System.out.println("恭喜，注册成功");

    }
}
