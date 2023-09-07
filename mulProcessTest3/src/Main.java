public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(() -> {
//            int n =0;
//            while(! isInterrupted()){
//                n ++;
//                System.out.println(n + " hello!");
//            }
//        });
        //匿名内部类可以访问外部类的private以及其他信息，箭头函数（lambda）不可以
        System.out.println("main start.");
        Thread t = new Thread(){
            int n = 0;
            @Override
            public void run(){
                while (! isInterrupted()){
                    n++;
                    System.out.println(n + " hello!");
                }
            }
        };
        t.start();
        Thread.sleep(1);
        t.interrupt();
        t.join();
        System.out.println("main end.");
    }
}

class HelloThread extends Thread{
    public volatile boolean running = true;

    @Override
    public void run(){
        System.out.println("do something.");
    }
}

