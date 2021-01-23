public class SelectionSort {
    public static void sort(String[] args) {
        sort(args, 0);
    }

    private static void sort(String[] args, int i) {
        if (i == args.length) {
            return;
        }
        int smallest = findSmallest(args, i);
        swap(args, i, smallest);
        sort(args, i + 1);
    }

    public static int findSmallest(String[] args, int i) {
        int smallestIndex = i;
        for (int k = i + 1; k < args.length; k++) {
            int cmp = args[k].compareTo(args[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = k;
            }
        }
        return smallestIndex;
    }

    /** Swaps args[a] with args[b]. */
    public static void swap(String[] args, int a, int b) {
        String temp = args[a];
        args[a] = args[b];
        args[b] = temp;
    }
}
