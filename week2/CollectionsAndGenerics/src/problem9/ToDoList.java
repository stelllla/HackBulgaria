package problem9;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ToDoList {

    private Comparator<Task> comparator = new Comparator<Task>() {
        public int compare(Task t1, Task t2) {
            if (t1.getPriority() < t2.getPriority()) {
                return 1;
            }
            if (t1.getPriority() > t2.getPriority()) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    private Queue<Task> queue = new PriorityQueue<>(15, comparator);
    private int existingTime;

    ToDoList(int time) {

        existingTime = time;
    }

    public boolean add(Task t) {
        return queue.offer(t);
    }

    public void markFinished(Task t) {
        if (!queue.contains(t)) {
            System.out.println("This task is not in my list!");
        } else {
            Iterator<Task> iter = queue.iterator();
            while (iter.hasNext()) {
                Task curr = iter.next();
                if (curr.equals(t)) {
                    curr.setFinished(true);
                    System.out.println("You marked  " + curr.getName() + "  as finished!");
                    break;
                }
            }
        }
    }

    public void markCancelled(Task t) {
        System.out.println("You cancelled  " + t.getName() + "!");
        queue.remove(t);

    }

    public Task getTop() {
        return queue.peek();

    }

    public boolean canFinish() {
        int sumTime = 0;
        Iterator<Task> iter = queue.iterator();
        while (iter.hasNext()) {
            sumTime = sumTime + iter.next().getTimeRequired();
        }
        if (sumTime <= existingTime) {
            return true;
        } else {
            return false;
        }

    }

    public int getRemainigTime() {
        int remainingTime = 0;
        Iterator<Task> iter = queue.iterator();
        while (iter.hasNext()) {
            Task curr = iter.next();

            if (!curr.isFinished()) {
                remainingTime += curr.getTimeRequired();
            }
        }
        return remainingTime;
    }

    public void print() {

        while (!queue.isEmpty()) {
            Task curr = queue.poll();

            System.out.println("Task:" + curr.getName() + "   " + "Priority:" + curr.getPriority() + "    " + "Time:"
                    + curr.getTimeRequired() + "      " + "Finished? :" + curr.isFinished());

        }

    }
}
