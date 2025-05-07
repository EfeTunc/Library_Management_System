package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GuestView extends JFrame {
    private JPanel GuestPanel;
    private JPanel MainPanel;
    private JPanel reserveBookPanel;
    private JPanel searchBooksPanel;
    private JPanel ViewRecords;
    private JPanel returnBookPanel;
    private JButton addBookingButton;
    private JButton viewBookingsButton;
    private JButton cancelBookingButton;
    private JButton returnBookButton;
    private JButton viewAvailableRoomsButton;
    private JButton logOutButton;
    private JTable SearchAndFilterBooks;
    private JTable viewRecordsTable;
    private JTable viewRoomTable;
    private JTextField bookISBNField;
    private JTextField bookNameField;
    private JButton bookButton;
    private JButton backButton1;
    private JButton backButton2;
    private JButton filterButton;
    private JButton backButton4;
    private JButton searchViewButton;
    private JTable returnBookTable;
    private JButton backButton3;
    private JTextField searchISBNField;
    private JTextField searchBooknameField;
    private JButton giveRatingButton;
    private JPanel Rating;
    private JButton giveRatingButton1;
    private JTextArea commentArea;
    private JComboBox rateCombo;
    private JButton backButton5;
    private JTextField bookGenreField;
    private JButton reserveSearchButton;
    private JTextField bookAuthorField;
    private JButton myRecordsButton;
    private JScrollPane serachBookTable;


    public GuestView(){
        setContentPane(GuestPanel);
        setTitle("Guest Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        createTable();

    }

    private void createTable(){
        DefaultTableModel tableModel1 = new DefaultTableModel();
        tableModel1.addColumn("Room Number");
        tableModel1.addColumn("Room Type");
        tableModel1.addColumn("Price");
        SearchAndFilterBooks.setModel(tableModel1);
        viewRoomTable.setModel(tableModel1);
        SearchAndFilterBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        viewRoomTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        DefaultTableModel tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("Book ID");
        tableModel2.addColumn("Room Number");
        tableModel2.addColumn("Room Type");
        tableModel2.addColumn("Check In Date");
        tableModel2.addColumn("Check Out Date");
        tableModel2.addColumn("Booking Status");
        tableModel2.addColumn("Price");
        viewRecordsTable.setModel(tableModel2);
        returnBookTable.setModel(tableModel2);
        viewRecordsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        returnBookTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this,msg);
    }


    public JButton getGiveRatingButton() {
        return giveRatingButton;
    }

    public JPanel getRating() {
        return Rating;
    }

    public JButton getGiveRatingButton1() {
        return giveRatingButton1;
    }

    public JTextArea getCommentArea() {
        return commentArea;
    }

    public JComboBox getRateCombo() {
        return rateCombo;
    }

    public JButton getBackButton5() {
        return backButton5;
    }

    public JButton getCancelBookingButton2() {
        return returnBookButton;
    }

    public JTextField getViewCheckinField() {
        return searchISBNField;
    }

    public JTextField getViewCheckoutField() {
        return searchBooknameField;
    }


    public JTable getViewRoomTable() {
        return viewRoomTable;
    }

    public JTextField getAddCheckoutField() {
        return bookISBNField;
    }

    public JTextField getAddCheckinField() {
        return bookNameField;
    }

    public JButton getSearchAddButton() {
        return filterButton;
    }

    public JButton getSearchViewButton() {
        return searchViewButton;
    }

    public JTable getaddBookTable() {
        return SearchAndFilterBooks;
    }

    public JTable getBookTable() {
        return viewRecordsTable;
    }

    public JTable getviewRoomTable() {
        return viewRoomTable;
    }

    public JButton getsearchAddButton() {
        return filterButton;
    }

    public JButton getBackButton4() {
        return backButton4;
    }

    public JButton getsearchViewButton() {
        return searchViewButton;
    }


    public JTable getCancelBookTable() {
        return returnBookTable;
    }

    public JButton getBackButton3() {
        return backButton3;
    }

    public JButton getBackButton1() {
        return backButton1;
    }

    public JButton getBackButton2() {
        return backButton2;
    }

    public JPanel getGuestPanel() {
        return GuestPanel;
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public JPanel getAddBooking() {
        return reserveBookPanel;
    }

    public JPanel getViewRooms() {
        return searchBooksPanel;
    }

    public JPanel getViewBooking() {
        return ViewRecords;
    }

    public JPanel getCancelBooking() {
        return returnBookPanel;
    }

    public JButton getAddBookingButton() {
        return addBookingButton;
    }

    public JButton getViewBookingsButton() {
        return viewBookingsButton;
    }

    public JButton getCancelBookingButton() {
        return cancelBookingButton;
    }

    public JButton getViewAvailableRoomsButton() {
        return viewAvailableRoomsButton;
    }

    public JButton getLogOutButton() {
        return logOutButton;
    }


    public JTextField getaddCheckoutField() {
        return bookISBNField;
    }

    public JTextField getaddCheckinField() {
        return bookNameField;
    }

    public JButton getBookButton() {
        return bookButton;
    }




}
