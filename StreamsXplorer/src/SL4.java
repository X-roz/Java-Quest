import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings({"unused"})
public class SL4 {

    public static void main(String[] args){

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        /// Behavioural Parametrization for more flexibility and generic code

        /* For instance:
            List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

            Even filter:
            numbers.stream().filter(x->x%2==0);

            Odd filter:
            numbers.stream().filter(x->x%2!=0);

            we can generalize this filter method using behavioural parametrization concept.
        */

        // Even numbers:
        System.out.println("*** Even ***");
        filterAndPrint(numbers, x->x%2==0);

        // Odd numbers:
        System.out.println("*** Odd ***");
        filterAndPrint(numbers, x->x%2!=0);

        // Multiples of 3:
        System.out.println("*** Multiples of 3 ***");
        filterAndPrint(numbers, x->x%3==0);

        // Many more filters we can add and process it

        /// Task 1 - Behavioural parameterization for mapping filter
        System.out.println("***** TASK 1 - Squaring numbers ****");
        mappingPrint(numbers, x-> x*x);

        System.out.println("***** TASK 1 - Squaring Even numbers ****");
        filterMapPrint(numbers, x-> x%2==0,x-> x*x);

        /// Task 2 - Behavioural parameterization for mapping filter and create a list
        System.out.println("***** TASK 2 - list of 3 multiples numbers ****");
        System.out.println(filterMapCreate(numbers, x->x%2==0, x-> x*3));

    }

    public static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate){
        numbers.stream().filter(predicate).forEach(System.out::println);
    }

    public static void mappingPrint(List<Integer> numbers, Function<? super Integer, ? super Integer> mapFunction){
        numbers.stream().map(mapFunction).forEach(System.out::println);
    }

    public static void filterMapPrint(List<Integer> numbers, Predicate<? super Integer> predicate, Function<? super Integer, ? super Integer> mapFunction){
        numbers.stream().filter(predicate).map(mapFunction).forEach(System.out::println);
    }

    public static List<?> filterMapCreate(List<Integer> numbers, Predicate<? super Integer> predicate,
                                       Function<? super Integer, ? super Integer> mapFunction){
        return numbers.stream().filter(predicate).map(mapFunction).toList();
    }
}
