package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginModel loginModel;
    private LoginView loginView;

    public LoginController(LoginModel loginModel, LoginView loginView){
        this.loginModel = loginModel;
        this.loginView = loginView;

        this.loginView.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    public void login() {
        String ssnOfUser = loginView.getSSNField();
        String password = loginView.getPasswordField();
        String userType = loginModel.auth(ssnOfUser, password);

        if (userType == null) {
            loginView.showMessage("Invalid User!");
        }
        else {
            String status = loginModel.user.getStatus();
            if (status.equalsIgnoreCase("deleted")) {
                loginView.showMessage("Your account has been deleted. Please contact the administrator.");
                return;
            }

            loginView.showMessage("Login successful!");
            loginView.dispose();

            if (userType.equals("admin")) {
                AdminView view = new AdminView();
                AdminModel model = new AdminModel();
                new AdminController(view, model);
                view.setVisible(true);
            }

            if (userType.equals("guest")) {
                GuestView guestView = new GuestView();
                GuestModel guestModel = new GuestModel();
                new GuestController(guestView, guestModel);
                guestView.setVisible(true);
            }
        }
    }

}
