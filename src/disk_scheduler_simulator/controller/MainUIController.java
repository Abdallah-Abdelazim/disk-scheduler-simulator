package disk_scheduler_simulator.controller;

import disk_scheduler_simulator.Main;
import disk_scheduler_simulator.scheduling_algs.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainUIController {

    @FXML
    private TextField reqInputQueueTextField;
    @FXML
    private TextField initHeadCylinderTextField;
    @FXML
    private CheckMenuItem fileReadCheck;


    private int [] reqInputQueue;
    private int initHeadCylinder;

    // Reference to the main application
    private Main main;

    @FXML
    private void startDiskScheduling() {

        if (reqInputQueueTextField.getText().equals("") || initHeadCylinderTextField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Required Input Missing!!");
            alert.setContentText("Please fill the input text fields");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(
                    new Image("file:resources/images/gears.png"));

            stage.initOwner(main.getPrimaryStage());
            alert.showAndWait();

        }
        else {
            prepareInput(initHeadCylinderTextField.getText(), reqInputQueueTextField.getText());

            scheduleFCFS();
            scheduleSSTF();
            scheduleScan();
            scheduleCScan();
            scheduleLook();
            scheduleCLook();

            try {
                main.showStatistics();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void closeApplication() {
        Platform.exit();
    }

    @FXML
    private void readInputFromFile() {
        if (fileReadCheck.isSelected()) {
            // read from file
            File inputFile = new File("Input File.txt");
            try {
                Scanner scanner = new Scanner(inputFile);
                initHeadCylinderTextField.setText(scanner.nextLine());
                initHeadCylinderTextField.setEditable(false);
                reqInputQueueTextField.setText(scanner.nextLine());
                reqInputQueueTextField.setEditable(false);
            } catch (FileNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("The System Cannot Find The Input File");
                alert.setContentText("Please make sure that \"Input File.txt\" exists " +
                        "and is in the same directory as the application.");
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(
                        new Image("file:resources/images/gears.png"));

                stage.initOwner(main.getPrimaryStage());
                alert.showAndWait();
            }
        }
        else{ // clear and set editable text fields
            initHeadCylinderTextField.clear();
            initHeadCylinderTextField.setEditable(true);
            reqInputQueueTextField.clear();
            reqInputQueueTextField.setEditable(true);
        }
    }

    @FXML
    private void showAboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Disk Scheduler Simulator");
        alert.setContentText("© 2017, Abdallah Abdelazim");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(
                new Image("file:resources/images/gears.png"));

        stage.initOwner(main.getPrimaryStage());
        alert.showAndWait();
    }

    public void prepareInput(String initHeadCylinderStr, String reqInputQueueStr) {

        initHeadCylinder = Integer.parseInt(initHeadCylinderStr);

        String [] strAuxiliaryArray =
                reqInputQueueStr.split(",|\\s");  // either commas or spaces

        reqInputQueue = new int[strAuxiliaryArray.length];
        for (int i=0; i<strAuxiliaryArray.length; i++) {
            reqInputQueue[i] = Integer.parseInt(strAuxiliaryArray[i]);
        }
    }

    private void scheduleFCFS() {
        FCFS fcfsAlg = new FCFS(reqInputQueue, initHeadCylinder);
        main.setScheduleSequenceFCFS(fcfsAlg.getSequence());
        main.setTotalHeadMovementFCFS(fcfsAlg.getTotalHeadMovement());
    }

    private void scheduleSSTF() {
        SSTF sstfAlg = new SSTF(reqInputQueue, initHeadCylinder);
        main.setScheduleSequenceSSTF(sstfAlg.getSequence());
        main.setTotalHeadMovementSSTF(sstfAlg.getTotalHeadMovement());
    }

    private void scheduleScan() {
        SCAN scanAlg = new SCAN(reqInputQueue, initHeadCylinder);
        SCAN.endCylinder = Main.DISK_END_CYLINDER;
        main.setScheduleSequenceScan(scanAlg.getSequence());
        main.setTotalHeadMovementScan(scanAlg.getTotalHeadMovement());
    }

    private void scheduleCScan() {
        CSCAN cscanAlg = new CSCAN(reqInputQueue, initHeadCylinder);
        CSCAN.endCylinder = Main.DISK_END_CYLINDER;
        main.setScheduleSequenceCScan(cscanAlg.getSequence());
        main.setTotalHeadMovementCScan(cscanAlg.getTotalHeadMovement());
    }

    private void scheduleLook() {
        LOOK lookalg = new LOOK(reqInputQueue, initHeadCylinder);
        main.setScheduleSequenceLook(lookalg.getSequence());
        main.setTotalHeadMovementLook(lookalg.getTotalHeadMovement());
    }

    private void scheduleCLook() {
        CLOOK clookAlg = new CLOOK(reqInputQueue, initHeadCylinder);
        main.setScheduleSequenceCLook(clookAlg.getSequence());
        main.setTotalHeadMovementCLook(clookAlg.getTotalHeadMovement());
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
