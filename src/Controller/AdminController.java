package Controller;

import Model.AdminModel;
import View.AdminView;

public class AdminController {
    AdminView adminView;
    AdminModel adminModel;

    public AdminController( AdminView adminView,AdminModel adminModel){
        this.adminView = adminView;
        this.adminModel = adminModel;

    }
}
