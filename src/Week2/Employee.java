package Week2;

public abstract class Employee {
    private String name;
    private double salary;
    public Employee(String EmployeeName , double EmployeeSalary) {
        this.name = EmployeeName;
        this.salary = EmployeeSalary;
    }

    public String getEmployeeName() {
        return name;
    }

    public void setEmployeeName(String EmployeeName) {
        this.name = EmployeeName;
    }

    public double getEmployeeSalary() {
        return salary;
    }

    public void setEmployeeSalary(double EmployeeSalary) {
        this.salary = EmployeeSalary;
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
