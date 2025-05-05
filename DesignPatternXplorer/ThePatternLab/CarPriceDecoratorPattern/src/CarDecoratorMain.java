public class CarDecoratorMain {
    public static void main(String[] args) {
        Car car1  = new SeatCover(new TopEndCar());
        System.out.println(car1.price());

        Car car2  = new SeatCover(new BaseModel());
        System.out.println(car2.price());

        Car car3  = new Speaker(new MidVariant());
        System.out.println(car3.price());
    }
}