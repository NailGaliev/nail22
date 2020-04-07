package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ArrayCollection<T> implements Collection<T> {

    private T[] m = (T[]) new Object[16];

    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(final Object o) {
        if (o == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if ( m[i].equals( ( (T[]) o ) ) ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return ArrayCollection.this.size > index;
            }

            @Override
            public T next() {
                return ArrayCollection.this.m[size++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        T[] newM = (T[]) new Object[this.size];
        System.arraycopy(m, 0, newM, 0, this.size);
        return newM;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) this.toArray();
    }

    @Override
    public boolean add(T e) {
        if (e == null) {
            return false;
        }
        if (size == m.length) {
            T[] newM = (T[]) new Object[size() << 1];
            System.arraycopy(m, 0, newM, 0, size);
            m = newM;
            m[size++] = e;
            return true;
        }
        m[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null || size == 0) {
            return false;
        }
        if (m[size - 1].equals(o)) {
            size--;
            return true;
        }
        for (int i = this.size - 1; i >= 0; i--) {
            if (m[i].equals(o)) {
                System.arraycopy(m, i + 1, m, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object object : c) {
            if (!this.contains(object)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.size() == 0 || c == null) {
            return false;
        }
        T[] secondeM = (T[]) c.toArray();
        T[] newM = (T[]) new Object[this.size + secondeM.length];
        System.arraycopy(this.m, 0, newM, 0, this.size);
        System.arraycopy(secondeM, 0, newM, this.size, secondeM.length);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.size() == 0 || c == null) {
            return false;
        }

        for (Object object : c) {
            this.remove(object);
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.size() == 0 || c == null) {
            return false;
        }
        for (Object object : this) {
            if (!c.contains(object)) {
                this.remove(object);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }
}
