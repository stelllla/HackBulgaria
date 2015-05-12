package problem6;

import java.util.HashSet;
import java.util.Set;

public class DuplicatingElements<E> {

    public Set<E> intersect(Set<E>[] arraySets) {
        Set<E> intersect = new HashSet<>();
        intersect.addAll(arraySets[0]);
        for (Set<E> set : arraySets) {
            intersect.retainAll(set);
        }

        return intersect;
    }

}
