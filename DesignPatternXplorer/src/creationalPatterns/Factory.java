package creationalPatterns;

public class Factory {

    public static void main(String [] args){

        DbFactory sqlDB = new SQLDatabase();
        DbFactory mysqlDB = new MySQLDatabase();

        sqlDB.createConnection();
        sqlDB.getData();
        mysqlDB.createConnection();
        mysqlDB.getData();
    }
}

interface DbFactory {
    void createConnection();
    void getData();
}

class SQLDatabase implements DbFactory{

    @Override
    public void createConnection() {
        System.out.println("SQL: Connected");
    }

    @Override
    public void getData() {
        System.out.println("SQL: Data fetched");
    }
}

class MySQLDatabase implements DbFactory{

    @Override
    public void createConnection() {
        System.out.println("MySQL: Connected");
    }

    @Override
    public void getData() {
        System.out.println("MySQL: Data fetched");
    }
}