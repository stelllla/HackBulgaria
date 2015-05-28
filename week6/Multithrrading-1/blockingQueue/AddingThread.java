package blockingQueue;

public class AddingThread implements Runnable {

    private BlockingQueue queue;

    public AddingThread(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        queue.add();
    }

}
