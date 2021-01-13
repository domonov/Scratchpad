/** AList2 is an array based circular list. */
public class AList2<Item> implements List61B<Item> {

    private Item[] items;
    private int first;
    private int last;
    private int size;

    public AList2() {
        items = (Item[]) new Object[16];
        size = 0;
        first = 0;
        last = 0;
    }

    @Override
    public void addFirst(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[first] = x;
        size += 1;
        decrement(first);
    }

    private void decrement(int first) {
        if (first == 0) {
            this.first = items.length - 1;
        } else {
            this.first -= 1;
        }
    }

    @Override
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[last] = x;
        increment(last);
        size += 1;
    }

    private void increment(int last) {
        if (last == items.length - 1) {
            this.last = 0;
        } else {
            this.last += 1;
        }
    }

    @Override
    public void insert(Item x, int position) {

    }

    @Override
    public Item getFirst() {
        return null;
    }

    @Override
    public Item getLast() {
        return null;
    }

    @Override
    public Item get(int position) {
        return null;
    }

    @Override
    public Item removeLast() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }
}
