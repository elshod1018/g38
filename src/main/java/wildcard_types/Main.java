package wildcard_types;

import java.io.Serializable;
import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    void printCollection(Collection c) {
        Iterator i = c.iterator();
        for (int k = 0; k < c.size(); k++) {
            System.out.println(i.next());
        }
    }

    void printCollection2(Collection<Object> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    void printCollection3(Collection<?> c) {
        Collection<?> c2 = new ArrayList<String>();
        for (Object e : c) {
            System.out.println(e);
        }
    }

    void printCollection4(Collection<? extends Number> c) {
        Collection<?> c2 = new ArrayList<String>();
        for (Object e : c) {
            System.out.println(e);
        }
    }

}
