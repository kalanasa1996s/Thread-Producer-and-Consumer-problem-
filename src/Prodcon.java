import java.util.LinkedList;

public class Prodcon extends Thread {

    LinkedList list = new LinkedList();
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

}
