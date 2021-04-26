class Looping {
    public void forLoop() {
        try {
            for(int i = 10; i > 0; i--) {
                System.out.println("number "  + i );
            }
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }
}

class ThreadExample extends Thread {
    private Thread t;
    private String threadName;
    Looping  Looping;

    ThreadExample( String name,  Looping pd) {
        threadName = name;
        Looping = pd;
    }

    public void run() {
        Looping.forLoop();
        System.out.println("Thread " +  threadName + "is  ending.");
    }

    public void start () {
        System.out.println(threadName + " is starting");
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class Synchronization {
    public static void main(String args[]) {

        Looping Looping = new Looping();

        ThreadExample thread1 = new ThreadExample( "Thread - 1 ", Looping );
        ThreadExample thread2 = new ThreadExample( "Thread - 2 ", Looping );

        thread1.start();
        thread2.start();

        // wait for threads to end
        try {
            thread1.join();
            thread2.join();
        } catch ( Exception e) {
            System.out.println("Interrupted");
        }
    }
}
