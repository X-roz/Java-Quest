package vehicles;

public enum VehicleConstants {
    CAR("Car"), TRUCK("Truck"), BIKE("Bike");

    private final String type;

    VehicleConstants(String name){
        this.type = name;
    }

    public String getType() {
        return type;
    }
}
