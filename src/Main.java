import Controller.AdminController;
import Controller.LoginController;
import Model.AdminModel;
import Model.LoginModel;
import View.AdminView;
import View.GuestView;
import View.LoginView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        LoginView loginView = new LoginView();
        LoginModel loginModel = new LoginModel();
        LoginController loginController = new LoginController(loginModel , loginView);

    }
}