public class Main {

    public static void main(String[] args) {
        Boolean b = Person.class.isAnnotationPresent(Report.class);
        System.out.println("Person.class.isAnnotationPresent: " + b);

        Report report = Person.class.getAnnotation(Report.class);
        int value = report.value();
        String type = report.type();
        System.out.println("value: " + value);
        System.out.println("type: " + type);
    }

}
