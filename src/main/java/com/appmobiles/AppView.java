package com.appmobiles;

import com.appmobiles.cdi.CDIControllerFactory;
import com.appmobiles.cdi.StartupScene;
import com.appmobiles.views.MainController;
import com.appmobiles.views.Vista1Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;

@ApplicationScoped
public class AppView {

    @Inject
    CDIControllerFactory controllerFactory;

    @Inject
    Config config;

    private MainController controller;

    public void start(@Observes @StartupScene Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(MainController.class.getResource("main.fxml"));
        loader.setControllerFactory(App.container.select(CDIControllerFactory.class).get());
        Scene scene = new Scene(loader.load(), config.values().width, config.values().height);
        scene.getStylesheets().setAll(getClass().getResource("style.css").toExternalForm());
        stage.setTitle(config.values().title);
        stage.setScene(scene);
        stage.show();
        controller = loader.getController();
    }

    /**
     * Open new Page in MainController
     * @param fxmlName
     */
    public void openPage(String fxmlName) {
        final FXMLLoader fxmlLoader = new FXMLLoader(Vista1Controller.class.getResource(fxmlName + ".fxml"));
        fxmlLoader.setControllerFactory(controllerFactory);
        try {
            controller.setPage(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Open dialog in new Window
     * e.g. dialog(MainController.class.getResource("main.fxml"));
     * @param resource
     * @throws IOException
     */
    public void dialog(URL resource) throws IOException {
        FXMLLoader loader = new FXMLLoader(resource);
        loader.setControllerFactory(controllerFactory);
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
}