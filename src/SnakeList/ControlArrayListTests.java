package SnakeList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ControlArrayListTests {
    @Test
    public void testDefaultConstructor() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class);
        Assert.assertNotEquals(null, controlArrayList);
    }

    @Test
    public void testCapacityConstructor() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 11);
        Assert.assertArrayEquals(new Integer[0], controlArrayList.toArray());
        Assert.assertEquals(0, controlArrayList.size());
    }

    @Test
    public void testArrayConstructor() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{6, 3, 68, 2, 8});
        Assert.assertArrayEquals(new Integer[]{6, 3, 68, 2, 8}, controlArrayList.toArray());
    }

    @Test
    public void testAdd() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 3);
        controlArrayList.add(5);
        controlArrayList.add(9);
        controlArrayList.add(2);
        Assert.assertArrayEquals(new Integer[]{5, 9, 2}, controlArrayList.toArray());
    }

    @Test
    public void testSet() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 4);
        controlArrayList.add(5);
        controlArrayList.add(9);
        controlArrayList.add(2);
        controlArrayList.add(6);
        controlArrayList.set(1, 16);
        Assert.assertArrayEquals(new Integer[]{5, 16, 2, 6}, controlArrayList.toArray());
    }

    @Test
    public void testRemoveFromBeginning() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{5, 9, 2, 8});
        controlArrayList.remove(0);
        Assert.assertArrayEquals(new Integer[]{9, 2, 8}, controlArrayList.toArray());
    }

    @Test
    public void testRemoveFromEnd() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{5, 9, 2, 8});
        controlArrayList.remove(3);
        Assert.assertArrayEquals(new Integer[]{5, 9, 2}, controlArrayList.toArray());
    }

    @Test
    public void testRemoveFromEndLoop() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{5, 9, 2, 8});
        controlArrayList.remove(0);
        controlArrayList.add(3, 17);
        controlArrayList.remove(3);
        Assert.assertArrayEquals(new Integer[]{9, 2, 8}, controlArrayList.toArray());
    }

    @Test
    public void testGet() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{6, 3, 68, 2, 8});
        Assert.assertEquals((Integer) 68, controlArrayList.get(2));
    }

    @Test
    public void testIndexOf() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(2, controlArrayList.indexOf(3));
    }


    @Test
    public void testIndexOfLoop() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 5);
        controlArrayList.add(5);
        controlArrayList.add(5);
        controlArrayList.add(5);
        controlArrayList.add(5);
        controlArrayList.add(5);
        controlArrayList.remove(0);
        controlArrayList.remove(0);
        controlArrayList.add(1);
        Assert.assertEquals(3, controlArrayList.indexOf(1));
    }

    @Test
    public void testFalseIndexOf() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(-1, controlArrayList.indexOf(21321));
    }

    @Test
    public void testDuplicateIndexOf() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{1, 3, 1, 3, 9});
        Assert.assertEquals(1, controlArrayList.indexOf(3));
    }

    @Test
    public void testLastIndexOf() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{1, 3, 1, 3, 9});
        Assert.assertEquals(3, controlArrayList.lastIndexOf(3));
    }

    @Test
    public void testContains() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(true, controlArrayList.contains(4));
    }

    @Test
    public void testContainsFalse() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        Assert.assertEquals(false, controlArrayList.contains(48));
    }

    @Test
    public void testRemoveObject() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        controlArrayList.remove((Integer) 3);
        Assert.assertArrayEquals(new Integer[]{ 1, 7, 4, 9}, controlArrayList.toArray());
    }

    @Test
    public void testClear() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{1, 7, 3, 4, 9});
        controlArrayList.clear();
        Assert.assertArrayEquals(new Integer[]{ }, controlArrayList.toArray());
        Assert.assertEquals(0, controlArrayList.size());
    }

    @Test
    public void testResize() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 0);
        controlArrayList.resize(3);
        controlArrayList.add(5);
        controlArrayList.add(9);
        controlArrayList.add(2);
        Assert.assertArrayEquals(new Integer[]{5, 9, 2}, controlArrayList.toArray());
    }

    @Test
    public void testResizeCopy() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 3);
        controlArrayList.add(5);
        controlArrayList.add(9);
        controlArrayList.add(2);
        controlArrayList.resize(5);
        Integer[] testArray = new Integer[3];
        testArray[0] = 5;
        testArray[1] = 9;
        testArray[2] = 2;
        Assert.assertArrayEquals(testArray, controlArrayList.toArray());
    }

    @Test
    public void testAddResize() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 0);
        controlArrayList.add(12);
        controlArrayList.add(7);
        controlArrayList.add(41);
        Integer[] testArray = new Integer[3];
        testArray[0] = 12;
        testArray[1] = 7;
        testArray[2] = 41;
        Assert.assertArrayEquals(testArray, controlArrayList.toArray());
    }

    @Test
    public void testAddToBeginning() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 3);
        controlArrayList.add(5);
        controlArrayList.add(3);
        controlArrayList.add(8);
        controlArrayList.remove(0);
        controlArrayList.add(0, 23);
        Assert.assertArrayEquals(new Integer[]{23, 3, 8}, controlArrayList.toArray());
    }

    @Test
    public void testAddToMiddleFront() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 5);
        controlArrayList.add(5);
        controlArrayList.add(3);
        controlArrayList.add(125);
        controlArrayList.add(6);
        controlArrayList.add(71);
        controlArrayList.remove(0);
        controlArrayList.add(1, 12);
        Assert.assertArrayEquals(new Integer[]{3, 12, 125, 6, 71}, controlArrayList.toArray());
    }

    @Test
    public void testAddToMiddleEnd() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 5);
        controlArrayList.add(5);
        controlArrayList.add(3);
        controlArrayList.add(125);
        controlArrayList.add(6);
        controlArrayList.add(71);
        controlArrayList.remove(4);
        controlArrayList.add(3, 12);
        Assert.assertArrayEquals(new Integer[]{5, 3, 125, 12, 6}, controlArrayList.toArray());
    }

    @Test
    public void testAddToMiddleFrontLoop() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 5);
        controlArrayList.add(5);
        controlArrayList.add(3);
        controlArrayList.add(125);
        controlArrayList.add(6);
        controlArrayList.add(71);
        controlArrayList.remove(4);
        controlArrayList.add(1, 12);
        ArrayList<Integer> test = new ArrayList<Integer>(5);
        test.add(5);
        test.add(3);
        test.add(125);
        test.add(6);
        test.add(71);
        test.remove(4);
        test.add(1, 12);
        Assert.assertArrayEquals(test.toArray(), controlArrayList.toArray());
    }

    @Test
    public void testAddToMiddleEndLoop() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 5);
        controlArrayList.add(5);
        controlArrayList.add(3);
        controlArrayList.add(125);
        controlArrayList.add(6);
        controlArrayList.add(71);
        controlArrayList.remove(0);
        controlArrayList.add(3, 12);
        ArrayList<Integer> arrayList = new ArrayList<Integer>(5);
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(125);
        arrayList.add(6);
        arrayList.add(71);
        arrayList.remove(0);
        arrayList.add(3,12);
        Assert.assertArrayEquals(arrayList.toArray(), controlArrayList.toArray());
    }

    @Test
    public void testRemoveFromMiddleFront() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 5);
        controlArrayList.add(5);
        controlArrayList.add(3);
        controlArrayList.add(125);
        controlArrayList.add(6);
        controlArrayList.add(71);
        controlArrayList.remove(1);
        ArrayList<Integer> arrayList = new ArrayList<Integer>(5);
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(125);
        arrayList.add(6);
        arrayList.add(71);
        arrayList.remove(1);
        Assert.assertArrayEquals(arrayList.toArray(), controlArrayList.toArray());
    }

    @Test
    public void testRemoveFromMiddleEnd() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(Integer.class, 5);
        controlArrayList.add(5);
        controlArrayList.add(3);
        controlArrayList.add(125);
        controlArrayList.add(6);
        controlArrayList.add(71);
        controlArrayList.remove(3);
        ArrayList<Integer> arrayList = new ArrayList<Integer>(5);
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(125);
        arrayList.add(6);
        arrayList.add(71);
        arrayList.remove(3);
        Assert.assertArrayEquals(arrayList.toArray(), controlArrayList.toArray());
    }

    @Test
    public void testSubList() {
        ControlArrayList<Integer> controlArrayList = new ControlArrayList(new Integer[]{6, 1, 3, 7, 8});
        Assert.assertArrayEquals(new Integer[]{1, 3, 7}, controlArrayList.subList(1, 3).toArray());
    }
}
