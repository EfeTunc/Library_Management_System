package Model;

public class ReservationRecord {
    private String isbn, bookName, userSSN, userName, dateBorrowed, dueDate, status;

    public ReservationRecord(String isbn, String bookName, String userSSN, String userName,
                             String dateBorrowed, String dueDate, String status) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.userSSN = userSSN;
        this.userName = userName;
        this.dateBorrowed = dateBorrowed;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Getters
    public String getIsbn() { return isbn; }
    public String getBookName() { return bookName; }
    public String getUserSSN() { return userSSN; }
    public String getUserName() { return userName; }
    public String getDateBorrowed() { return dateBorrowed; }
    public String getDueDate() { return dueDate; }
    public String getStatus() { return status; }
}
