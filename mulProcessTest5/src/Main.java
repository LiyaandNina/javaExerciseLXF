public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread ad = new AddCount();
        Thread minu = new MinusCount();
        ad.start();
        minu.start();
        ad.join();
        minu.join();
        System.out.println(Count.counter);
    }
}

class Count {
    public static final Object lock = new Object();
    public static int counter = 0;
}

class AddCount extends Thread {

    @Override
    public void run(){
        int i = 0;
        while(i < 10000){
            synchronized (Count.lock){
                Count.counter++;
            }
            i++;
        }
    }
}

class MinusCount extends Thread {

    @Override
    public void run(){
        int i = 0;
        while(i < 10000){
            synchronized (Count.lock){
                Count.counter--;
            }
            i++;
        }
    }
}