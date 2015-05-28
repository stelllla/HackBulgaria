package mutex;

public class Threads implements Runnable {
    private String name;
    private Count count;

    Threads(String name, Count count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        while (count.getCount() < 50) {
            try {
                count.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + " counter : " + count.getCount());
        }

    }
}
