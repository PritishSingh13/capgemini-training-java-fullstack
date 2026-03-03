/*2. Write a Java program that performs the following tasks:
Create a class Employee with three attributes: id, name, and sal (salary).
Implement a parameterized constructor to initialize these attributes.
Create a non-static method printDetails() to display employee details.
In the main() method:
Create an 4 Employee object*/







class Question02_Employee {

    int id;
    String name;
    double sal;

    // Parameterized constructor
    Question02_Employee(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    // Non-static method
    void printDetails() {
        System.out.println("ID: " + id +  ", Name: " + name +  ", Salary: " + sal);
    }

    public static void main(String[] args) {

        Question02_Employee e1 = new Question02_Employee(1, "Amit", 30000);
        Question02_Employee e2 = new Question02_Employee(2, "Ravi", 35000);
        Question02_Employee e3 = new Question02_Employee(3, "Neha", 40000);
        Question02_Employee e4 = new Question02_Employee(4, "Pritish", 45000);

        e1.printDetails();
        e2.printDetails();
        e3.printDetails();
        e4.printDetails();
    }
}
