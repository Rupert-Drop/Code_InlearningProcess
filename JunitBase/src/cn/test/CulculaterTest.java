package cn.test;

import cn.Rubter.Culculater;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CulculaterTest {
    @Test
    public void addTest() {
        System.out.println("addTest");
        Culculater c = new Culculater();
        int r = c.add(5, 6);

        //该方法将期望值与add（）方法的返回值做比较，判断是否相等
        Assert.assertEquals(11, r);
    }

    @Before
    public void beforeTest() {
        System.out.println("@before注解修饰的方法在每个测试方法执行前都被执行一次");
    }

    @After
    public void afterTest() {
        System.out.println("@after注解修饰的方法在每个测试方法执行后都被执行一次");
    }
}
