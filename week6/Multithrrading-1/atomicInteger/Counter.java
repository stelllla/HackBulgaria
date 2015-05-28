package atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;


public class Counter {
    
    private  AtomicInteger counter;

    Counter() {
        counter = new AtomicInteger(0);
        
    }
    public AtomicInteger getCounter() {
        return counter;
    }

    public void setCounter(AtomicInteger atomicCounter) {
        counter.set(atomicCounter.get());
    }
    
    public synchronized void increment() {
        counter.getAndIncrement();
    }

}
