import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SL8 {

    public static void main(String[] args) {

        List<String> courses = new ArrayList<>(practice.generateStringList());

        /// Task 1 - Join all the strings with a delimiter ";"
        System.out.println("**** Task 1 ****");
        System.out.println(courses.stream().collect(Collectors.joining(";")));

        /// Flat map
        System.out.println("**** Task 2 ****");
        System.out.println(courses.stream().map(c->c.split("")).flatMap(Arrays::stream).distinct().toList());

        /// Flat map - 2
        System.out.println("**** Task 3 ****");
        List<String> courses2 = practice.generateStringList();
        System.out.println(courses.stream().flatMap(c ->
                courses2.stream().filter(c2 -> c.length() == c2.length()).map(c2 -> List.of(c,c2)))
                .filter(l -> !l.get(0).equals(l.get(1))).toList());

        /// Higher order function - A function returns a function.
        System.out.println("**** Task 4 ****");
        System.out.println(courses.stream().filter(courseFilterPredicate(3)).toList());

        /// Replace All
        System.out.println("**** Task 5 ****");
        courses.replaceAll(String::toUpperCase);
        System.out.println(courses);

        /// Remove if
        System.out.println("**** Task 6 ****");
        courses.removeIf(c-> c.length()>3);
        System.out.println(courses);

        /// Parallel Streams
        System.out.println("**** Task 7 ****");
        courses2.stream().parallel().forEach(System.out::println);

    }

    private static Predicate<String> courseFilterPredicate(int l) {
        return c -> c.length() > l;
    }

}
