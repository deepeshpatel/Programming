/*
 * Copyright (c) 2020 Deepesh Patel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sutra.algo.util;

import java.util.*;

public class IndexedListWrapper<T> implements List<T> {

    private List<T> data;
    private int[] indices;

    public IndexedListWrapper(List<T> data, int[] indices) {
        this.data = data;
        this.indices = indices;
    }

    @Override
    public int size() {
        return indices.length;
    }

    @Override
    public boolean isEmpty() {
        return indices.length > 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr(0);
    }

    @Override
    public Object[] toArray() {
        List<T> temp = new ArrayList<>();
        for(T t: this) {
            temp.add(t);
        }
        return temp.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        List<T> temp = new ArrayList<>();
        for(T t: this) {
            temp.add(t);
        }
        return temp.toArray(a);
    }

    @Override
    public boolean add(T t) {
        throwUnsupportedOException();
        return false;
    }

    @Override
    public boolean remove(Object o) {
        throwUnsupportedOException();
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throwUnsupportedOException();
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throwUnsupportedOException();
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throwUnsupportedOException();
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throwUnsupportedOException();
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throwUnsupportedOException();
        return false;
    }

    @Override
    public void clear() {
        throwUnsupportedOException();
    }

    @Override
    public T get(int index) {
        return data.get(indices[index]);
    }

    @Override
    public T set(int index, T element) {
        throwUnsupportedOException();
        return null;
    }

    @Override
    public void add(int index, T element) {
        throwUnsupportedOException();
    }

    @Override
    public T remove(int index) {
        throwUnsupportedOException();
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < indices.length; i++)
                if (data.get(indices[i])==null)
                    return i;
        } else {
            for (int i = 0; i < indices.length; i++)
                if (o.equals(data.get(indices[i])))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new Itr(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new Itr(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throwUnsupportedOException();
        return null;
    }

    private void throwUnsupportedOException() {
        throw new UnsupportedOperationException("Method not supported for this view only list");
    }

    @Override
    public String toString() {
        Iterator<T> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            T e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    private class Itr implements ListIterator<T> {

        private int index;

        private Itr(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index<indices.length;
        }

        @Override
        public T next() {
            return data.get(indices[index++]);
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public T previous() {
            if (index < 0)
                throw new NoSuchElementException();
            return data.get(indices[index-1]);
        }

        @Override
        public int nextIndex() {
            return index+1;
        }

        @Override
        public int previousIndex() {
            return index-1;
        }

        @Override
        public void remove() {
            throwUnsupportedOException();
        }

        @Override
        public void set(T t) {
            throwUnsupportedOException();
        }

        @Override
        public void add(T t) {
            throwUnsupportedOException();
        }
    }
}
