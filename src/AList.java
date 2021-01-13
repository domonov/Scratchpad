public class AList<Item> {

    private Item[] items;
    private int size;

    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    public void insert(Item x, int position) {

    }

    public void addFirst(Item x) {

    }

    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size += 1;
    }

    public Item getFirst() {
        return items[0];
    }

    public Item getLast() {
        return items[size - 1];
    }

    public Item get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

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
