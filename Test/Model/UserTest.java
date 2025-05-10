package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User(
                "123456789",
                "Ali",
                "Veli",
                "hashedPassword123",
                "ali.veli@example.com",
                "Active"
        );
    }

    @Test
    public void getStatus() {
        assertEquals("Active", user.getStatus());
    }

    @Test
    public void setStatus() {
        user.setStatus("Inactive");
        assertEquals("Inactive", user.getStatus());
    }

    @Test
    public void getSSN() {
        assertEquals("123456789", user.getSSN());
    }

    @Test
    public void getUserName() {
        assertEquals("Ali", user.getUserName());
    }

    @Test
    public void getUserSurname() {
        assertEquals("Veli", user.getUserSurname());
    }

    @Test
    public void getUserPassword() {
        assertEquals("hashedPassword123", user.getUserPassword());
    }

    @Test
    public void getUserEmail() {
        assertEquals("ali.veli@example.com", user.getUserEmail());
    }

    @Test
    public void setUserPassword() {
        user.setUserPassword("newPassword456");
        assertEquals("newPassword456", user.getUserPassword());
    }
}
