import java.util.Objects;

// Student class inherits from Person class
class Student extends Person {
    // Additional attributes specific to Student
    private final int studentId; // Unique identifier for the student
    private static int id;       // Static variable to manage student IDs
    private String speciality;   // Speciality of the student

    // Default constructor initializes attributes to default values
    public Student() {
        super(); // Call the default constructor of the superclass (Person)
        this.studentId = 0;
    }

    // Parameterized constructor initializes attributes with provided values
    public Student(String name, int age, String speciality) {
        super(name, age); // Call the parameterized constructor of the superclass (Person)
        this.studentId = id; // Assign student ID
        this.speciality = speciality; // Assign speciality
        id++; // Increment student ID for the next student
    }

    // Hash code method generates a unique hash code for each Student object
    @Override
    public int hashCode() {
        return Objects.hash(name, age, speciality); // Combine hash codes of all attributes
    }

    // Equals method compares two Student objects for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // If both objects refer to the same memory location, they are equal
        if (o == null || getClass() != o.getClass()) return false; // If the class types are different, they are not equal
        Student student = (Student) o; // Cast the object to a Student
        return age == student.age && // Compare ages
                Objects.equals(name, student.name) && // Compare names
                Objects.equals(speciality, student.speciality); // Compare specialities
    }

    // String representation of the Student object
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId=" + studentId +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
