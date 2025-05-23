package vehicles;

import constants.VehicleTypes;
import exception.UnsupportedVehicleException;

public class VehicleFactory {

    public static Vehicle getVehicle(VehicleTypes type) throws UnsupportedVehicleException {

        switch (type){
            case TRUCK_TYPE -> {
                return new Truck();
            }
            case CAR_TYPE -> {
                return new Car();
            }
            case BIKE_TYPE -> {
                return new Bike();
            }
            default -> {
                throw new UnsupportedVehicleException("Invalid Vehicle type");
            }
        }

    }
    
}
