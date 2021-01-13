public class RotatingSLList<Item> extends SLList<Item> {

    public void rotateRight() {
        Item x = removeLast();
        addFirst(x);
    }

    public static void main(String[] args) {
        RotatingSLList<Integer> intList = new RotatingSLList<>();
        intList.addFirst(4);
        intList.addFirst(3);
        intList.addFirst(2);
        intList.addFirst(1);

        intList.print();
        System.out.println("Above is the original list.");
        intList.rotateRight();
        System.out.println("Below is the rotated list.");
        intList.print();

    }

}
