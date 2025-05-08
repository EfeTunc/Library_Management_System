package View;

import javax.swing.*;


public class LoginView extends JFrame {
    private JTextField SSNField;
    private JButton loginButton;
    private JPanel LoginPanel;
    private JPasswordField passwordField;

    public LoginView(){
        setContentPane(LoginPanel);
        setTitle("User Login Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this,msg);
    }

    public String getSSNField() {
        return SSNField.getText();
    }

    public String getPasswordField() {
        return passwordField.getText();
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JPanel getLoginPanel() {
        return LoginPanel;
    }


}
