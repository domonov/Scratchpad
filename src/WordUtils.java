public class WordUtils {
    public static String longest(SLList list) {
        // this method will be iterative
        // checks the first node's item and records the length
        // go to another node and compares the length of the item in that node
        // records the longest word
        if (list.size() > 0) {
            String l = "";
            while (list.) {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        SLList<String> list = new SLList<>();
        list.addFirst("Davron");
        list.addLast("Nelly");
        list.insert("David", 5);

        String longestName = longest(list);
        System.out.println("The longest name is " + longestName);
    }
}
