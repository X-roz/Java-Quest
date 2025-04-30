package regional;

import vehicles.EmissionNorms;
import vehicles.VehicleConstants;
import vehicles.VehicleFactory;
import vehicles.VehicleOperations;

public class IndiaVehicleFactory implements RegionalVehicleFactory{
    
    @Override
    public void createCar() {
        try{
            System.out.println("\nIndia Vehicle Factory : Manufacturing Car");
            VehicleOperations car = VehicleFactory.getVehicle(VehicleConstants.CAR);
            car.equipments();
            car.emissionStandard(EmissionNorms.TIER_3);
            car.seatType(4);
            car.steeringType("right");
            car.timePeriodToManufacture();
            System.out.println("India Vehicle Factory : Car Manufactured");
        }catch (Exception e){
            System.out.println("ERROR in India Car Manufacturing unit : "+ e.getMessage());
        }
    }

    @Override
    public void createBike() {
        try{
            System.out.println("\nIndia Vehicle Factory : Manufacturing Bike");
            VehicleOperations car = VehicleFactory.getVehicle(VehicleConstants.BIKE);
            car.equipments();
            car.emissionStandard(EmissionNorms.TIER_3);
            car.seatType(4);
            car.steeringType("right");
            car.timePeriodToManufacture();
            System.out.println("India Vehicle Factory : Bike Manufactured");
        }catch (Exception e){
            System.out.println("ERROR in India Bike Manufacturing unit : "+ e.getMessage());
        }
    }

    @Override
    public void createTruck() {
        try{
            System.out.println("\nIndia Vehicle Factory : Manufacturing Truck");
            VehicleOperations car = VehicleFactory.getVehicle(VehicleConstants.TRUCK);
            car.equipments();
            car.emissionStandard(EmissionNorms.TIER_2);
            car.seatType(4);
            car.steeringType("right");
            car.timePeriodToManufacture();
            System.out.println("India Vehicle Factory : Truck Manufactured");
        }catch (Exception e){
            System.out.println("ERROR in India Truck Manufacturing unit : "+ e.getMessage());
        }
    }
}
