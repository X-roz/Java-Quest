import regional.RegionalConstants;
import regional.RegionalVehicleFactory;
import regional.RegionalVehicleFactoryImpl;

public class Client {

    public static void main(String[] args){

        try {
            RegionalVehicleFactory usFactory = RegionalVehicleFactoryImpl.getRegionalVehicleFactory(RegionalConstants.USA);
            usFactory.createCar();
            usFactory.createBike();
            usFactory.createTruck();

            RegionalVehicleFactory indFactory = RegionalVehicleFactoryImpl.getRegionalVehicleFactory(RegionalConstants.INDIA);
            indFactory.createCar();
            indFactory.createBike();
            indFactory.createTruck();

            RegionalVehicleFactory euFactory = RegionalVehicleFactoryImpl.getRegionalVehicleFactory(RegionalConstants.EUROPE);
            euFactory.createCar();
            euFactory.createBike();
            euFactory.createTruck();
        }catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        }

    }
}
