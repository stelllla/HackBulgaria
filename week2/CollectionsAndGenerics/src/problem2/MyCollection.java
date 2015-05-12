package problem2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class MyCollection<E> implements Collection<E> {

    private List<E> list;
    
    public MyCollection() {
        list = new ArrayList<E>();
    }
    
    @Override
    public boolean add(E e) {
        if ( list.contains(e) || e == null) {
            list.remove(e);
            return false;
        }
        else {
            list.add(e);
            return true;
        }
    }

    @Override
    public void clear() {
        for( int i = 0; i < list.size(); i ++) {
            list.remove(i);
        }
    }

    @Override
    public boolean contains(Object o) {
        return  list.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return list.retainAll(c);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return list.toArray();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return list.addAll(c);
    }

}
