package org.example;

import java.util.Arrays;
import java.util.Iterator;

public class ReverseCollection<T> implements Iterable<T> {
    private T[] array;

    @SafeVarargs
    public ReverseCollection(T... objs) {
        this.array = Arrays.copyOfRange(objs, 0, objs.length);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator();
    }

    class ReverseIterator implements Iterator<T> {
        int index;

        public ReverseIterator() {
            this.index = array.length;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return ReverseCollection.this.array[index];
        }
    }
}
