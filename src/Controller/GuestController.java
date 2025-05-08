package Controller;

import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestController {
    private GuestModel guestModel;
    private GuestView guestView;

    public GuestController(GuestView guestView,GuestModel guestModel ) {
        this.guestModel = guestModel;
        this.guestView = guestView;


    }
}