import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<User> userQueue = new PriorityQueue<>(new UserComparator());
        userQueue.offer(new User("xiaowang", "A1"));
        userQueue.offer(new User("laoli", "V2"));
        userQueue.offer(new User("misszhang", "V1"));
        System.out.println(userQueue.poll().name);
        System.out.println(userQueue.peek().name);
        System.out.println(userQueue.peek().name);
    }
}


class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2){
        if(u1.number.charAt(0) == u2.number.charAt(0)){
            return Integer.compare(
                    Integer.parseInt(u1.number.substring(1)),
                    Integer.parseInt(u2.number.substring(1))
            );
        }
        if(u1.number.charAt(0) == 'V'){
            return -1;
        }else{
            return 1;
        }
    }
}


class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}