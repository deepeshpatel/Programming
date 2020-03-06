package com.sutra.algo.util;

import java.util.Iterator;
import java.util.List;


/**
 * @author Deepesh Patel
 * <p>
 * Iterator to iterate over multiple Iterable in order.
 */
public class IteratorSequence<T> implements Iterator<T> {

    private List<Iterable<T>> iterables;
    private Iterator<T> current;

    public IteratorSequence(List<Iterable<T>> iterables) {
        this.iterables = iterables;
        current = iterables.remove(iterables.size() - 1).iterator();
    }

    @Override
    public boolean hasNext() {

        if (current.hasNext()) {
            return true;
        }

        if (iterables.size() == 0) {
            return false;
        }

        current = iterables.remove(iterables.size() - 1).iterator();
        return hasNext();
    }

    @Override
    public T next() {
        return current.next();
    }
}