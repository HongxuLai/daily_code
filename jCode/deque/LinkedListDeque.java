package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{

    private class Node{
        T item;
        Node prev;
        Node next;
        Node(T i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    // create an empty deque
    public LinkedListDeque(){
        sentinel = new Node(null, null, null); // item is dummy for sentinel
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    // add T type item to the front of the deque
    @Override
    public void addFirst(T item){
        Node n = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;
        size ++;
    }

    // add T type item to the last of the deque
    @Override
    public void addLast(T item){
        Node n = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
        size ++;
    }

    @Override
    public int size(){
        return size;
    }

    // print the item in the deque and print a new line after all items are printed
    @Override
    public void printDeque(){
        Node p = sentinel.next;
        while (p != sentinel){
            System.out.print(p.item);
            if (p.next != sentinel) {
                System.out.print(" ");
            }
            p = p.next;
        }
        System.out.println( );
    }

    // remove the first item of the deque
    @Override
    public T removeFirst(){
        if (size == 0) return null;
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size --;
        return first.item;
    }

    // remove the last item of the deque
    @Override
    public T removeLast(){
        if (size == 0) return null;
        Node last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        size --;
        return last.item;
    }

    // get index + 1'th item
    @Override
    public T get(int index){
        Node p = sentinel.next;
        if (index < 0 || index >= size) return null;
        for (int i = 0; i < index; i++){
            p = p.next;
        }
        return p.item;
    }

    // get index + 1'th item using recursion
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(p.next, index - 1);
    }

    @Override
    public Iterator<T> iterator(){
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {

        private Node p;

        DequeIterator() {
            p = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            return p != sentinel;
        }

        @Override
        public T next() {
            T item = p.item;
            p = p.next;
            return item;
        }
    }

    public boolean equals(Object o){
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
