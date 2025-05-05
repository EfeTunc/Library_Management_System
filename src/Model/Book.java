package Model;
public class Book {
    private String ISBN;
    private String bookName;
    private String author;
    private String genre;
    private String publicationDate;
    private String language;
    private boolean availability;
    private String location;

    public Book(String ISBN, String bookName, String author, String genre,
                String publicationDate, String language, boolean availability, String location) {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.language = language;
        this.availability = availability;
        this.location = location;
    }

    // Getters & setters
    public String getISBN() { return ISBN; }
    public String getBookName() { return bookName; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getPublicationDate() { return publicationDate; }
    public String getLanguage() { return language; }
    public boolean isAvailable() { return availability; }
    public String getLocation() { return location; }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
