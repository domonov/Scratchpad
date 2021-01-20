import java.util.Iterator;

public class ArraySet<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    public ArraySet() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    public void add(Item x) {

        if (contains(x) || x == null) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    public boolean contains(Item x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
       return size;
    }


    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
