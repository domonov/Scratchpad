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
    private Node<Item> last;
    private int size;

    public SLList() {
        sentinel = null;
        last = null;
        size = 0;
    }

    @Override
    public void insert(Item x, int position) {
        if (size == 0 || position > size) {
            addLast(x);
        } else {
            Node<Item> temp = get(sentinel, position);
            temp = new Node<>(x, temp);
        }
        size += 1;
    }

    @Override
    public void addFirst(Item x) {
        if (size == 0) {
            sentinel = new Node<>(x, null);
            last = sentinel;
        } else {
            sentinel = new Node<>(x, sentinel);
        }
        size += 1;
    }

    @Override
    public void addLast(Item x) {
        if (size == 0) {
            addFirst(x);
        } else {
            last.next = new Node<>(x, null);
            last = last.next;
        }
        size += 1;
    }

    @Override
    public Item getFirst() {
        if (size > 0) {
            return sentinel.item;
        }
        return null;
    }

    @Override
    public Item getLast() {
        if (size > 0) {
            return last.item;
        }
        return null;
    }

    @Override
    public Item get(int i) {
        return get(sentinel, i).item;
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
       if (size == 1) {
           new SLList<>();
       }
    }

    @Override
    public void print() {
        for (Node p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }
}
