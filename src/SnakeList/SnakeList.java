package SnakeList;

import java.lang.reflect.Array;
import java.util.*;

public class SnakeList<T> implements List {
    protected T[] array;
    protected int size;
    protected int start;

    public SnakeList(Class<T> c) {
        this(c, 10);
    }

    public SnakeList(Class<T> c, int capacity) {
        this.array = (T[]) Array.newInstance(c, capacity);
        this.size = 0;
        this.start = 0;
    }

    public SnakeList(T[] array) {
        this.array = array;
        this.size = array.length;
        this.start = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public boolean add(Object o) {
        add(size, o);
        return true;
    }

    @Override
    public void add(int index, Object element) {
        T e = (T) element;
        if (size + 1 > array.length) {
            Resize(Math.max(array.length, 1));
        }
        if (index <= 0 && size != 0) {
            start--;
            if (start == -1)
                start = array.length - 1;
            else
                start = getRealIndex(0);
            array[start] = e;
            size++;
        } else if (index >= size) {
            array[getRealIndex(index)] = e;
            size++;
        } else {
            if (index <= size / 2) {
                add(index - 1, get(index - 1));
            } else {
                add(index + 1, get(index));
            }
            array[getRealIndex(index)] = e;
        }
    }

    @Override
    public Object remove(int index) {
        if (size == 0)
            return null;
        T e = get(index);
        if (index <= 0) {
            array[start] = null;
            start = getRealIndex(1);
            size--;
        } else if (index >= size - 1) {
            array[getRealIndex(index)] = null;
            size--;
        } else {
            if (index <= size / 2) {
                array[getRealIndex(index)] = (T) remove(index - 1);
            } else {
                array[getRealIndex(index)] = (T) remove(index + 1);
            }
        }
        return e;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1)
            return false;
        remove(index);
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    public void Resize(int amount) {
        T[] newArray = (T[]) Array.newInstance(array.getClass().componentType(), size + amount);
        for (int i = 0; i < size; i++) {
            newArray[i] = get(i);
        }
        start = 0;
        array = newArray;
    }

    @Override
    public void clear() {
        for (int i = size - 1; i >= 0; i--) {
            remove(i);
        }
    }

    @Override
    public T get(int index) {
        return array[getRealIndex(index)];
    }

    @Override
    public T set(int index, Object element) {
        if (size == 0 || index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        T oldElement = get(index);
        array[getRealIndex(index)] = (T)element;
        return oldElement;
    }

    protected int getRealIndex(int index) {
        if (array.length == 0)
            return 0;
        return (index + start) % array.length;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (get(i).equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public SnakeList subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        T[] newArray = (T[]) Array.newInstance(array.getClass().componentType(), toIndex - fromIndex + 1);
        for (int i = 0; i < toIndex - fromIndex + 1; i++) {
            newArray[i] = get(i + fromIndex);
        }
        return new SnakeList(newArray);
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, array.length);
    }

    public Object[] toExactArray() {
        T[] newArray = (T[])Array.newInstance(array.getClass().componentType(),size);
        for (int i = 0; i < size; i++) {
            newArray[i] = get(i);
        }
        return newArray;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}