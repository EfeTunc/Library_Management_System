package Model;

import DatabaseConnection.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class GuestModel {

    public List<Book> search(String ISBN, String bookName){
        try {
            Connection connection = JDBC.connect();

            bookName = bookName.isEmpty() ? "%" : "%" + bookName + "%";
            ISBN = ISBN.isEmpty() ? "%" : "%" + ISBN + "%";

            String query = "SELECT * FROM books WHERE bookName LIKE ? AND ISBN LIKE  ?";

            PreparedStatement updateStmt = connection.prepareStatement(query);
            updateStmt.setString(1, bookName);
            updateStmt.setString(2,ISBN);
            ResultSet rs = updateStmt.executeQuery();
            List<Book> list = new ArrayList<>();
            while (rs.next()) {
                Book b = new Book(
                        rs.getString("ISBN"),
                        rs.getString("bookName"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getString("publicationDate"),
                        rs.getString("language"),
                        rs.getBoolean("availability"),
                        rs.getString("location")
                );
                list.add(b);
            }
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> filter(String Genre, String Author){
        try {
            Connection connection = JDBC.connect();

            Genre = Genre.isEmpty() ? "%" : "%" + Genre + "%";
            Author = Author.isEmpty() ? "%" : "%" + Author + "%";

            String query = "SELECT * FROM books WHERE genre LIKE ? AND author LIKE ?";

            PreparedStatement updateStmt = connection.prepareStatement(query);
            updateStmt.setString(1, Genre);
            updateStmt.setString(2,Author);
            ResultSet rs = updateStmt.executeQuery();
            List<Book> list = new ArrayList<>();
            while (rs.next()) {
                Book b = new Book(
                        rs.getString("ISBN"),
                        rs.getString("bookName"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getString("publicationDate"),
                        rs.getString("language"),
                        rs.getBoolean("availability"),
                        rs.getString("location")
                );
                list.add(b);
            }
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int addReservation(Reservation reservation){
        try {
            Connection connection = JDBC.connect();

            String query = "INSERT INTO reservations (ISBN, SSN, dateBorrowed, dateDue,status) VALUES (?, ?, ?, ?,?)";

            java.sql.Date sqlBorrow = java.sql.Date.valueOf(reservation.getDateBorrowed());
            java.sql.Date sqlDue = java.sql.Date.valueOf(reservation.getDateDue());

            PreparedStatement updateStmt = connection.prepareStatement(query);
            updateStmt.setString(1, reservation.getISBN());
            updateStmt.setInt(2,reservation.getUserSSN());
            updateStmt.setDate(3,sqlBorrow);
            updateStmt.setDate(4, sqlDue);
            updateStmt.setString(5,reservation.getStatus());

            int rs = updateStmt.executeUpdate();

            return rs;

        } catch (Exception e) {
            return -1;

        }

    }

    public int returnBook(String ID,String ISBN){
        try {
            Connection connection = JDBC.connect();

            String query = "UPDATE reservations " +
                    "SET status = ? " +
                    "WHERE rid = ?";

            PreparedStatement updateStmt = connection.prepareStatement(query);
            updateStmt.setString(1,"Returned");
            updateStmt.setString(2, ID);


            int rs = updateStmt.executeUpdate();

            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    public ResultSet populateReturnTable(){
        try {
            Connection connection = JDBC.connect();

            String query = "SELECT * FROM users U, books B, reservations R WHERE U.SSN = ? AND U.SSN = R.SSN AND B.ISBN = R.ISBN AND R.status = ? ;";


            PreparedStatement updateStmt = connection.prepareStatement(query);
            updateStmt.setString(1, LoginModel.user.getSSN());
            updateStmt.setString(2,"Not Returned");

            ResultSet rs = updateStmt.executeQuery();


            return rs;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    public ResultSet populateRecordsTable(){

        try {
            Connection connection = JDBC.connect();

            String query = "SELECT R.rid, R.status, R.dateBorrowed, R.dateDue, B.bookName FROM users U, books B, reservations R WHERE U.SSN = ? AND U.SSN = R.SSN AND B.ISBN = R.ISBN ;";


            PreparedStatement updateStmt = connection.prepareStatement(query);
            updateStmt.setString(1, LoginModel.user.getSSN());


            ResultSet rs = updateStmt.executeQuery();


            return rs;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public int updatePassword(String pass){
        try {
            Connection connection = JDBC.connect();

            String query = "UPDATE users " +
                    "SET userPassword = ? " +
                    "WHERE SSN = ?";

            PreparedStatement updateStmt = connection.prepareStatement(query);
            updateStmt.setString(1,pass);
            updateStmt.setString(2, LoginModel.user.getSSN());


            int rs = updateStmt.executeUpdate();

            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }



}
