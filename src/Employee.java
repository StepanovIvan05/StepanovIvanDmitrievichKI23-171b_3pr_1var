import java.util.Objects;

// Employee class inherits from Person class
class Employee extends Person {
    // Additional attributes specific to Employee
    protected String bossName; // Name of the boss
    protected int salary;      // Salary of the employee

    // Default constructor initializes attributes to default values
    public Employee() {
        super(); // Call the default constructor of the superclass (Person)
        this.bossName = "Undefined";
        this.salary = 0;
    }

    // Parameterized constructor initializes attributes with provided values
    public Employee(String name, int age, String bossName, int salary) {
        super(name, age); // Call the parameterized constructor of the superclass (Person)
        this.bossName = bossName;
        this.salary = salary;
    }

    // Hash code method generates a unique hash code for each Employee object
    @Override
    public int hashCode() {
        return Objects.hash(name, age, bossName, salary); // Combine hash codes of all attributes
    }

    // Equals method compares two Employee objects for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // If both objects refer to the same memory location, they are equal
        if (o == null || getClass() != o.getClass()) return false; // If the class types are different, they are not equal
        Employee employee = (Employee) o; // Cast the object to an Employee
        return age == employee.age && // Compare ages
                Objects.equals(name, employee.name) && // Compare names
                Objects.equals(bossName, employee.bossName) && // Compare boss names
                salary == employee.salary; // Compare salaries
    }

    // String representation of the Employee object
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss's name='" + bossName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
