package cn.Rubter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 斗地主案例
 */

public class pokerDemo {
    public static void main(String[] args) {
        //定义一个Arraylist数组pokers,存放54张牌
        ArrayList<String> pokers = new ArrayList<String>();
        //定义一个数组打印花色，一个数组打印牌数字
        String[] huaSes = {"♠", "♥", "♣", "♦"};
        String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        //存储大小王
        pokers.add("大王");
        pokers.add("小王");
        //发牌
        for (String num : number) {
            for (String huaSe : huaSes) {
                //   System.out.println(huaSe+num);//循环打印花色与数字
                pokers.add(huaSe + num);//将52张牌装进集合中
            }
        }
        //洗牌
        // 利用collections工具类中的shuffle方法，随机打乱集合中的排序
        Collections.shuffle(pokers);
        // System.out.println(pokers);
        //定义3个玩家Arraylist数组player1-3，一个底牌Arraylist数组others
        ArrayList<String> player1 = new ArrayList<String>();
        ArrayList<String> player2 = new ArrayList<String>();
        ArrayList<String> player3 = new ArrayList<String>();
        ArrayList<String> diPai = new ArrayList<String>();
        //循环遍历pokers数组，发牌到player1-3和others中
        for (int i = 0; i < pokers.size(); i++) {
            if (i >= 51) {//数组从零开始，故此处因该大于50，而不是51；或者是大于等于51
                //将牌添加进底牌集合中
                diPai.add(pokers.get(i));
            } else if (i % 3 == 1) {
                //将牌添加进player1中
                player1.add(pokers.get(i));
            } else if (i % 3 == 2) {
                //将牌添加进player2中
                player2.add(pokers.get(i));
            } else if (i % 3 == 0) {
                //将牌添加进play3中
                player3.add(pokers.get(i));
            }
        }
        //test
        System.out.print(player1.size() + "张牌:");
        System.out.println("玩家A：" + player1);
        System.out.print(player2.size() + "张牌:");
        System.out.println("玩家B：" + player2);
        System.out.print(player3.size() + "张牌:");
        System.out.println("玩家C：" + player3);
        System.out.print(diPai.size() + "张牌:");
        System.out.println("底牌：" + diPai);
    }
}
