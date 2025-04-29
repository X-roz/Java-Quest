import exception.UnsupportedVehicleException;
import org.junit.Assert;
import org.junit.Test;
import vehicles.Vehicle;
import vehicles.VehicleFactory;

import static constants.VehicleTypes.*;

public class UserTest {

    @Test
    public void testUser() throws UnsupportedVehicleException {

        Vehicle userChoice1 = VehicleFactory.getVehicle(BIKE_TYPE);

        /// Validate Type and Price
        Assert.assertEquals(userChoice1.getType(), BIKE_TYPE.getType());
        Assert.assertEquals(userChoice1.getRentalPricePerHour(), BIKE_TYPE.getPrice());
        Assert.assertEquals(userChoice1.calculateRentalCost(2), BIKE_TYPE.getPrice() * 2);

        Vehicle userChoice2 = VehicleFactory.getVehicle(CAR_TYPE);
        /// Validate Type and Price
        Assert.assertEquals(userChoice2.getType(), CAR_TYPE.getType());
        Assert.assertEquals(userChoice2.getRentalPricePerHour(), CAR_TYPE.getPrice());
        Assert.assertEquals(userChoice2.calculateRentalCost(2), CAR_TYPE.getPrice() * 2);

        Vehicle userChoice3 = VehicleFactory.getVehicle(TRUCK_TYPE);
        /// Validate Type and Price
        Assert.assertEquals(userChoice3.getType(), TRUCK_TYPE.getType());
        Assert.assertEquals(userChoice3.getRentalPricePerHour(), TRUCK_TYPE.getPrice());
        Assert.assertEquals(userChoice3.calculateRentalCost(2), TRUCK_TYPE.getPrice() * 2);

    }

}
