import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) throws Exception{
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Main::fetchPrice);
        Thread.sleep(500);
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        cf.exceptionally((e) -> {
           e.printStackTrace();
           return null;
        });
        Thread.sleep(2000);
    }

    static double fetchPrice(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}