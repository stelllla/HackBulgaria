package mutex;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        Count count = new Count();
        Thread A  = new Thread(new Threads("A",count));
        Thread B  = new Thread(new Threads("B",count));
        
        A.start();
        B.start();
        
        A.join();
        B.join();
    }
    }

