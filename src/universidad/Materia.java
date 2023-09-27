package universidad;

import java.util.ArrayList;
import java.util.Objects;


public class Materia {

	private Integer codigo;
	private String nombre;
	private ArrayList <Materia> correlativas;
	
	public Materia(Integer codigo, String nombre) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.correlativas= new ArrayList<>();

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}

		public boolean agregarCorrelativa(Materia correlativa) {
			if (correlativas.contains(correlativa)) {
				return false;
		}
			return correlativas.add(correlativa);
		}

		public Boolean eliminarCorrelativa(Materia pb2, Materia pb1) {
			ArrayList<Materia>correlativasMateria= pb2.getCorrelativas();
			
			if(correlativasMateria.contains(pb1)) {
				correlativasMateria.remove(pb1);
				return true;
			}
			
			return false;
		}
		
		
		
	}
	
	
	

