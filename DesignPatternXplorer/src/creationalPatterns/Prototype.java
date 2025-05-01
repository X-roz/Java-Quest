package creationalPatterns;

import lombok.Data;

public class Prototype {

    public static void main(String [] args){
        Employee e1 = new Employee("1","vicky","123-abc","150000","3");
        Employee e2 = e1.copy();

        e1.setSalary("200000");
        System.out.println(e1);
        System.out.println(e2);
    }
    
}

@Data
class Employee {
    String id;
    String name;
    String address;
    String salary;
    String experience;
    
    Employee(String id,String name,String address,String salary,String experience) {
        this.id = id;
        this.experience=experience;
        this.address =address;
        this.name = name;
        this.salary =salary;
    }
    
    public Employee copy(){
        return new Employee(this.getId(),this.getName(), this.address, this.getSalary(), this.getExperience());
    }
}