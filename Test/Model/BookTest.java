package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void getISBN() {
        // Test verisini oluşturuyoruz
        Book book = new Book("1234567890", "Test Book", "Test Author", "Fiction", "2025-01-01", "English", true, "Shelf A");

        // ISBN değerinin doğru olup olmadığını kontrol ediyoruz
        assertEquals("1234567890", book.getISBN());
    }

    @Test
    public void getBookName() {
        // Test verisini oluşturuyoruz
        Book book = new Book("1234567890", "Test Book", "Test Author", "Fiction", "2025-01-01", "English", true, "Shelf A");

        // Kitap adının doğru olup olmadığını kontrol ediyoruz
        assertEquals("Test Book", book.getBookName());
    }

    @Test
    public void getAuthor() {
        // Test verisini oluşturuyoruz
        Book book = new Book("1234567890", "Test Book", "Test Author", "Fiction", "2025-01-01", "English", true, "Shelf A");

        // Yazarın doğru olup olmadığını kontrol ediyoruz
        assertEquals("Test Author", book.getAuthor());
    }

    @Test
    public void getGenre() {
        // Test verisini oluşturuyoruz
        Book book = new Book("1234567890", "Test Book", "Test Author", "Fiction", "2025-01-01", "English", true, "Shelf A");

        // Türün doğru olup olmadığını kontrol ediyoruz
        assertEquals("Fiction", book.getGenre());
    }

    @Test
    public void getPublicationDate() {
        // Test verisini oluşturuyoruz
        Book book = new Book("1234567890", "Test Book", "Test Author", "Fiction", "2025-01-01", "English", true, "Shelf A");

        // Yayın tarihinin doğru olup olmadığını kontrol ediyoruz
        assertEquals("2025-01-01", book.getPublicationDate());
    }

    @Test
    public void getLanguage() {
        // Test verisini oluşturuyoruz
        Book book = new Book("1234567890", "Test Book", "Test Author", "Fiction", "2025-01-01", "English", true, "Shelf A");

        // Dilin doğru olup olmadığını kontrol ediyoruz
        assertEquals("English", book.getLanguage());
    }

    @Test
    public void isAvailable() {
        // Test verisini oluşturuyoruz
        Book book = new Book("1234567890", "Test Book", "Test Author", "Fiction", "2025-01-01", "English", true, "Shelf A");

        // Kitabın mevcut olup olmadığını kontrol ediyoruz
        assertTrue(book.isAvailable());
    }

    @Test
    public void getLocation() {
        // Test verisini oluşturuyoruz
        Book book = new Book("1234567890", "Test Book", "Test Author", "Fiction", "2025-01-01", "English", true, "Shelf A");

        // Kitabın bulunduğu konumun doğru olup olmadığını kontrol ediyoruz
        assertEquals("Shelf A", book.getLocation());
    }

    @Test
    public void setAvailability() {
        // Test verisini oluşturuyoruz
        Book book = new Book("1234567890", "Test Book", "Test Author", "Fiction", "2025-01-01", "English", true, "Shelf A");

        // Başlangıçta availability true olmalı
        assertTrue(book.isAvailable());

        // Availability'yi false olarak set ediyoruz
        book.setAvailability(false);

        // Availability'nin false olduğunu kontrol ediyoruz
        assertFalse(book.isAvailable());
    }
}
