public class Abstraction {

    public static void main(String[] args){

        Student stdInstance1 = new Student();
        stdInstance1.name = "vicky";
        stdInstance1.age = 24;
        stdInstance1.alumniStudent();

        Student stdInstance2 = new Student();
        stdInstance2.name = "ajay";
        stdInstance2.age = 18;
        stdInstance2.activeStudent();

        stdInstance1.display();
        stdInstance2.display();

        // Abstraction: Process of hiding the internal data from outer world.
        //
        // here we have a Student class with thier details.
        // we don't want to access the status of the student directly.
        // so we used the private access modifier to hide the data from outer class.
        // If we want to do some operation on the status variable.
        // we can write a public function inside the class. Now, we can use that public func to modify the data.

    }

    public static class Student {
        public String name;
        public int age;
        public static String schoolName = "Kurinji";
        private boolean status;

        public void display(){
            System.out.println("Student Name :"+ name);
            System.out.println("Age :"+ age);
            System.out.println("School Name :"+ schoolName);
            System.out.println("Status :" + (status?"Active Student":"Alumni Student"));
            System.out.println();
        }

        public void activeStudent(){
            this.status = true;
        }

        public void alumniStudent(){
            this.status = false;
        }

    }


}
