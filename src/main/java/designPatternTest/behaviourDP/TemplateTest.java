package designPatternTest.behaviourDP;

abstract class ExamFlow{
    private void answer(){
        System.out.println("Answer exam");
    }
    private void check(){
        System.out.println("Check answer");
    }
    protected abstract void mark();

    private void show(){
        this.answer();
        this.check();
        this.mark();
    }
}

class John extends ExamFlow{

    @Override
    protected void mark() {
        System.out.println("Pass exam with 100 marks");
    }
}

class David extends ExamFlow{

    @Override
    protected void mark() {
        System.out.println("Fail exam with 30 marks");
    }
}
public class TemplateTest {
    public static void main(String[] args) {
        ExamFlow examFlow = new David();
        examFlow.mark();
        ExamFlow flow = new John();
        flow.mark();
    }
}
