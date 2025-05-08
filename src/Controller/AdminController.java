package Controller;

import DatabaseConnection.JDBC;
import Model.AdminModel;
import Model.Book;
import Model.LoginModel;
import Model.User;
import View.AdminView;

import javax.swing.*;
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
                tableModel.getDataVector().clear();
                adminView.switchToPanel(adminView.getMainPanel());
            }
        });
        this.adminView.getBackButton4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) adminView.getViewBooksTable().getModel();
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
                String Genre = adminView.getAddGenre().getText().trim();
                String PubDate = adminView.getAddPubDate().getText().trim();
                String Location = adminView.getAddLocation().getText().trim();
                String Lang =  (String) adminView.getComboBox2().getSelectedItem();


                if (ISBN.isEmpty() || BookName.isEmpty() || Author.isEmpty() || Genre.isEmpty() || PubDate.isEmpty() || Location.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Eksik Bilgi", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Book book = new Book(ISBN,BookName,Author,Genre,PubDate,Lang,true,Location);
                adminModel.addBook(book);


            }
        });

        this.adminView.getSearchUserManageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ssn = adminView.getManageSSNField().getText().trim();
                if (ssn.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Eksik Bilgi", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                adminModel.searchUser(ssn,adminView.getUserTable());
            }
        });

        this.adminView.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.adminView.getAllBooksSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name =  adminView.getAllBooksNameField().getText().trim();
                String ISBN = adminView.getAllBooksISBNField().getText().trim();
                List<Book> bookList = adminModel.allBooks(ISBN,name);
                DefaultTableModel tableModel = (DefaultTableModel) adminView.getViewBooksTable().getModel();
                try {

                    for (Book book : bookList){
                        String isbn = book.getISBN();
                        String bookName = book.getBookName();
                        String author = book.getAuthor();
                        String genre = book.getGenre();
                        String publicationDate = book.getPublicationDate();
                        String language = book.getLanguage();
                        String availability = (book.isAvailable()) ? "Available" : "Booked";
                        String location = book.getLocation();

                        tableModel.addRow(new Object[] {isbn,bookName,author,genre,publicationDate,language,availability,location});
                    }
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.adminView.getSearchUserManageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ssn =  adminView.getAllBooksNameField().getText().trim();
                String name = adminView.getAllBooksNameField().getText().trim();
                boolean checked = adminView.getHasOutstandingOverdueItemsCheckBox().isSelected();
                List<User> userList = adminModel.allUsers(ssn,name,checked);

                try {

                    for (User user : userList){
                        String SSN = user.getUserSSN();
                        String Name = user.getUserName();
                        String Surname = user.getUserSurname();
                        String Email = user.getUserEmail();
                        DefaultTableModel tableModel = (DefaultTableModel) adminView.getViewBooksTable().getModel();
                        tableModel.addRow(new Object[] {SSN,Name,Surname,Email});
                    }
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        this.adminView.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int column = 0;
                int row = adminView.getUserTable().getSelectedRow();
                try {
                    String status = adminView.getStatusCombo().getSelectedItem().toString();
                    String SSN = adminView.getUserTable().getModel().getValueAt(row, column).toString();
                    if (adminModel.updateUser(SSN,status) == 1) {
                        adminView.getUserTable().getModel().setValueAt(status,row,column);
                        JOptionPane.showMessageDialog(null,"Successfully updated!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Please select a user!");
                }
            }
        });
    }
}
