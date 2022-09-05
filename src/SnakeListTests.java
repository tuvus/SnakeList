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
    public void testSet() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 4);
        snakeList.add(5);
        snakeList.add(9);
        snakeList.add(2);
        snakeList.add(6);
        snakeList.set(1, 16);
        Assert.assertArrayEquals(new Integer[]{5, 16, 2, 6}, snakeList.toArray());
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
        snakeList.add(3, 17);
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
    public void testIndexOf() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(2, snakeList.indexOf(3));
    }

    @Test
    public void testIndexOfLoop() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 5);
        snakeList.add(5);
        snakeList.add(5);
        snakeList.add(5);
        snakeList.add(5);
        snakeList.add(5);
        snakeList.remove(0);
        snakeList.remove(0);
        snakeList.add(1);
        Assert.assertEquals(3, snakeList.indexOf(1));
    }

    @Test
    public void testFalseIndexOf() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(-1, snakeList.indexOf(21321));
    }

    @Test
    public void testContains() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(true, snakeList.contains(4));
    }

    @Test
    public void testContainsFalse() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(false, snakeList.contains(48));
    }

    @Test
    public void testRemoveObject() {
        SnakeList<Integer> snakeList = new SnakeList(new Integer[]{1, 7, 3, 4, 9});
        snakeList.remove((Integer)3);
        Assert.assertArrayEquals(new Integer[]{null, 1, 7, 4, 9}, snakeList.toArray());
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
    public void testAddToBeginning() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 3);
        snakeList.add(5);
        snakeList.add(3);
        snakeList.add(8);
        snakeList.remove(0);
        snakeList.add(0, 23);
        Assert.assertArrayEquals(new Integer[]{23, 3, 8}, snakeList.toArray());
    }

    @Test
    public void testAddToBeginningLoop() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 3);
        snakeList.add(5);
        snakeList.add(3);
        snakeList.add(0, 23);
        Assert.assertArrayEquals(new Integer[]{5, 3, 23}, snakeList.toArray());
    }

    @Test
    public void testAddToMiddleFront() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 5);
        snakeList.add(5);
        snakeList.add(3);
        snakeList.add(125);
        snakeList.add(6);
        snakeList.add(71);
        snakeList.remove(0);
        snakeList.add(1, 12);
        Assert.assertArrayEquals(new Integer[]{3, 12, 125, 6, 71}, snakeList.toArray());
    }

    @Test
    public void testAddToMiddleEnd() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 5);
        snakeList.add(5);
        snakeList.add(3);
        snakeList.add(125);
        snakeList.add(6);
        snakeList.add(71);
        snakeList.remove(4);
        snakeList.add(3, 12);
        Assert.assertArrayEquals(new Integer[]{5, 3, 125, 12, 6}, snakeList.toArray());
    }

    @Test
    public void testAddToMiddleFrontLoop() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 5);
        snakeList.add(5);
        snakeList.add(3);
        snakeList.add(125);
        snakeList.add(6);
        snakeList.add(71);
        snakeList.remove(4);
        snakeList.add(1, 12);
        Assert.assertArrayEquals(new Integer[]{12, 3, 125, 6, 5}, snakeList.toArray());
    }

    @Test
    public void testAddToMiddleEndLoop() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 5);
        snakeList.add(5);
        snakeList.add(3);
        snakeList.add(125);
        snakeList.add(6);
        snakeList.add(71);
        snakeList.remove(0);
        snakeList.add(3, 12);
        Assert.assertArrayEquals(new Integer[]{71, 3, 125, 6, 12}, snakeList.toArray());
    }

    @Test
    public void testRemoveFromMiddleFront() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 5);
        snakeList.add(5);
        snakeList.add(3);
        snakeList.add(125);
        snakeList.add(6);
        snakeList.add(71);
        snakeList.remove(1);
        Assert.assertArrayEquals(new Integer[]{null, 5, 125, 6, 71}, snakeList.toArray());
    }

    @Test
    public void testRemoveFromMiddleEnd() {
        SnakeList<Integer> snakeList = new SnakeList(Integer.class, 5);
        snakeList.add(5);
        snakeList.add(3);
        snakeList.add(125);
        snakeList.add(6);
        snakeList.add(71);
        snakeList.remove(3);
        Assert.assertArrayEquals(new Integer[]{5, 3, 125, 71, null}, snakeList.toArray());
    }
}