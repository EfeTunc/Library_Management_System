package Model;

import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class ReservationTest {

    Reservation reservation = new Reservation(
            "7", "6161",
            LocalDate.of(2025, 5, 1),
            LocalDate.of(2025, 5, 10),
            "Returned"
    );

    @Test
    public void getStatus() {
        assertEquals("Returned", reservation.getStatus());
    }

    @Test
    public void setStatus() {
        reservation.setStatus("Returned");
        assertEquals("Returned", reservation.getStatus());
    }

    @Test
    public void getISBN() {
        assertEquals("7", reservation.getISBN());
    }

    @Test
    public void setISBN() {
        reservation.setISBN("9789876543210");
        assertEquals("9789876543210", reservation.getISBN());
    }

    @Test
    public void getUserSSN() {
        assertEquals(6161, reservation.getUserSSN());
    }

    @Test
    public void setUserSSN() {
        reservation.setUserSSN(987654321);
        assertEquals(987654321, reservation.getUserSSN());
    }

    @Test
    public void setDateBorrowed() {
        LocalDate newDate = LocalDate.of(2024, 4, 1);
        reservation.setDateBorrowed(newDate);
        assertEquals(newDate, reservation.getDateBorrowed());
    }

    @Test
    public void getDateBorrowed() {
        assertEquals(LocalDate.of(2025, 5, 1), reservation.getDateBorrowed());
    }

    @Test
    public void getDateDue() {
        assertEquals(LocalDate.of(2025, 5, 10), reservation.getDateDue());
    }

    @Test
    public void setDateDue() {
        LocalDate newDueDate = LocalDate.of(2026, 6, 1);
        reservation.setDateDue(newDueDate);
        assertEquals(newDueDate, reservation.getDateDue());
    }

    @Test
    public void isOverdue() {
        // Ödünç alma tarihi geçmişte, iade tarihi geçmişteyse true olmalı
        Reservation overdueReservation = new Reservation(
                "9", "6161",
                LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(1),
                "Not Returned"
        );
        assertTrue(overdueReservation.isOverdue());

        // Gelecekteyse false
        Reservation notOverdue = new Reservation(
                "9", "6161",
                LocalDate.now(),
                LocalDate.now().plusDays(5),
                "Not Returned"
        );
        assertFalse(notOverdue.isOverdue());
    }
}
