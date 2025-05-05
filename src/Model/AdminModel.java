package Model;

import DatabaseConnection.JDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminModel {





        public void addBook(Book book){
                try {
                        Connection connection = JDBC.connect();

                        String query = "QUERY GELECEK";

                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        updateStmt.setString(1, book.getISBN());
                        updateStmt.setString(2, book.getBookName());
                        updateStmt.setString(3, book.getAuthor());
                        updateStmt.setString(4, book.getGenre());
                        updateStmt.setString(5, book.getLanguage());
                        updateStmt.setString(6,book.getLocation());
                        updateStmt.setString(7, book.getPublicationDate());
                        updateStmt.setString(8, "Available");

                        updateStmt.executeUpdate();

                }
                 catch (Exception e) {
                        throw new RuntimeException(e);
                }

        }


        public void removeBook(String ISBN){

                try {
                        Connection connection = JDBC.connect();

                        String query = "QUERY GELECEK";

                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        updateStmt.setString(1, ISBN);


                        updateStmt.executeUpdate();

                }
                catch (Exception e) {
                        throw new RuntimeException(e);
                }

        }
        public void updateBook(){

        }
        public int updateUser(String SSN,String status){
                try {
                        Connection connection = JDBC.connect();

                        String query = "QUERY GELECEK";

                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        updateStmt.setString(1, SSN);
                        updateStmt.setString(2,status);
                        return updateStmt.executeUpdate();

                }
                catch (Exception e) {
                        throw new RuntimeException(e);
                }


        }
        public void addUser(User user){
                try {
                        Connection connection = JDBC.connect();

                        String query = "QUERY GELECEK";

                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        updateStmt.setString(1, user.getUserSSN());
                        updateStmt.setString(2, user.getUserName());
                        updateStmt.setString(3, user.getUserSurname());
                        updateStmt.setString(4, user.getUserEmail());
                        updateStmt.setString(5, user.getUserPassword());
                        updateStmt.setString(6,"Active");

                        updateStmt.executeUpdate();

                }
                 catch (Exception e) {
                        throw new RuntimeException(e);
                }

        }
        public ResultSet viewRecords(){
                try {
                        Connection connection = JDBC.connect();

                        String query = "QUERY GELECEK";
                        PreparedStatement updateStmt = connection.prepareStatement(query);

                        return updateStmt.executeQuery();
                } catch (SQLException e) {
                        e.printStackTrace();
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
                return null;

        }
        public ResultSet viewBooks(String ISBN){
                try {
                        Connection connection = JDBC.connect();
                        String query = "QUERY GELECEK";
                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        return updateStmt.executeQuery();
                }
                 catch (Exception e) {
                        throw new RuntimeException(e);
                }



        }
        public void manageUser(String SSN, String status){
                try {
                        Connection connection = JDBC.connect();
                        String query = "QUERY GELECEK";
                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        updateStmt.executeUpdate();
                }
                catch (Exception e) {
                        throw new RuntimeException(e);
                }

        }

        public void searchUser(String ssn, JTable table){
                populateUser(table,ssn);
        }

        public void populateUser(JTable table,String SSN){
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                try {
                        ResultSet rs = users(SSN);
                        while (rs.next()){
                                String roomType = rs.getString("room_type");
                                String price = rs.getString("price");

                                tableModel.addRow(new Object[] {roomType,price});
                        }
                }catch (Exception e1) {
                        e1.printStackTrace();
                }
        }

        public ResultSet users(String ssn){
                try {
                        Connection connection = JDBC.connect();

                        String query = "QUERY GELECEK";

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

                        bookName = ISBN.isEmpty() ? "%" : "%" + bookName + "%";
                        ISBN = ISBN.isEmpty() ? "%" : "%" + ISBN + "%";

                        String query = "QUERY GELECEK";

                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        updateStmt.setString(1, ISBN);
                        updateStmt.setString(2,bookName);
                        ResultSet rs = updateStmt.executeQuery();
                        List<Book> list = new ArrayList<>();
                        while (rs.next()) {
                                Book b = new Book(
                                        rs.getString("ISBN"),
                                        rs.getString("Book Name"),
                                        rs.getString("Author"),
                                        rs.getString("Genre"),
                                        rs.getString("Publication Date"),
                                        rs.getString("Language"),
                                        rs.getBoolean("Availability"),
                                        rs.getString("Location")
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

                        String query = "QUERY GELECEK";

                        PreparedStatement updateStmt = connection.prepareStatement(query);
                        updateStmt.setString(1, ssn);
                        updateStmt.setString(2,name);
                        ResultSet rs = updateStmt.executeQuery();
                        List<User> list = new ArrayList<>();
                        while (rs.next()) {
                                User u = new User(
                                        rs.getString("SSN"),
                                        rs.getString("Name"),
                                        rs.getString("Surname"),
                                        "",
                                        rs.getString("Email"),
                                        rs.getString("Status")
                                );
                                list.add(u);
                        }
                        return list;

                } catch (Exception e) {
                        throw new RuntimeException(e);
                }

        }





}
