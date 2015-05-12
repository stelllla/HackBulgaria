package problem1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ReversedCollection {

    public static void reverse(Collection<Integer> collection) {
        List<Integer> list = new ArrayList<Integer>();

        Iterator<Integer> iterator = collection.iterator();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        collection.clear();
        int i = 0;
        while (i != list.size() - 1) {
            collection.add(list.get(i));
        }
    }
    
}
