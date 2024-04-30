package views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ViewsExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> integers = List.of(1, 2, 3);

        List<String> stringList = getStrings();
//        stringList.add("1");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(3);

       /* List<Integer> integers1 = Collections.unmodifiableList(integerList);
        integers1.add(2);*/

        List<Integer> synchronizedList = Collections.synchronizedList(integerList);



    }

    public static List<String> getStrings() {
        //.....

//         new ArrayList<>();
//        return Collections.emptyList();
        return Collections.singletonList("result");
    }
}
