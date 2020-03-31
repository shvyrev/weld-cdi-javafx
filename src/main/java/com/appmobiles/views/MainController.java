package com.appmobiles.views;

import com.appmobiles.AppView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private static final Logger log = LoggerFactory.getLogger( MainController.class );

    @FXML
    public StackPane pageHolder;

    @FXML
    public Label headerLabel;

    @Inject
    AppView appView;

    public void setPage(Node node){
        log.info(" $ setVista : " + pageHolder);
        pageHolder.getChildren().setAll(node);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info(" $ initialize : " + url + " " + resourceBundle);
        Platform.runLater(() -> appView.openPage("vista1"));
    }
}
