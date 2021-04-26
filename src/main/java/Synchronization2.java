class Looping2 {
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

class ThreadExample2 extends Thread {
    private Thread t;
    private String threadName;
    Looping2  looping;

    ThreadExample2( String name,  Looping2 pd) {
        threadName = name;
        looping = pd;
    }

    public void run() {
        synchronized(looping) {
            looping.forLoop();
        }
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

public class Synchronization2 {

    public static void main(String args[]) {
        Looping2 looping = new Looping2();

        ThreadExample2 thread1 = new ThreadExample2( "Thread1 ", looping );
        ThreadExample2 thread2 = new ThreadExample2( "Thread2 ", looping );

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