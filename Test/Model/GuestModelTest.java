package Model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class GuestModelTest {

    @Test
    public void search() {
        GuestModel guestModel = new GuestModel();
        List<Book> books = guestModel.search("1", "emirali ve efenin maceraları");

        // Test: Eğer kitaplar bulunduysa, kitap listesi boş olmamalıdır
        assertNotNull(books);
        // Test: Eğer veri varsa, listenin boyutu 1'den büyük olmalıdır (örnek)
        assertTrue(books.size() > 0);
    }

    @Test
    public void filter() {
        GuestModel guestModel = new GuestModel();
        List<Book> books = guestModel.filter("Fantasy", "efe");

        // Test: Eğer kitaplar bulunduysa, kitap listesi boş olmamalıdır
        assertNotNull(books);
        // Test: Eğer veri varsa, listenin boyutu 1'den büyük olmalıdır
        assertTrue(books.size() > 0);
    }

    @Test
    public void addReservation() {
        GuestModel guestModel = new GuestModel();
        Reservation reservation = new Reservation("9", "6161", LocalDate.of(2025,6,1), LocalDate.of(2025,6,15), "Not Returned");

        // Test: Eğer rezervasyon ekleme başarılıysa, dönen değer 1 olmalıdır
        int result = guestModel.addReservation(reservation);
        assertEquals(1, result);
    }

    @Test
    public void populateReturnTable() throws SQLException {
        // Sahte kullanıcı oluştur
        LoginModel.user = new User("123456789", "Test", "User", "hashedpassword", "guest", "active");

        GuestModel guestModel = new GuestModel();

        ResultSet rs = guestModel.populateReturnTable();
        assertNotNull(rs);
    }

}
