package Model;
import java.time.LocalDate;
public class Reservation {
    private String ISBN;
    private int userSSN;
    private LocalDate dateBorrowed;
    private LocalDate dateDue;

    private String status;

    public Reservation(String ISBN, String userSSN, LocalDate dateBorrowed, LocalDate dateDue, String status) {
        this.ISBN = ISBN;
        this.userSSN = Integer.parseInt(userSSN);
        this.dateBorrowed = dateBorrowed;
        this.dateDue = dateDue;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters
    public String getISBN() { return ISBN; }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getUserSSN() {
        return userSSN;
    }

    public void setUserSSN(int userSSN) {
        this.userSSN = userSSN;
    }

    public void setDateBorrowed(LocalDate dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

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
