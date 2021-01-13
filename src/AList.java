public class AList<Item> implements List61B<Item> {

    private Item[] items;
    private int size;

    public AList() {
        items = (Item[]) new Object[16];
        size = 0;
    }

    @Override
    public void insert(Item x, int position) {
        if (size == items.length) {
            resize(size * 2);
        }
        Item[] temp = (Item[]) new Object[items.length];
        System.arraycopy(items, 0, temp, 0, position + 1);
        temp[position] = x;
        System.arraycopy(items, position + 1, temp, position + 1, size - position);
        items = temp;
        size += 1;
    }

    @Override
    public void addFirst(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        Item[] temp = (Item[]) new Object[items.length];
        temp[0] = x;
        System.arraycopy(items, 0, temp, 1, size);
        items = temp;
        size += 1;
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
