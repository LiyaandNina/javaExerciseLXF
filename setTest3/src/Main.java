import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        Set<Message> messageSet = new TreeSet<>(new Comparator<Message>(){
            @Override
            public int compare(Message m1, Message m2){
                return Integer.compare(m1.sequence, m2.sequence);
            }
        });
        for(Message message : received){
            messageSet.add(message);
        }
//        return List.of(messageSet.toArray(new Message[messageSet.size()]));
        return new ArrayList<>(messageSet);
    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}