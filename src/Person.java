import java.util.Objects;

// Person class represents a basic entity with name and age attributes
class Person {
    // Attributes
    protected String name; // Name of the person
    protected int age;     // Age of the person

    // Default constructor initializes name as "Undefined" and age as 0
    public Person() {
        this.name = "Undefined";
        this.age = 0;
    }

    // Parameterized constructor initializes name and age based on provided values
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Equals method to compare two Person objects for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // If both objects refer to the same memory location, they are equal
        if (o == null || getClass() != o.getClass()) return false; // If the class types are different, they are not equal
        Person person = (Person) o; // Cast the object to a Person
        return age == person.age && // Compare ages
                Objects.equals(name, person.name); // Compare names
    }

    // Hash code method generates a unique hash code for each Person object
    @Override
    public int hashCode() {
        return Objects.hash(name, age); // Combine hash codes of name and age
    }

    // String representation of the Person object
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
