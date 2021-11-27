public class ThreadAssignment {

    static class Counter {
       public synchronized void count() {
            //todo implement me
            for (int i = 350; i>=1; i--)
                System.out.println(i);
                System.out.println("finich !");
        }
    }

    static class MyThread extends Thread {
        private final Counter counter;

        public MyThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.count();
        }
    }

    public static void main(String[] args) throws InterruptedException  {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        t1.start();
        MyThread t2 = new MyThread(counter);
        t2.start();
        t1.join();
        t2.join();
        System.out.println("done !");
    }
}
