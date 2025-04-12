import java.awt.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SL7 {

    public static void main(String[] args){

        // Primitive int - Stream
        System.out.println("**** Task 1 ****");
        System.out.println(IntStream.of(1,2,3,4,5,7).sum());

        // Range
        System.out.println("**** Task 2 ****");
        System.out.println(IntStream.range(1,10).sum());

        // Range Closed
        System.out.println("**** Task 3 ****");
        System.out.println(IntStream.rangeClosed(1,10).sum());

        // Iteration
        System.out.println("**** Task 4 ****");
        System.out.println(IntStream.iterate(1, e -> e+2).limit(10).sum());

        // 1-20 Even numbers using Iteration
        System.out.println("**** Task 5 ****");
        System.out.println(Arrays.toString(IntStream.iterate(0, e -> e + 2).limit(10).toArray()));

        // Primitive int to Integer using Boxed()
        System.out.println("**** Task 5 ****");
        System.out.println(IntStream.iterate(2, e-> e+2).limit(10).boxed().toList());

        // Using Enormous calculation
        System.out.println("**** Task 6 ****");
        System.out.println(IntStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
    }
}
