package KONIG.CENTRAL.CONTROLLERS;

import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private JFXHamburger hambi;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HamburgerSlideCloseTransition transition = new HamburgerSlideCloseTransition(hambi);
        transition.setRate(-1);
    }
}
