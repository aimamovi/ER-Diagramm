package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    /**
     * @ToDo edit run configuration
     * Open "Run" -> "Edit Configurations..."
     * Add this to your VM options (just copy & paste the following line):
     * --module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib" --add-modules=javafx.controls,javafx.fxml
     */

    /**
     * main method
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        MyFXMLLoader.setPrimaryStage(primaryStage);

        MyFXMLLoader loader = new MyFXMLLoader();
        loader.loadFXML("view/scene.fxml", "Ticketsystem");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
