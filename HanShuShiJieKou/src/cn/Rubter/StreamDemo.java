package cn.Rubter;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * 流式编程思想案例
 */
public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> sheep = new ArrayList<>();
        ArrayList<String> wolf = new ArrayList<>();
        Collections.addAll(sheep, "喜羊羊", "美羊羊", "懒洋洋", "沸羊羊", "慢羊羊", "花羊羊");
        Collections.addAll(wolf, "小灰灰", "灰太狼", "红太狼", "蕉太狼", "香太狼", "武大狼");

        Stream<String> litWolf = wolf.stream().filter((name) -> name.startsWith("小"));
        Stream<String> litSheep = sheep.stream().filter((name) -> name.length() == 3 && name.endsWith("羊")).limit(3);
        //合二为一，并转换为people类
        Stream.concat(litWolf, litSheep).map((name) -> new People(name)).forEach(name -> System.out.println(name));
    }
}
