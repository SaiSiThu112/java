package designPattern.creationalDP;

interface Connection{
    void open();
    void close();
}

class MySQLConnection implements Connection{

    @Override
    public void open() {
        System.out.println("MySQLConnection is open");
    }

    @Override
    public void close() {
        System.out.println("MySQLConnection is close");
    }
}

class OracleConnection implements Connection{

    @Override
    public void open() {
        System.out.println("Oracle Connection is open");
    }

    @Override
    public void close() {
        System.out.println("Oracle Connection is close");
    }
}

abstract class ConnectionFactory{

    abstract Connection getConnection();
}

class MySQLConnectionFactory extends ConnectionFactory{

    @Override
    Connection getConnection() {
        return new MySQLConnection();
    }
}
class OracleConnectionFactory extends ConnectionFactory{

    @Override
    Connection getConnection() {
        return new OracleConnection();
    }
}

public class FactoryDP {
    public static void main(String[] args) {
        Connection con = new MySQLConnectionFactory().getConnection();
        con.open();
        con.close();

    }
}
