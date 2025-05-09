package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminView extends JFrame {
    private JPanel AdminPanel;

    private JPanel MainPanel;
    private JPanel addBookPanel;

    private JPanel ViewAndManageUserPanel;
    private JPanel deleteUserPanel;
    private JPanel ViewAndManageBooksPanel;
    private JPanel ViewAllRecords;

    private JButton addBookButton;
    private JButton viewRecordButton;
    private JButton addUserButton;
    private JButton removeBookButton;
    private JButton updateBookButton;
    private JButton viewUserButton;



    public JButton getDeleteBookSearch() {
        return deleteBookSearch;
    }

    public void setDeleteBookSearch(JButton deleteBookSearch) {
        this.deleteBookSearch = deleteBookSearch;
    }

    public JButton getSearchUser() {
        return searchUserManageButton;
    }

    public void setSearchUser(JButton searchUser) {
        this.searchUserManageButton = searchUser;
    }

    private JButton removeUserButton;
    private JButton exitButton;
    private JButton backButton5;
    private JTextField addISBN;
    private JTextField addBookName;
    private JTextField addAuthor;
    private JTextField addGenre;
    private JTextField addPubDate;
    private JTextField textField7;
    private JButton creatBookButton;
    private JTextField textField9;
    private JTextField textField10;

    private JButton searchBookManageButton;

    private JButton returnToAdminMenuButton;
    private JTextField textField11;
    private JTextArea viewUserArea;
    private JButton deleteItButton;
    private JButton backButton6;
    private JTextField deleteField;
    private JButton ReturnToAdminMenuButtonView;
    private JButton returnToMainMenuButtonViewEmployee;
    private JTextArea allbookingsArea;
    private JButton backButton4;

    private JButton BackButton;
    private JButton updateButton;
    private JButton backButton3;
    private JButton returnToMainMenuButtonRevenue;
    private JTextArea mostBookedArea;
    private JButton returnToMainMenuButtonmostBooked;
    private JComboBox comboBox1;
    private JTable viewAllUsers;
    private JTable employeesTable;
    private JTable RecordsTable;
    private JTable viewBooksTable;
    private JTable mostBookedTable;
    private JTable deleteTable;
    private JTable UserTable;
    private JPanel allRatings;
    private JTable ratingsTable;
    private JButton returnToMainMenuButton;
    private JButton allRatingsButton;
    private JComboBox statusCombo;
    private JTextField totalRevenueField;
    private JButton viewAndModifyPricingButton;
    private JTable pricingTable;
    private JTextField priceField;
    private JButton assignNewPriceButton;
    private JButton backButton;
    private JPanel pricingPanel;
    private JComboBox addUserCombo;
    private JTextField deleteUserField;
    private JButton deleteBookSearch;
    private JButton viewBooksButton;
    private JTextField addLocation;
    private JComboBox comboBox2;
    private JPanel addUserPanel;
    private JTextField addUserSSN;
    private JTextField addUserName;
    private JTextField addUserSurname;
    private JTextField addUserMail;
    private JButton addUserButton2;
    private JCheckBox hasOutstandingOverdueItemsCheckBox;
    private JScrollPane userTable;
    private JTextField allBooksISBNField;
    private JButton allBooksSearchButton;
    private JButton BackButton2;
    private JTextField manageSSNField;
    private JButton searchUserManageButton;
    private JTextField newLocationField;
    private JButton updateManageButton;
    private JTextField recordsSSNField;
    private JButton recordFilterButton;
    private JTextField recordsISBNField;
    private JTextField allBooksNameField;
    private JCheckBox allRecordsOverDueBox;
    private JTextField viewandmanageuserField;
    private JButton deleteButton;


    public AdminView() {

        setContentPane(AdminPanel);
        setTitle("Admin Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        createTable1();
        createTable2();
        createTable3();

        getComboBox1().addItem("Fantasy");
        getComboBox1().addItem("Sci-Fi");
        getComboBox1().addItem("Children");
        getComboBox1().addItem("History");
        getComboBox1().addItem("Novel");
        getComboBox1().addItem("Poem");
        getComboBox1().addItem("Psychological");

    }

    public void switchToPanel(JPanel panel) {
        AdminPanel.removeAll();
        AdminPanel.add(panel);
        AdminPanel.repaint();
        AdminPanel.revalidate();
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

        viewBooksTable.setModel(tableModel2);
        viewBooksTable.setAutoCreateRowSorter(true);
    }

    public void createTable2() {
        DefaultTableModel tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("ISBN");
        tableModel2.addColumn("Book Name");
        tableModel2.addColumn("User SSN");
        tableModel2.addColumn("User Name");
        tableModel2.addColumn("Borrowed Date");
        tableModel2.addColumn("Due Date");
        tableModel2.addColumn("Status");
        RecordsTable.setModel(tableModel2);
        RecordsTable.setAutoCreateRowSorter(true);
    }


    public void createTable3() {
        DefaultTableModel tableModel2 = new DefaultTableModel();
        tableModel2.addColumn("User SSN");
        tableModel2.addColumn("User Name");
        tableModel2.addColumn("User Surname");
        tableModel2.addColumn("User Mail");
        tableModel2.addColumn("Status");

        UserTable.setModel(tableModel2);
        UserTable.setAutoCreateRowSorter(true);
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JTextField getViewandmanageuserField() {
        return viewandmanageuserField;
    }

    public void setViewandmanageuserField(JTextField viewandmanageuserField) {
        this.viewandmanageuserField = viewandmanageuserField;
    }

    public JTextField getAllBooksISBNField() {
        return allBooksISBNField;
    }

    public void setAllBooksISBNField(JTextField allBooksISBNField) {
        this.allBooksISBNField = allBooksISBNField;
    }

    public JButton getAllBooksSearchButton() {
        return allBooksSearchButton;
    }

    public void setAllBooksSearchButton(JButton allBooksSearchButton) {
        this.allBooksSearchButton = allBooksSearchButton;
    }

    public JTextField gettextField(){
        return gettextField();
    }
    public JTextField getRecordsSSNField() {
        return recordsSSNField;
    }

    public void setRecordsSSNField(JTextField recordsSSNField) {
        this.recordsSSNField = recordsSSNField;
    }

    public JButton getRecordFilterButton() {
        return recordFilterButton;
    }

    public void setRecordFilterButton(JButton recordFilterButton) {
        this.recordFilterButton = recordFilterButton;
    }

    public JTextField getRecordsISBNField() {
        return recordsISBNField;
    }

    public void setRecordsISBNField(JTextField recordsISBNField) {
        this.recordsISBNField = recordsISBNField;
    }


    public JTextField getAllBooksNameField() {
        return allBooksNameField;
    }

    public void setAllBooksNameField(JTextField allBooksNameField) {
        this.allBooksNameField = allBooksNameField;
    }

    public JCheckBox getAllRecordsOverDueBox() {
        return allRecordsOverDueBox;
    }

    public void setAllRecordsOverDueBox(JCheckBox allRecordsOverDueBox) {
        this.allRecordsOverDueBox = allRecordsOverDueBox;
    }

    public JTextField getManageISBNButton() {
        return allBooksISBNField;
    }

    public void setManageISBNButton(JTextField manageISBNButton) {
        this.allBooksISBNField = manageISBNButton;
    }

    public JTextField getManageSSNField() {
        return manageSSNField;
    }

    public void setManageSSNField(JTextField manageSSNField) {
        this.manageSSNField = manageSSNField;
    }

    public JTextField getNewLocationField() {
        return newLocationField;
    }

    public void setNewLocationField(JTextField newLocationField) {
        this.newLocationField = newLocationField;
    }

    public JButton getCreatBookButton() {
        return creatBookButton;
    }

    public void setCreatBookButton(JButton creatBookButton) {
        this.creatBookButton = creatBookButton;
    }

    public JButton getSearchBookManageButton() {
        return searchBookManageButton;
    }

    public void setSearchBookManageButton(JButton searchBookManageButton) {
        this.searchBookManageButton = searchBookManageButton;
    }

    public JButton getSearchManageButton() {
        return allBooksSearchButton;
    }

    public void setSearchManageButton(JButton searchManageButton) {
        this.allBooksSearchButton = searchManageButton;
    }

    public JButton getSearchUserManageButton() {
        return searchUserManageButton;
    }

    public void setSearchUserManageButton(JButton searchUserManageButton) {
        this.searchUserManageButton = searchUserManageButton;
    }

    public JTextField getTextField3() {
        return newLocationField;
    }

    public void setTextField3(JTextField textField3) {
        this.newLocationField = textField3;
    }

    public JButton getUpdateManageButton() {
        return updateManageButton;
    }

    public void setUpdateManageButton(JButton updateManageButton) {
        this.updateManageButton = updateManageButton;
    }

    public void setAddUserButton(JButton addUserButton) {
        this.addUserButton = addUserButton;
    }

    public JTextField getDeleteUserField() {
        return deleteUserField;
    }

    public void setDeleteUserField(JTextField deleteUserField) {
        this.deleteUserField = deleteUserField;
    }

    public JButton getDeleteUserButton() {
        return deleteBookSearch;
    }

    public void setDeleteUserButton(JButton deleteUserButton) {
        this.deleteBookSearch = deleteUserButton;
    }

    public JButton getAddBookButton() {
        return addBookButton;
    }

    public void setAddBookButton(JButton addBookButton) {
        this.addBookButton = addBookButton;
    }

    public JButton getViewRecordButton() {
        return viewRecordButton;
    }

    public void setViewRecordButton(JButton viewRecordButton) {
        this.viewRecordButton = viewRecordButton;
    }

    public JButton getRemoveBookButton() {
        return removeBookButton;
    }

    public void setRemoveBookButton(JButton removeBookButton) {
        this.removeBookButton = removeBookButton;
    }

    public JButton getUpdateBookButton() {
        return updateBookButton;
    }

    public void setUpdateBookButton(JButton updateBookButton) {
        this.updateBookButton = updateBookButton;
    }

    public JButton getRemoveUserButton() {
        return removeUserButton;
    }

    public void setRemoveUserButton(JButton removeUserButton) {
        this.removeUserButton = removeUserButton;
    }

    public JPanel getAdminPanel() {
        return AdminPanel;
    }

    public void setAdminPanel(JPanel adminPanel) {
        AdminPanel = adminPanel;
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        MainPanel = mainPanel;
    }

    public JPanel getAddBookPanel() {
        return addBookPanel;
    }

    public void setAddBookPanel(JPanel addBookPanel) {
        this.addBookPanel = addBookPanel;
    }

    public JPanel getViewAndManageUserPanel() {
        return ViewAndManageUserPanel;
    }

    public void setViewAndManageUserPanel(JPanel viewAndManageUserPanel) {
        ViewAndManageUserPanel = viewAndManageUserPanel;
    }

    public JPanel getDeleteUserPanel() {
        return deleteUserPanel;
    }

    public void setDeleteUserPanel(JPanel deleteUserPanel) {
        this.deleteUserPanel = deleteUserPanel;
    }

    public JPanel getViewAndManageBooksPanel() {
        return ViewAndManageBooksPanel;
    }

    public void setViewAndManageBooksPanel(JPanel viewAndManageBooksPanel) {
        ViewAndManageBooksPanel = viewAndManageBooksPanel;
    }

    public JPanel getViewAllRecords() {
        return ViewAllRecords;
    }

    public void setViewAllRecords(JPanel viewAllRecords) {
        ViewAllRecords = viewAllRecords;
    }

    public JButton getAddUserButton() {
        return addUserButton;
    }



    public JButton getViewUserButton() {
        return viewRecordButton;
    }

    public void setViewUserButton(JButton viewUserButton) {
        this.viewRecordButton = viewUserButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JButton getBackButton5() {
        return backButton5;
    }

    public void setBackButton5(JButton backButton5) {
        this.backButton5 = backButton5;
    }

    public JTextField getAddISBN() {
        return addISBN;
    }

    public void setAddISBN(JTextField addISBN) {
        this.addISBN = addISBN;
    }

    public JTextField getAddBookName() {
        return addBookName;
    }

    public void setAddBookName(JTextField addBookName) {
        this.addBookName = addBookName;
    }

    public JTextField getAddAuthor() {
        return addAuthor;
    }

    public void setAddAuthor(JTextField addAuthor) {
        this.addAuthor = addAuthor;
    }

    public JTextField getAddGenre() {
        return addGenre;
    }

    public void setAddGenre(JTextField addGenre) {
        this.addGenre = addGenre;
    }

    public JTextField getAddPubDate() {
        return addPubDate;
    }

    public void setAddPubDate(JTextField addPubDate) {
        this.addPubDate = addPubDate;
    }

    public JTextField getTextField7() {
        return textField7;
    }

    public void setTextField7(JTextField textField7) {
        this.textField7 = textField7;
    }

    public JButton getCreateAUserButton() {
        return creatBookButton;
    }

    public void setCreateAUserButton(JButton createAUserButton) {
        this.creatBookButton = createAUserButton;
    }

    public JTextField getTextField9() {
        return textField9;
    }

    public void setTextField9(JTextField textField9) {
        this.textField9 = textField9;
    }

    public JTextField getTextField10() {
        return textField10;
    }

    public void setTextField10(JTextField textField10) {
        this.textField10 = textField10;
    }

    public JButton getReturnToAdminMenuButton() {
        return returnToAdminMenuButton;
    }

    public void setReturnToAdminMenuButton(JButton returnToAdminMenuButton) {
        this.returnToAdminMenuButton = returnToAdminMenuButton;
    }

    public JTextField getTextField11() {
        return textField11;
    }

    public void setTextField11(JTextField textField11) {
        this.textField11 = textField11;
    }

    public JTextArea getViewUserArea() {
        return viewUserArea;
    }

    public void setViewUserArea(JTextArea viewUserArea) {
        this.viewUserArea = viewUserArea;
    }

    public JButton getDeleteItButton() {
        return deleteItButton;
    }

    public void setDeleteItButton(JButton deleteItButton) {
        this.deleteItButton = deleteItButton;
    }

    public JButton getBackButton6() {
        return backButton6;
    }

    public void setBackButton6(JButton backButton6) {
        this.backButton6 = backButton6;
    }

    public JTextField getDeleteField() {
        return deleteField;
    }

    public void setDeleteField(JTextField deleteField) {
        this.deleteField = deleteField;
    }

    public JButton getReturnToAdminMenuButtonView() {
        return ReturnToAdminMenuButtonView;
    }

    public void setReturnToAdminMenuButtonView(JButton returnToAdminMenuButtonView) {
        ReturnToAdminMenuButtonView = returnToAdminMenuButtonView;
    }

    public JButton getReturnToMainMenuButtonViewEmployee() {
        return returnToMainMenuButtonViewEmployee;
    }

    public void setReturnToMainMenuButtonViewEmployee(JButton returnToMainMenuButtonViewEmployee) {
        this.returnToMainMenuButtonViewEmployee = returnToMainMenuButtonViewEmployee;
    }

    public JTextArea getAllbookingsArea() {
        return allbookingsArea;
    }

    public void setAllbookingsArea(JTextArea allbookingsArea) {
        this.allbookingsArea = allbookingsArea;
    }

    public JButton getBackButton4() {
        return backButton4;
    }

    public void setBackButton4(JButton backButton4) {
        this.backButton4 = backButton4;
    }

    public JButton getBackButton() {
        return BackButton;
    }

    public void setBackButton(JButton backButton) {
        BackButton = backButton;
    }

    public JPanel getPricingPanel() {
        return pricingPanel;
    }

    public void setPricingPanel(JPanel pricingPanel) {
        this.pricingPanel = pricingPanel;
    }

    public JComboBox getAddUserCombo() {
        return addUserCombo;
    }

    public void setAddUserCombo(JComboBox addUserCombo) {
        this.addUserCombo = addUserCombo;
    }

    public JTextField getTextField1() {
        return deleteUserField;
    }

    public void setTextField1(JTextField textField1) {
        this.deleteUserField = textField1;
    }

    public JButton getButton1() {
        return deleteBookSearch;
    }

    public void setButton1(JButton button1) {
        this.deleteBookSearch = button1;
    }

    public JButton getViewBooksButton() {
        return viewBooksButton;
    }

    public void setViewBooksButton(JButton viewBooksButton) {
        this.viewBooksButton = viewBooksButton;
    }

    public JTextField getAddLocation() {
        return addLocation;
    }

    public void setAddLocation(JTextField addLocation) {
        this.addLocation = addLocation;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }


    public void setComboBox2(JComboBox comboBox2) {
        this.comboBox2 = comboBox2;
    }

    public JPanel getAddUserPanel() {
        return addUserPanel;
    }

    public void setAddUserPanel(JPanel addUserPanel) {
        this.addUserPanel = addUserPanel;
    }

    public JTextField getAddUserSSN() {
        return addUserSSN;
    }

    public void setAddUserSSN(JTextField addUserSSN) {
        this.addUserSSN = addUserSSN;
    }

    public JTextField getAddUserName() {
        return addUserName;
    }

    public void setAddUserName(JTextField addUserName) {
        this.addUserName = addUserName;
    }

    public JTextField getAddUserSurname() {
        return addUserSurname;
    }

    public void setAddUserSurname(JTextField addUserSurname) {
        this.addUserSurname = addUserSurname;
    }

    public JTextField getAddUserMail() {
        return addUserMail;
    }

    public void setAddUserMail(JTextField addUserMail) {
        this.addUserMail = addUserMail;
    }

    public JButton getAddUserButton2() {
        return addUserButton2;
    }

    public void setAddUserButton2(JButton addUserButton2) {
        this.addUserButton2 = addUserButton2;
    }

    public JCheckBox getHasOutstandingOverdueItemsCheckBox() {
        return hasOutstandingOverdueItemsCheckBox;
    }

    public void setHasOutstandingOverdueItemsCheckBox(JCheckBox hasOutstandingOverdueItemsCheckBox) {
        this.hasOutstandingOverdueItemsCheckBox = hasOutstandingOverdueItemsCheckBox;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }




    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getBackButton3() {
        return backButton3;
    }

    public void setBackButton3(JButton backButton3) {
        this.backButton3 = backButton3;
    }

    public JButton getReturnToMainMenuButtonRevenue() {
        return returnToMainMenuButtonRevenue;
    }

    public void setReturnToMainMenuButtonRevenue(JButton returnToMainMenuButtonRevenue) {
        this.returnToMainMenuButtonRevenue = returnToMainMenuButtonRevenue;
    }

    public JTextArea getMostBookedArea() {
        return mostBookedArea;
    }

    public void setMostBookedArea(JTextArea mostBookedArea) {
        this.mostBookedArea = mostBookedArea;
    }

    public JButton getReturnToMainMenuButtonmostBooked() {
        return returnToMainMenuButtonmostBooked;
    }

    public void setReturnToMainMenuButtonmostBooked(JButton returnToMainMenuButtonmostBooked) {
        this.returnToMainMenuButtonmostBooked = returnToMainMenuButtonmostBooked;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }


    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }

    public JTable getViewAllUsers() {
        return viewAllUsers;
    }

    public void setViewAllUsers(JTable viewAllUsers) {
        this.viewAllUsers = viewAllUsers;
    }

    public JTable getEmployeesTable() {
        return employeesTable;
    }

    public void setEmployeesTable(JTable employeesTable) {
        this.employeesTable = employeesTable;
    }

    public JTable getRecordsTable() {
        return RecordsTable;
    }

    public void setRecordsTable(JTable recordsTable) {
        RecordsTable = recordsTable;
    }

    public JTable getViewBooksTable() {
        return viewBooksTable;
    }

    public void setViewBooksTable(JTable viewBooksTable) {
        this.viewBooksTable = viewBooksTable;
    }

    public JTable getMostBookedTable() {
        return mostBookedTable;
    }

    public void setMostBookedTable(JTable mostBookedTable) {
        this.mostBookedTable = mostBookedTable;
    }

    public JTable getDeleteTable() {
        return deleteTable;
    }

    public void setDeleteTable(JTable deleteTable) {
        this.deleteTable = deleteTable;
    }

    public JTable getUserTable() {
        return UserTable;
    }

    public void setUserTable(JScrollPane userTable) {
        this.userTable = userTable;
    }

    public JTextField getTextField2() {
        return allBooksISBNField;
    }

    public void setTextField2(JTextField textField2) {
        this.allBooksISBNField = textField2;
    }

    public JButton getButton2() {
        return allBooksSearchButton;
    }

    public void setButton2(JButton button2) {
        this.allBooksSearchButton = button2;
    }

    public JButton getBackButton2() {
        return BackButton2;
    }

    public void setBackButton2(JButton backButton2) {
        BackButton2 = backButton2;
    }

    public void setUserTable(JTable userTable) {
        UserTable = userTable;
    }

    public JPanel getAllRatings() {
        return allRatings;
    }

    public void setAllRatings(JPanel allRatings) {
        this.allRatings = allRatings;
    }

    public JTable getRatingsTable() {
        return ratingsTable;
    }

    public void setRatingsTable(JTable ratingsTable) {
        this.ratingsTable = ratingsTable;
    }

    public JButton getReturnToMainMenuButton() {
        return returnToMainMenuButton;
    }

    public void setReturnToMainMenuButton(JButton returnToMainMenuButton) {
        this.returnToMainMenuButton = returnToMainMenuButton;
    }

    public JButton getAllRatingsButton() {
        return allRatingsButton;
    }

    public void setAllRatingsButton(JButton allRatingsButton) {
        this.allRatingsButton = allRatingsButton;
    }

    public JComboBox getStatusCombo() {
        return statusCombo;
    }

    public void setStatusCombo(JComboBox statusCombo) {
        this.statusCombo = statusCombo;
    }

    public JTextField getTotalRevenueField() {
        return totalRevenueField;
    }

    public void setTotalRevenueField(JTextField totalRevenueField) {
        this.totalRevenueField = totalRevenueField;
    }

    public JButton getViewAndModifyPricingButton() {
        return viewAndModifyPricingButton;
    }

    public void setViewAndModifyPricingButton(JButton viewAndModifyPricingButton) {
        this.viewAndModifyPricingButton = viewAndModifyPricingButton;
    }

    public JTable getPricingTable() {
        return pricingTable;
    }

    public void setPricingTable(JTable pricingTable) {
        this.pricingTable = pricingTable;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public void setPriceField(JTextField priceField) {
        this.priceField = priceField;
    }

    public JButton getAssignNewPriceButton() {
        return assignNewPriceButton;
    }

    public void setAssignNewPriceButton(JButton assignNewPriceButton) {
        this.assignNewPriceButton = assignNewPriceButton;
    }
}






