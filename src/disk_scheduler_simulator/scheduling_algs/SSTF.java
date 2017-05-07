package disk_scheduler_simulator.scheduling_algs;


/**
 * Created by abdal on 2017-04-17.
 */
public class SSTF implements SchedulingAlgorithm {

    private int [] reqQueue;  // input
    private int initHeadCylinder;  // input

    private int [] scheduleSequence;  // output
    private int totalHeadMovement = 0;  // output

    public SSTF(int[] reqQueue, int initHeadCylinder) {
        this.reqQueue = new int[reqQueue.length];
        System.arraycopy(reqQueue, 0, this.reqQueue, 0, reqQueue.length);
        this.initHeadCylinder = initHeadCylinder;
    }

    private int getNearestCylinder(int currHeadCylinder) {
        int min = 10000;
        int minPos = -1;
        for (int i = 0; i < reqQueue.length; i++){
            if (reqQueue[i] == -1) continue;
            else if  (Math.abs(currHeadCylinder - reqQueue[i]) < min) {
                minPos = i;
                min = Math.abs(currHeadCylinder - reqQueue[i]);  // i++ also works!!
            }
        }
        int nearestCylinder = reqQueue[minPos];
        reqQueue[minPos] = -1;  // -1 is an indicator that the request has been already satisfied
        return nearestCylinder;
    }

    public int [] getSequence() {
        scheduleSequence = new int[reqQueue.length];
        int currHeadCylinder = initHeadCylinder;
        for (int i = 0; i < scheduleSequence.length; i++){
            int nearestCylinder = getNearestCylinder(currHeadCylinder);
            scheduleSequence[i] = nearestCylinder;
            currHeadCylinder = nearestCylinder;
        }

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
