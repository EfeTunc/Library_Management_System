import Controller.AdminController;
import Model.AdminModel;
import View.AdminView;
import View.GuestView;
import View.LoginView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        AdminView adminView = new AdminView();
        AdminModel adminModel = new AdminModel();
        AdminController adminController = new AdminController(adminView,adminModel);


    }
}