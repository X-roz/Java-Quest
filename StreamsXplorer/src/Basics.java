import java.util.List;

public class Basics {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,3,45,67,88,90,2,48);

        // printALlNumberStructuralPrograming(numbers);
        // printALlNumberFunctionalPrograming(numbers);
        // printEvenNumberStructuralPrograming(numbers);
        // printEvenNumberFunctionalPrograming(numbers);
    }

    // Structural Programming - Take each numbers in the list and prints it
    public static void printALlNumberStructuralPrograming(List<Integer> numbers) {
        for(Integer n: numbers){
            System.out.println(n);
        }
    }

    // Filter in structural programming
    public static void printEvenNumberStructuralPrograming(List<Integer> numbers) {
        for(Integer n: numbers){
            if (n % 2 == 0){
                System.out.println(n);
            }
        }
    }

    public static void display(Integer n){
        System.out.println(n);
    }

    // Functional Programing - stream through the list and prints it
    public static void printALlNumberFunctionalPrograming(List<Integer> numbers){

        // numbers.stream().forEach(Basics::display);
        numbers.stream().forEach(System.out::println);

        // System.out::println, Basics::display --> Method References
    }


    // Functional programming filters - To filter the stream and process it
    public static void printEvenNumberFunctionalPrograming(List<Integer> numbers) {
        numbers.stream()
                .filter((n)-> n%2==0)
                // Lambda Expression - with one statement it will return that statement's output otherwise we need to provide return statement.
                .forEach(System.out::println);
    }
}