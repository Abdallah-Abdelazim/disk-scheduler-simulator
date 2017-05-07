package disk_scheduler_simulator.scheduling_algs;

/**
 * Created by abdal on 2017-04-16.
 */
public interface SchedulingAlgorithm {

    int [] getSequence();
    int getTotalHeadMovement();

}
