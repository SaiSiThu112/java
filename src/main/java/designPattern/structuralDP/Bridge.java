package designPattern.structuralDP;

interface DownloadAPI{
    void downloadFile();
    void downloadZipFile();
}

class GDrive implements DownloadAPI{

    @Override
    public void downloadFile() {
        System.out.println("download as file using gdrive");
    }

    @Override
    public void downloadZipFile() {
        System.out.println("download as zip file using gdrive");
    }
}

class Mega implements DownloadAPI{

    @Override
    public void downloadFile() {
        System.out.println("download as file using mega");
    }

    @Override
    public void downloadZipFile() {
        System.out.println("download as zip file using mega");
    }
}

abstract class Type{

    DownloadAPI api;

    Type(DownloadAPI api) {
        this.api = api;
    }

    abstract void downloadType();
}

class File extends Type{

    File(DownloadAPI api) {
        super(api);
    }

    @Override
    void downloadType() {
        api.downloadFile();
    }
}

class Zip extends Type{

    Zip(DownloadAPI api) {
        super(api);
    }

    @Override
    void downloadType() {
        api.downloadZipFile();
    }
}

public class Bridge {
    public static void main(String[] args) {
        DownloadAPI api = new GDrive();
        Type one = new File(api);
        one.downloadType();

        api = new Mega();
        one = new Zip(api);
        one.downloadType();
    }
}
