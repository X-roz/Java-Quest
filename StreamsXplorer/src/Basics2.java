import java.util.Comparator;
import java.util.List;

public class Basics2 {
    public static void main(String[] args){

        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<String> courses = List.of("Spring", "Spring boot", "API", "Docker", "JPA", "Database", "AWS");

        // Sum of numbers
        // Reduce - Actually reduce means we are reducing a list of elements into one result
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        ///  Task 1 - Square every number and prints it sum
        System.out.println("***** TASK 1 *****");
        Integer squaredSum =numbers.stream().map(x-> x*x).reduce(0, Integer::sum);
        System.out.println(squaredSum);

        ///  Task 2 - Sum of odd numbers
        System.out.println("***** TASK 2 *****");
        Integer oddSum =numbers.stream().filter(n->!(n%2==0)).reduce(0, Integer::sum);
        System.out.println(oddSum);

        // Distinct Elements - Avoid duplication while streaming
        System.out.println("***** DISTINCT *****");
        numbers.stream().distinct().forEach(System.out::println);

        // Sort Elements  - default: Comparator - Natural Order (Ascending)
        System.out.println("***** ASC SORT *****");
        numbers.stream().sorted().forEach(System.out::println);

        // Sort Elements  - default: Comparator - Reverse Order (Descending)
        System.out.println("***** DESC SORT *****");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // Sort Elements in the order of length of string
        System.out.println("***** String SORT by length *****");
        courses.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        // Collecting Stream elements into a list
        System.out.println("***** Collecting Stream elements *****");
        List<Integer> squaredList = numbers.stream().map(x->x*x).toList();
        System.out.println(squaredList);

        ///  Task 3 - Even numbers list
        System.out.println("***** TASK 3 *****");
        List<Integer> evenList =numbers.stream().filter(n->n%2==0).toList();
        System.out.println(evenList);

        ///  Task 4 - List of all courses length
        System.out.println("***** TASK 4 *****");
        List<Integer> courseLengthList =courses.stream().map(String::length).toList();
        System.out.println(courseLengthList);

        /// Task 5 - Greatest of all numbers
        System.out.println("***** TASK 5 *****");
        Integer greatestNumber =numbers.stream().reduce(0, (x,y)-> x>y?x:y);
        System.out.println(greatestNumber);

        // Intermediate and Terminal Stream Operations
        // Intermediate operations take stream as input and returns stream. example: filter, distinct, sorted, map
        // Terminal operations take stream as input and returns a type. example: reduce, collect, toList

    }
}
