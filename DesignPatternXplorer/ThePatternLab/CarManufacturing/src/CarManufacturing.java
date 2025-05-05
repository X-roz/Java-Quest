public class CarManufacturing {
    public static void main(String[] args) {

        Car normalCar = new NormalCar();
        Car topEndCar = new TopEndCar(normalCar);

        normalCar.addIndicators();

        System.out.println();

        topEndCar.addIndicators();
    }
}