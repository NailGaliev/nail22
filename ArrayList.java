package com.company;

public class ArrayList<T> {
    private final int size = 16;
    private final int rate = 4;
    private Object[] arr = new Object[size];
    private int point = 0;


    public void add(T item) {
        if(point == arr.length-1)
            resize(arr.length*2);
        arr[point++] = item;
    }


    public T get(int index) {
        return (T) arr[index];
    }


    public void remove(int index) {
        for (int i = index; i<point; i++)
            arr[i] = arr[i+1];
        arr[point] = null;
        point--;
        if (arr.length > size && point < arr.length / rate)
            resize(arr.length/2);

    }

    public int size() {
        return point;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(arr, 0, newArray, 0, point);
        arr = newArray;
    }
}