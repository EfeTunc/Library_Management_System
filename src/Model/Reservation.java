package Model;
import java.time.LocalDate;
public class Reservation {
    private String ISBN;
    private int userID;
    private LocalDate dateBorrowed;
    private LocalDate dateDue;

    public Reservation(String ISBN, int userID, LocalDate dateBorrowed, LocalDate dateDue) {
        this.ISBN = ISBN;
        this.userID = userID;
        this.dateBorrowed = dateBorrowed;
        this.dateDue = dateDue;
    }

    // Getters
    public String getISBN() { return ISBN; }
    public int getUserID() { return userID; }
    public LocalDate getDateBorrowed() { return dateBorrowed; }
    public LocalDate getDateDue() { return dateDue; }

    // Setters
    public void setDateDue(LocalDate newDateDue) {
        this.dateDue = newDateDue;
    }

    // Helper method
    public boolean isOverdue() {
        return LocalDate.now().isAfter(dateDue);
    }
}
