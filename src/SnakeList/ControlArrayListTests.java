package SnakeList;
import org.junit.Assert;
import org.junit.Test;

public class ControlArrayListTests {
    @Test
    public void testDefaultConstructor() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class);
        Assert.assertNotEquals(null, ControlArrayList);
    }

    @Test
    public void testCapacityConstructor() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 11);
        Assert.assertArrayEquals(new Integer[11], ControlArrayList.toArray());
    }

    @Test
    public void testArrayConstructor() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{6, 3, 68, 2, 8});
        Assert.assertArrayEquals(new Integer[]{6, 3, 68, 2, 8}, ControlArrayList.toArray());
    }

    @Test
    public void testAdd() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 3);
        ControlArrayList.add(5);
        ControlArrayList.add(9);
        ControlArrayList.add(2);
        Assert.assertArrayEquals(new Integer[]{5, 9, 2}, ControlArrayList.toArray());
    }

    @Test
    public void testSet() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 4);
        ControlArrayList.add(5);
        ControlArrayList.add(9);
        ControlArrayList.add(2);
        ControlArrayList.add(6);
        ControlArrayList.set(1, 16);
        Assert.assertArrayEquals(new Integer[]{5, 16, 2, 6}, ControlArrayList.toArray());
    }

    @Test
    public void testRemoveFromBeginning() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{5, 9, 2, 8});
        ControlArrayList.remove(0);
        Assert.assertArrayEquals(new Integer[]{null, 9, 2, 8}, ControlArrayList.toArray());
    }

    @Test
    public void testRemoveFromEnd() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{5, 9, 2, 8});
        ControlArrayList.remove(3);
        Assert.assertArrayEquals(new Integer[]{5, 9, 2, null}, ControlArrayList.toArray());
    }

    @Test
    public void testRemoveFromEndLoop() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{5, 9, 2, 8});
        ControlArrayList.remove(0);
        ControlArrayList.add(3, 17);
        ControlArrayList.remove(3);
        Assert.assertArrayEquals(new Integer[]{null, 9, 2, 8}, ControlArrayList.toArray());
    }

    @Test
    public void testGet() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{6, 3, 68, 2, 8});
        Assert.assertEquals((Integer) 68, ControlArrayList.get(2));
    }

    @Test
    public void testGetLoop() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{6, 3, 68, 2, 8});
        Assert.assertEquals((Integer) 3, ControlArrayList.get(6));
    }

    @Test
    public void testIndexOf() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(2, ControlArrayList.indexOf(3));
    }


    @Test
    public void testIndexOfLoop() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 5);
        ControlArrayList.add(5);
        ControlArrayList.add(5);
        ControlArrayList.add(5);
        ControlArrayList.add(5);
        ControlArrayList.add(5);
        ControlArrayList.remove(0);
        ControlArrayList.remove(0);
        ControlArrayList.add(1);
        Assert.assertEquals(3, ControlArrayList.indexOf(1));
    }

    @Test
    public void testFalseIndexOf() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(-1, ControlArrayList.indexOf(21321));
    }

    @Test
    public void testDuplicateIndexOf() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{1, 3, 1, 3, 9});
        Assert.assertEquals(1, ControlArrayList.indexOf(3));
    }

    @Test
    public void testLastIndexOf() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{1, 3, 1, 3, 9});
        Assert.assertEquals(3, ControlArrayList.lastIndexOf(3));
    }

    @Test
    public void testContains() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(true, ControlArrayList.contains(4));
    }

    @Test
    public void testContainsFalse() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(false, ControlArrayList.contains(48));
    }

    @Test
    public void testRemoveObject() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        ControlArrayList.remove((Integer) 3);
        Assert.assertArrayEquals(new Integer[]{null, 1, 7, 4, 9}, ControlArrayList.toArray());
    }

    @Test
    public void testClear() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        ControlArrayList.clear();
        Assert.assertArrayEquals(new Integer[]{null, null, null, null, null}, ControlArrayList.toArray());
        Assert.assertEquals(0, ControlArrayList.size());
    }

    @Test
    public void testResize() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 0);
        ControlArrayList.Resize(3);
        ControlArrayList.add(5);
        ControlArrayList.add(9);
        ControlArrayList.add(2);
        Assert.assertArrayEquals(new Integer[]{5, 9, 2}, ControlArrayList.toArray());
    }

    @Test
    public void testResizeCopy() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 3);
        ControlArrayList.add(5);
        ControlArrayList.add(9);
        ControlArrayList.add(2);
        ControlArrayList.Resize(5);
        Integer[] testArray = new Integer[ControlArrayList.array.length];
        testArray[0] = 5;
        testArray[1] = 9;
        testArray[2] = 2;
        Assert.assertArrayEquals(testArray, ControlArrayList.toArray());
    }

    @Test
    public void testAddResize() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 0);
        ControlArrayList.add(12);
        ControlArrayList.add(7);
        ControlArrayList.add(41);
        Integer[] testArray = new Integer[ControlArrayList.array.length];
        testArray[0] = 12;
        testArray[1] = 7;
        testArray[2] = 41;
        Assert.assertArrayEquals(testArray, ControlArrayList.toArray());
    }

    @Test
    public void testAddToBeginning() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 3);
        ControlArrayList.add(5);
        ControlArrayList.add(3);
        ControlArrayList.add(8);
        ControlArrayList.remove(0);
        ControlArrayList.add(0, 23);
        Assert.assertArrayEquals(new Integer[]{23, 3, 8}, ControlArrayList.toArray());
    }

    @Test
    public void testAddToBeginningLoop() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 3);
        ControlArrayList.add(5);
        ControlArrayList.add(3);
        ControlArrayList.add(0, 23);
        Assert.assertArrayEquals(new Integer[]{5, 3, 23}, ControlArrayList.toArray());
    }

    @Test
    public void testAddToMiddleFront() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 5);
        ControlArrayList.add(5);
        ControlArrayList.add(3);
        ControlArrayList.add(125);
        ControlArrayList.add(6);
        ControlArrayList.add(71);
        ControlArrayList.remove(0);
        ControlArrayList.add(1, 12);
        Assert.assertArrayEquals(new Integer[]{3, 12, 125, 6, 71}, ControlArrayList.toArray());
    }

    @Test
    public void testAddToMiddleEnd() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 5);
        ControlArrayList.add(5);
        ControlArrayList.add(3);
        ControlArrayList.add(125);
        ControlArrayList.add(6);
        ControlArrayList.add(71);
        ControlArrayList.remove(4);
        ControlArrayList.add(3, 12);
        Assert.assertArrayEquals(new Integer[]{5, 3, 125, 12, 6}, ControlArrayList.toArray());
    }

    @Test
    public void testAddToMiddleFrontLoop() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 5);
        ControlArrayList.add(5);
        ControlArrayList.add(3);
        ControlArrayList.add(125);
        ControlArrayList.add(6);
        ControlArrayList.add(71);
        ControlArrayList.remove(4);
        ControlArrayList.add(1, 12);
        Assert.assertArrayEquals(new Integer[]{12, 3, 125, 6, 5}, ControlArrayList.toArray());
    }

    @Test
    public void testAddToMiddleEndLoop() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 5);
        ControlArrayList.add(5);
        ControlArrayList.add(3);
        ControlArrayList.add(125);
        ControlArrayList.add(6);
        ControlArrayList.add(71);
        ControlArrayList.remove(0);
        ControlArrayList.add(3, 12);
        Assert.assertArrayEquals(new Integer[]{71, 3, 125, 6, 12}, ControlArrayList.toArray());
    }

    @Test
    public void testRemoveFromMiddleFront() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 5);
        ControlArrayList.add(5);
        ControlArrayList.add(3);
        ControlArrayList.add(125);
        ControlArrayList.add(6);
        ControlArrayList.add(71);
        ControlArrayList.remove(1);
        Assert.assertArrayEquals(new Integer[]{null, 5, 125, 6, 71}, ControlArrayList.toArray());
    }

    @Test
    public void testRemoveFromMiddleEnd() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(Integer.class, 5);
        ControlArrayList.add(5);
        ControlArrayList.add(3);
        ControlArrayList.add(125);
        ControlArrayList.add(6);
        ControlArrayList.add(71);
        ControlArrayList.remove(3);
        Assert.assertArrayEquals(new Integer[]{5, 3, 125, 71, null}, ControlArrayList.toArray());
    }

    @Test
    public void testSubList() {
        ControlArrayList<Integer> ControlArrayList = new ControlArrayList(new Integer[]{6, 1, 3, 7, 8});
        Assert.assertArrayEquals(new Integer[]{1, 3, 7}, ControlArrayList.subList(1, 3).toArray());
    }
}
