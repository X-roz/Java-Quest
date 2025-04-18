import lombok.Data;

public class Builder {

    public static void main(String[] args){

        Employee employee = new EmployeeBuilder().setId("R1").setName("vicky")
                .setAddress("123-ABC").setExperience("3").setSalary("1800000").build();

        System.out.println(employee);
    }

    @Data
    static class Employee {
        String id;
        String name;
        String address;
        String salary;
        String experience;

        // Let's assume we have more details available
        Employee(String id,String name,String address,String salary,String experience) {
            this.id = id;
            this.experience=experience;
            this.address =address;
            this.name = name;
            this.salary =salary;
            // more to add
        }
    }

    // It's really hard for people to use this class with more variables.
    // so we can use Builder class here to simplify the process with default variables.
    static class EmployeeBuilder{

        // Default values
        String id="R0";
        String name="Ravi";
        String address="123";
        String salary="160000";
        String experience="3";

        public EmployeeBuilder setId(String id){
            this.id = id;
            return  this;
        }

        public EmployeeBuilder setName(String name){
            this.name = name;
            return  this;
        }

        public EmployeeBuilder setAddress(String address){
            this.address = address;
            return  this;
        }

        public EmployeeBuilder setSalary(String salary){
            this.salary = salary;
            return  this;
        }

        public EmployeeBuilder setExperience(String exp){
            this.experience = exp;
            return  this;
        }

        public Employee build(){
            return new Employee(id,name,address,salary,experience);
        }
    }

}





