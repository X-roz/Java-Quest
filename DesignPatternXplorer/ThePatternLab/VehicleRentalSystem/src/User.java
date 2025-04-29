import exception.UnsupportedVehicleException;
import vehicles.Vehicle;
import vehicles.VehicleFactory;
import static constants.VehicleTypes.*;

public class User {

    public static void main(String[] args) {

        try {
            Vehicle userChoice1 = VehicleFactory.getVehicle(BIKE_TYPE);
            System.out.println("User's choice : " + userChoice1.getType() +
                    " rental price per hour : " + userChoice1.getRentalPricePerHour());

            System.out.println("For 2 hours rental price for " + userChoice1.getType() + " : " +
                    userChoice1.calculateRentalCost(2));

            Vehicle userChoice2 = VehicleFactory.getVehicle(CAR_TYPE);
            System.out.println("User's choice : " + userChoice2.getType() +
                    " rental price per hour : " + userChoice2.getRentalPricePerHour());

            System.out.println("For 2 hours rental price for " + userChoice2.getType() + " : " +
                    userChoice2.calculateRentalCost(2));

            Vehicle userChoice3 = VehicleFactory.getVehicle(TRUCK_TYPE);
            System.out.println("User's choice : " + userChoice3.getType() +
                    " rental price per hour : " + userChoice3.getRentalPricePerHour());

            System.out.println("For 2 hours rental price for " + userChoice3.getType() + " : " +
                    userChoice3.calculateRentalCost(2));

        }catch (UnsupportedVehicleException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}