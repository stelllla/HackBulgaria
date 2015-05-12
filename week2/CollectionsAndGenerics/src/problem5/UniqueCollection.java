package problem5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UniqueCollection<E> {

    public E firstUniqueElement(Collection<E> collection) {

        List<E> list = new ArrayList<E>();
        list.addAll(collection);
        for ( int i = 0; i < list.size(); i++) {
            if (Collections.frequency(list, list.get(i)) == 1) {
                return list.get(i);
            }
        }
        return null;
    }
}
