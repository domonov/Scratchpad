public class AList<Item> implements List61B<Item> {

    private Item[] items;
    private int size;

    public AList() {
        items = (Item[]) new Object[16];
        size = 0;
    }

    @Override
    public void insert(Item x, int position) {
        Item[] temp = (Item[]) new Object[items.length + 1];

        System.arraycopy(items, 0, temp, 0, position);
        temp[position] = x;

        System.arraycopy(items, position, temp, position + 1, items.length - position);
        items = temp;
    }

    @Override
    public void addFirst(Item x) {
       insert(x, 0);
    }

    @Override
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size += 1;
    }

    @Override
    public Item getFirst() {
        return items[0];
    }

    @Override
    public Item getLast() {
        return items[size - 1];
    }

    @Override
    public Item get(int i) {
        return items[i];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Item removeLast() {
        if (size < items.length / 2) {
            resize(items.length / 2);
        }
        Item last = getLast();
        items[size - 1] = null;
        size -= 1;
        return last;
    }

    private void resize(int newSize) {
        Item[] p = (Item[]) new Object[newSize];
        System.arraycopy(items, 0, p, 0, size);
        items = p;
    }
}
