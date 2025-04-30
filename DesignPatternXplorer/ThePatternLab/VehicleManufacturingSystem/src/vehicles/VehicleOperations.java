package vehicles;

public interface VehicleOperations {

    void equipments();
    void seatType(int totalSeat);
    void steeringType(String position);

    /// Time required to build a vehicle
    void timePeriodToManufacture();

    /// To manufacture vehicle based on the norms
    void emissionStandard(EmissionNorms norms);
}
