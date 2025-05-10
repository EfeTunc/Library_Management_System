package Controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginControllerTest {

    @Test
    public void login() {

        class StubLoginModel extends Model.LoginModel {
            @Override
            public String auth(String ssn, String password) {
                if (ssn.equals("123") && password.equals("pass")) return "admin";
                return null;
            }
        }

        // Stub for LoginView
        class StubLoginView extends View.LoginView {
            private String messageShown;
            @Override public String getSSNField() { return "123"; }
            @Override public String getPasswordField() { return "pass"; }
            @Override public void showMessage(String message) { this.messageShown = message; }
            @Override public void dispose() {}
            public String getMessageShown() { return messageShown; }
        }

        StubLoginModel model = new StubLoginModel();
        StubLoginView view = new StubLoginView();

        LoginController controller = new LoginController(model, view);
        controller.login();

        assertEquals("Login successful!", view.getMessageShown());
    }
}