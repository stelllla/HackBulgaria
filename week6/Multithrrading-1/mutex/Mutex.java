package mutex;


public class Mutex {
    
    //private Queue<Threads> threads = new LinkedList<Threads>();
    private int state = 0;
    private Object lock;
    
    public Mutex(int state,Object lock) {
        this.state = state;
        this.lock = lock;
    }

    /** 
     * Allow one thread to execute,while others are waiting. 
     * 
     * @return
     * @throws InterruptedException
     */
    public void acquire() throws InterruptedException {
      synchronized (lock) {
        while (state != 0) {
           lock.wait();
        }
        state = 1;
        }
       
    }
    
    public void release() {
        synchronized (lock) {
             state = 0;
             lock.notifyAll();
        }
       
    }
}
