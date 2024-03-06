import java.util.Objects;

class Teacher extends Employee {
    private final String subject;
    private int numberGroups;

    public Teacher() {
        super();
        this.subject = "Undefined";
    }

    public Teacher(String name, int age, String bossName,int salary,  String subject, int numberGroups) {
        super(name, age, bossName, salary);
        this.subject = subject;
        this.numberGroups = numberGroups;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, bossName, salary, subject, numberGroups);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher person = (Teacher) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(bossName, person.bossName) &&
                salary == person.salary &&
                Objects.equals(subject, person.subject) &&
                numberGroups == person.numberGroups;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", boss's name'=" + bossName + '\'' +
                ", subject='" + subject + '\'' +
                ", number of groups='" + numberGroups + '\'' +
                ", hash code='" + hashCode() + '\'' +
                '}';
    }
}