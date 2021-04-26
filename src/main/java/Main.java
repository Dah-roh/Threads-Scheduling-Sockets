public class Main {
    public static String lockingWithAString = "First Lock";
    public static String lockingWithAnotherString = "Second Lock";

    public static void main(String args[]) {
        ThreadDemo1 thread1 = new ThreadDemo1();
        ThreadDemo2 thread2 = new ThreadDemo2();
        thread1.start();
        thread2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (lockingWithAString) {
                System.out.println("Thread 1: Holding lock 1...");

                try { Thread.sleep(10); }
                catch (InterruptedException e) {}

                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (lockingWithAnotherString) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (lockingWithAnotherString) {
                System.out.println("Thread 2: Holding lock 2...");

                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 1...");

                synchronized (lockingWithAString) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}