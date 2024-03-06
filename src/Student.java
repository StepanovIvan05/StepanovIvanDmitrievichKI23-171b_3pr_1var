import java.util.Objects;

class Student extends Person {
    private final int studentId;
    private static int id;
    private String speciality;

    public Student() {
        super();
        this.studentId = 0;
    }

    public Student(String name, int age, String speciality) {
        super(name, age);
        this.studentId = id;
        this.speciality = speciality;
        id++;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, speciality);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student person = (Student) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(speciality, person.speciality);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId=" + studentId +
                ", speciality='" + speciality + '\'' +
                ", hash code='" + hashCode() + '\'' +
                '}';
    }
}