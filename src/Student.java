// James Yue

// Subclass of Person
public class Student extends Person {

    // Instance variable
    private int grade;

    // Constructor takes in the instance variables of Person and intializes grade
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Getter function for grade
    public int getGrade() {
        return grade;
    }

    // Uses the toString from Person and adds on the grade
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}