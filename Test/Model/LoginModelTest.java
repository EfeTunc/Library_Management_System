package Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginModelTest {

    @Test
    public void hashPassword() {
        String password = "test123";
        String expectedHash = LoginModel.hashPassword(password);

        // Aynı girdiye aynı çıktıyı vermeli
        assertEquals(expectedHash, LoginModel.hashPassword(password));

        // Farklı girdiye farklı çıktıyı vermeli
        assertNotEquals(expectedHash, LoginModel.hashPassword("differentPassword"));

        // Hash uzunluğu SHA-256 için 64 karakter olmalı
        assertEquals(64, expectedHash.length());
    }

    @Test
    public void auth() {
        LoginModel loginModel = new LoginModel();

        // Bu kullanıcı test veritabanında mevcut olmalı
        String ssn = "1001";
        String password = "1"; // Şifrenin SHA-256 hash'i veritabanında kayıtlı olmalı

        String role = loginModel.auth(ssn, password);

        // Kullanıcı varsa rol null olmamalı ve LoginModel.user dolmuş olmalı
        assertNotNull(role);
        assertNotNull(LoginModel.user);
        assertEquals(ssn, LoginModel.user.getSSN());
    }
}