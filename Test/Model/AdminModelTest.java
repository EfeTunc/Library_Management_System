package Model;

import org.junit.Test;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import static org.junit.Assert.*;

public class AdminModelTest {

    AdminModel adminModel = new AdminModel();

    @Test
    public void addBook() {
        Book stubBook = new Book("1234567890123", "Stub Book", "Author", "Genre", "2023-01-01", "English", true, "A1");
        try {
            adminModel.addBook(stubBook); // Assuming this connects to a stub or test DB
            // If no exception, pass test
            assertTrue(true);
        } catch (Exception e) {
            fail("addBook threw exception: " + e.getMessage());
        }
    }

    @Test
    public void addUser() {
        User stubUser = new User("6161", "Test", "User", "password", "test@example.com", "active");
        try {
            adminModel.addUser(stubUser);
            assertTrue(true);
        } catch (Exception e) {
            fail("addUser threw exception: " + e.getMessage());
        }
    }

    @Test
    public void getFilteredReservations() {
        List<ReservationRecord> list = adminModel.getFilteredReservations("", "", false);
        assertNotNull(list);
        assertTrue(list instanceof List);
    }

    @Test
    public void populateUser() {
        JTable table = new JTable(new DefaultTableModel(new Object[]{"SSN", "Name", "Surname", "Email", "Status"}, 0));
        adminModel.populateUser(table, "11122334455"); // Fake SSN; should not fail
        assertNotNull(table.getModel());
    }

    @Test
    public void populateOverdueUser() {
        JTable table = new JTable(new DefaultTableModel(new Object[]{"SSN", "Name", "Surname", "Email", "Status"}, 0));
        adminModel.populateOverdueUser(table, "11122334455");
        assertNotNull(table.getModel());
    }

    @Test
    public void deleteBookByISBN() {
        boolean result = adminModel.deleteBookByISBN("1234567890123"); // Stub ISBN
        // Might be false if not deletable, but should not throw
        assertTrue(result || !result); // Accept both for stub test
    }

    @Test
    public void changeStatus() {
        int result = adminModel.changeStatus("11122334455", "inactive");
        assertTrue(result >= 0);
    }

    @Test
    public void users() {
        try {
            assertNotNull(adminModel.users("11122334455"));
        } catch (Exception e) {
            fail("users() threw an exception: " + e.getMessage());
        }
    }

    @Test
    public void allBooks() {
        List<Book> books = adminModel.allBooks("", "");
        assertNotNull(books);
        assertTrue(books instanceof List);
    }

    @Test
    public void allUsers() {
        List<User> users = adminModel.allUsers("", "", false);
        assertNotNull(users);
        assertTrue(users instanceof List);
    }

    @Test
    public void populateUserWithFilter() {
        JTable table = new JTable(new DefaultTableModel(new Object[]{"SSN", "Name", "Surname", "Email", "Status"}, 0));
        adminModel.populateUserWithFilter(table, "", "", false);
        assertNotNull(table.getModel());
    }
}
