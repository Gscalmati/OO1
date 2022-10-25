package ar.edu.unlp.info.oo1.ejercicio10_jobScheduler;

public abstract class Strategy {
	
		private String nombre;
		
		public Strategy (String unNombre) {
			this.nombre = unNombre;
		}
		
		public abstract JobDescription next(JobScheduler scheduler);

		public String getNombre() {
			// TODO Auto-generated method stub
			return this.nombre;
		}

}
