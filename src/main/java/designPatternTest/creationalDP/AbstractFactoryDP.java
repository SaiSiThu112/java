package designPatternTest.creationalDP;

abstract class ReportHeader{
    abstract void genereateHeader();
}
abstract class ReportBody{
    abstract void genereateBody();
}

class HTMLHeader extends ReportHeader{

    @Override
    void genereateHeader() {
        System.out.println("Create HTML Header");
    }
}
class HTMLBody extends  ReportBody{

    @Override
    void genereateBody() {
        System.out.println("Create HTML Body");
    }
}
class PDFHeader extends ReportHeader{

    @Override
    void genereateHeader() {
        System.out.println("Create PDF Header");
    }
}
class PDFBody extends ReportBody{

    @Override
    void genereateBody() {
        System.out.println("Create PDF Body");
    }
}
abstract class ReportFactory{
    abstract ReportHeader createHeader();
    abstract ReportBody createBody();
}
class HTMLReportFactory extends ReportFactory{

    @Override
    ReportHeader createHeader() {
        return new HTMLHeader();
    }

    @Override
    ReportBody createBody() {
        return new HTMLBody();
    }
}
class PDFReportFactory extends ReportFactory{

    @Override
    ReportHeader createHeader() {
        return new PDFHeader();
    }

    @Override
    ReportBody createBody() {
        return new PDFBody();
    }
}
public class AbstractFactoryDP {
    public static void main(String[] args) {
        ReportFactory factory = new PDFReportFactory();
        ReportHeader header = factory.createHeader();
        ReportBody body = factory.createBody();
        header.genereateHeader();
        body.genereateBody();
    }
}
