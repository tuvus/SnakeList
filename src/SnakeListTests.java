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
    public void testGetRealIndex() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{5, 2, 7});
        Assert.assertEquals(0, snakeList.getRealIndex(0));
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
    public void testGetRealIndexOver() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{5, 9, 2});
        Assert.assertEquals(1, snakeList.getRealIndex(4));
    }

    @Test
    public void testGetRealIndexEnd() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{5, 9, 2, 8});
        Assert.assertEquals(3, snakeList.getRealIndex(3));
    }

    @Test
    public void testRemoveFromBeginning() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{5, 9, 2, 8});
        snakeList.remove(0);
        Assert.assertArrayEquals(new Integer[]{null, 9, 2, 8}, snakeList.toArray());
    }

    @Test
    public void testRemoveFromEnd() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{5, 9, 2, 8});
        snakeList.remove(3);
        Assert.assertArrayEquals(new Integer[]{5, 9, 2, null}, snakeList.toArray());
    }

    @Test
    public void testRemoveFromEndLoop() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{5, 9, 2, 8});
        snakeList.remove(0);
        snakeList.add(3,17);
        snakeList.remove(3);
        Assert.assertArrayEquals(new Integer[]{null, 9, 2, 8}, snakeList.toArray());
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
    public void testResizeCopy() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 3);
        snakeList.add(5);
        snakeList.add(9);
        snakeList.add(2);
        snakeList.Resize(5);
        Integer[] testArray = new Integer[snakeList.array.length];
        testArray[0] = 5;
        testArray[1] = 9;
        testArray[2] = 2;
        Assert.assertArrayEquals(testArray, snakeList.toArray());
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
        Assert.assertArrayEquals(testArray, snakeList.toArray());
    }

    @Test
    public void testAddToBeginningLoop() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 3);
        snakeList.add(5);
        snakeList.add(3);
        snakeList.add(0, 23);
        Assert.assertArrayEquals(new Integer[]{5, 3, 23}, snakeList.toArray());
    }
}
