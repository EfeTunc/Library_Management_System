package Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReservationRecordTest {

    private ReservationRecord record;

    @Before
    public void setUp() {
        record = new ReservationRecord(
                "9781234567890",
                "Clean Code",
                "123456789",
                "Ali Veli",
                "2024-05-01",
                "2024-05-15",
                "Borrowed"
        );
    }

    @Test
    public void getIsbn() {
        assertEquals("9781234567890", record.getIsbn());
    }

    @Test
    public void getBookName() {
        assertEquals("Clean Code", record.getBookName());
    }

    @Test
    public void getUserSSN() {
        assertEquals("123456789", record.getUserSSN());
    }

    @Test
    public void getUserName() {
        assertEquals("Ali Veli", record.getUserName());
    }

    @Test
    public void getDateBorrowed() {
        assertEquals("2024-05-01", record.getDateBorrowed());
    }

    @Test
    public void getDueDate() {
        assertEquals("2024-05-15", record.getDueDate());
    }

    @Test
    public void getStatus() {
        assertEquals("Borrowed", record.getStatus());
    }
}
