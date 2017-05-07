package disk_scheduler_simulator;

import disk_scheduler_simulator.controller.MainUIController;
import disk_scheduler_simulator.controller.StatisticsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * javafx Main Application class
 * @author Abdallah Abdelazim
 */
public class Main extends Application {

    private Stage primaryStage;

    private int [] scheduleSequenceFCFS;
    private int [] scheduleSequenceSSTF;
    private int [] scheduleSequenceScan;
    private int [] scheduleSequenceCScan;
    private int [] scheduleSequenceLook;
    private int [] scheduleSequenceCLook;

    private int totalHeadMovementFCFS;
    private int totalHeadMovementSSTF;
    private int totalHeadMovementScan;
    private int totalHeadMovementCScan;
    private int totalHeadMovementLook;
    private int totalHeadMovementCLook;

    /**
     * the disk-specific last cylinder number
     * Change this here only
     */
    public static final int DISK_END_CYLINDER = 199;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Disk Scheduler Simulator");
        this.primaryStage.getIcons().add(new Image("file:resources/images/gears.png"));

        // Load mainUI from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class
                .getResource("view/mainUI.fxml"));
        Parent root = loader.load();

        // Give the controller access to the main app.
        MainUIController controller = loader.getController();
        controller.setMain(this);

        this.primaryStage.setScene(new Scene(root));
        this.primaryStage.show();
        this.primaryStage.setMinWidth(this.primaryStage.getWidth()-50);
        this.primaryStage.setMinHeight(this.primaryStage.getHeight()-50);
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void showStatistics() throws Exception {
        Stage stage = new Stage();
        stage.setTitle("Disk Scheduler Simulator Results & Statistics");
        stage.getIcons().add(new Image("file:resources/images/gears.png"));

        // Load mainUI from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class
                .getResource("view/statistics.fxml"));
        Parent root = loader.load();

        // Give the controller access to the main app.
        StatisticsController controller = loader.getController();
        controller.setMain(this);

        stage.setScene(new Scene(root));
        stage.show();
        stage.setMinWidth(stage.getWidth()-50);
        stage.setMinHeight(stage.getHeight()-50);

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public int[] getScheduleSequenceFCFS() {
        return scheduleSequenceFCFS;
    }

    public void setScheduleSequenceFCFS(int[] scheduleSequenceFCFS) {
        this.scheduleSequenceFCFS = scheduleSequenceFCFS;
    }

    public int[] getScheduleSequenceSSTF() {
        return scheduleSequenceSSTF;
    }

    public void setScheduleSequenceSSTF(int[] scheduleSequenceSSTF) {
        this.scheduleSequenceSSTF = scheduleSequenceSSTF;
    }

    public int[] getScheduleSequenceScan() {
        return scheduleSequenceScan;
    }

    public void setScheduleSequenceScan(int[] scheduleSequenceScan) {
        this.scheduleSequenceScan = scheduleSequenceScan;
    }

    public int[] getScheduleSequenceCScan() {
        return scheduleSequenceCScan;
    }

    public void setScheduleSequenceCScan(int[] scheduleSequenceCScan) {
        this.scheduleSequenceCScan = scheduleSequenceCScan;
    }

    public int[] getScheduleSequenceLook() {
        return scheduleSequenceLook;
    }

    public void setScheduleSequenceLook(int[] scheduleSequenceLook) {
        this.scheduleSequenceLook = scheduleSequenceLook;
    }

    public int[] getScheduleSequenceCLook() {
        return scheduleSequenceCLook;
    }

    public void setScheduleSequenceCLook(int[] scheduleSequenceCLook) {
        this.scheduleSequenceCLook = scheduleSequenceCLook;
    }

    public int getTotalHeadMovementFCFS() {
        return totalHeadMovementFCFS;
    }

    public void setTotalHeadMovementFCFS(int totalHeadMovementFCFS) {
        this.totalHeadMovementFCFS = totalHeadMovementFCFS;
    }

    public int getTotalHeadMovementSSTF() {
        return totalHeadMovementSSTF;
    }

    public void setTotalHeadMovementSSTF(int totalHeadMovementSSTF) {
        this.totalHeadMovementSSTF = totalHeadMovementSSTF;
    }

    public int getTotalHeadMovementScan() {
        return totalHeadMovementScan;
    }

    public void setTotalHeadMovementScan(int totalHeadMovementScan) {
        this.totalHeadMovementScan = totalHeadMovementScan;
    }

    public int getTotalHeadMovementCScan() {
        return totalHeadMovementCScan;
    }

    public void setTotalHeadMovementCScan(int totalHeadMovementCScan) {
        this.totalHeadMovementCScan = totalHeadMovementCScan;
    }

    public int getTotalHeadMovementLook() {
        return totalHeadMovementLook;
    }

    public void setTotalHeadMovementLook(int totalHeadMovementLook) {
        this.totalHeadMovementLook = totalHeadMovementLook;
    }

    public int getTotalHeadMovementCLook() {
        return totalHeadMovementCLook;
    }

    public void setTotalHeadMovementCLook(int totalHeadMovementCLook) {
        this.totalHeadMovementCLook = totalHeadMovementCLook;
    }
}
