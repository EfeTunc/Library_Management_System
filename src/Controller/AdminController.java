package Controller;

import DatabaseConnection.JDBC;
import Model.*;
import View.AdminView;
import View.LoginView;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminController {

    AdminView adminView;
    AdminModel adminModel;


    public AdminController( AdminView adminView,AdminModel adminModel){
        this.adminView = adminView;
        this.adminModel = adminModel;

        this.adminView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) adminView.getRecordsTable().getModel();
                tableModel.setRowCount(0);
                tableModel.getDataVector().clear();
                adminView.switchToPanel(adminView.getMainPanel());
            }
        });

        this.adminView.getBackButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                adminView.switchToPanel(adminView.getMainPanel());
            }
        });
        this.adminView.getBackButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) adminView.getUserTable().getModel();
                tableModel.setRowCount(0);
                tableModel.fireTableDataChanged();
                adminView.switchToPanel(adminView.getMainPanel());
            }
        });

        this.adminView.getBackButton4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) adminView.getViewBooksTable().getModel();
                tableModel.setRowCount(0);
                tableModel.getDataVector().clear();
                adminView.switchToPanel(adminView.getMainPanel());
            }
        });
        this.adminView.getBackButton5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                adminView.switchToPanel(adminView.getMainPanel());
            }
        });


        this.adminView.getAddUserButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.switchToPanel(adminView.getAddUserPanel());
            }
        });

        this.adminView.getAddUserButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SSN = adminView.getAddUserSSN().getText().trim();
                String userName = adminView.getAddUserName().getText().trim();
                String userSurname = adminView.getAddUserSurname().getText().trim();
                String mail = adminView.getAddUserMail().getText().trim();

                if (SSN.isEmpty() || userName.isEmpty() || userSurname.isEmpty() || mail.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the blanks!", "Misinformation", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!SSN.matches("\\d{4,}")) {
                    JOptionPane.showMessageDialog(null, "SSN must be numeric and at least 4 digits.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!userName.matches("[a-zA-Z]+") || !userSurname.matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "Name and surname must contain only letters.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!mail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                    JOptionPane.showMessageDialog(null, "Invalid email address.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                StringBuilder password = new StringBuilder(SSN);
                password.append(userName);
                String pass = password.toString();

                User user = new User(SSN, userName, userSurname, pass, mail, "active");
                adminModel.addUser(user);
                JOptionPane.showMessageDialog(null, "User has been created!", "Successful", JOptionPane.INFORMATION_MESSAGE);

                adminView.getAddUserSSN().setText("");
                adminView.getAddUserName().setText("");
                adminView.getAddUserSurname().setText("");
                adminView.getAddUserMail().setText("");
            }
        });



        this.adminView.getRemoveUserButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                adminView.switchToPanel(adminView.getViewAndManageUserPanel());
            }
        });

        this.adminView.getViewRecordButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.switchToPanel(adminView.getViewAllRecords());
            }
        });

        this.adminView.getUpdateBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.switchToPanel(adminView.getViewAndManageBooksPanel());

            }
        });

        this.adminView.getAddBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminView.switchToPanel(adminView.getAddBookPanel());
            }
        });


        this.adminView.getCreatBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ISBN = adminView.getAddISBN().getText().trim();
                String BookName = adminView.getAddBookName().getText().trim();
                String Author = adminView.getAddAuthor().getText().trim();
                String Genre = (String) adminView.getComboBox1().getSelectedItem();
                String PubDate = adminView.getAddPubDate().getText().trim();
                String Location = adminView.getAddLocation().getText().trim();
                String Lang =  (String) adminView.getComboBox2().getSelectedItem();

                if (ISBN.isEmpty() || BookName.isEmpty() || Author.isEmpty() || Genre.isEmpty() || PubDate.isEmpty() || Location.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the blanks!", "Misinformation", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!ISBN.matches("\\d{4,13}")) {
                    JOptionPane.showMessageDialog(null, "Invalid ISBN. Only 4–13 digits allowed.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!PubDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    JOptionPane.showMessageDialog(null, "Invalid date format. Use yyyy-mm-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Book book = new Book(ISBN, BookName, Author, Genre, PubDate, Lang, true, Location);
                adminModel.addBook(book);
                JOptionPane.showMessageDialog(null, "Book has been created!", "Successful", JOptionPane.INFORMATION_MESSAGE);

                adminView.getAddISBN().setText("");
                adminView.getAddBookName().setText("");
                adminView.getAddAuthor().setText("");
                adminView.getAddPubDate().setText("");
                adminView.getAddLocation().setText("");
            }
        });


        this.adminView.getHasOutstandingOverdueItemsCheckBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ssn = adminView.getManageSSNField().getText().trim();
                if(adminView.getHasOutstandingOverdueItemsCheckBox().isSelected()){
                    adminModel.populateOverdueUser(adminView.getUserTable() , ssn);
                }else{
                    adminModel.populateUser(adminView.getUserTable() , ssn );
                }
            }
        });

        this.adminView.getSearchUserManageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) adminView.getUserTable().getModel();
                tableModel.setRowCount(0);

                String ssn = adminView.getManageSSNField().getText().trim();
                boolean onlyOverdue = adminView.getHasOutstandingOverdueItemsCheckBox().isSelected();

                adminModel.populateUserWithFilter(adminView.getUserTable(), ssn, onlyOverdue);
                adminView.getManageSSNField().setText("");
            }
        });


        this.adminView.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = adminView.getUserTable().getSelectedRow();

                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a user!");
                    return;
                }

                try {
                    DefaultTableModel tableModel = (DefaultTableModel) adminView.getUserTable().getModel();

                    if (tableModel.getRowCount() == 0 || row >= tableModel.getRowCount()) {
                        JOptionPane.showMessageDialog(null, "Table is empty or row index out of bounds.");
                        return;
                    }

                    String ssn = tableModel.getValueAt(row, 0).toString();
                    String status = adminView.getStatusCombo().getSelectedItem().toString();

                    int result = adminModel.changeStatus(ssn, status);

                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, "Status updated successfully!");
                        adminModel.populateUser(adminView.getUserTable(), ssn);
                    } else {
                        JOptionPane.showMessageDialog(null, "Update failed.");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Unexpected error occurred.");
                }
            }
        });



        this.adminView.getAllBooksSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name =  adminView.getAllBooksNameField().getText().trim();
                String ISBN = adminView.getAllBooksISBNField().getText().trim();
                List<Book> bookList = adminModel.allBooks(ISBN,name);
                DefaultTableModel tableModel = (DefaultTableModel) adminView.getViewBooksTable().getModel();

                tableModel.setRowCount(0);
                if (bookList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No books found.");
                    return;
                }
                try {
                    for (Book book : bookList){
                        String isbn = book.getISBN();
                        String bookName = book.getBookName();
                        String author = book.getAuthor();
                        String genre = book.getGenre();
                        String publicationDate = book.getPublicationDate();
                        String language = book.getLanguage();
                        String availability = (book.isAvailable()) ? "True" : "False";
                        String location = book.getLocation();

                        tableModel.addRow(new Object[] {isbn,bookName,author,genre,location,language,publicationDate,availability});
                    }
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.adminView.getSearchUserManageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ssn =  adminView.getManageSSNField().getText().trim();
                String name = adminView.getViewandmanageuserField().getText().trim();
                boolean checked = adminView.getHasOutstandingOverdueItemsCheckBox().isSelected();
                List<User> userList = adminModel.allUsers(ssn,name,checked);
                try {
                    for (User user : userList){
                        String SSN = user.getUserSSN();
                        String Name = user.getUserName();
                        String Surname = user.getUserSurname();
                        String Email = user.getUserEmail();
                        DefaultTableModel tableModel = (DefaultTableModel) adminView.getUserTable().getModel();
                        tableModel.addRow(new Object[] {SSN,Name,Surname,Email});
                    }
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


        this.adminView.getRecordFilterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ssn = adminView.getRecordsSSNField().getText().trim();
                String isbn = adminView.getRecordsISBNField().getText().trim();
                boolean overdue = adminView.getAllRecordsOverDueBox().isSelected();

                List<ReservationRecord> reservations = adminModel.getFilteredReservations(ssn, isbn, overdue);
                DefaultTableModel model = (DefaultTableModel) adminView.getRecordsTable().getModel();
                model.setRowCount(0);

                for (ReservationRecord r : reservations) {
                    model.addRow(new Object[]{
                            r.getIsbn(),
                            r.getBookName(),
                            r.getUserSSN(),
                            r.getUserName(),
                            r.getDateBorrowed(),
                            r.getDueDate(),
                            r.getStatus()
                    });
                }
            }
        });

        this.adminView.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = adminView.getViewBooksTable();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int selectedRow = table.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a book to delete.");
                    return;
                }

                String isbn = model.getValueAt(selectedRow, 0).toString();

                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete book with ISBN: " + isbn + "?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    boolean success = adminModel.deleteBookByISBN(isbn);

                    if (success) {
                        model.removeRow(selectedRow);  // remove from GUI
                        JOptionPane.showMessageDialog(null, "Book deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete the book.");
                    }
                }
            }
        });






    }







}
