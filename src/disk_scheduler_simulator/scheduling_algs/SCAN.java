package disk_scheduler_simulator.scheduling_algs;

import java.util.Arrays;

/**
 * Created by abdal on 2017-04-17.
 */
public class SCAN implements SchedulingAlgorithm {
    private int [] reqQueue;  // input
    private int initHeadCylinder;  // input

    private int [] scheduleSequence;  // output
    private int totalHeadMovement = 0;  // output

    public static int endCylinder = 199;  // 199 is the default value

    public SCAN(int[] reqQueue, int initHeadCylinder) {
        this.reqQueue = new int[reqQueue.length];
        System.arraycopy(reqQueue, 0, this.reqQueue, 0, reqQueue.length);
        this.initHeadCylinder = initHeadCylinder;
    }

    public int [] getSequence() {
        Arrays.sort(reqQueue, 0, reqQueue.length); // Sorts the array of ints into ascending numerical order

        scheduleSequence = new int[reqQueue.length+1];

        int nextSequenceIndex = 0;

        /** move left **/

        // get the first element in the array that is smaller than the initHeadCylinder
        int startIndex = 0;
        for (int i=0; i<reqQueue.length; i++) {
            if (reqQueue[i]>initHeadCylinder) {
                startIndex = i-1;
                break;
            }
        }

        for (int i = startIndex; i>=0; i--) {
            scheduleSequence[nextSequenceIndex++] = reqQueue[i];
        }

        /***********************************/

        scheduleSequence[nextSequenceIndex++] = 0; // <--- Scan reaches zero

        /**********************************/

        /** move right **/
        for (int i = startIndex+1; i<reqQueue.length; i++) {
            scheduleSequence[nextSequenceIndex++] = reqQueue[i];
        }

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
