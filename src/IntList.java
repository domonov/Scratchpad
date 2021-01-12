public class IntList {
    public int first;
    public IntList rest;

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    /** Return the size of the list using recursion. */
    public int size() {
        if (this.rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }


    /** Returns the size of the list using iteration. */
    public int iterativeSize() {
        IntList p = this;
        int size = 1;
        while (this.rest != null) {
            size += 1;
            this.rest = this.rest.rest;
        }
        return size;
    }

    /** Returns the ith item iteratively. */
    public int get(int i) {
        IntList p = this;
        while (i > 0) {
            p = p.rest;
            i -= 1;
        }
        return p.first;
    }

    /** Returns the ith item recursively. */
    public int recursiveGet(int i) {
        if (i == 0) {
            return this.first;
        }
        return this.rest.recursiveGet(i - 1);
    }

//    public void addFirst(int x) {
//        rest = this;
//        first = x;
//    }

    public static void main(String[] args) {
        IntList list = new IntList(5, null);
//        list.addFirst(10);
//        list.addFirst(15);
        System.out.println(list.get(0));
    }



}
