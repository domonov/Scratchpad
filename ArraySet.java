import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    /** To support the enhanced for loop, compiler checks if there is an iterator method in the data structure
     * and if the iterator interface has hasNext() and next() methods inside. If those two conditions are met, then
     * compiler allows the data structure to be used in the enhanced for loop.
     */

    @Override
    public Iterator<Item> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<Item> {
        private int curr;

        public ArraySetIterator() {
            curr = 0;
        }

        @Override
        public boolean hasNext() {
            return curr < size;
        }

        @Override
        public Item next() {
            Item returnItem = items[curr];
            curr += 1;
            return returnItem;
        }
    }

    /*@Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            returnSB.append(items[i]);
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }*/

    @Override
    public String toString() {
        List<String> listOfItems = new ArrayList<>();
        for (Item p : this) {
            listOfItems.add(p.toString());
        }
        return "{" + String.join(", ", listOfItems) + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        ArraySet<Item> other = (ArraySet<Item>) obj;
        if (this.size != other.size) {
            return false;
        }
        for (Item p : this) {
            if (!other.contains(p)) {
                return false;
            }
        }
        return true;
    }

    public static <Stuff> ArraySet<Stuff> of(Stuff... stuff) {
        ArraySet<Stuff> returnSet = new ArraySet<>();
        for (Stuff p : stuff) {
            returnSet.add(p);
        }
        return returnSet;
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

        for (String p : s) {
            System.out.println(p);
        }

        System.out.println("Below is an ugly iterator:");
        Iterator<String> seer = s.iterator();
        while (seer.hasNext()) {
            System.out.println(seer.next());
        }

        System.out.println("Below is our ArraySet:");
        System.out.println(s);

        System.out.println("Below is the equals() check:");
        ArraySet<String> another = ArraySet.of("Davron", "Nelly");
        System.out.println(s.equals(another));
    }
}
