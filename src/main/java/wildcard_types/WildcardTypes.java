package wildcard_types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class WildcardTypes {
    public static void main(String[] args) {
        print2(new ArrayList<>());
        print3(new ArrayList<String>());
        print4(new ArrayList<>());
        print5(new ArrayList<Integer>());
    }

    @SuppressWarnings("rawtypes")
    public void print(Collection collection) {
        Iterator it = collection.iterator();

    }

    static void print2(Collection<Object> collection) {
        for (Object o : collection) {
            int a = (int) o;
            System.out.println(o);
        }
    }

    static void print3(Collection<?> collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
    }

    static void print4(Collection<? extends Number> collection) {
        for (Number o : collection) {
            System.out.println(o);
        }
    }

    static <T extends Number> void print5(Collection<T> collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
    }


}

/*class Service<? extends Cloneable> {
    ? type;
}*/


