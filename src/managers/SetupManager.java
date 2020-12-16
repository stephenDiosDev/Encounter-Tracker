package managers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * A manager for the initial setup page, where the user can enter actor names, initiatives and HP (optional)
 */
public class SetupManager extends Application{

    public SetupManager(Stage stage) {
        try {   //if can't call start method, print error message with stack trace and exit
            this.start(stage);
        } catch (IOException ioEx) {
            System.err.println("IOException: SetupManager cannot be created!");
           // System.err.println(Arrays.toString(Thread.currentThread().getStackTrace()));
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Application.launch((args));
    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(SetupManager.class.getResource("/src/fxmlPages/setupPage.fxml"));
        //VBox root = loader.load();
        VBox root = FXMLLoader.load(getClass().getResource("/fxmlPages/setupPage.fxml"));

        System.out.println("HERE");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Setup Page");   //TODO set some global title value
        stage.show();
    //setup and encounter manager should have its own start function, taking a common stage from MasterController
    //to switch from setup->encounter and vice versa, call a method in MasterController and pass any needed data
    //MasterController should then call method that creates (if needed) instance of the manager and passes along data in constructor or something
    }
}
