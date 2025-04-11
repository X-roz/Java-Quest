import java.util.Random;
import java.util.function.*;

public class SL5 {

    public static void main(String[] args){

        ///  Operators

        // Supplier - Takes nothing but return something
        Random random = new Random();
        Supplier<Integer> randomInt = ()-> random.nextInt(1000);

        System.out.println("Suppliers Operator : "  +randomInt.get());

        // UnaryOperator - Takes one and return
        UnaryOperator<Integer> multiOf3 = (x)-> x*3;
        System.out.println("Unary Operator : " + multiOf3.apply(10));

        // BiPredicate
        BiPredicate<Integer, String> biPredicate = (n, s) -> n > 10 && s.length() >= 5;
        System.out.println("Bi Predicate : " + biPredicate.test(30, "welcome"));

        // BiFunction
        BiFunction<Integer, String, String> biFunction = (n, s) -> n +" " + s;
        System.out.println("Bi Function : " + biFunction.apply(40, "Hello!"));

        // BiConsumer
        BiConsumer<String, String> biConsumer = (s1,s2) ->{
            System.out.println("Bi Consumer : " + s1 + ", "+ s2);
        };
        biConsumer.accept("hi","hello");

        ///  For primitive datatypes we can use IntBinaryOperator

        IntBinaryOperator intBinaryOperatorSum = Integer::sum;
        System.out.println("primitive datatypes for sum : " + intBinaryOperatorSum.applyAsInt(12, 12));

    }
}
