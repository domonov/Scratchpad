/** SLList is an abstraction layer that uses IntNode to
 * create a list without dealing with "null" when initiating.
 */
public class SLList<Item> implements List61B<Item> {

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<Item> sentinel;
    private int size;

    public SLList() {
        sentinel = new Node<>(null, null);
        size = 0;
    }

    @Override
    public void insert(Item x, int position) {
        if (size == 0 || position > size) {
            addLast(x);
        } else {
            Node<Item> temp = get(sentinel, position);
            temp = new Node<>(x, temp);
            size += 1;
        }
    }

    @Override
    public void addFirst(Item x) {
        sentinel.next = new Node<>(x, sentinel.next);
        size += 1;
    }

    @Override
    public void addLast(Item x) {
        Node<Item> p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node<>(x, null);
        size += 1;
    }

    @Override
    public Item getFirst() {
        return sentinel.item;
    }

    @Override
    public Item getLast() {
        Node<Item> p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    @Override
    public Item get(int i) {
        if (i < size) {
            return get(sentinel, i).item;
        }
        return null;
    }

    private Node<Item> get(Node<Item> node, int i) {
        if (i == 1) {
            return node;
        }
        return get(node.next, i - 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Item removeLast() {
        Node<Item> p = sentinel;
        while (p.next != null) {
            if (p.next.next == null) {
                break;
            } else {
                p = p.next;
            }
        }
        Item returnItem = p.next.item;
        p.next = null;
        size -= 1;
        return returnItem;
    }

    @Override
    public void print() {
        for (Node<Item> p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }
}
