package disk_scheduler_simulator.scheduling_algs;

import java.util.Arrays;

/**
 * Created by abdal on 2017-04-17.
 */
public class CSCAN implements SchedulingAlgorithm {
    private int [] reqQueue;  // input
    private int initHeadCylinder;  // input

    private int [] scheduleSequence;  // output
    private int totalHeadMovement = 0;  // output

    public static int endCylinder = 199;  // 199 is the default value

    public CSCAN(int[] reqQueue, int initHeadCylinder) {
        this.reqQueue = new int[reqQueue.length];
        System.arraycopy(reqQueue, 0, this.reqQueue, 0, reqQueue.length);
        this.initHeadCylinder = initHeadCylinder;
    }

    public int [] getSequence() {
        Arrays.sort(reqQueue, 0, reqQueue.length); // Sorts the array of ints into ascending numerical order

        scheduleSequence = new int[reqQueue.length+3];

        int nextSequenceIndex = 0;

        /** move right **/
        // get the first element in the array that is bigger than the initHeadCylinder
        int startIndex = 0;
        for (int i=0; i<reqQueue.length; i++) {
            if (reqQueue[i]>initHeadCylinder) {
                startIndex = i;
                break;
            }
        }

        for (int i = startIndex; i<reqQueue.length; i++) {
            scheduleSequence[nextSequenceIndex++] = reqQueue[i];
        }

        /***********************************/

        scheduleSequence[nextSequenceIndex++] = endCylinder; // <--- Scan reaches endCylinder

        /**********************************/

        /** Immediately return to the beginning of the disk and move right **/
        scheduleSequence[nextSequenceIndex++] = 0;           // <-- return to zero

        for (int i = 0; i<startIndex; i++) {
            scheduleSequence[nextSequenceIndex++] = reqQueue[i];
        }

        /*********************************/

        scheduleSequence[nextSequenceIndex++] = endCylinder;  // <--- Scan reaches endCylinder

        /*********************************/

        return scheduleSequence;
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
