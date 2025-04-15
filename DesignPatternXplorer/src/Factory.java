public class Factory {

    public static void main(String [] args){

        DatabaseFactory sqlDB = new SQLDatabase();
        DatabaseFactory mysqlDB = new MySQLDatabase();

        sqlDB.createConnection();
        sqlDB.getData();
        mysqlDB.createConnection();
        mysqlDB.getData();
    }
}

interface DatabaseFactory {
    void createConnection();
    void getData();
}

class SQLDatabase implements DatabaseFactory{

    @Override
    public void createConnection() {
        System.out.println("SQL: Connected");
    }

    @Override
    public void getData() {
        System.out.println("SQL: Data fetched");
    }
}

class MySQLDatabase implements DatabaseFactory{

    @Override
    public void createConnection() {
        System.out.println("MySQL: Connected");
    }

    @Override
    public void getData() {
        System.out.println("MySQL: Data fetched");
    }
}