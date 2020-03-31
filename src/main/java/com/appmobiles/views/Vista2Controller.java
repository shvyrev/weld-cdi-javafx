package com.appmobiles.views;

import com.appmobiles.AppView;
import com.appmobiles.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class Vista2Controller implements Initializable {

    private static final Logger log = LoggerFactory.getLogger( Vista2Controller.class );

    @Inject
    AppView appView;

    @Inject
    Model model;

    /**
     * Event handler fired when the user requests a previous vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void previousPane(ActionEvent event) {
        appView.openPage("vista1");

        model.next();
        log.info(" $ previousPane : " + model.getNames());
//        VistaNavigator.loadVista(VistaNavigator.VISTA_1);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info(" $ initialize : " + url + " " + resourceBundle);
    }
}