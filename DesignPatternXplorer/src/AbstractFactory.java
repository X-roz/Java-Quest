import java.util.HashMap;
import java.util.Map;

public class AbstractFactory {

    public static void main(String[] args){

        DataSource dataSource = new DataSourceImpl();

        System.out.println("****** Database Connection ******");
        dataSource.getDatabaseFactory(Constants.SQL_DATABASE).createConnection();
        dataSource.getDatabaseFactory(Constants.MYSQL_DATABASE).createConnection();

        System.out.println("****** Database Retrieval ******");
        dataSource.getDatabaseFactory(Constants.SQL_DATABASE).getData();
        dataSource.getDatabaseFactory(Constants.MYSQL_DATABASE).getData();

        System.out.println("****** Network Validation ******");
        dataSource.getNetworkFactory(Constants.CENTRAL_NETWORK).checkUrl();
        dataSource.getNetworkFactory(Constants.THIRD_PARTY_API).checkUrl();

        System.out.println("****** Network Data retrieval  ******");
        dataSource.getNetworkFactory(Constants.CENTRAL_NETWORK).getJsonData();
        dataSource.getNetworkFactory(Constants.THIRD_PARTY_API).getJsonData();
    }
}

// Let's create a Datasource for our application from different regions
// 1. Database
// 2. Network

///  Constants

class Constants {
    public static String SQL_DATABASE = "SQL";
    public static String MYSQL_DATABASE = "MySQL";
    public static String CENTRAL_NETWORK = "Central";
    public static String THIRD_PARTY_API = "3-API";
}

///  Abstract layer for the both Data sources
interface DataSource {
    DatabaseFactoryImpl getDatabaseFactory(String dbName);
    NetworkFactoryImpl  getNetworkFactory(String networkName);
}

class DataSourceImpl implements DataSource{

    private final Map<String, DatabaseFactoryImpl> dbRegistry = new HashMap<>();
    private final Map<String, NetworkFactoryImpl> networkRegistry = new HashMap<>();

    // load all the DB layers and network layers in the registry
    public DataSourceImpl(){
        this.dbRegistry.put(Constants.SQL_DATABASE, new SQLDb());
        this.dbRegistry.put(Constants.MYSQL_DATABASE, new MySQLDb());
        this.networkRegistry.put(Constants.CENTRAL_NETWORK, new CentralRepo());
        this.networkRegistry.put(Constants.THIRD_PARTY_API, new ThirdPartyAPI());
    }

    @Override
    public DatabaseFactoryImpl getDatabaseFactory(String dbName) {
        return dbRegistry.getOrDefault(dbName, null);
    }

    @Override
    public NetworkFactoryImpl getNetworkFactory(String networkName) {
        return networkRegistry.getOrDefault(networkName, null);
    }
}

///  Database Factory Implementation we can add multiple DB layers later period if needed
interface DatabaseFactoryImpl {
    void createConnection();
    void getData();
}

class SQLDb implements DatabaseFactoryImpl{

    @Override
    public void createConnection() {
        System.out.println("SQL: Connected");
    }

    @Override
    public void getData() {
        System.out.println("SQL: Data fetched");
    }
}

class MySQLDb implements DatabaseFactoryImpl{

    @Override
    public void createConnection() {
        System.out.println("MySQL: Connected");
    }

    @Override
    public void getData() {
        System.out.println("MySQL: Data fetched");
    }
}


///  Network Factory Implementation we can add multiple Network layers later period if needed
interface NetworkFactoryImpl {
    void checkUrl();
    void getJsonData();
}

class CentralRepo implements NetworkFactoryImpl{

    @Override
    public void checkUrl() {
        System.out.println("CentralRepo: Valid Url");
    }

    @Override
    public void getJsonData() {
        System.out.println("CentralRepo: Data fetched");
    }
}

class ThirdPartyAPI implements NetworkFactoryImpl{

    @Override
    public void checkUrl() {
        System.out.println("ThirdPartyAPI: Valid Url");
    }

    @Override
    public void getJsonData() {
        System.out.println("ThirdPartyAPI: Data fetched");
    }
}