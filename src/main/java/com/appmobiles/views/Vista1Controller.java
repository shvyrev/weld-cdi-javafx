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

public class Vista1Controller implements Initializable {

    private static final Logger log = LoggerFactory.getLogger( Vista1Controller.class );

    @Inject
    AppView appView;

    @Inject
    Model model;

    /**
     * Event handler fired when the user requests a new vista.
     *
     * @param event the event that triggered the handler.
     */
    @FXML
    void nextPane(ActionEvent event) {

        model.next();
        log.info(" $ nextPane : " + model.getNames());

        appView.openPage("vista2");
//        VistaNavigator.loadVista(VistaNavigator.VISTA_2);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info(" $ initialize : " + url + " " + resourceBundle);
    }
}