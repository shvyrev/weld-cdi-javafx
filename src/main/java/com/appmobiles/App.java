package com.appmobiles;

import com.appmobiles.cdi.StartupScene;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.util.AnnotationLiteral;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static SeContainer container;

    @Override
    public void start(Stage stage) throws IOException {
        container = SeContainerInitializer.newInstance().initialize();
        container.getBeanManager().fireEvent(stage, new AnnotationLiteral<StartupScene>() {});
    }

    public static void main(String[] args) {
        launch();
    }

}