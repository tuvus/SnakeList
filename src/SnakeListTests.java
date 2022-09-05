import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class SnakeListTests {
    @Test
    public void testDefaultConstructor() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class);
        Assert.assertNotEquals(null, snakeList);
    }

    @Test
    public void testCapacityConstructor() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 11);
        Assert.assertArrayEquals(new Integer[11], snakeList.toArray());
    }

    @Test
    public void testArrayConstructor() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{6, 3, 68, 2, 8});
        Assert.assertArrayEquals(new Integer[]{6, 3, 68, 2, 8}, snakeList.toArray());
    }

    @Test
    public void testAdd() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 3);
        snakeList.add(5);
        snakeList.add(9);
        snakeList.add(2);
        Assert.assertArrayEquals(new Integer[]{5, 9, 2}, snakeList.toArray());
    }

    @Test
    public void testGet() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{6, 3, 68, 2, 8});
        Assert.assertEquals((Integer) 68, snakeList.get(2));
    }

    @Test
    public void testGetLoop() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{6, 3, 68, 2, 8});
        Assert.assertEquals((Integer) 3, snakeList.get(6));
    }

    @Test
    public void testResize() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 0);
        snakeList.Resize(3);
        snakeList.add(5);
        snakeList.add(9);
        snakeList.add(2);
        Assert.assertArrayEquals(new Integer[]{5, 9, 2}, snakeList.toArray());
    }

    @Test
    public void testAddResize() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 0);
        snakeList.add(12);
        snakeList.add(7);
        snakeList.add(41);
        Integer[] testArray = new Integer[snakeList.array.length];
        testArray[0] = 12;
        testArray[1] = 7;
        testArray[2] = 41;
        Assert.assertArrayEquals("ArrayConstructorTest", testArray, snakeList.toArray());
    }
}
