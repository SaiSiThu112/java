package designPattern.creationalDP;

interface Singer{
    void sing();
}
interface SongWriter{
    void writeSong();
}
class XBox implements Singer{

    @Override
    public void sing() {
        System.out.println("XBox is Singing song");
    }
}
class JCZ implements SongWriter{

    @Override
    public void writeSong() {
        System.out.println("JCZ is Writing song");
    }
}

abstract class Show{
    abstract Singer singerRole();
    abstract SongWriter writerRole();
}
class ThuWaNa extends Show{

    @Override
    Singer singerRole() {
        return new XBox();

    }

    @Override
    SongWriter writerRole() {
        return new JCZ();
    }
}
public class AbstractFactoryDP {
    public static void main(String[] args) {
        Show show = new ThuWaNa();
        show.singerRole().sing();
        show.writerRole().writeSong();
    }
}
