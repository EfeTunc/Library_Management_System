package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GuestView extends JFrame {
    private JPanel GuestPanel;
    private JPanel myRecordButton;
    private JPanel reserveBookPanel;
    private JPanel searchBooksPanel;
    private JPanel ViewRecords;
    private JPanel returnBookPanel;
    private JButton searchBookButton;
    private JButton reserveBookButton;
    private JButton returnBookPanelButton;
    private JButton returnBookButton;
    private JButton viewAvailableRoomsButton;
    private JButton logOutButton;
    private JTable SearchAndFilterBooks;
    private JTable viewRecordsTable;
    private JTable searchBookTable;
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
    private JButton passwordSettingButton;
    private JTextField newPasswordField;
    private JButton passwordUpdateButton;
    private JPanel passwordChangePanel;
    private JComboBox reserveGenreComboBox;


    public GuestView(){
        setContentPane(GuestPanel);
        setTitle("Guest Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        createTable1();
        createTable2();
        createTable3();
        createTable4();
    }

    public void createTable1() {
        DefaultTableModel tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("ISBN");
        tableModel2.addColumn("Book Name");
        tableModel2.addColumn("Author");
        tableModel2.addColumn("Genre");
        tableModel2.addColumn("Location");
        tableModel2.addColumn("Language");
        tableModel2.addColumn("Publication Date");
        tableModel2.addColumn("Availability");

        searchBookTable.setModel(tableModel2);
        searchBookTable.setAutoCreateRowSorter(true);
    }

    public void createTable2() {
        DefaultTableModel tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("ISBN");
        tableModel2.addColumn("Book Name");
        tableModel2.addColumn("Author");
        tableModel2.addColumn("Genre");
        tableModel2.addColumn("Location");
        tableModel2.addColumn("Language");
        tableModel2.addColumn("Publication Date");
        tableModel2.addColumn("Availability");

        SearchAndFilterBooks.setModel(tableModel2);
        SearchAndFilterBooks.setAutoCreateRowSorter(true);
    }

    public void createTable3() {
        DefaultTableModel tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("Reservation ID");
        tableModel2.addColumn("Book Name");
        tableModel2.addColumn("Borrow Date");
        tableModel2.addColumn("Due Date");

        returnBookTable.setModel(tableModel2);
        returnBookTable.setAutoCreateRowSorter(true);
    }

    public void createTable4() {
        DefaultTableModel tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("Reservation ID");
        tableModel2.addColumn("Book Name");
        tableModel2.addColumn("Borrow Date");
        tableModel2.addColumn("Due Date");
        tableModel2.addColumn("Status");


        viewRecordsTable.setModel(tableModel2);
        viewRecordsTable.setAutoCreateRowSorter(true);
    }

    public void switchToPanel(JPanel panel) {
        GuestPanel.removeAll();
        GuestPanel.add(panel);
        GuestPanel.repaint();
        GuestPanel.revalidate();
    }



    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this,msg);
    }

    public JComboBox getReserveGenreComboBox() {
        return reserveGenreComboBox;
    }

    public void setReserveGenreComboBox(JComboBox reserveGenreComboBox) {
        this.reserveGenreComboBox = reserveGenreComboBox;
    }

    public JTable getSearchBookTable() {
        return searchBookTable;
    }

    public JPanel getMyRecordButton() {
        return myRecordButton;
    }

    public void setMyRecordButton(JPanel myRecordButton) {
        this.myRecordButton = myRecordButton;
    }

    public JButton getSearchBookButton() {
        return searchBookButton;
    }

    public void setSearchBookButton(JButton searchBookButton) {
        this.searchBookButton = searchBookButton;
    }

    public JButton getReserveBookButton() {
        return reserveBookButton;
    }

    public void setReserveBookButton(JButton reserveBookButton) {
        this.reserveBookButton = reserveBookButton;
    }

    public JButton getReturnBookPanelButton() {
        return returnBookPanelButton;
    }

    public void setReturnBookPanelButton(JButton returnBookPanelButton) {
        this.returnBookPanelButton = returnBookPanelButton;
    }

    public void setSearchBookTable(JTable searchBookTable) {
        this.searchBookTable = searchBookTable;
    }

    public JPanel getGuestPanel() {
        return GuestPanel;
    }

    public void setGuestPanel(JPanel guestPanel) {
        GuestPanel = guestPanel;
    }

    public JPanel getMainPanel() {
        return myRecordButton;
    }

    public void setMainPanel(JPanel mainPanel) {
        myRecordButton = mainPanel;
    }

    public JPanel getReserveBookPanel() {
        return reserveBookPanel;
    }

    public void setReserveBookPanel(JPanel reserveBookPanel) {
        this.reserveBookPanel = reserveBookPanel;
    }

    public JPanel getSearchBooksPanel() {
        return searchBooksPanel;
    }

    public void setSearchBooksPanel(JPanel searchBooksPanel) {
        this.searchBooksPanel = searchBooksPanel;
    }

    public JPanel getViewRecords() {
        return ViewRecords;
    }

    public void setViewRecords(JPanel viewRecords) {
        ViewRecords = viewRecords;
    }

    public JPanel getReturnBookPanel() {
        return returnBookPanel;
    }

    public void setReturnBookPanel(JPanel returnBookPanel) {
        this.returnBookPanel = returnBookPanel;
    }

    public JButton getAddBookingButton() {
        return searchBookButton;
    }

    public void setAddBookingButton(JButton addBookingButton) {
        this.searchBookButton = addBookingButton;
    }

    public JButton getViewBookingsButton() {
        return reserveBookButton;
    }

    public void setViewBookingsButton(JButton viewBookingsButton) {
        this.reserveBookButton = viewBookingsButton;
    }

    public JButton getCancelBookingButton() {
        return returnBookPanelButton;
    }

    public void setCancelBookingButton(JButton cancelBookingButton) {
        this.returnBookPanelButton = cancelBookingButton;
    }

    public JButton getReturnBookButton() {
        return returnBookButton;
    }

    public void setReturnBookButton(JButton returnBookButton) {
        this.returnBookButton = returnBookButton;
    }

    public JButton getViewAvailableRoomsButton() {
        return viewAvailableRoomsButton;
    }

    public void setViewAvailableRoomsButton(JButton viewAvailableRoomsButton) {
        this.viewAvailableRoomsButton = viewAvailableRoomsButton;
    }

    public JButton getLogOutButton() {
        return logOutButton;
    }

    public void setLogOutButton(JButton logOutButton) {
        this.logOutButton = logOutButton;
    }

    public JTable getSearchAndFilterBooks() {
        return SearchAndFilterBooks;
    }

    public void setSearchAndFilterBooks(JTable searchAndFilterBooks) {
        SearchAndFilterBooks = searchAndFilterBooks;
    }

    public JTable getViewRecordsTable() {
        return viewRecordsTable;
    }

    public void setViewRecordsTable(JTable viewRecordsTable) {
        this.viewRecordsTable = viewRecordsTable;
    }

    public JTable getViewRoomTable() {
        return searchBookTable;
    }

    public void setViewRoomTable(JTable viewRoomTable) {
        this.searchBookTable = viewRoomTable;
    }

    public JTextField getBookISBNField() {
        return bookISBNField;
    }

    public void setBookISBNField(JTextField bookISBNField) {
        this.bookISBNField = bookISBNField;
    }

    public JTextField getBookNameField() {
        return bookNameField;
    }

    public void setBookNameField(JTextField bookNameField) {
        this.bookNameField = bookNameField;
    }

    public JButton getBookButton() {
        return bookButton;
    }

    public void setBookButton(JButton bookButton) {
        this.bookButton = bookButton;
    }

    public JButton getBackButton1() {
        return backButton1;
    }

    public void setBackButton1(JButton backButton1) {
        this.backButton1 = backButton1;
    }

    public JButton getBackButton2() {
        return backButton2;
    }

    public void setBackButton2(JButton backButton2) {
        this.backButton2 = backButton2;
    }

    public JButton getFilterButton() {
        return filterButton;
    }

    public void setFilterButton(JButton filterButton) {
        this.filterButton = filterButton;
    }

    public JButton getBackButton4() {
        return backButton4;
    }

    public void setBackButton4(JButton backButton4) {
        this.backButton4 = backButton4;
    }

    public JButton getSearchViewButton() {
        return searchViewButton;
    }

    public void setSearchViewButton(JButton searchViewButton) {
        this.searchViewButton = searchViewButton;
    }

    public JTable getReturnBookTable() {
        return returnBookTable;
    }

    public void setReturnBookTable(JTable returnBookTable) {
        this.returnBookTable = returnBookTable;
    }

    public JButton getBackButton3() {
        return backButton3;
    }

    public void setBackButton3(JButton backButton3) {
        this.backButton3 = backButton3;
    }

    public JTextField getSearchISBNField() {
        return searchISBNField;
    }

    public void setSearchISBNField(JTextField searchISBNField) {
        this.searchISBNField = searchISBNField;
    }

    public JTextField getSearchBooknameField() {
        return searchBooknameField;
    }

    public void setSearchBooknameField(JTextField searchBooknameField) {
        this.searchBooknameField = searchBooknameField;
    }

    public JButton getGiveRatingButton() {
        return giveRatingButton;
    }

    public void setGiveRatingButton(JButton giveRatingButton) {
        this.giveRatingButton = giveRatingButton;
    }

    public JPanel getRating() {
        return Rating;
    }

    public void setRating(JPanel rating) {
        Rating = rating;
    }

    public JButton getGiveRatingButton1() {
        return giveRatingButton1;
    }

    public void setGiveRatingButton1(JButton giveRatingButton1) {
        this.giveRatingButton1 = giveRatingButton1;
    }

    public JTextArea getCommentArea() {
        return commentArea;
    }

    public void setCommentArea(JTextArea commentArea) {
        this.commentArea = commentArea;
    }

    public JComboBox getRateCombo() {
        return rateCombo;
    }

    public void setRateCombo(JComboBox rateCombo) {
        this.rateCombo = rateCombo;
    }

    public JButton getBackButton5() {
        return backButton5;
    }

    public void setBackButton5(JButton backButton5) {
        this.backButton5 = backButton5;
    }

    public JTextField getBookGenreField() {
        return bookGenreField;
    }

    public void setBookGenreField(JTextField bookGenreField) {
        this.bookGenreField = bookGenreField;
    }

    public JButton getReserveSearchButton() {
        return reserveSearchButton;
    }

    public void setReserveSearchButton(JButton reserveSearchButton) {
        this.reserveSearchButton = reserveSearchButton;
    }

    public JTextField getBookAuthorField() {
        return bookAuthorField;
    }

    public void setBookAuthorField(JTextField bookAuthorField) {
        this.bookAuthorField = bookAuthorField;
    }

    public JButton getMyRecordsButton() {
        return myRecordsButton;
    }

    public void setMyRecordsButton(JButton myRecordsButton) {
        this.myRecordsButton = myRecordsButton;
    }

    public JScrollPane getSerachBookTable() {
        return serachBookTable;
    }

    public void setSerachBookTable(JScrollPane serachBookTable) {
        this.serachBookTable = serachBookTable;
    }

    public JButton getPasswordSettingButton() {
        return passwordSettingButton;
    }

    public void setPasswordSettingButton(JButton passwordSettingButton) {
        this.passwordSettingButton = passwordSettingButton;
    }

    public JTextField getNewPasswordField() {
        return newPasswordField;
    }

    public void setNewPasswordField(JTextField newPasswordField) {
        this.newPasswordField = newPasswordField;
    }

    public JButton getPasswordUpdateButton() {
        return passwordUpdateButton;
    }

    public void setPasswordUpdateButton(JButton passwordUpdateButton) {
        this.passwordUpdateButton = passwordUpdateButton;
    }

    public JPanel getPasswordChangePanel() {
        return passwordChangePanel;
    }

    public void setPasswordChangePanel(JPanel passwordChangePanel) {
        this.passwordChangePanel = passwordChangePanel;
    }


}
