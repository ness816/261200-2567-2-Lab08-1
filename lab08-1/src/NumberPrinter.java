import java.util.Random;

class NumberPrinter implements Runnable {
    private final int threadNumber;
    private static final int MAX_NUMBER = 50;
    private static final Random random = new Random();

    public NumberPrinter(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            System.out.println("Thread #" + threadNumber + ": " + i);

            // Uncomment the following lines to introduce random delays
            try {
                Thread.sleep(random.nextInt(100)); // Random delay between 0-99ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}






