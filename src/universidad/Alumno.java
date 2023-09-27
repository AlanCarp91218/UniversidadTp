package universidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {
	
	private Integer dni;
	private String apellido;
	private String nombre;
	private ArrayList<Materia> correlativasAprobadas; // Lista de correlativas aprobadas
	private ArrayList<Comision> comisionesInscritas;
	private ArrayList<Materia> materiasAprobadas;

	public Alumno(Integer dni, String apellido, String nombre) {
		this.apellido=apellido;
		this.dni=dni;
		this.nombre=nombre;
		this.correlativasAprobadas = new ArrayList<>(); 
	    this.comisionesInscritas = new ArrayList<>();
	    this.materiasAprobadas = new ArrayList<>();

	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	
	public List<Materia> getCorrelativasAprobadas() {
		return correlativasAprobadas;
	}

	public void setCorrelativasAprobadas(ArrayList<Materia> correlativasAprobadas) {
		this.correlativasAprobadas = correlativasAprobadas;
	}

	public List<Comision> getComisionesInscritas() {
		return comisionesInscritas;
	}

	public void setComisionesInscritas(ArrayList<Comision> comisionesInscritas) {
		this.comisionesInscritas = comisionesInscritas;
	}

	public ArrayList<Materia> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(ArrayList<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	public void aprobarMateria(Materia materia) {
		this.materiasAprobadas.add(materia);
			
		}

	public Boolean agregarComisionInscripto(Comision comision) {
		for (Comision com : comisionesInscritas) {
			if(com.getDia().equals(comision.getDia())&&(com.getTurno().equals(comision.getTurno()))) {
				return false;
			}
		}
		return this.comisionesInscritas.add(comision);
		
	}


		
	}
	
	

