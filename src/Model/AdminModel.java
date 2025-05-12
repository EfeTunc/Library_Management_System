package Model;

import DatabaseConnection.JDBC;
import View.AdminView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AdminModel {


        public void addBook(Book book){
                try {
                        Connection connection = JDBC.connect();

                        String query = "INSERT INTO books(ISBN, bookName, author, genre, publicationDate, language, location) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?)";

                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        updateStmt.setString(1, book.getISBN());
                        updateStmt.setString(2, book.getBookName());
                        updateStmt.setString(3, book.getAuthor());
                        updateStmt.setString(4, book.getGenre());
                        updateStmt.setString(5, book.getPublicationDate());
                        updateStmt.setString(6, book.getLanguage());
                        updateStmt.setString(7,book.getLocation());
                        updateStmt.executeUpdate();

                }
                 catch (Exception e) {
                        throw new RuntimeException(e);
                }

        }



        public boolean addUser(User user) {
                try {
                        Connection connection = JDBC.connect();

                        String checkQuery = "SELECT COUNT(*) FROM users WHERE SSN = ?";
                        PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
                        checkStmt.setString(1, user.getSSN());
                        ResultSet rs = checkStmt.executeQuery();

                        if (rs.next() && rs.getInt(1) > 0) {
                                return false;
                        }

                        String query = "INSERT INTO users(SSN, userName, userSurname, userPassword, userEmail, role, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement insertStmt = connection.prepareStatement(query);
                        insertStmt.setString(1, user.getSSN());
                        insertStmt.setString(2, user.getUserName());
                        insertStmt.setString(3, user.getUserSurname());
                        insertStmt.setString(4, LoginModel.hashPassword(user.getUserPassword()));
                        insertStmt.setString(5, user.getUserEmail());
                        insertStmt.setString(6, "guest");
                        insertStmt.setString(7, user.getStatus());

                        insertStmt.executeUpdate();
                        return true;

                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
        }


        public List<ReservationRecord> getFilteredReservations(String ssn, String isbn, boolean overdueOnly) {
                List<ReservationRecord> list = new ArrayList<>();

                String query = "SELECT r.ISBN, b.bookName, u.SSN, u.userName, r.dateBorrowed, r.status " +
                        "FROM reservations r " +
                        "JOIN books b ON r.ISBN = b.ISBN " +
                        "JOIN users u ON r.SSN = u.SSN WHERE 1=1";

                if (!ssn.isEmpty()) query += " AND u.SSN = ?";
                if (!isbn.isEmpty()) query += " AND r.ISBN = ?";

                try {
                        Connection conn = JDBC.connect();
                        PreparedStatement ps = conn.prepareStatement(query);
                        int index = 1;
                        if (!ssn.isEmpty()) ps.setString(index++, ssn);
                        if (!isbn.isEmpty()) ps.setString(index++, isbn);

                        ResultSet rs = ps.executeQuery();
                        Date today = new Date(System.currentTimeMillis());

                        while (rs.next()) {
                                String status = rs.getString("status");
                                Date borrow = rs.getDate("dateBorrowed");

                                Calendar cal = Calendar.getInstance();
                                cal.setTime(borrow);
                                cal.add(Calendar.DAY_OF_MONTH, 30);
                                Date due = new Date(cal.getTimeInMillis());

                                if (overdueOnly) {
                                        if (!(status.equals("Not Returned") && due.before(today))) continue;
                                }

                                list.add(new ReservationRecord(
                                        rs.getString("ISBN"),
                                        rs.getString("bookName"),
                                        rs.getString("SSN"),
                                        rs.getString("userName"),
                                        borrow.toString(),
                                        due.toString(),
                                        status
                                ));
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }

                return list;
        }




        public void populateUser(JTable table,String SSN){

                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);

                try {
                        ResultSet rs = users(SSN);
                        while (rs.next()){
                                String ssn = rs.getString("SSN");
                                String username = rs.getString("userName");
                                String surname = rs.getString("userSurname");
                                String mail = rs.getString("userEmail");
                                String status = rs.getString("status");
                                tableModel.addRow(new Object[] {ssn , username , surname , mail , status});
                        }
                }catch (Exception e1) {
                        e1.printStackTrace();
                }
        }

        public void populateOverdueUser(JTable table , String SSN){

                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);

                try {
                        Connection connection = JDBC.connect();

                        String query = "SELECT u.SSN, u.userName, u.userSurname, u.userEmail, u.status, r.dateBorrowed " +
                                "FROM users u " +
                                "JOIN reservations r ON u.SSN = r.SSN " +
                                "WHERE r.status = 'Not Returned'";
                        PreparedStatement stmt = connection.prepareStatement(query);
                        ResultSet rs = stmt.executeQuery();

                        java.sql.Date today = new java.sql.Date(System.currentTimeMillis());

                        while (rs.next()) {
                                java.sql.Date borrowedDate = rs.getDate("dateBorrowed");

                                java.util.Calendar cal = java.util.Calendar.getInstance();
                                cal.setTime(borrowedDate);
                                cal.add(java.util.Calendar.DAY_OF_MONTH, 30);
                                java.sql.Date dueDate = new java.sql.Date(cal.getTimeInMillis());

                                if (dueDate.before(today)) {

                                        String ssn = rs.getString("SSN");
                                        String username = rs.getString("userName");
                                        String surname = rs.getString("userSurname");
                                        String mail = rs.getString("userEmail");
                                        String status = rs.getString("status");

                                        tableModel.addRow(new Object[]{ssn, username, surname, mail, status});
                                }
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }


        }



        public boolean deleteBookByISBN(String isbn) {
                try {
                        Connection conn = JDBC.connect();

                        String checkQuery = "SELECT COUNT(*) FROM reservations WHERE ISBN = ? AND status != 'Returned'";
                        PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
                        checkStmt.setString(1, isbn);
                        ResultSet rs = checkStmt.executeQuery();

                        if (rs.next() && rs.getInt(1) > 0) {
                                JOptionPane.showMessageDialog(null,
                                        "This book is currently reserved and cannot be deleted.",
                                        "Cannot Delete Book",
                                        JOptionPane.WARNING_MESSAGE);
                                return false;
                        }

                        String deleteReservations = "DELETE FROM reservations WHERE ISBN = ?";
                        PreparedStatement deleteResStmt = conn.prepareStatement(deleteReservations);
                        deleteResStmt.setString(1, isbn);
                        deleteResStmt.executeUpdate();

                        String deleteBook = "DELETE FROM books WHERE ISBN = ?";
                        PreparedStatement deleteBookStmt = conn.prepareStatement(deleteBook);
                        deleteBookStmt.setString(1, isbn);
                        int affected = deleteBookStmt.executeUpdate();

                        return affected > 0;

                } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                }
        }



        public int changeStatus(String ssn , String status){
                try{
                        Connection connection = JDBC.connect();

                        String query = "UPDATE users SET status = ? WHERE SSN = ?;";

                        PreparedStatement preparedStatement = connection.prepareStatement(query);

                        preparedStatement.setString(1,status);
                        preparedStatement.setString(2,ssn);

                        return preparedStatement.executeUpdate();

                }catch (Exception e){
                        throw new RuntimeException(e);
                }
        }

        public ResultSet users(String ssn){
                try {
                        Connection connection = JDBC.connect();

                        String query = "SELECT * FROM users u , guests g WHERE g.guestSSN = u.SSN AND u.SSN = ?";

                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        updateStmt.setString(1, ssn);
                        ResultSet rs = updateStmt.executeQuery();
                        return rs;

                } catch (Exception e) {
                        throw new RuntimeException(e);
                }

        }

        public List<Book> allBooks(String ISBN, String bookName){
                try {
                        Connection connection = JDBC.connect();

                        bookName = bookName.isEmpty() ? "%" : "%" + bookName + "%";
                        ISBN = ISBN.isEmpty() ? "%" : "%" + ISBN + "%";

                        String query = "SELECT * FROM books WHERE ISBN LIKE ? AND bookName LIKE ?;";

                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        updateStmt.setString(1, ISBN);
                        updateStmt.setString(2,bookName);
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


        public List<User> allUsers(String ssn, String name,boolean checked){
                try {
                        Connection connection = JDBC.connect();

                        name = name.isEmpty() ? "%" : "%" + name + "%";
                        ssn = ssn.isEmpty() ? "%" : "%" + ssn + "%";

                        String query = "SELECT DISTINCT u.* " +
                                "FROM users u " +
                                "LEFT JOIN reservations r ON u.SSN = r.SSN " +
                                "WHERE CAST(u.SSN AS CHAR) LIKE ? AND u.userName LIKE ?";

                        if (checked) {
                                query += " AND r.dateDue IS NOT NULL AND r.dateDue < CURRENT_DATE()";
                        }

                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        updateStmt.setString(1, ssn);
                        updateStmt.setString(2,name);
                        ResultSet rs = updateStmt.executeQuery();
                        List<User> list = new ArrayList<>();
                        while (rs.next()) {
                                User u = new User(
                                        rs.getString("SSN"),
                                        rs.getString("userName"),
                                        rs.getString("userSurname"),
                                        "userPassword",
                                        rs.getString("userEmail"),
                                        rs.getString("status")
                                );
                                list.add(u);
                        }
                        return list;

                } catch (Exception e) {
                        throw new RuntimeException(e);
                }

        }

        public void populateUserWithFilter(JTable table, String ssn, String name, boolean overdueOnly) {
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);

                try {
                        Connection conn = JDBC.connect();
                        StringBuilder query = new StringBuilder();

                        if (overdueOnly) {
                                query.append("SELECT DISTINCT u.SSN, u.userName, u.userSurname, u.userEmail, u.status, r.dateBorrowed ")
                                        .append("FROM users u JOIN reservations r ON u.SSN = r.SSN ")
                                        .append("WHERE r.status = 'Not Returned' AND u.role = 'guest'");
                        } else {
                                query.append("SELECT * FROM users u WHERE u.role = 'guest'");
                        }

                        List<String> conditions = new ArrayList<>();
                        List<Object> params = new ArrayList<>();

                        if (!ssn.isEmpty()) {
                                conditions.add("u.SSN = ?");
                                params.add(ssn);
                        }

                        if (!name.isEmpty()) {
                                conditions.add("(LOWER(u.userName) LIKE ? OR LOWER(u.userSurname) LIKE ?)");
                                String likeName = "%" + name.toLowerCase() + "%";
                                params.add(likeName);
                                params.add(likeName);
                        }

                        if (!conditions.isEmpty()) {
                                for (String cond : conditions) {
                                        query.append(" AND ").append(cond);
                                }
                        }

                        PreparedStatement ps = conn.prepareStatement(query.toString());

                        for (int i = 0; i < params.size(); i++) {
                                ps.setObject(i + 1, params.get(i));
                        }

                        ResultSet rs = ps.executeQuery();
                        java.sql.Date today = new java.sql.Date(System.currentTimeMillis());

                        while (rs.next()) {
                                if (overdueOnly) {
                                        java.sql.Date borrowedDate = rs.getDate("dateBorrowed");
                                        Calendar cal = Calendar.getInstance();
                                        cal.setTime(borrowedDate);
                                        cal.add(Calendar.DAY_OF_MONTH, 30);
                                        java.sql.Date dueDate = new java.sql.Date(cal.getTimeInMillis());
                                        if (!dueDate.before(today)) continue; // only overdue
                                }

                                String ssnVal = rs.getString("SSN");
                                String username = rs.getString("userName");
                                String surname = rs.getString("userSurname");
                                String mail = rs.getString("userEmail");
                                String status = rs.getString("status");

                                tableModel.addRow(new Object[]{ssnVal, username, surname, mail, status});
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }








}
