public class Speaker extends Accessories {

    Car car;

    public Speaker(Car car){
        this.car = car;
    }

    @Override
    public int price() {
        return this.car.price() + 450;
    }
}
