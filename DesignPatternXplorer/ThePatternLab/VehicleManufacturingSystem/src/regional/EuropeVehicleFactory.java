package regional;



import vehicles.EmissionNorms;
import vehicles.VehicleConstants;
import vehicles.VehicleFactory;
import vehicles.VehicleOperations;

public class EuropeVehicleFactory implements RegionalVehicleFactory{

    @Override
    public void createCar() {
        try{
            System.out.println("\nEurope Vehicle Factory : Manufacturing Car");
            VehicleOperations car = VehicleFactory.getVehicle(VehicleConstants.CAR);
            car.equipments();
            car.emissionStandard(EmissionNorms.TIER_3);
            car.seatType(4);
            car.steeringType("right");
            car.timePeriodToManufacture();
            System.out.println("Europe Vehicle Factory : Car Manufactured");
        }catch (Exception e){
            System.out.println("ERROR in Europe Car Manufacturing unit : "+ e.getMessage());
        }
    }

    @Override
    public void createBike() {
        try{
            System.out.println("\nEurope Vehicle Factory : Manufacturing Bike");
            VehicleOperations car = VehicleFactory.getVehicle(VehicleConstants.BIKE);
            car.equipments();
            car.emissionStandard(EmissionNorms.TIER_3);
            car.seatType(4);
            car.steeringType("right");
            car.timePeriodToManufacture();
            System.out.println("Europe Vehicle Factory : Bike Manufactured");
        }catch (Exception e){
            System.out.println("ERROR in Europe Bike Manufacturing unit : "+ e.getMessage());
        }
    }

    @Override
    public void createTruck() {
        try{
            System.out.println("\nEurope Vehicle Factory : Manufacturing Truck");
            VehicleOperations car = VehicleFactory.getVehicle(VehicleConstants.TRUCK);
            car.equipments();
            car.emissionStandard(EmissionNorms.TIER_2);
            car.seatType(4);
            car.steeringType("right");
            car.timePeriodToManufacture();
            System.out.println("Europe Vehicle Factory : Truck Manufactured");
        }catch (Exception e){
            System.out.println("ERROR in Europe Truck Manufacturing unit : "+ e.getMessage());
        }
    }
}
