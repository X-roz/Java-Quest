package vehicles;

public interface Vehicle {
    String getType();
    int getRentalPricePerHour();
    int calculateRentalCost(int hours);
}

