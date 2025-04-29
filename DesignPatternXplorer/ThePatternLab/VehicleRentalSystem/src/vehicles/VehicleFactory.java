package vehicles;

import constants.VehicleTypes;
import exception.UnsupportedVehicleException;
import static constants.VehicleTypes.*;

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
                throw new UnsupportedOperationException("Invalid Vehicle type");
            }
        }

    }
    
}
