package disk_scheduler_simulator.controller;

import disk_scheduler_simulator.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Created by abdal on 2017-04-17.
 */
public class StatisticsController {

    @FXML
    private TextArea resultsTextArea;

    // reference to MainUIController object
    private Main main;

    @FXML
    private void showResults() {
        StringBuilder strBuilder = new StringBuilder("");

        // FCFS
        strBuilder.append("FCFS Sequence:  ");
        for (int n : main.getScheduleSequenceFCFS()) {
            strBuilder.append(" -> " + n);
        }
        strBuilder.append("\nFCFS Total Head Movement = " + main.getTotalHeadMovementFCFS() + "\n\n");

        //SSTF
        strBuilder.append("SSTF Sequence:  ");
        for (int n : main.getScheduleSequenceSSTF()) {
            strBuilder.append(" -> " + n);
        }
        strBuilder.append("\nSSTF Total Head Movement = " + main.getTotalHeadMovementSSTF() + "\n\n");

        //SCAN
        strBuilder.append("SCAN Sequence:  ");
        for (int n : main.getScheduleSequenceScan()) {
            strBuilder.append(" -> " + n);
        }
        strBuilder.append("\nSCAN Total Head Movement = " + main.getTotalHeadMovementScan() + "\n\n");

        //CSCAN
        strBuilder.append("C-SCAN Sequence:  ");
        for (int n : main.getScheduleSequenceCScan()) {
            strBuilder.append(" -> " + n);
        }
        strBuilder.append("\nC-SCAN Total Head Movement = " + main.getTotalHeadMovementCScan() + "\n\n");

        // LOOK
        strBuilder.append("LOOK Sequence:  ");
        for (int n : main.getScheduleSequenceLook()) {
            strBuilder.append(" -> " + n);
        }
        strBuilder.append("\nLOOK Total Head Movement = " + main.getTotalHeadMovementLook() + "\n\n");

        // CLOOK
        strBuilder.append("CLOOK Sequence:  ");
        for (int n : main.getScheduleSequenceCLook()) {
            strBuilder.append(" -> " + n);
        }
        strBuilder.append("\nLOOK Total Head Movement = " + main.getTotalHeadMovementCLook() + "\n\n");


        resultsTextArea.setText(strBuilder.toString());
    }


    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
