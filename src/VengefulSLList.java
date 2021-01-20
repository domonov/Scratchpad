public class VengefulSLList<Item> extends SLList<Item> {

    private SLList<Item> removed;

    public VengefulSLList() {
        removed = new SLList<>();
    }

    public VengefulSLList(Item x) {
        super(x);
    }

    @Override
    public Item removeLast() {
        Item plucked = super.removeLast();
        removed.addFirst(plucked);
        return plucked;
    }

    public void printLostItems() {
        removed.print();
    }


    public static void main(String[] args) {
        VengefulSLList<Integer> list = new VengefulSLList<>();
        list.addLast(1);
        list.addLast(5);
        list.addLast(10);
        list.addLast(13);
        list.removeLast();
        list.removeLast();
        System.out.println("Removed Items are below:");
        list.printLostItems();
    }
 }
