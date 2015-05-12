package problem4;

import java.util.Collection;
import java.util.LinkedList;

public class RotateCollection {

    public void rotate(Collection<Integer> collection, int rotateStep) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.addAll(collection);
        collection.clear();
        
        while (rotateStep != 0) {
            Integer last = list.removeLast();
            list.offerFirst(last);
            rotateStep--;
        }
        
        collection.addAll(list);
    }
}
