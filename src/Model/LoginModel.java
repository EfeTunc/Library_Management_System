package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DatabaseConnection.JDBC;
public class LoginModel {

    public static User user;
    public String auth(String ssn,String password){
        try {
            String hashed_pass = hashPassword(password);
            Connection connection = JDBC.connect();
            String query = "SELECT * FROM users U WHERE U.SSN = ? AND U.userPassword = ? ";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,ssn);
            stmt.setString(2,hashed_pass);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getBoolean(1)){
                int SSN = rs.getInt("SSN");
                String userName = rs.getString("userName");
                String userSurname = rs.getString("userSurname");
                String userPassword = rs.getString("userPassword");
                String role = rs.getString("role");
                String status = rs.getString("status");
                user = new User(SSN , userName , userSurname , userPassword , role , status);
                return role;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash algoritması bulunamadı", e);
        }
    }

}