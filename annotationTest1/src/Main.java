public class Main {
    public static void main(String[] args) {
        boolean test1 = Main.class.isAnnotationPresent(Report.class);
        System.out.println("Annotation Report in Main: " + test1);
    }
}



