public class Main {

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 345);
        int a = add(p);
        System.out.println(a);
    }

    static int add(Pair<? extends Integer> pair){
        pair.setFirst(Integer.valueOf(12));
        return pair.getFirst().intValue() + pair.getLast().intValue();
    }
}

class Pair<T>{
    private T first;
    private T last;
    public Pair(T first, T last){
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }
}
