package problem5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;

public class ImmutableList<E extends Serializable> extends ArrayList<E> {

    /**
     * 
     */
    private static final long serialVersionUID = -2607298734996638983L;
    
    public ImmutableList(Collection<? extends E> collection) {
        Iterator<? extends E> iter = collection.iterator();
        while (iter.hasNext()) {
            E elem = iter.next();
            this.add(elem);
        }

    }

    public void putElem(E elem) throws ImmutableClassExeption {
        throw new ImmutableClassExeption("You can`t put an element in an immutable structure!");
    }

    public void putAll(Collection<? extends E> collection) throws ImmutableClassExeption {
        throw new ImmutableClassExeption("You can`t put elements in an immutable structure!");
    }

    public void removeElem(int index) throws ImmutableClassExeption {
        throw new ImmutableClassExeption("You can`t remove an element of an immutable structure!");
    }
    
    public void clear () throws ImmutableClassExeption {
        throw new ImmutableClassExeption("You can`t remove the elements of an immutable structure!");
    }
    
    public boolean contains(Object o) {
        return this.contains(o);
    }

    @SuppressWarnings("unchecked")
    public E getElem(int index) {
        Object cloned = SerializationUtils.clone(this.get(index));
        return (E) cloned;
    }

    @SafeVarargs
    public static <E extends Serializable> List<E> asList(E... arguments) {

        List<E> list = new ArrayList<E>();
        for (int i = 0; i < arguments.length; i++) {
            list.add(arguments[i]);
        }
        
        ImmutableList<E> immutableList = new ImmutableList<E>(list);
        return immutableList;

    }

}
