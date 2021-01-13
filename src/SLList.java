import java.util.List;

/** SLList is an abstraction layer that uses IntNode to
 * create a list without dealing with "null" when initiating.
 */
public class SLList<Item> implements List61B<Item> {

    private class IntNode {
        Item item;
        IntNode next;

        IntNode(Item item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode sentinel;
    private IntNode last;
    private int size;

    public SLList() {
        sentinel = new IntNode(null, null);
        size = 0;
    }

    public SLList(Item x) {
        this();
        sentinel.next = new IntNode(x, null);
        last = sentinel.next;
        size += 1;
    }

    private void insert(IntNode node, Item x, int position) {
        if (position == 1) {
            if (last.next == null) {
                node.next = new IntNode(node.item, node.next);
                node.item = x;
                last = node.next;
                size += 1;
            } else {
                node.next = new IntNode(node.item, node.next);
                node.item = x;
                size += 1;
            }
        } else {
            insert(node.next, x, position - 1);
        }
    }

    public void insert(Item x, int pos) {
        if (size == 0 || pos > size) {
            addLast(x);
        } else {
            insert(sentinel.next, x, pos);
        }
    }

    public void addFirst(Item x) {
        sentinel.next = new IntNode(x, sentinel.next);
        if (last == null) {
            last = sentinel.next;
        }
        size += 1;
    }

    public void addLast(Item x) {
        if (last == null) {
            addFirst(x);
        } else {
            last.next = new IntNode(x, null);
            last = last.next;
            size += 1;
        }
    }

    public Item getFirst() {
        if (size > 0) {
            return sentinel.next.item;
        }
        return null;
    }

    public Item getLast() {
        if (last != null) {
            return last.item;
        }
        return null;
    }

    public Item get(int i) {
        return get(sentinel.next, i);
    }

    private Item get(IntNode list, int i) {
        if (i == 0) {
            return list.item;
        }
        return get(list.next, i - 1);
    }

    public int size() {
        return size;
    }

    public Item removeLast() {
        // iterate until you reach a node whose next = last
        // point last to that node and node.next == null;
        IntNode p = sentinel;
        while (p.next != null) {
            if (p.next.equals(last)) {
                last = p;
                p.next = null;
                return p.item;
            }
        }
        return null;
    }
}
