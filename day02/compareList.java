package others;

import java.util.ArrayList;
import java.util.List;

//输出两个队列相同的元素
public class compareList {
    public static void main(String[] args) {
        ArrayList<Object> list1 = new ArrayList<>();
        list1.add("hello");
        list1.add("world");
        list1.add("lilei");
        list1.add(1);
        list1.add(true);
        ArrayList<Object> list2 = new ArrayList<>();
        list2.add("nihao");
        list2.add("china");
        list2.add("hello");
        list2.add(4);
        list2.add(true);

        testCompare(list1,list2);
    }

    public static void testCompare(List<Object> list1, List<Object> list2) {
        for (int i = 0; i < list1.size(); i++) {
            Object obj1 = list1.get(i);
            for (int j = 0; j < list2.size(); j++) {
                Object obj2 = list2.get(j);
                if (obj1.equals(obj2)) {
                    System.out.println("两个列表相同的元素有： " + obj2);
                }
            }
        }
    }
}
