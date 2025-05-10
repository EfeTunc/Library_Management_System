package DatabaseConnection;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class JDBCTest {

    @Test
    public void connect() {
        try {
            Connection conn = JDBC.connect();
            assertNotNull("Connection should not be null", conn);
            assertFalse("Connection should not be closed", conn.isClosed());
            conn.close();
        } catch (Exception e) {
            fail("Exception during connection: " + e.getMessage());
        }
    }
}