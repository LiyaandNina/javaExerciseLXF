import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class ReverseList<T> implements Iterable<T> {
    public List<T> reverseList = new ArrayList<>();

    public void add(T t){
        reverseList.add(t);
    }

    @Override
    public Iterator iterator(){
        return new ReverseListIterator(reverseList.size());
    }

    class ReverseListIterator implements Iterator<T> {
        public int index;

        public ReverseListIterator(int index){
            this.index = index;
        }

        @Override
        public boolean hasNext(){
            return index > 0 ;
        }

        @Override
        public T next(){
            index--;
            return ReverseList.this.reverseList.get(index);
        }
    }
}