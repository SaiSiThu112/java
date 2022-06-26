package SOLID.ocp;

public interface Condition<T> {

    boolean isMatched(T item);
}
