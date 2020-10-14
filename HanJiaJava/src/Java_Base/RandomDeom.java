package Java_Base;
/**
 * 猜数字游戏：
 * 练习random使用
 */

import java.util.Random;
import java.util.Scanner;

public class RandomDeom {

    public static void main(String[] args) {
        Random r = new Random();
        //bound:边界，包括0，不包括边界（10）
        int a = r.nextInt(100);
        //  System.out.println(a);
        System.out.println("猜数字小游戏：");
        System.out.println("请输入你的猜想：");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int b = scanner.nextInt();

            if (a == b) {
                System.out.println("干得漂亮！你猜对了");
                break;
            } else if (a < b) {
                System.out.println("它比你猜的数字小");
            } else if (a > b) {
                System.out.println("它比你猜的数字大");
            }
        }

    }
}
