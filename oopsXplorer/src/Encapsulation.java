public class Encapsulation {

    public static void main(String[] args){

        // creating an instance for person class
        Person personInstance1 = new Person();
        personInstance1.name = "vicky";
        personInstance1.age = 4;

        Person personInstance2 = new Person();
        personInstance2.name = "tejas";
        personInstance2.age = 2;

        personInstance1.display();
        personInstance2.display();

        // Definition: Bundle of data with methods that can operate that data within the class.
        // Classes are like Blueprint
        // Objects are a created using that classes [blueprint]
        // Each object has its own data.
    }

    public static class Person {
        public String name;
        public int age;

        public void display(){
            System.out.println("name :"+name);
            System.out.println("age  : "+age);
            System.out.println();
        }
    }
}
