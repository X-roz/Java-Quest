package vehicles;

public class VehicleFactory {

    public static VehicleOperations getVehicle(VehicleConstants vc) throws Exception {
        switch (vc){
            case CAR -> {
                return new Car();
            }
            case BIKE -> {
                return new Bike();
            }
            case TRUCK -> {
                return new Truck();
            }
            default -> throw new Exception("");
        }
    }
}
