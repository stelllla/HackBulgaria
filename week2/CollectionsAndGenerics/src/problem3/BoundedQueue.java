package problem3;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BoundedQueue<E> implements Queue<E> {
    
    Queue<E> queue;
    int max;
    
    public BoundedQueue(int max) {
        this.max = max;
        queue = new LinkedList<E>();
        }

    @Override
    public boolean addAll(Collection<? extends E> c) {
         queue.addAll(c);
         
         while (queue.size() > max ) {
             queue.remove();
         }
         return true;
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public boolean contains(Object o) {
        return queue.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return queue.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    @Override
    public boolean remove(Object o) {
        return queue.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return queue.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return queue.retainAll(c);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return queue.toArray(a);
    }

    @Override
    public boolean add(E arg0) {
        queue.add(arg0);
        if ( queue.size() > max) {
            queue.remove();
        }
        return false;
    }

    @Override
    public E element() {
        return queue.element();
    }

    @Override
    public boolean offer(E arg0) {
        queue.offer(arg0);
        if ( queue.size() > max){
            queue.remove();
        }
        return true;
    }

    @Override
    public E peek() {
        return queue.peek();
    }

    @Override
    public E poll() {
        return queue.poll();
    }

    @Override
    public E remove() {
        return queue.remove();
    }
    
    public String toString() {
        StringBuilder string = new StringBuilder();
        Iterator<E> iter = queue.iterator();
        while (iter.hasNext()) {
            string.append(iter.next()).append(" ");
        }
        
        return string.toString();
    }

}
