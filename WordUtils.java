public class WordUtils {
    public static String longest(List61B<String> list) {
        int longestIndex = 1;
        for (int i = 1; i < list.size(); i++) {
            String longestWord = list.get(longestIndex);
            String thisWord = list.get(i);
            if (thisWord.length() > longestWord.length()) {
                longestIndex = i;
            }
        }
        return list.get(longestIndex);
    }

    public static void main(String[] args) {
        AList<String> list = new AList<>();
        list.addLast("elks");
        list.addFirst("are");
        list.addFirst("watching");
        list.addFirst("hunters");
        list.addLast("running");

        System.out.println("The longest word is " + longest(list));
    }
}
