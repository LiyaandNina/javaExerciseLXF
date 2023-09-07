public class Main {
    public static void main(String[] args) {
//        String re = "learn\\s((J|j)ava|(P|p)hp|(G|g)o)";
        String re = "learn\\s([Jj]ava|[Pp]hp|[Gg]o)";
//        System.out.println("learn java".matches(re));
//        System.out.println("learn Java".matches(re));
//        System.out.println("learn php".matches(re));
//        System.out.println("learn Go".matches(re));
        String rex = "^[1-9a-zA-Z][0-9a-zA-Z]{1,10}@163\\.com";
        //false
        System.out.println("lszmsssss@163.comahafs".matches(rex));
        //true
        System.out.println("lszmsssss@163.com".matches(rex));
    }
}