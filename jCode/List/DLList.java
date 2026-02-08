public class DLList {

    /** make DLList by making linked sentinel circular */
    private class Node{
        int item;
        Node prev;
        Node next;
        Node(int i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /** make an empty DLList */
    public DLList(){
        sentinel = new Node(0, null, null); // item is dummy for sentinel
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** add a new first node */
    public void addFirst(int x){
        Node n = new Node(x, null, null);
        sentinel.next.prev = n;
        sentinel.next = n;
        size ++;
    }

    /** add a new last node */
    public void addLast(int x){
        Node n = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
        size ++;
    }

    /** remove the last item */
    public int removeLast(){
        if (size == 0) {
            return -1;
        }
        Node last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        size--;
        return last.item;
    }

    /** remove the first item */
    public int removeFirst() {
        if (size == 0) {
            return -1;
        }
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return first.item;
    }
}
