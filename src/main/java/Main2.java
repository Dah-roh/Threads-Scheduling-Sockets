public class Main2 {
    public static String lockingString= "First Lock";
    public static String lockingString2 = "Second Lock";

    public static void main(String args[]) {
        ThreadDemo1 thread1 = new ThreadDemo1();
        ThreadDemo2 thread2 = new ThreadDemo2();
        thread1.start();
        thread2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (lockingString) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (lockingString2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (lockingString) {
                System.out.println("Thread 2: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 2...");

                synchronized (lockingString2) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}