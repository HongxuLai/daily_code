public class SLList {
    public class IntNode{
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    private IntNode first;
    private IntNode sentinel;
    private int size;

    /** add a new SLList with one item */
    public SLList(int x){
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** add an empty SLList */
    public SLList(){
        sentinel = new IntNode(0, null);
        size = 0;
    }

    /** add a new first item */
    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** get first item */
    public int getFirst(){
        return sentinel.next.item;
    }

    /** add a new last item */
    public void addLast(int x){
        size += 1;
        IntNode p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }
}
