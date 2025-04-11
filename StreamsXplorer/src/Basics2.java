import java.util.List;

public class Basics2 {
    public static void main(String[] args){

        List<Integer> numbers = List.of(12,3,45,67,88,90,2,48);

        // Sum of numbers
        // Reduce - Actually reduce means we are reducing a list of elements into one result
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

    }
}
