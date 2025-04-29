package constants;

public enum VehicleTypes {
    CAR_TYPE("CAR", 50),
    BIKE_TYPE("BIKE", 100),
    TRUCK_TYPE("TRUCK",200);

    private final String type;
    private final int price;

    VehicleTypes(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
         return type;
    }

    public int getPrice(){
        return price;
    }
}
