package behavioralPattern;

import java.util.Random;
import java.util.function.BinaryOperator;

public class Strategy {

    public static void main(String[] args){
        ExecutorStrategy ue = new UpperCaseExecutor();
        ExecutorStrategy le = new LowerCaseExecutor();
        ExecutorStrategy re = new RandomCaseExecutor();

        System.out.println(ue.format("welcome to the virtual reality world"));
        System.out.println(le.format("welcome to the virtual reality world"));
        System.out.println(re.format("welcome to the virtual reality world"));
    }

}

interface ExecutorStrategy {
    String format(String input);
}

// UPPERCASE Executor
class UpperCaseExecutor implements ExecutorStrategy {

    @Override
    public String format(String input) {
        return input.toUpperCase();
    }
}

// LOWERCASE Executor
class LowerCaseExecutor implements ExecutorStrategy {

    @Override
    public String format(String input) {
        return input.toLowerCase();
    }
}

// Random Case Executor
class RandomCaseExecutor implements ExecutorStrategy {

    Random random = new Random();

    BinaryOperator<String> operator = (s1, s2) -> s1+s2;

    @Override
    public String format(String input) {

        return input.chars().mapToObj( i -> (char)i)
                .map(c->random.nextBoolean()?Character.toUpperCase(c):Character.toLowerCase(c))
                .map(String::valueOf)
                .reduce("", operator);
    }
}