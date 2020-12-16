package managers;

import javafx.application.Application;
import javafx.stage.Stage;

public class MasterController{

    /**
     * Should setup any variables like the setup page
     * Should switch
     */
    private SetupManager setupManager;  //the "main" fxml page
    private EncounterManager encounterManager;  //the actual combat fxml page

    private Stage mainStage;
    /*
    don't create an instance of encounterManager on startup. Instead only create when needed, but
    once it is created do a check to see if it exists rather than recreate it
     */

    public MasterController() {
        //instantiate the setup manager
        setupManager = new SetupManager(mainStage);
        System.out.println("CREATED MASTER CONTROLLER SUCCESSFULLY");
    }


}
