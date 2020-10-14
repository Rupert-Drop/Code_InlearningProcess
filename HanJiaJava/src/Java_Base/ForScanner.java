package Java_Base;
/**
 * 输出，手动录入的内容
 * 2020.1.6
 * 窗外，再见了心爱的梦中女孩
 */

import java.util.Scanner;

public class ForScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        for (int i = 0; i < line.length(); i++) {
            System.out.println(line.charAt(i));
        }
    }
}
