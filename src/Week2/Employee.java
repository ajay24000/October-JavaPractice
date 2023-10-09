package Week2;

public abstract class Employee {
    String name;
    double salary;
    public Employee(String name , double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getEmployeeName() {
        return name;
    }

    public void setEmployeeName(String name) {
        this.name = name;
    }

    public double getEmployeeSalary() {
        return salary;
    }

    public void setEmployeeSalary(double salary) {
        this.salary = salary;
    }
    abstract double calculateSalary();

}
class Manager extends Employee {
    public Manager(String employeeName, double employeeSalary) {
        super(employeeName, employeeSalary);
    }
    public double calculateSalary() {
        return getEmployeeSalary();
    }
}
class Developer extends Employee {
    public Developer(String employeeName, double employeeSalary) {
        super(employeeName, employeeSalary);
    }

    double calculateSalary() {
        return getEmployeeSalary();
    }
}
class Main {
    public static void main(String[] args) {
        Manager mg = new Manager("Alice", 80000);

        Developer dl = new Developer("Bob", 60000);

        printEmployeeDetails(mg);
        printEmployeeDetails(dl);
    }
    private static void printEmployeeDetails(Employee employee) {
        System.out.println("Name: " + employee.getEmployeeName());
        System.out.println("Salary: $" + employee.calculateSalary());
    }
}
