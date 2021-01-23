public class DLList<Item> {
    private class Node {
        private Item item;
        private Node prev, next;

        private Node(Item item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public Node sentinel;
    private int size;

    public DLList(Item item) {
        sentinel = new Node(item, null, null);
        sentinel.next = new Node(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        size += 1;
    }

    public Item getFirst() {
        return sentinel.next.item;
    }

    public void addLast(Item item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        size += 1;
    }

    public Item getLast() {
        return sentinel.prev.item;
    }

    public Item removeLast() {
        Item returnItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return returnItem;
    }
}
