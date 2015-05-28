package mutex;

public class Count {

    private int count;
    private Mutex mutex;
    private int state = 0;

    Count() {
        count = 0;
        mutex = new Mutex(0, new Object());
    }

    public int getState() {
        return state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() throws InterruptedException {
        mutex.acquire();
        setCount(getCount() + 1);
        mutex.release();
    }
}
