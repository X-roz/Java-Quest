import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class practice {

    public static void main(String[] args){

        /// Basic level
        /*
        1. Filter even numbers from a list
        Given a list of integers, use streams to return a list of only even numbers.

        2. Count strings starting with 'A'
        Given a list of strings, count how many strings start with the letter 'A' (case-insensitive).

        3. Convert a list of strings to uppercase
        Use stream to convert all strings in a list to uppercase.

        4. Sort a list of integers
        Use streams to sort the list in ascending and descending order.

        5. Find the maximum and minimum
        Use streams to find the max and min in a list of integers.

        */
        // basics();

        /// Intermediate Level
        /*
        1. Group strings by their length
        Input: ["apple", "bat", "cat", "banana", "ant"]
        Output: Map with key as string length and value as list of strings of that length.

        2. Find duplicate elements in a list
        Return a set of duplicate elements using streams.

        3. Flatten a list of lists
        Convert List<List<String>> to a single List<String> using flatMap.

        4. Frequency count of characters in a string
        Input: "banana"
        Output: {b=1, a=3, n=2}

        5. Find the first non-repeating character in a string
        Input: "swiss"
        Output: 'w'

         */
        // intermediate();

        ///  Advance level
        /*
        1. Custom Collector to join strings with a delimiter
        Join all names in a list with ; but in uppercase.

        2. Map employees by department
        Given a list of Employee objects (with fields: name, department), return a map of department to list of employees.

        3. Sum of salaries by department
        Input: List of Employees
        Output: Map<Department, Total Salary>

        4. Find top 3 highest earning employee
        Input: List of Employee(name, salary)
        Output: Top 3 based on salary.

        5. Partition integers into even and odd
        Output: Map<Boolean, List<Integer>> where true → even, false → odd.
        */
        advance();

    }

    private static void advance() {
        System.out.println("***** A1 *****");
        List<String> strList = generateStringList();
        System.out.println(strList.stream().map(String::toUpperCase).collect(Collectors.joining(";")));

        System.out.println("***** A2 *****");
        List<Employee> employeeList = List.of(
                new Employee("Ryan", "CS", 1200),
                new Employee("Rave", "BIO-TECH",1300),
                new Employee("Kim", "CS", 1500),
                new Employee("Vicky", "IT", 100000000),
                new Employee("Sam", "CS", 1988)
        );
        Map<String,List<String>> dp = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())
        ));
        System.out.println(dp);

        System.out.println("***** A3 *****");
        Map<String,Integer> sp =employeeList.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getSalary, Collectors.reducing(0, Integer::sum))
                )
        );
        System.out.println(sp);

        System.out.println("***** A4 *****");
        List<String> topHire = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3)
                .map(Employee::getName).toList();
        System.out.println(topHire);

    }

    @Getter
    static class Employee {
        String name;
        String department;
        int salary;

        Employee(String name, String dep, int salary){
            this.name = name;
            this.department = dep;
            this.salary = salary;
        }
    }

    private static void intermediate(){

        System.out.println("***** I1 *****");
        List<String> fruits = List.of("apple", "bat", "cat", "banana", "ant");
        System.out.println("Fruits based on length :" +
                fruits.stream().collect(Collectors.groupingBy(String::length, Collectors.toList())));

        System.out.println("***** I2 *****");
        List<Integer> listWithDup = List.of(12,3,12,4,4,5,6,7,5) ;
        System.out.println("Duplicate values : "+listWithDup.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) //returns map
                .entrySet().stream() // stream through map
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList()
        );

        System.out.println("***** I3 *****");
        List<List<String>> strFruits = List.of(fruits, fruits);
        System.out.println("flat map : " + strFruits.stream().flatMap(List::stream).toList());

        System.out.println("***** I4 *****");
        String s = "banana";
        System.out.println("Frequency count of characters in a string : "+s.chars().mapToObj(c -> (char) c).collect(
            Collectors.groupingBy(Function.identity(), Collectors.counting())
        ));

        System.out.println("***** I5 *****");
        s = "uhssswwiieesho";
        System.out.println("First non-repeating character : "+
                s.chars().mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .filter(e -> e.getValue() == 1).findFirst().map(Map.Entry::getKey).get()
        );

    }

    private static void basics() {

        List<Integer> num = generateRandomList();
        System.out.println("numbers  : "+ num);
        System.out.println("***** B1 *****");
        System.out.println("Even numbers : "+num.stream().filter(n->n%2==0).toList());

        List<String> courses = generateStringList();
        System.out.println("courses  : "+ courses);
        System.out.println("***** B2 *****");
        System.out.println("Courses starts with A : "+ courses.stream().filter(c-> c.startsWith("A")).toList());

        System.out.println("***** B3 *****");
        System.out.println("Courses in Uppercase : "+ courses.stream().map(String::toUpperCase).toList());

        System.out.println("***** B4 - A *****");
        System.out.println("Sort ASC : "+ num.stream().sorted().toList()); // default: naturalOrder comparator
        System.out.println("***** B4 - B *****");
        System.out.println("Sort DESC : "+ num.stream().sorted(Comparator.reverseOrder()).toList());

        System.out.println("***** B5 - A *****");
        System.out.println("Max : "+ num.stream().max(Comparator.naturalOrder()));
        System.out.println("***** B5 - B *****");
        System.out.println("Min : "+ num.stream().min(Comparator.naturalOrder()));

    }

    private static List<Integer> generateRandomList() {
        Random random = new Random();
        Supplier<Integer> randSupplier = () -> random.nextInt(100);
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<7;i++){
            numbers.add(randSupplier.get());
        }
        return numbers;
    }

    private static  List<String> generateStringList() {
        return List.of("Spring", "Spring boot", "API", "Docker", "JPA", "Database", "AWS");
    }
}
