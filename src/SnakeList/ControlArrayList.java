package SnakeList;

import java.lang.reflect.Array;
import java.util.*;

public class ControlArrayList<T> implements List {
    protected T[] array;
    protected int size;

    public ControlArrayList(Class<T> c) {
        this(c, 10);
    }

    public ControlArrayList(Class<T> c, int capacity) {
        this.array = (T[]) Array.newInstance(c, capacity);
        this.size = 0;
    }

    public ControlArrayList(T[] array) {
        this.array = array;
        this.size = array.length;
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
            resize(Math.max(array.length, 1));
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = e;
        size++;
    }

    @Override
    public Object remove(int index) {
        if (size == 0)
            return null;
        T e = get(index);
        for (int i = index; i + 1 < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
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

    public void resize(int amount) {
        T[] newArray = (T[]) Array.newInstance(array.getClass().componentType(), size + amount);
        System.arraycopy(array, 0, newArray, 0, size);
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
        return array[index];
    }

    @Override
    public T set(int index, Object element) {
        if (size == 0 || index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        T oldElement = get(index);
        array[index] = (T) element;
        return oldElement;
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
        return Arrays.copyOf(array, size);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
