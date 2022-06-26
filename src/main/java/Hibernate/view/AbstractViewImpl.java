package Hibernate.view;

import java.util.List;

public abstract class AbstractViewImpl<T > implements AbstractView<T> {

    @Override
    public void printDetails(T model) {

    }

    @Override
    public void printDetails(List<T> modelList) {
            for (T model : modelList){
                printDetails(model);
            }
    }
}
