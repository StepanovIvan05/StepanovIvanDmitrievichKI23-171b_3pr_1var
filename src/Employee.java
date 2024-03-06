import java.util.Objects;

class Employee extends Person {
    protected String bossName;
    protected int salary;

    public Employee() {
        super();
        this.bossName = "Undefined";
        this.salary = 0;
    }

    public Employee(String name, int age, String bossName, int salary) {
        super(name, age);
        this.bossName = bossName;
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, bossName, salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee person = (Employee) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(bossName, person.bossName) &&
                salary == person.salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss's name='" + bossName +
                ", salary=" + salary + '\'' +
                ", hash code='" + hashCode() + '\'' +
                '}';
    }
}