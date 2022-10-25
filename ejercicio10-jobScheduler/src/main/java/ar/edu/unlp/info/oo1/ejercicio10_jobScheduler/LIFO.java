package ar.edu.unlp.info.oo1.ejercicio10_jobScheduler;

public class LIFO extends Strategy{

	public LIFO () {
		super ("LIFO");
	}
	
	public JobDescription next(JobScheduler scheduler) {
		JobDescription nextJob = scheduler.jobs.get(scheduler.jobs.size()-1);
		scheduler.unschedule(nextJob);
    	return nextJob;
	}
}
