public class SeatCover extends Accessories {

    Car car;
    public SeatCover(Car topEndCar) {
        this.car = topEndCar;
    }

    @Override
    public int price() {
        return this.car.price() + 700;
    }
}
