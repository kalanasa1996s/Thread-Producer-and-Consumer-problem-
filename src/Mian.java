public class Mian {
    public static void main(String[] args) throws InterruptedException {

        Prodcon prodcon = new Prodcon();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    prodcon.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    prodcon.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }
}
