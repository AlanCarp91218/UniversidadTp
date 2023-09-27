package universidad;

import java.util.ArrayList;

public class Comision {

	
	private Turno turno;
	private Integer numeroComision;
	private Materia materia; 
	private Aula aula;
	private CicloLectivo cl;
	private ArrayList<Profesor> profesores;
	private ArrayList<Alumno> alumnos;
	private ArrayList <RegistroNota> registros;
	
	public Comision(Integer numeroComision, Turno turno, Materia materia, CicloLectivo cl, Aula aula) {
		this.numeroComision=numeroComision;
		this.turno=turno;
		this.materia = materia;
		this.aula = aula;
		this.cl=cl;
		this.profesores= new ArrayList<>();
		this.alumnos= new ArrayList<>();
		this.registros= new ArrayList <>();
	}


	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}


	public Integer getNumeroComision() {
		return numeroComision;
	}

	public void setNumeroComision(Integer numeroComision) {
		this.numeroComision = numeroComision;
	}

	public Materia getMateria() {
		return materia;
	}


	public void setMateria(Materia materia) {
		this.materia = materia;
	}


	public CicloLectivo getCl() {
		return cl;
	}


	public void setCl(CicloLectivo cl) {
		this.cl = cl;
	}


	public Aula getAula() {
		return aula;
	}


	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}


	public void setProfesores(ArrayList<Profesor> prof) {
		this.profesores = prof;
	}
	
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	

	public ArrayList<RegistroNota> getRegistros() {
		return registros;
	}

	public void setRegistros(ArrayList<RegistroNota> registros) {
		this.registros = registros;
	}

	public Boolean agregarProfesorAlCurso(Profesor prof) {
		Profesor profe = buscarProfesorEnLaComision(prof); //SI EL MISMO PROFE NO ESTA REGISTRADO EN ESE MISMO CURSO
		if(profe==null) {
			return profesores.add(prof);
		}
		return false;
	}


	private Profesor buscarProfesorEnLaComision(Profesor prof) {
		for (Profesor profesor : profesores) {
			if(profesor.getId().equals(prof.getId())) {
				return profesor;
			}
		}
		return null;
	}


	public Boolean agregarAlumnoALaComision(Alumno alumno) {
		Alumno al= buscarAlumnoEnLaComision(alumno);
			if(al==null) {
				return alumnos.add(alumno);
			}
		
		return false;
		}
		
	
	public Alumno buscarAlumnoEnLaComision(Alumno alumno) {
		for (Alumno alumno2 : alumnos) {
			if((alumno2.getDni().equals(alumno.getDni()))) {
				return alumno2;
		}
	}
		return null;

}
	public Integer cantidadProfesoresEnLaComision(){
		return this.profesores.size();
	}
	
	public Integer cantidadAlumnosEnLaComision(){
		return this.alumnos.size();
	}


	public Boolean registrarNota(RegistroNota nuevaNota) {

        if(registros.size()==0) {
            return registros.add(nuevaNota);
        }else {

            if(!validarQueLaNotaNoExista(nuevaNota)) {
                return false;
            }

            return registros.add(nuevaNota);

        } 

    }
	
    
    public Boolean validarQueLaNotaNoExista(RegistroNota notaEvaluada) {
        for (RegistroNota rn : registros) {
            if (rn.getAlumno().getDni().equals(notaEvaluada.getAlumno().getDni()) &&
                rn.getNota().getTipoNota() == notaEvaluada.getNota().getTipoNota()) {
                return false; // Si se encuentra una coincidencia, retorna false
            }
        }
        return true; // Si no se encontraron coincidencias, retorna true (puede agregar la nota)
    }
}
