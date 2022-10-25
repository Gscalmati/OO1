package ar.edu.unlp.info.oo1.ejercicio10_jobScheduler;

public class HighestPriority extends Strategy{

	public HighestPriority () {
		
		super ("HighestPriority");
	}
	
	public JobDescription next(JobScheduler scheduler) {
		JobDescription nextJob = scheduler.jobs.stream()
				.max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
				.orElse(null);
		scheduler.unschedule(nextJob);
        	return nextJob;
	}
}
