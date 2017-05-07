package disk_scheduler_simulator.scheduling_algs;

import java.util.Arrays;

/**
 * Created by abdal on 2017-04-16.
 */
public class FCFS implements SchedulingAlgorithm {
    private int [] reqQueue;  // input
    private int initHeadCylinder;  // input

    private int [] scheduleSequence;  // output
    private int totalHeadMovement = 0;  // output

    public FCFS(int[] reqQueue, int initHeadCylinder) {
        this.reqQueue = new int[reqQueue.length];
        System.arraycopy(reqQueue, 0, this.reqQueue, 0, reqQueue.length);
        this.initHeadCylinder = initHeadCylinder;
    }

    public int [] getSequence() {
        scheduleSequence = new int[reqQueue.length];
        System.arraycopy(reqQueue, 0, scheduleSequence, 0, reqQueue.length);
        return this.scheduleSequence;
    }

    public int getTotalHeadMovement() {
        int currHeadPosition = initHeadCylinder;

        for (int cylinder: scheduleSequence) {
            totalHeadMovement += Math.abs(currHeadPosition - cylinder);
            currHeadPosition = cylinder;
        }

        return totalHeadMovement;
    }

    public int[] getReqQueue() {
        return reqQueue;
    }

    public void setReqQueue(int[] reqQueue) {
        this.reqQueue = new int[reqQueue.length];
        System.arraycopy(reqQueue, 0, this.reqQueue, 0, reqQueue.length);
    }

    public int getInitHeadCylinder() {
        return initHeadCylinder;
    }

    public void setInitHeadCylinder(int initHeadCylinder) {
        this.initHeadCylinder = initHeadCylinder;
    }
}
