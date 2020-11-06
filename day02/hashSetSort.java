package others;

import java.util.*;

//hashSet排序
public class hashSetSort {
    public static void main(String[] args) {

        HashSet<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("h");
        set1.add("K");
        set1.add("3");
        set1.add("-8");
        List<String> list = new ArrayList<>();
        list.addAll(set1);

        Collections.sort(list);
        printList1(list);
    }

    private static void printList1(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
