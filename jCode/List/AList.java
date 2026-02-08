public class AList {
    private int[] items;
    private int size;

    /** create an empty list */
    public AList(){
        items = new int[100];
        size = 0;
    }

    /** when size = length, resize the array */
    private void resize(int capacity){
        int[] a = new int[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** add last item */
    public void addLast(int x){
        if(size == items.length){
            resize(size + 1);
        }
        items[size] = x;
        size += 1;
    }

    /** get the last item */
    public int getLast(){
        return items[size - 1];
    }

    /** get i'th item */
    public int get(int i){
        return items[i];
    }

    /** remove the last item */
    public int removeLast(){
        int x = getLast();
        size -= 1;
        return x;
    }
}
