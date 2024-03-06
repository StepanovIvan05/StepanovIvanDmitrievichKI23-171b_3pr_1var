import java.util.Objects;

// Teacher class inherits from Employee class
class Teacher extends Employee {
    // Additional attributes specific to Teacher
    private final String subject; // Subject taught by the teacher
    private int numberGroups;     // Number of groups taught by the teacher

    // Default constructor initializes attributes to default values
    public Teacher() {
        super(); // Call the default constructor of the superclass (Employee)
        this.subject = "Undefined";
    }

    // Parameterized constructor initializes attributes with provided values
    public Teacher(String name, int age, String bossName, int salary, String subject, int numberGroups) {
        super(name, age, bossName, salary); // Call the parameterized constructor of the superclass (Employee)
        this.subject = subject;
        this.numberGroups = numberGroups;
    }

    // Hash code method generates a unique hash code for each Teacher object
    @Override
    public int hashCode() {
        return Objects.hash(name, age, bossName, salary, subject, numberGroups); // Combine hash codes of all attributes
    }

    // Equals method compares two Teacher objects for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // If both objects refer to the same memory location, they are equal
        if (o == null || getClass() != o.getClass()) return false; // If the class types are different, they are not equal
        Teacher teacher = (Teacher) o; // Cast the object to a Teacher
        return age == teacher.age && // Compare ages
                salary == teacher.salary && // Compare salaries
                numberGroups == teacher.numberGroups && // Compare number of groups
                Objects.equals(name, teacher.name) && // Compare names
                Objects.equals(bossName, teacher.bossName) && // Compare boss names
                Objects.equals(subject, teacher.subject); // Compare subjects
    }

    // String representation of the Teacher object
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", boss's name='" + bossName + '\'' +
                ", subject='" + subject + '\'' +
                ", number of groups='" + numberGroups + '\'' +
                '}';
    }
}
