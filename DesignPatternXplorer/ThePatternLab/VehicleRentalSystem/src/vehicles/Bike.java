package vehicles;

import constants.RentalConstants;

public class Bike implements Vehicle {

    @Override
    public String getType() {
        return RentalConstants.BIKE_TYPE;
    }

    @Override
    public int getRentalPricePerHour() {
        return RentalConstants.BIKE_PRICE_PER_HOUR;
    }

    @Override
    public int calculateRentalCost(int hours) {
        return hours>0 ? RentalConstants.BIKE_PRICE_PER_HOUR * hours : 0;
    }
}
