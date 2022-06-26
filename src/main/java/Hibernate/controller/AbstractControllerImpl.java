package Hibernate.controller;

import Hibernate.view.AbstractView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractControllerImpl<Model , View extends AbstractView<Model>> implements AbstractController<Model , View>{

    private Model model;
    private View view;

    @SuppressWarnings("unchecked")
    public AbstractControllerImpl() {

        Class<Model> modelCLass = (Class<Model>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Class<View>  viewClass  = (Class<View>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];

        model = (Model) getInstance(modelCLass);
        view = (View) getInstance(viewClass);

    }

    public Object getInstance(Class<?> className){
        try {
            return className.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void printDetails(Model model) {
        view.printDetails(model);
    }

    @Override
    public void printDetails(List<Model> modelList) {
        view.printDetails(modelList);
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }
}
