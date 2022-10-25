package ar.edu.unlp.info.oo1.ejercicio10_jobScheduler;

public class FIFO extends Strategy{

	public FIFO () {
		super ("FIFO");
	}
	
	public JobDescription next(JobScheduler scheduler) {
		JobDescription nextJob = scheduler.getJobs().get(0);
		scheduler.unschedule(nextJob);
    	return nextJob;
	}
}
