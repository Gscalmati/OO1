package ar.edu.unlp.info.oo1.ejercicio10_jobScheduler;

public class MostEffort extends Strategy{

	public MostEffort () {
		
		super ("HighestPriority");
	}
	
	public JobDescription next(JobScheduler scheduler) {
		JobDescription nextJob = scheduler.jobs.stream()
     			.max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
     			.orElse(null);
		scheduler.unschedule(nextJob);
		    return nextJob;	}
}
