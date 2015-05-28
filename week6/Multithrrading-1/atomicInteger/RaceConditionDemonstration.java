package atomicInteger;
public class RaceConditionDemonstration {
    
    public static class MyThread implements Runnable {

        private String name;
        private Counter counter; 
        
        MyThread(String name,Counter counter) {
            this.name = name;
            this.counter = counter;
        }
        
        @Override
        public void run() {
            while (counter.getCounter().get() < 50) {
                 counter.increment();
                 System.out.println(this.name + "   counter = " + counter.getCounter().get());
            }
    
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
       
        Counter counter = new Counter();
        Thread A  = new Thread(new MyThread("A",counter));
        Thread B  = new Thread(new MyThread("B",counter));
        
        A.start();
        B.start();
        
        A.join();
        B.join();
    }
}   
   
    

