import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@SuppressWarnings({"unused","CommentedOutCode"})
public class SL3 {

    @SuppressWarnings({"unused","CommentedOutCode"})
    public static void main(String[] args){

        ///  What happens behind lambda expressions

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        /*
        numbers.stream()
                .filter(x->x%2==0)
                .map(x->x*x)
                .forEach(System.out::println);
        */

        /// Lambda expression for filter operation

        Predicate<Integer> evenFilter = x -> x%2 == 0;

        /* what actually happens */
        Predicate<Integer> evenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n%2==0;
            }
        };

        /// Lambda expression for mapping operation

        Function<Integer, Integer> mappingSquaredNumbers = x-> x*x;

        /* what actually happens */
        Function<Integer,Integer> mappingFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n*n;
            }
        } ;

        /// Lambda expression for Consumer operation

        Consumer<Integer> printNumbers = System.out::println;

        /* what actually happens */
        Consumer<Integer> printConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        };


        // Displaying numbers with custom defined variables
        numbers.stream()
                .filter(evenPredicate)
                .map(mappingFunction)
                .forEach(printConsumer);
    }
}
