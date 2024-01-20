// James Yue

// Subclass of Person
public class Athlete extends Person {

    // Instance variable
    private String sport;

    // Constructor takes in the instance variables of Person and intializes sport
    public Athlete(String firstName, String lastName, String phoneNumber, String sport) {
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
    }

    // Getter function for sport
    public String getSport() {
        return sport;
    }

    // Uses the toString from Person and adds on the sport
    public String toString() {
        return super.toString() + " Sport: " + sport;
    }
}