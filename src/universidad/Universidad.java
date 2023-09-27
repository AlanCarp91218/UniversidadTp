package universidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Universidad {
	
	private ArrayList <Profesor> profesores;
	private ArrayList <Comision> comisiones;
	private ArrayList <Materia> materias;
	private ArrayList <Alumno> alumnos;
	private ArrayList <CicloLectivo> ciclosLectivos;
	private String nombre;
	

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos= new ArrayList<>();
		this.materias= new ArrayList<>();
		this.comisiones= new ArrayList<>();
		this.profesores= new ArrayList<>();
		this.ciclosLectivos=  new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean registrarAlumno(Alumno alumno) {
		if (!(this.alumnos.contains(alumno))) {
			return this.alumnos.add(alumno);
		}
		return false;
	}

	
	private Alumno buscarAlumnoPorDni(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if(alumnos.get(i).getDni().equals(dni)) {
				return alumnos.get(i);
			}
		}
		return null;	
	}
		
	
	public Boolean existeAlumno(Alumno alumno) {
		if(alumnos.contains(alumno)) {
			return true;
		}
		return false;
	}
	
	private Materia buscarMateriaPorCodigo(Integer codigo) {
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getCodigo().equals(codigo)) {
				return materias.get(i);
			}
		}
		return null;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public boolean registraMateria(Materia materia) {
			if(buscarMateriaPorCodigo(materia.getCodigo())==null) {
			return this.materias.add(materia);
		}
			return false;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	public ArrayList<Comision> getCursos() {
		return comisiones;
	}

	public void setCursos(ArrayList<Comision> cursos) {
		this.comisiones = cursos;
	}
	
	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	public ArrayList<CicloLectivo> getCiclosLectivos() {
		return ciclosLectivos;
	}

	public void setCiclosLectivos(ArrayList<CicloLectivo> ciclosLectivos) {
		this.ciclosLectivos = ciclosLectivos;
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(ArrayList<Comision> comisiones) {
		this.comisiones = comisiones;
	}

	//-------------------------------------------------------//

	public boolean inscribirAlumnoAUnaMateria(Integer dni, Integer codigo) {
		Alumno alumno= buscarAlumnoPorDni(dni);
		Materia materia = buscarMateriaPorCodigo(codigo);
		
		if(alumno!=null&&materia!=null) {
			
		}
		return false;
	}

	public Comision buscarComisionPorNumero(Comision comision) {
		for (Comision curso2 : comisiones) {
			if(curso2.getNumeroComision().equals(comision.getNumeroComision())) {
					return curso2;
			}
		}
	return null;
	}
	
	public Boolean crearNuevaComision(Comision comision) {
		for (Comision comision2 : comisiones) {
			if(comision2.getNumeroComision().equals(comision.getNumeroComision())||
				(comision2.getMateria().equals(comision.getMateria())&&
				comision2.getTurno().equals(comision.getTurno())&& 
				comision2.getCl().equals(comision.getCl()))) {
					return false;
			
			}
		}
		
	return this.comisiones.add(comision);
	}
	
	private Boolean existeComision(Comision comision) {
		if(comisiones.contains(comision)) {
			return true;
		}
		return false;
	}

	
	public Boolean asignarProfesor(Profesor prof, Comision comision) {
		Profesor profe = buscarProfesorPorId(prof.getId());
		Comision cursoBuscado = buscarComisionPorNumero(comision);
		if (profe!=null&&cursoBuscado!=null) {
			if(sePuedeRegistrarProfesor(comision)==true){ //VERIFICA CANTIDAD DE PROFES Y ALUMNOS EN EL CURSO
				return comision.agregarProfesorAlCurso(prof);		
			}
			}
		
			return false;
		
		}

	private boolean sePuedeRegistrarProfesor(Comision curso) { //DEPENDE DE LA CANTIDAD DE ALUMNOS EN EL CURSO.

		if(curso.cantidadAlumnosEnLaComision()<=1&&curso.cantidadProfesoresEnLaComision()==0) {
			return true;
		}
		
		if(curso.cantidadAlumnosEnLaComision()>=2&&curso.cantidadAlumnosEnLaComision()<=3 &&
				curso.cantidadProfesoresEnLaComision()<=1) {
			return true;
		}

		if(curso.cantidadAlumnosEnLaComision()>=4&&curso.cantidadAlumnosEnLaComision()<=60 && 	
				curso.cantidadProfesoresEnLaComision()<=2) {
			return true;
		}
		
		return false;
	}
	
	public Boolean registrarProfesor(Profesor prof) {
		if (buscarProfesorPorId(prof.getId()) == null) {
			return this.profesores.add(prof);
		}
		return false;
	}

	
	
	private Profesor buscarProfesorPorId(Integer id) {
		for (int i = 0; i < profesores.size(); i++) {
			if (profesores.get(i).getId().equals(id)) {
				return profesores.get(i);
			}
		}
		
		return null;
	}
	public Boolean asignarAlumnoALaComision(Alumno alumno, Comision comision, LocalDate fechaInscripcion) {
		if(saberSiTieneSusCorrelativasAprobadas(alumno, comision.getMateria())==true) {
		if(buscarAlumnoEnComision(alumno, comision)==null){
		Alumno al = buscarAlumnoPorDni(alumno.getDni());
		Comision comision2 = buscarComisionPorNumero(comision);
		if(verificarFechaInscripcion(comision,fechaInscripcion)==true) {
		
		if(al!=null && comision2 !=null) {
			if(comision2.getAula().getCapacidad()>comision2.getAlumnos().size()) {
				comision2.agregarAlumnoALaComision(alumno);
			return true;
				
		}
			}
		}
		}
		}
		return false;
	}

	private Boolean verificarFechaInscripcion(Comision curso, LocalDate fechaInscripcion) {
		if(fechaInscripcion.isAfter(curso.getCl().getFechaInicioInscripcion())&&
				fechaInscripcion.isBefore(curso.getCl().getFechaFinInscripcion())){
				return true;
		}
		return false;
	}

	
	//--------------METODOS CICLO LECTIVO----------------------//

	public Boolean agregarCicloLectivo(CicloLectivo cl) {
		if(buscarCicloLectivoPorId(cl.getIdCiclo())==null) {
			if(seSuperponenFechas(cl)==false) {
			return this.ciclosLectivos.add(cl);
 
		}
		}
		return false;
		
	}
	
	private Boolean seSuperponenFechas(CicloLectivo cl) {
		for (CicloLectivo cicloLectivo : ciclosLectivos) {
				if(cl.getFechaIncioCiclo().isBefore(cicloLectivo.getFechaFinCiclo()) ||
						(cl.getFechaFinCiclo().isAfter(cicloLectivo.getFechaIncioCiclo())&&
						cl.getFechaFinCiclo().isBefore(cicloLectivo.getFechaFinCiclo()))) {
					return true;
				}
			}
		return false;
	}

	private CicloLectivo buscarCicloLectivoPorId (Integer id) {
		for (CicloLectivo cicloLectivo : ciclosLectivos) {
			if(cicloLectivo.getIdCiclo().equals(id)) {
				return cicloLectivo;
			}
		}
		return null;
	}

	public void agregarCorrelativa(Materia pb2, Materia pb1) {
		Materia base= buscarMateriaPorCodigo(pb2.getCodigo());
		Materia correlativa= buscarMateriaPorCodigo(pb1.getCodigo());
		
		if(base!=null&&correlativa!=null) {
			pb2.agregarCorrelativa(pb1);		
		}
		
	}

	public Boolean eliminarCorrelativa(Materia pb2, Materia pb1) {
		if(pb2.eliminarCorrelativa(pb2,pb1)==true) {
			return true;
		}
		return false;
	}

	
	//---------------------------METODOS REGISTRO DE NOTAS ---------------------------- //
	
	public Boolean registrarNota(Alumno alumno, Comision comision, Nota nota) {
		Integer valTipoNota = 0;
		Boolean validacionNotasMayoresA7 = false;
        if(!existeComision(comision)) { //SI LA COMISION NO EXISTE ARROJA FALSE
        return false;
        }
        if(!existeAlumno(alumno)) { // SI EL ALUMNO NO EXISTE ARROJA FALSE.
            return false;
        }
        if(nota.getValor()>10||nota.getValor()<1) { //SI LA NOTA NO ESTA ENTRE 1 Y 10 ARROJA FALSE
        	return false;
        }
        if(nota.getValor()>= 7 && nota.getTipoNota()==TipoNota.FINAL) { //SI RINDE FINAL Y NO TIENE SUS CORRELATIVAS APROBADAS, ARROJA FALSE.
        	if(saberSiTieneSusCorrelativasAprobadas(alumno, comision.getMateria())==false) {
        		return false;
        	}
        }
        
        if(nota.getTipoNota()==TipoNota.RECUPERATORIO2PARCIAL) { //SI RINDE RECUPERATORIO DEL SEGUNDO PARCIAL CUANDO RINDIO EL PRIMERO PREVIAMENTE, ARROJA FALSE.
        	for (RegistroNota rn : comision.getRegistros()) {
				if(rn.getAlumno()==alumno) {
					if(rn.getNota().getTipoNota()==TipoNota.RECUPERATORIO1PARCIAL) {
						return false;
					}
				}
			}
        }
        
        if(nota.getTipoNota()==TipoNota.FINAL) { //LOGICA SI FUERA FINAL
        	for (RegistroNota rn : comision.getRegistros()) {
				
        		if(rn.getAlumno()==alumno) {
					if(rn.getNota().getTipoNota()==TipoNota.PRIMER_PARCIAL) {
						valTipoNota = 1;
						if(rn.getNota().getValor()>=7) { //PRIMER PARCIAL MAYOR == A 7
							validacionNotasMayoresA7 = true;
						}else {
							validacionNotasMayoresA7 = false;
						}
					}
					if(rn.getNota().getTipoNota()==TipoNota.SEGUNDO_PARCIAL) {
						valTipoNota = 2;
						if(rn.getNota().getValor()>=7) { //SEGUNDO PARCIAL MAYOR == A 7
							validacionNotasMayoresA7 = true;
						}else {
							validacionNotasMayoresA7 = false;
						}
					}
					if(validacionNotasMayoresA7==false) {
						if(rn.getNota().getTipoNota()==TipoNota.RECUPERATORIO1PARCIAL||rn.getNota().getTipoNota()==TipoNota.RECUPERATORIO2PARCIAL) {
							valTipoNota = 3;
						}
					}
					
				}
		}
        	if(validacionNotasMayoresA7==true) {
        		if(valTipoNota!=2) {
        			return false;
        		}
        	}else {
        		if(valTipoNota!=3) {
        			return false;
        		}
        	}
        	
        	
        }

        Boolean valor = false;
        for (Comision co : comisiones) {
            if(co.getNumeroComision().equals(comision.getNumeroComision())) {

                valor = co.registrarNota(new RegistroNota(alumno,nota));

            }
        }

        return valor;


    }

	//-----------------METODOS CORRELATIVAS------------------------//
	private Boolean saberSiTieneSusCorrelativasAprobadas(Alumno alumno, Materia materia) {
		ArrayList<Materia> correlativas = materia.getCorrelativas();
        for (Materia correlativa : correlativas) {
            if (alumno.getCorrelativasAprobadas().contains(correlativa)) {
                return true;
            }
        }
        if(correlativas.size()==0) {
        	return true;
        }
        return false;
    }
	
	public ArrayList <RegistroNota> obtenerNota (Alumno alumno, Comision comision) {
		Alumno al=buscarAlumnoEnComision(alumno,comision);
		Comision comi = buscarComisionPorNumero(comision);
		if(al!=null&&comi!=null) {
		for (Comision co : comisiones) {
			for (Alumno alumno2 : alumnos) {
				if (co.getNumeroComision().equals(comision.getNumeroComision())) {
					if (alumno2.getDni().equals(alumno.getDni())) {
						return co.getRegistros();
					}
				}
			}
		}
		}
		return null;
	}
	
	public Alumno buscarAlumnoEnComision (Alumno alumno, Comision comision) {
		for (Comision comi : comisiones) {
			if(comi.getAlumnos().contains(alumno)) {
				return alumno;
			}
		}
		return null;
	}
	
	
	public Integer calcularPromedio(Alumno alumno, Comision comision) {
		Alumno al= buscarAlumnoPorDni(alumno.getDni());
		Comision com = buscarComisionPorNumero(comision);
		
		if(al!=null&&com!=null) {

		Double totalNota = 0.0;
		 Integer cantidadNotas = 0;

		    for(RegistroNota registro : comision.getRegistros()) {
		      if(registro.getAlumno().getDni().equals(alumno.getDni())) {
		         if(registro.getNota().getValor()!=null) {
		            totalNota+=registro.getNota().getValor();
		             cantidadNotas++;
		  }
		    }
	 }
		        Double promedio = totalNota / cantidadNotas;
		        Integer redondeado= (int)Math.round(promedio);
		        return redondeado;
	}
		return 0;
		}
	

	public Boolean aproboLaMateria(Alumno alumno, Comision comision) {
		if(calcularPromedio(alumno,comision)>=7) {
			alumno.aprobarMateria(comision.getMateria());
			return true;
		} 
		
		return false;
	}

	public ArrayList <Materia> obtenerMateriasFaltantes(Alumno alumno) {
		ArrayList <Materia> faltantes = new ArrayList<>();
		for (Materia materia : materias) {
			if(!(alumno.getMateriasAprobadas().contains(materia))) {
				faltantes.add(materia);
			}
		}
		return faltantes;
			
		}	
	}