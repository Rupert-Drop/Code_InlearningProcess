package cn.poker;
/**
 * （ Collections：收集物；sort：排序；index：索引
 * shuffle：洗牌
 * ）
 */

import java.util.*;

/**
 * 斗地主双例模式
 * 进行了牌面的排序
 * 使用了collections工具类操作集合
 */
public class Poker {
    public static void main(String[] args) {
        //储存牌的索因和组装好的牌
        HashMap<Integer, String> pokers = new HashMap<>();
        Objects.requireNonNull(pokers, "pokers数组为空");//判断数组是否为空，用throw抛出异常处理
        //创建list索引集合，存储索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //生成牌
        List<String> colors = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        Collections.addAll(colors, "♠", "♥", "♣", "♦");
        Collections.addAll(numbers, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        //将大小王储存储进集合中
        //定义一个牌的索引
        int index = 0;
        pokerIndex.add(index);//将索引放入索引集合中
        pokers.put(index, "大王");//将牌与索引存入Map集合中
        index++;
        pokerIndex.add(index);
        pokers.put(index, "小王");
        for (String number : numbers) {
            for (String color : colors) {
                // System.out.print(color+number);
                //装进pokers集合中
                index++;
                pokerIndex.add(index);
                pokers.put(index, color + number);
            }
        }
        //洗牌，打乱集合
        Collections.shuffle(pokerIndex);
     /*   System.out.println("Map集合："+pokers);
        System.out.println("索引集合："+pokerIndex);*/

        //创建玩家及底牌集合
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();
        //发牌,存储牌的索引
        for (int i = 0; i < pokerIndex.size(); i++) {
            if (i > 50) {
                diPai.add(pokerIndex.get(i));
            } else if (i % 3 == 0) {
                player1.add(pokerIndex.get(i));
            } else if (i % 3 == 1) {
                player2.add(pokerIndex.get(i));
            } else if (i % 3 == 2) {
                player3.add(pokerIndex.get(i));
            }
        }
        //给集合中牌面排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(diPai);
        //根据索引获取牌面
        look("玩家1", pokers, player1);
        look("玩家2", pokers, player2);
        look("玩家3", pokers, player3);
        look("底 牌", pokers, diPai);
       /* pokers.entrySet();
        System.out.println(pokers.entrySet());*/
    }

    public static void look(String name, HashMap<Integer, String> pokers, ArrayList<Integer> list) {
        System.out.print(name + ":");
        for (Integer index : list) {
            String value = pokers.get(index);
            System.out.print(value + " ");
        }
        System.out.print("   剩余牌数：" + list.size());
        System.out.println();
    }
}
