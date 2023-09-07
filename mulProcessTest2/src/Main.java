public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("t start.");
            System.out.println("t end.");
        });
        System.out.println("main start.");
        t.start();
//        t.join();
        System.out.println("main end.");
    }
}