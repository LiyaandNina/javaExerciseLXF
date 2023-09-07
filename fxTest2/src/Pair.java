public class Pair<T> {
    private T first;
    private T last;

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public static <K> Pair<K> create(K a, K b){
        return new Pair<K>(a, b);
    }

    public boolean same(T t) {
        return this == t;
    }
}
