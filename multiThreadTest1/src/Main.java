public class Main {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        Thread t2 = new Thread(() -> {
            System.out.println("lambda my thread.");
        });
        t2.start();
    }
}

class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("My Thread!");
    }

}

//class MyRunnable implements Runnable{
//
//    @Override
//    public void run(){
//
//    }
//}