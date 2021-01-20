public class ArraySet<Item> {
    private Item[] items;
    private int last;

    public ArraySet() {
        items = (Item[]) new Object[];
        last = 0;
    }

    public void add(Item x) {
        for (Item p : items) {
            if (p.equals(x)) {
                return;
            }
        }
        items[last] = x;
        last += 1;
    }

    public boolean contains(Item x) {
        for (Item p : items) {
            if (p.equals(x)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return items.length;
    }
}
