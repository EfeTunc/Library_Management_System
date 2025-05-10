package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestController {
    private GuestModel guestModel;
    private GuestView guestView;

    public GuestController(GuestView guestView,GuestModel guestModel ) {
        this.guestModel = guestModel;
        this.guestView = guestView;



        this.guestView.getBackButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) guestView.getSearchAndFilterBooks().getModel();
                tableModel.setRowCount(0);;
                guestView.switchToPanel(guestView.getMainPanel());
            }
        });
        this.guestView.getBackButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) guestView.getViewRecordsTable().getModel();
                tableModel.setRowCount(0);;
                guestView.switchToPanel(guestView.getMainPanel());
            }
        });
        this.guestView.getBackButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) guestView.getReturnBookTable().getModel();
                tableModel.setRowCount(0);;
                guestView.switchToPanel(guestView.getMainPanel());
            }
        });
        this.guestView.getBackButton4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = (DefaultTableModel) guestView.getSearchBookTable().getModel();
                tableModel.setRowCount(0);;
                guestView.getSearchISBNField().setText("");
                guestView.getSearchBooknameField().setText("");
                guestView.switchToPanel(guestView.getMainPanel());

            }
        });
        this.guestView.getBackButton5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                guestView.switchToPanel(guestView.getMainPanel());
            }
        });

        this.guestView.getSearchBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guestView.switchToPanel(guestView.getSearchBooksPanel());
            }
        });

        this.guestView.getReturnBookPanelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guestView.switchToPanel(guestView.getReturnBookPanel());

                DefaultTableModel tableModel = (DefaultTableModel) guestView.getReturnBookTable().getModel();
                try {
                    ResultSet rs = guestModel.populateReturnTable();
                    while (rs.next()){
                        tableModel.addRow(new Object[]{rs.getInt("rid"),rs.getString("bookName"),rs.getString("dateBorrowed"),rs.getString("dateDue")});
                    }
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }});

        this.guestView.getReserveBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guestView.switchToPanel(guestView.getReserveBookPanel());
            }
        });

        this.guestView.getMyRecordsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guestView.switchToPanel(guestView.getViewRecords());
                DefaultTableModel tableModel = (DefaultTableModel) guestView.getViewRecordsTable().getModel();
                try {
                    ResultSet rs = guestModel.populateRecordsTable();
                    while (rs.next()){
                        tableModel.addRow(new Object[]{rs.getInt("rid"),rs.getString("bookName"),rs.getString("dateBorrowed"),rs.getString("dateDue"),rs.getString("status")});
                    }
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        this.guestView.getPasswordSettingButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guestView.switchToPanel(guestView.getPasswordChangePanel());
            }
        });

        this.guestView.getLogOutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginView loginView = new LoginView();
                LoginModel loginModel = new LoginModel();
                new LoginController(loginModel,loginView);
                guestView.dispose();
                loginView.setVisible(true);
            }
        });

        this.guestView.getSearchViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel1 = (DefaultTableModel) guestView.getSearchBookTable().getModel();
                tableModel1.setRowCount(0);
                String ISBN = guestView.getSearchISBNField().getText().trim();
                String BookName = guestView.getSearchBooknameField().getText().trim();

                if (ISBN.isEmpty()  && BookName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Eksik Bilgi", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                List<Book> bookList = guestModel.search(ISBN,BookName);
                DefaultTableModel tableModel = (DefaultTableModel) guestView.getSearchBookTable().getModel();
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

                        tableModel.addRow(new Object[] {isbn,bookName,author,genre,location,language,publicationDate,availability});
                    }

                    guestView.getSearchBooknameField().setText("");
                    guestView.getSearchISBNField().setText("");

                }catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });

        guestView.getReserveSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel1 = (DefaultTableModel) guestView.getSearchAndFilterBooks().getModel();
                tableModel1.setRowCount(0);
                String ISBN = guestView.getBookISBNField().getText().trim();
                String BookName = guestView.getBookNameField().getText().trim();

                if (ISBN.isEmpty()  && BookName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!", "Eksik Bilgi", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                List<Book> bookList = guestModel.search(ISBN,BookName);
                DefaultTableModel tableModel = (DefaultTableModel) guestView.getSearchAndFilterBooks().getModel();
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

                        tableModel.addRow(new Object[] {isbn,bookName,author,genre,location,language,publicationDate,availability});
                    }

                    guestView.getBookNameField().setText("");
                    guestView.getBookISBNField().setText("");
                    guestView.getBookAuthorField().setText("");
                }catch (Exception e1) {
                    e1.printStackTrace();
                }



            }
        });
        guestView.getFilterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel1 = (DefaultTableModel) guestView.getSearchAndFilterBooks().getModel();
                tableModel1.setRowCount(0);
                String Genre = guestView.getReserveGenreComboBox().getSelectedItem().toString();
                String Author = guestView.getBookAuthorField().getText().trim();

                List<Book> bookList = guestModel.filter(Genre,Author);
                DefaultTableModel tableModel = (DefaultTableModel) guestView.getSearchAndFilterBooks().getModel();
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

                        tableModel.addRow(new Object[] {isbn,bookName,author,genre,location,language,publicationDate,availability});
                    }
                    guestView.getBookNameField().setText("");
                    guestView.getBookISBNField().setText("");
                    guestView.getBookAuthorField().setText("");
                }catch (Exception e1) {
                    e1.printStackTrace();
                }


            }
        });

        guestView.getBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int column = 0;
                int row = guestView.getSearchAndFilterBooks().getSelectedRow();
                try {
                    String ISBN = guestView.getSearchAndFilterBooks().getModel().getValueAt(row,column).toString();
                    String  SSN = LoginModel.user.getSSN();
                    Reservation reservation = new Reservation(ISBN,SSN,LocalDate.now(),LocalDate.now().plusDays(30),"Not Returned");
                    int returned = guestModel.addReservation(reservation);
                    if (returned == 1) {
                        JOptionPane.showMessageDialog(null,"Successful");
                        guestView.getSearchAndFilterBooks().getModel().setValueAt("Not Available",row,7);
                    }else if (returned == -3) {
                        JOptionPane.showMessageDialog(null,"This account is not active.");
                    }else if (returned == -1) {
                        JOptionPane.showMessageDialog(null,"Already booked!");
                    }else if (returned == -2) {
                        JOptionPane.showMessageDialog(null,"Up to 4 books can be reserved.");
                    }
                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null,"Please select a book!");
                }
            }
        });

        guestView.getReturnBookButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int column = 0;
                int row = guestView.getReturnBookTable().getSelectedRow();
                try {

                    String ID = guestView.getReturnBookTable().getModel().getValueAt(row,column).toString();
                    column++;
                    String ISBN = guestView.getReturnBookTable().getModel().getValueAt(row,column).toString();

                    if (guestModel.returnBook(ID,ISBN) == 1) {
                        JOptionPane.showMessageDialog(null,"Successful!");
                        DefaultTableModel tableModel = (DefaultTableModel) guestView.getReturnBookTable().getModel();
                        tableModel.setRowCount(0);
                        ResultSet rs = guestModel.populateReturnTable();
                        while (rs.next()){
                            tableModel.addRow(new Object[]{rs.getInt("rid"),rs.getString("bookName"),rs.getString("dateBorrowed"),rs.getString("dateDue")});
                        }

                    }
                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null,"Please select a book!");
                }

            }
        });


        guestView.getPasswordUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String new_pass = guestView.getNewPasswordField().getText().trim();
                    if (new_pass.length() < 6) {
                        JOptionPane.showMessageDialog(null, "Password cannot be shorter than 6 characters!");
                        return;
                    }

                    String hashed_pass = LoginModel.hashPassword(new_pass);

                    if (guestModel.updatePassword(hashed_pass) == 1){
                        JOptionPane.showMessageDialog(null,"Successful!");
                        LoginView loginView = new LoginView();
                        LoginModel loginModel = new LoginModel();
                        new LoginController(loginModel,loginView);
                        guestView.dispose();
                        loginView.setVisible(true);

                    }
                } catch (Exception ex) {


                }
            }
        });
    }
}