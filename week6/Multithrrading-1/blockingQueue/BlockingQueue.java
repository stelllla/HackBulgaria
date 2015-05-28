package blockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BlockingQueue {

    private Queue<Integer> queue;

    public BlockingQueue() {
        queue = new LinkedList<Integer>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public synchronized void add() {
        
        int elem;
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert value= ");
        elem = sc.nextInt();
        queue.add(elem);
        notifyAll();
    }

    public int remove() {

        int removed = queue.remove();
        System.out.println("You removed  " + removed);
        return removed;
    }

    public synchronized int poll() throws InterruptedException {

        if (queue.isEmpty()) {
            Thread addThread = new Thread(new AddingThread(this));

            System.out.println("The queue is empty.Waiting to add an element...");

            addThread.start();
            wait();

        }

        int element = remove();
        return element;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue q = new BlockingQueue();
        q.add();
        q.add();

        q.poll();
        q.poll();
        q.poll();

    }

}
