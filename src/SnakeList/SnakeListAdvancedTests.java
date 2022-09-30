package SnakeList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class SnakeListAdvancedTests {
    @Test
    public void Test1() {
        SnakeList snakeList = new SnakeList(Boolean.class, 3);
        snakeList.add(false);
        snakeList.add(true);
        snakeList.add(false);
        snakeList.add(false);
        snakeList.add(true);
        snakeList.add(false);
        snakeList.remove(true);
        snakeList.remove(false);
        snakeList.remove(false);
        snakeList.add(false);
        snakeList.add(false);
        Assert.assertArrayEquals(new Boolean[]{false, true, false, false, false}, snakeList.toArray());
    }

    @Test
    public void Test2() {
        SnakeList snakeList = new SnakeList(String.class, 0);
        snakeList.add("alpha");
        snakeList.add(0, "beta");
        snakeList.add(0, "omega");
        snakeList.add(snakeList.size, "gamma");
        snakeList.remove(snakeList.get(1));
        Assert.assertArrayEquals(new String[]{"omega", "alpha", "gamma"}, snakeList.toArray());
    }

    @Test
    public void Test3() {
        SnakeList snakeList = new SnakeList(Integer.class, 10);
        snakeList.add(-1);
        for (int i = 0; i < 30; i++) {
            snakeList.add(1);
            snakeList.remove(0);
        }
        Assert.assertArrayEquals(new Integer[]{ 1 }, snakeList.toArray());
    }

    @Test
    public void Test4() {
        SnakeList snakeList = new SnakeList(Integer.class, 8);
        snakeList.add(-1);
        for (int i = 0; i < 30; i++) {
            snakeList.add(0, 1);
            snakeList.remove(snakeList.size() - 1);
        }
        Assert.assertArrayEquals(new Integer[]{ 1 }, snakeList.toArray());
    }

    @Test
    public void RandomTest1() {
        SnakeList snakeList = new SnakeList(Integer.class, 0);
        ArrayList arrayList = new ArrayList<Integer>(0);
        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            int randomOperation = random.nextInt(20);
            if (randomOperation == 0) {
                arrayList.clear();
                snakeList.clear();
            } else if (randomOperation <= 10 && arrayList.size() > 0) {
                int index = random.nextInt(arrayList.size());
                int number = random.nextInt();
                arrayList.add(index,number);
                snakeList.add(index,number);
            } else if (randomOperation <= 15 && arrayList.size() > 0) {
                int index = random.nextInt(arrayList.size());
                arrayList.remove(index);
                snakeList.remove(index);
            } else {
                int number = random.nextInt();
                arrayList.add(number);
                snakeList.add(number);
            }
        }
        Assert.assertArrayEquals(arrayList.toArray(),snakeList.toArray());
    }
}
