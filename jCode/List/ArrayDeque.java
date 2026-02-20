package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    // create an empty list
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    // helper for the index minus one
    private int minusOne(int x){
        if(x - 1 < 0) {
            x = (x - 1 + items.length) % items.length;
        }
        else{
            x = x - 1;
        }
        return x;
    }

    // helper for the index plus one
    private int plusOne(int x){
        if(x + 1 < items.length){
            x = x + 1;
        }
        else{
            x = x + 1 - items.length;
        }
        return x;
    }

    // resize the array
    private void resize(int capacity){
        T[] newItems = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst) % items.length; // nextFirst + 1 is always the index of the first item

        for(int i = 0; i < size; i++){
            newItems[i] = items[oldIndex];
            oldIndex = plusOne(oldIndex) % items.length;
        }
        items = newItems;

        nextFirst = capacity - 1;
        nextLast = size;
    }

    // a helper for checking the size before adding and after removing
    private void check(){
        if(size == items.length){
            resize(items.length * 2);
        }
        else if(items.length >= 16 && size < items.length / 4){
            resize(items.length / 2);
        }
    }

    // add T type item to the front of the deque
    @Override
    public void addFirst(T item){
        check();
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size ++;
    }

    // add T type item to the last of the deque
    @Override
    public void addLast(T item){
        check();
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size ++;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        int index = plusOne(nextFirst) % items.length;
        for (int i = 0; i < size; i++){
            System.out.print(items[index]);
            if(i < size - 1){
                System.out.println(" ");
            }
            index = plusOne(index) % items.length;
        }
        System.out.println( );
    }

    // remove the first item of the deque
    @Override
    public T removeFirst(){
        if(size == 0) return null;
        nextFirst = plusOne(nextFirst);
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;
        check();
        return item;
    }

    @Override
    // remove the first item of the deque
    public T removeLast(){
        if(size == 0) return null;
        nextLast = minusOne(nextLast);
        T item = items[nextLast];
        items[nextLast] = null;
        size --;
        check();
        return item;
    }

    // get index + 1'th item
    @Override
    public T get(int index){
        if (index < 0 || index >= size) return null;
        int originIndex = (plusOne(nextFirst) + index) % items.length;
        return items[originIndex];
    }

    @Override
    public Iterator<T> iterator(){
        return new DequeIterator();
    }
    private class DequeIterator implements Iterator<T>{

        private int index;
        private int count;

        DequeIterator(){
            index = plusOne(nextFirst);
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            T item = items[index];
            index = plusOne(index);
            count ++;
            return item;
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque<?>)) {
            return false;
        }

        Deque<?> other = (Deque<?>) o;

        if (this.size() != other.size()) {
            return false;
        }

        Iterator<T> it1 = this.iterator();
        Iterator<?> it2 = other.iterator();

        while (it1.hasNext() && it2.hasNext()) {
            T item1 = it1.next();
            Object item2 = it2.next();

            if (item1 == null) {
                if (item2 != null) {
                    return false;
                }
            } else {
                if (!item1.equals(item2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
