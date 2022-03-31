import java.util.LinkedList;

public class Prodcon extends Thread {

    LinkedList<Integer> list = new LinkedList();
    int capacity =1 ;

    public synchronized void producer() throws InterruptedException {

        int value =0;

        while (true){

            if (list.size() == capacity){
                wait();
            }else{
                System.out.println("Producer Produce");
                list.add(value++);
                notify();
                Thread.sleep(1000);
            }

        }


    }

    public synchronized void consumer() throws InterruptedException {
        int val;
        while (true){

            if (list.size() == 0){
                wait();
            }else {

                val = list.removeFirst();
                System.out.println("COnsumer consume"+val);
                notify();

                Thread.sleep(1000);
            }

        }
    }

}
