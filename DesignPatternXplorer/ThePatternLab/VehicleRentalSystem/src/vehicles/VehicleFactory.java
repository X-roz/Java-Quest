package vehicles;

import constants.RentalConstants;

public class VehicleFactory {

    public static Vehicle getVehicle(String type){

        switch (type){
            case RentalConstants.TRUCK_TYPE -> {
                return new Truck();
            }
            case RentalConstants.CAR_TYPE -> {
                return new Car();
            }
            case RentalConstants.BIKE_TYPE -> {
                return new Bike();
            }
            default -> {
                return null;
            }
        }

    }
    
}
