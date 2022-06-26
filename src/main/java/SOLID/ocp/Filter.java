package SOLID.ocp;

import java.util.List;

public interface Filter<T> {

       void filter(List<T> items, Condition<T> condition);

}
