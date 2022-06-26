package designPattern.behaviour;

interface SortStrategy{
    void sort();
}

class SelectionSort implements SortStrategy{

    @Override
    public void sort() {
        System.out.println("Sorting with selection");
    }
}

class MergeSort implements SortStrategy{

    @Override
    public void sort() {
        System.out.println("Sorting with merge");
    }
}

class Context {
    SortStrategy sortStrategy;

    public void sort(){
        this.sortStrategy.sort();
    }
    public void setSortStrategy(SortStrategy sortStrategy){
        this.sortStrategy = sortStrategy;
    }
    public SortStrategy getSortStrategy(){
        return sortStrategy;
    }
}

public class Strategy {
    public static void main(String[] args) {
        Context context = new Context();
        context.setSortStrategy(new SelectionSort());
        context.sort();

        context.setSortStrategy(new MergeSort());
        context.sort();
    }
}
