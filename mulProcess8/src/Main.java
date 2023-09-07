public class Main {
    public static void main(String[] args) {
        log("start main.");
        new Thread(){
            @Override
            public void run(){
                log("run task...");
            }
        }.start();
        new Thread(() -> {
            log("print...");
        }).start();
        log("end main.");
    }

    static void log(String s){
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}