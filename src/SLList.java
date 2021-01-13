/** SLList is an abstraction layer that uses IntNode to
 * create a list without dealing with "null" when initiating.
 */
public class SLList<Item> implements List61B<Item> {

    private class Node {
        Item item;
        Node next;

        Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(Item x) {
        this();
        sentinel.next = new Node(x, sentinel);
        size += 1;
    }

    private void insert(Node node, Item x, int position) {
        if (position == 1) {
            node.next = new Node(node.item, node.next);
            node.item = x;
            size += 1;
        }
        insert(node.next, x, position - 1);
    }

    @Override
    public void insert(Item x, int position) {
        if (size == 0 || position > size) {
            addLast(x);
        } else {
            insert(sentinel.next, x, position);
        }
    }

    @Override
    public void addFirst(Item x) {
        sentinel.next = new Node(x, sentinel.next);
        size += 1;
    }

    @Override
    public void addLast(Item x) {
        // traverse until i find the node whose next is sentinel
        Node p = sentinel.next;
        while (p.next != sentinel) {
            p = p.next;
        }
        p.next = new Node(x, p.next);
    }

    @Override
    public Item getFirst() {
        if (size > 0) {
            return sentinel.next.item;
        }
        return null;
    }

    @Override
    public Item getLast() {
        Node p = sentinel.next;
        while (p.next != sentinel) {
            p = p.next;
        }
        return p.item;
    }

    @Override
    public Item get(int i) {
        return get(sentinel.next, i);
    }

    private Item get(Node list, int i) {
        if (i == 0) {
            return list.item;
        }
        return get(list.next, i - 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Item removeLast() {
        Node p = sentinel.next;
        while (p.next.next != sentinel) {
            p = p.next;
        }
        p.next = p.next.next;
        return null;
    }

    @Override
    public void print() {
        for (Node p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }
}
