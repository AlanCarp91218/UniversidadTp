package universidad;

public class Aula {

	private Integer numeroAula;
	private Integer capacidad;
	
	public Aula(Integer numeroAula, Integer capacidad) {
		this.capacidad= capacidad;
		this.numeroAula= numeroAula;
	}

	public Integer getNumeroAula() {
		return numeroAula;
	}

	public void setNumeroAula(Integer numeroAula) {
		this.numeroAula = numeroAula;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	

}
