package universidad;

import java.time.LocalDate;

public class CicloLectivo {
	
	private Integer idCiclo;
	private LocalDate fechaIncioCiclo;
	private LocalDate fechaFinCiclo;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion;
	
	public CicloLectivo(Integer idCiclo, LocalDate fechaIncioCiclo, LocalDate fechaFinCiclo,
			LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
		this.idCiclo = idCiclo;
		this.fechaIncioCiclo = fechaIncioCiclo;
		this.fechaFinCiclo = fechaFinCiclo;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinInscripcion = fechaFinInscripcion;
	}

	public Integer getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(Integer idCiclo) {
		this.idCiclo = idCiclo;
	}

	public LocalDate getFechaIncioCiclo() {
		return fechaIncioCiclo;
	}

	public void setFechaIncioCiclo(LocalDate fechaIncioCiclo) {
		this.fechaIncioCiclo = fechaIncioCiclo;
	}

	public LocalDate getFechaFinCiclo() {
		return fechaFinCiclo;
	}

	public void setFechaFinCiclo(LocalDate fechaFinCiclo) {
		this.fechaFinCiclo = fechaFinCiclo;
	}

	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}

	public LocalDate getFechaFinInscripcion() {
		return fechaFinInscripcion;
	}

	public void setFechaFinInscripcion(LocalDate fechaFinInscripcion) {
		this.fechaFinInscripcion = fechaFinInscripcion;
	}
	
	

}
