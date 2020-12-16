import managers.MasterController;
/**
 * Creates an instance of the master manager
 */
public class EncounterTracker{
    private static MasterController masterController;

    static public void main(String[] args) {
        masterController = new MasterController();
    }
}
