/** SLList is an abstraction layer that uses IntNode to
 * create a list without dealing with "null" when initiating.
 */
public class SLList {

    private static class IntNode {
        int item;
        IntNode next;

        IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode sentinel;
    private IntNode last;
    private int size;

    public SLList() {
        sentinel = new IntNode(888, null);
        size = 0;
    }

    public SLList(int x) {
        this();
        sentinel.next = new IntNode(x, null);
        last = sentinel.next;
        size += 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        if (last == null) {
            last = sentinel.next;
        }
        size += 1;
    }

    public Integer getFirst() {
        if (size > 0) {
            return sentinel.next.item;
        }
        return null;
    }

    public void addLast(int x) {
        if (last == null) {
            addFirst(x);
        } else {
            last.next = new IntNode(x, null);
            last = last.next;
            size += 1;
        }
    }

    public Integer getLast() {
        if (last != null) {
            return last.item;
        }
        return null;
    }

    private void insert(IntNode node, int x, int pos) {
        if (pos == 1) {
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
            insert(node.next, x, pos - 1);
        }
    }

    public void insert(int x, int pos) {
        if (size == 0 || pos > size) {
            addLast(x);
        } else {
            insert(sentinel.next, x, pos);
        }
    }

    public Integer removeLast() {
        return null;
    }

    public int size() {
        return size;
    }
}
