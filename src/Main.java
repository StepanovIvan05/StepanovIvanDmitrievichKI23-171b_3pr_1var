import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class of the application
public class Main {
    // List to store Person objects
    private static final List<Person> people = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private static boolean finish = true;

    // Main method
    public static void main(String[] args) {
        while(finish){
            // Display menu options
            System.out.println("""
                    Menu:
                    1.Add empty Person
                    2.Add Person with data
                    3.Delete Person
                    4.Display all people
                    5.Comparison of two people
                    6.Exit
                    (1-6):""");
            // Read user choice
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    choiceClass(1);// Add empty Person
                    break;
                case "2":
                    choiceClass(0);// Add Person with data
                    break;
                case "3":
                    System.out.print("Enter index to delete: ");
                    if(scanner.hasNextInt()){
                        int index = scanner.nextInt();
                        removePerson(index);// Delete Person
                    }
                    else{
                        errorOut();
                    }
                    scanner.nextLine();
                    break;
                case "4":
                    printAllPeople(); // Display all people
                    break;
                case "5":
                    int firstIndex, secondIndex;
                    System.out.print("Enter first index to compare: ");
                    if(scanner.hasNextInt()){
                        firstIndex = scanner.nextInt();
                    }
                    else{
                        errorOut();
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                    System.out.print("Enter second index to compare: ");
                    if(scanner.hasNextInt()){
                        secondIndex = scanner.nextInt();
                    }
                    else{
                        errorOut();
                        scanner.nextLine();
                        break;
                    }
                    System.out.println(comparePeople(firstIndex, secondIndex)); // Compare two people
                    scanner.nextLine();
                    break;
                case "6":
                    finish = false; // Exit
                    break;
                default:
                    System.out.println("Incorrect choice.");
            }
        }
    }

    // Add Person to the list
    private static void addPerson(Person person) {
        people.add(person);
    }

    // Remove Person from the list
    private static void removePerson(int index) {
        if (index >= 0 && index < people.size()) {
            people.remove(index);
            System.out.println("Person at index " + index + " removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Display all people in the list
    private static void printAllPeople() {
        for (int i = 0; i < people.size(); i++) {
            System.out.println("Index " + i + ": " + people.get(i));
        }
    }

    // Compare two people based on their indexes
    private static String comparePeople(int index1, int index2) {
        if (index1 >= 0 && index1 < people.size() &&
                index2 >= 0 && index2 < people.size()) {
            if(people.get(index1).hashCode() == people.get(index2).hashCode() && people.get(index1).equals(people.get(index2))){
                return "People are equal.";
            }
            else{
                return "People are not equal.";
            }
        } else {
            return "Invalid index.";
        }
    }

    // Method to add Person, Employee, Teacher, or Student based on user input
    private static void choiceClass(int isEmpty){
        System.out.print("Enter who to add(Person, Employee, Teacher, Student): ");
        String choice = scanner.nextLine();
        String name;
        String bossName;
        int salary;
        int age;
        switch (choice){
            case "Person":
                if(isEmpty == 0){
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    age = inputAge();
                    if(age == -1){
                        break;
                    }
                    addPerson(new Person(name, age));
                }
                else{
                    addPerson(new Person());
                }
                break;
            case "Employee":
                if(isEmpty == 0){
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    age = inputAge();
                    if(age == -1){
                        break;
                    }
                    System.out.print("Enter boss's name: ");
                    bossName = scanner.nextLine();
                    salary = inputSalary();
                    if(salary == -1){
                        break;
                    }
                    addPerson(new Employee(name, age, bossName, salary));
                }
                else{
                    addPerson(new Employee());
                }
                break;
            case "Teacher":
                if(isEmpty == 0){
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    age = inputAge();
                    int numberGroups;
                    if(age == -1){
                        break;
                    }
                    System.out.print("Enter boss's name: ");
                    bossName = scanner.nextLine();
                    salary = inputSalary();
                    if(salary == -1){
                        break;
                    }
                    System.out.print("Enter subject: ");
                    String subject = scanner.nextLine();
                    System.out.print("Enter number of groups(1-100): ");
                    if(scanner.hasNextInt()){
                        numberGroups = scanner.nextInt();
                        if(numberGroups <= 0 || numberGroups > 100){
                            scanner.nextLine();
                            errorOut();
                            return;
                        }
                    }
                    else{
                        scanner.nextLine();
                        errorOut();
                        return;
                    }
                    scanner.nextLine();
                    addPerson(new Teacher(name, age, bossName,salary, subject, numberGroups));
                }
                else{
                    addPerson(new Teacher());
                }
                break;
            case "Student":
                if(isEmpty == 0){
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    age = inputAge();
                    if(age == -1){
                        break;
                    }
                    System.out.print("Enter speciality: ");
                    String speciality = scanner.nextLine();
                    addPerson(new Student(name, age, speciality));
                }
                else{
                    addPerson(new Student());
                }
                break;
            default:
                System.out.println("Incorrect choice.");
                break;
        }
    }

    // Method to handle input errors
    private static void errorOut(){
        System.out.println("Input error");
    }

    // Method to input age and validate it
    private static int inputAge(){
        System.out.print("Enter age(0 - 200): ");
        if(scanner.hasNextInt()){
            int age = scanner.nextInt();
            scanner.nextLine();
            if(age < 0 || age > 200){
                errorOut();
                return -1;
            }
            return age;
        }
        else{
            scanner.nextLine();
            errorOut();
            return -1;
        }
    }

    // Method to input salary and validate it
    private static int inputSalary(){
        System.out.print("Enter salary: ");
        if(scanner.hasNextInt()){
            int salary = scanner.nextInt();
            scanner.nextLine();
            if(salary < 0 || salary > 1e9){
                errorOut();
                return -1;
            }
            return salary;
        }
        else{
            scanner.nextLine();
            errorOut();
            return -1;
        }
    }

}
