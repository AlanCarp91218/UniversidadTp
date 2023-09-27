package universidad;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaCrearUnaUniversidad() {
		
		String nombre= "UNLAM";
		
		Universidad unlam = new Universidad (nombre);

		assertNotNull(unlam);
}
	
	@Test
	public void queSePuedaRegistrarUnAlumnoAUnaUniversidad() {
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "Marta";
    	String apellido = "perez";
    	Integer dni= 1; 
    	Alumno alumno = new Alumno (dni,apellido, nombre);
    	
		Boolean registroExitoso = unlam.registrarAlumno(alumno);
		
    	assertTrue(registroExitoso);
    	
	}
	
	@Test
	public void queNoSePuedanRegistrarDosAlumnosConMismoDniALaUniversidad() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "Marta";
    	String apellido = "perez";
    	Integer dni= 3;
    	
    	Alumno alumno = new Alumno (dni,apellido, nombre);
    	Alumno alumno2 = new Alumno (dni,"Juan", "Perez");
    	
    	unlam.registrarAlumno(alumno);
		Boolean registroExitoso = unlam.registrarAlumno(alumno2);
		
    	assertFalse(registroExitoso);
}
	
	@Test
	public void queSePuedaRegistrarUnaMateriaALaUniversidad() {
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "PB2 ";
        Integer codigo = 1;
  
        Materia pb2 = new Materia (codigo,nombre);
        assertTrue (unlam.registraMateria(pb2));
    	       
	}
	
	@Test
	public void queNoSePuedaRegistrarDosMateriaConMismoIdALaUniversidad() {
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	nombre = "PB2 ";
        Integer codigo = 1;
  
        Materia pb2 = new Materia (codigo,nombre);
        
        Materia pb1 = new Materia (codigo,nombre);
        
        unlam.registraMateria(pb1);
        
        assertFalse (unlam.registraMateria(pb2));
    	       
	}
	
	@Test
	public void queSePuedaCrearUnCicloLectivo() {
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer idCiclo=1;
    	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
    	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
    	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 10);
    	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
    	
    	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
        
    	unlam.agregarCicloLectivo(cl);
   
    	assertNotNull (cl);
    	       
	}
	
	@Test
	public void queNoSePuedanAgregarDosCiclosLectivosConMismoId() {
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer idCiclo=1;
    	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
    	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
    	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 10);
    	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
    	
    	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
    	CicloLectivo cl2 = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);

    	unlam.agregarCicloLectivo(cl);

    	assertFalse(unlam.agregarCicloLectivo(cl2));
    	       
	}
	
	@Test
	public void queNoSePuedanAgregarDosCiclosLectivosSiSeSuperponenLasFechas() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer idCiclo=1;
    	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
    	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
    	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 10);
    	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
    	
    	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
    	
    	Integer idCiclo2=2;
    	LocalDate fechaInicioCiclo2= LocalDate.of(2023, 11, 19); //ES ANTERIOR A QUE TERMINE EL OTRO CICLO LECTIVO.
    	LocalDate fechaFinCiclo2= LocalDate.of(2024, 03, 10);
    	LocalDate fechaInicioInscripcion2= LocalDate.of(2023, 8, 10);
    	LocalDate fechaFinInscripcion2= LocalDate.of(2023, 8, 14);
    	
    	CicloLectivo cl2 = new CicloLectivo(idCiclo2,fechaInicioCiclo2,fechaFinCiclo2,fechaInicioInscripcion2,fechaFinInscripcion2);

    	unlam.agregarCicloLectivo(cl);

    	assertFalse(unlam.agregarCicloLectivo(cl2));
    	       
	}
	
	
	
	
	@Test
	public void queSePuedaCrearUnaComisionEnLaUniversidad() {
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer numeroComision= 1;
    	Turno turno= Turno.MAÑANA;
        Aula aula = new Aula (300,30);
        Materia pb2 = new Materia (1,"PB2");
        Integer idCiclo=1;
    	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
    	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
    	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 10);
    	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
    	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
    
        unlam.registraMateria(pb2);
     	
        Comision comision = new Comision (numeroComision, turno, pb2, cl, aula);
        
   
    	assertTrue (unlam.crearNuevaComision(comision));
    	       
	}
	
	@Test
	public void queNoSePuedaCrearDosComisionesConMismoNumeroDeComision() {
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer numeroComision= 1;
    	Turno turno= Turno.MAÑANA;
    	Integer idCiclo=1;
    	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
    	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
    	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 10);
    	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
    	
    	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
    	Aula aula = new Aula (300,30);
        Materia pb2 = new Materia (1,"PB2");

        unlam.registraMateria(pb2);
     	
        Comision comision = new Comision (numeroComision, turno, pb2, cl, aula);

    	unlam.crearNuevaComision(comision);
    	
    	Materia pb1 = new Materia (3,"PB1");
    	unlam.registraMateria(pb1);
    	
        Comision comision2 = new Comision (1, turno, pb1, cl, aula);
        
        assertFalse(unlam.crearNuevaComision(comision2));
    	       
	}
	
	@Test
	public void queNoSePuedaCrearDosComisionesConMismaMateriaTurnoYCicloLectivo() {
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer numeroComision= 1;
    	Turno turno= Turno.MAÑANA;
    	Integer idCiclo=1;
    	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
    	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
    	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 10);
    	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
    	
    	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
    	Aula aula = new Aula (300,30);
        Materia pb2 = new Materia (1,"PB2");

        unlam.registraMateria(pb2);
     	
        Comision comision = new Comision (numeroComision, turno, pb2, cl, aula);

    	unlam.crearNuevaComision(comision);
    	
    	Materia pb1 = new Materia (3,"PB1");
    	unlam.registraMateria(pb1);
    	
        Comision comision2 = new Comision (2, turno, pb2, cl, aula);
        
        assertFalse(unlam.crearNuevaComision(comision2));
    	       
	}
	
	@Test
	public void queSePuedaRegistrarUnProfesorALaUniversidad() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer id= 1;
    	String nombre2 = "Juan";
    	String apellido= "Perez";
    	Integer edad= 35;
    	
    	Profesor prof = new Profesor (id,nombre2,apellido,edad);
    	
    	Boolean exitoso= unlam.registrarProfesor(prof); //AGREGA PROFESOR AL SISTEMA DE LA UNIVERSIDAD
    	
    	assertTrue(exitoso);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosProfesoresConMismoDniALaUniversidad() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer id= 1;
    	String nombre2 = "Juan";
    	String apellido= "Perez";
    	Integer edad= 35;
    	
    	Profesor prof = new Profesor (id,nombre2,apellido,edad);
    	Profesor prof2 = new Profesor (id,"alan","dominguez",20);

    	unlam.registrarProfesor(prof);
    	
    	Boolean exitoso= unlam.registrarProfesor(prof2); //AGREGA PROFESOR AL SISTEMA DE LA UNIVERSIDAD
    	
    	assertFalse(exitoso);
	}
	
	@Test
	public void queSePuedaAsignarUnProfesorAUnaComision() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer codigoComision= 1;
        Aula aula = new Aula (300,30);
        Materia pb2 = new Materia (1,"PB2");
        Turno turno= Turno.MAÑANA;
        
        Integer idCiclo=1;
    	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
    	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
    	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 10);
    	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
    	
    	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
        unlam.registraMateria(pb2);
     	
        Comision comision = new Comision (codigoComision, turno , pb2, cl, aula);

    	unlam.crearNuevaComision(comision);
	
    	Integer id= 1;
    	String nombre2 = "Juan";
    	String apellido= "Perez";
    	Integer edad= 35;
    	
    	Profesor prof = new Profesor (id,nombre2,apellido,edad);
    	
    	unlam.registrarProfesor(prof); //AGREGA PROFESOR AL SISTEMA DE LA UNIVERSIDAD
    	    	
    	Boolean exitoso= unlam.asignarProfesor(prof,comision); //ASIGNA ESE PROFESOR AL CURSO
    	
    	assertTrue(exitoso);
    	       
	}
	
	@Test
	public void queNoSePuedaAsignarElMismoProfesorALaMismaComisionDosVeces() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer codigoComision= 1;
        Aula aula = new Aula (300,30);
        Materia pb2 = new Materia (1,"PB2");
        Turno turno= Turno.MAÑANA;
        
        Integer idCiclo=1;
    	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
    	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
    	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
    	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
    	
    	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
        unlam.registraMateria(pb2);
     	
        Comision comision = new Comision (codigoComision, turno , pb2, cl, aula);

    	unlam.crearNuevaComision(comision);
	
    	Integer id= 1;
    	String nombre2 = "Juan";
    	String apellido= "Perez";
    	Integer edad= 35;
    	
    	Profesor prof = new Profesor (id,nombre2,apellido,edad);
    	
    	Alumno alumno = new Alumno (1,"Alan","Dominguez");
    	Alumno alumno2 = new Alumno (2,"Alancito","Dominguez");
    	LocalDate fecha= LocalDate.of(2023, 8, 10);
    	unlam.registrarAlumno(alumno);
    	unlam.registrarAlumno(alumno2);
    	
    	unlam.asignarAlumnoALaComision(alumno, comision, fecha); 
    	unlam.asignarAlumnoALaComision(alumno2, comision, fecha);
    	
    	unlam.registrarProfesor(prof); //AGREGA PROFESOR AL SISTEMA DE LA UNIVERSIDAD
    	    	
    	unlam.asignarProfesor(prof, comision);
    	
    	Boolean exitoso= unlam.asignarProfesor(prof,comision); //ASIGNA ESE PROFESOR AL CURSO
    	
    	assertFalse(exitoso);
    	       
	}
	
	@Test
	public void queSePuedaInscribirUnAlumnoAUnComision() { //TODOS DATOS CORRECTOS
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer codigoCurso= 1;
    	 Integer idCiclo=1;
     	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
     	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
     	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
     	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
     	Turno turno= Turno.MAÑANA;     	
     	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
        Aula aula = new Aula (300,65);
        Materia pb2 = new Materia (1,"PB2");
     	
        Comision comision = new Comision (codigoCurso, turno, pb2, cl, aula);

    	unlam.crearNuevaComision(comision);
	
    	Integer id= 1;
    	String nombre2 = "Juan";
    	String apellido= "Perez";
    	
    	Alumno alumno = new Alumno (id,nombre2,apellido);
    	LocalDate fechaInscripcion = LocalDate.of(2023, 8, 10);
    	
    	unlam.registrarAlumno(alumno);
    	
    	Boolean exitoso= unlam.asignarAlumnoALaComision(alumno,comision,fechaInscripcion);
    	
    	assertTrue(exitoso);
    	       
	}
	
	@Test
	public void queNoSePuedaInscribirAUnAlumnoSiEstaFueraDeFechaDeInscripcion() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer codigoCurso= 1;
    	 Integer idCiclo=1;
     	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
     	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
     	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
     	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
     	Turno turno= Turno.MAÑANA;     	
     	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
        Aula aula = new Aula (300,65);
        Materia pb2 = new Materia (1,"PB2");
     	
        Comision comision = new Comision (codigoCurso, turno, pb2, cl, aula);

    	unlam.crearNuevaComision(comision);
    	
    	Comision comision2 = new Comision (codigoCurso, turno, pb2, cl, aula);

     	unlam.crearNuevaComision(comision2);
	
    	Integer id= 1;
    	String nombre2 = "Juan";
    	String apellido= "Perez";
    	
    	Alumno alumno = new Alumno (id,nombre2,apellido);
    	LocalDate fechaInscripcion = LocalDate.of(2023, 8, 15); //FUERA DEL LIMITE DE INSCRIPCION
    	
    	unlam.registrarAlumno(alumno);
    	
    	unlam.asignarAlumnoALaComision(alumno,comision,fechaInscripcion);
    	
    	Boolean exitoso= unlam.asignarAlumnoALaComision(alumno,comision,fechaInscripcion);
    	
    	assertFalse(exitoso);
    	       
	}
	
	@Test
	public void queNoSePuedaInscribirUnAlumnoSiExcedeLaCapacidadMaximaEnElAula() { //TODOS DATOS CORRECTOS
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer codigoCurso= 1;
    	 Integer idCiclo=1;
     	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
     	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
     	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
     	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
     	Turno turno= Turno.MAÑANA;     	
     	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
        Aula aula = new Aula (300,1);
        Materia pb2 = new Materia (1,"PB2");
     	
        Comision comision = new Comision (codigoCurso, turno, pb2, cl, aula);

    	unlam.crearNuevaComision(comision);
	
    	Integer id= 1;
    	String nombre2 = "Juan";
    	String apellido= "Perez";
    	
    	Alumno alumno = new Alumno (id,nombre2,apellido);
    	LocalDate fechaInscripcion = LocalDate.of(2023, 8, 10);
    	
    	unlam.registrarAlumno(alumno);

    	Alumno alumno2 = new Alumno (2,"alan","dominguez");
    	unlam.registrarAlumno(alumno2);
    	unlam.asignarAlumnoALaComision(alumno,comision,fechaInscripcion);
    	Boolean exitoso= unlam.asignarAlumnoALaComision(alumno2,comision,fechaInscripcion);
    	
    	assertFalse(exitoso);
    	       
	}
	
	
	@Test
	public void queSePuedaAgregarUnaMateriaCorrelativa() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	nombre = "PB1";
        Integer codigo = 1;
        Materia pb1 = new Materia (codigo, nombre);
        
        unlam.registraMateria(pb1);
        
        nombre = "PB2";
        
       
        Materia pb2 = new Materia (2, nombre);
        
        unlam.registraMateria(pb2);
        unlam.agregarCorrelativa(pb2,pb1);

        ArrayList<Materia> correlativas2 = pb2.getCorrelativas();
        
        assertTrue(correlativas2.contains(pb1));
	}
	
	@Test
	public void queSePuedaEliminarUnaCorrelatividad() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	nombre = "PB1";
        Integer codigo = 1;
        Materia pb1 = new Materia (codigo, nombre);
        
        unlam.registraMateria(pb1);
        
        nombre = "PB2";
         
        Materia pb2 = new Materia (2, nombre);
        
        unlam.registraMateria(pb2);
        unlam.agregarCorrelativa(pb2,pb1);
        
        unlam.eliminarCorrelativa(pb2,pb1);

        ArrayList<Materia> correlativas2 = pb2.getCorrelativas();
        
        assertFalse(correlativas2.contains(pb1));
	}
	
	@Test
	public void queSePuedaRegistrarUnaNotaDeUnAlumno() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer codigoComision= 1;
    	Integer idCiclo=1;
     	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
     	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
     	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
     	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
     	Turno turno= Turno.MAÑANA;     	
     	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
        Aula aula = new Aula (300,65);
        Materia pb2 = new Materia (1,"PB2");
     	
        Comision comision = new Comision (codigoComision, turno, pb2, cl, aula);

    	unlam.crearNuevaComision(comision);
	
    	Integer id= 1;
    	String nombre2 = "Juan";
    	String apellido= "Perez";
    	
    	Alumno alumno = new Alumno (id,nombre2,apellido);
    	
    	unlam.registrarAlumno(alumno);
    	
    	Nota primerNota = new Nota (TipoNota.PRIMER_PARCIAL,9);
    	Nota primerNota2 = new Nota (TipoNota.SEGUNDO_PARCIAL,10);
    	
    	unlam.registrarNota(alumno,comision,primerNota);
    	Boolean exitoso= unlam.registrarNota(alumno,comision,primerNota2);
    	
    	assertTrue(exitoso);
    	       
	}
	
	@Test
	public void queNoSePuedaRegistrarDosNotasDelMismoTipo() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer codigoComision= 1;
    	Integer idCiclo=1;
     	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
     	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
     	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
     	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
     	Turno turno= Turno.MAÑANA;     	
     	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
        Aula aula = new Aula (300,65);
        Materia pb2 = new Materia (1,"PB2");
     	
        Comision comision = new Comision (codigoComision, turno, pb2, cl, aula);

    	unlam.crearNuevaComision(comision);
	
    	Integer id= 1;
    	String nombre2 = "Juan";
    	String apellido= "Perez";
    	
    	Alumno alumno = new Alumno (id,nombre2,apellido);
    	
    	unlam.registrarAlumno(alumno);
    	
    	Nota primerNota = new Nota (TipoNota.PRIMER_PARCIAL,9);
    	Nota primerNota2 = new Nota (TipoNota.PRIMER_PARCIAL,10);
    	
    	unlam.registrarNota(alumno,comision,primerNota);
    	Boolean exitoso= unlam.registrarNota(alumno,comision,primerNota2);
    	
    	assertFalse(exitoso);
    	       
	}
	
	@Test
	public void queNoSePuedaRegistrarDosRecuperatorios() {
		
		String  nombre = "Unlam";
    	Universidad unlam = new Universidad (nombre);
    	
    	Integer codigoComision= 1;
    	Integer idCiclo=1;
     	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
     	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
     	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
     	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
     	Turno turno= Turno.MAÑANA;     	
     	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
        Aula aula = new Aula (300,65);
        Materia pb2 = new Materia (1,"PB2");
     	
        Comision comision = new Comision (codigoComision, turno, pb2, cl, aula);

    	unlam.crearNuevaComision(comision);
	
    	Integer id= 1;
    	String nombre2 = "Juan";
    	String apellido= "Perez";
    	
    	Alumno alumno = new Alumno (id,nombre2,apellido);
    	
    	unlam.registrarAlumno(alumno);
    	
    	Nota primerNota = new Nota (TipoNota.PRIMER_PARCIAL,10);
    	Nota primerNota2 = new Nota (TipoNota.SEGUNDO_PARCIAL,4);
    	Nota primerNota3 = new Nota (TipoNota.RECUPERATORIO1PARCIAL,6);
    	Nota primerNota4 = new Nota (TipoNota.RECUPERATORIO2PARCIAL,6);
    	
    	unlam.registrarNota(alumno,comision,primerNota);
    	unlam.registrarNota(alumno,comision,primerNota2);
    	unlam.registrarNota(alumno,comision,primerNota3);

    	Boolean exitoso= unlam.registrarNota(alumno,comision,primerNota4);
    	
    	assertFalse(exitoso);
	}
	
    	@Test
    	public void queNoSePuedaRegistrarUnaNotaMenorA1oMayorA10() {
    		
    		String  nombre = "Unlam";
        	Universidad unlam = new Universidad (nombre);
        	
        	Integer codigoComision= 1;
        	Integer idCiclo=1;
         	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
         	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
         	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
         	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
         	Turno turno= Turno.MAÑANA;     	
         	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
            Aula aula = new Aula (300,65);
            Materia pb2 = new Materia (1,"PB2");
         	
            Comision comision = new Comision (codigoComision, turno, pb2, cl, aula);

        	unlam.crearNuevaComision(comision);
    	
        	Integer id= 1;
        	String nombre2 = "Juan";
        	String apellido= "Perez";
        	
        	Alumno alumno = new Alumno (id,nombre2,apellido);
        	
        	unlam.registrarAlumno(alumno);
        	
        	Nota primerNota = new Nota (TipoNota.PRIMER_PARCIAL,91218); //REGISTRO DE NOTA FUERA DE RANGO
        	
        	Boolean exitoso= unlam.registrarNota(alumno,comision,primerNota);
        	
        	assertFalse(exitoso);
	
	}
    	
    	@Test
    	public void queSePuedaoObtenerElPromedioDeUnAlumno() { //TODOS DATOS CORRECTOS
    															//FUNCION MATH.ROUND IMPLEMENTADA PARA REDONDEAR PROMEDIO HACIA ARRIBA
    		String  nombre = "Unlam";
        	Universidad unlam = new Universidad (nombre); 	
        	Integer codigoCurso= 1;
        	Integer idCiclo=1;
         	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
         	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
         	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
         	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
         	Turno turno= Turno.MAÑANA;     	
         	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
            Aula aula = new Aula (300,65);
            Materia pb2 = new Materia (1,"PB2");
         	
            Comision comision = new Comision (codigoCurso, turno, pb2, cl, aula);

        	unlam.crearNuevaComision(comision);
    	
        	Integer id= 1;
        	String nombre2 = "Juan";
        	String apellido= "Perez";
        	
        	Alumno alumno = new Alumno (id,nombre2,apellido);
        	LocalDate fechaInscripcion = LocalDate.of(2023, 8, 10);
        	
        	unlam.registrarAlumno(alumno);
            unlam.asignarAlumnoALaComision(alumno,comision,fechaInscripcion);

        	Nota primerNota = new Nota (TipoNota.PRIMER_PARCIAL,7);
        	Nota segundaNota = new Nota (TipoNota.SEGUNDO_PARCIAL,10);
        	
        	unlam.registrarNota(alumno, comision, primerNota);
        	unlam.registrarNota(alumno, comision, segundaNota);
        	Integer exitoso= unlam.calcularPromedio(alumno,comision);
        	
        	assertEquals(9, exitoso,0.01);
    	}
    	
    	@Test
    	public void queSePuedaoObtenerLasNotasDeUnAlumnoEnUnaComision() { //TODOS DATOS CORRECTOS
    															//FUNCION MATH.ROUND IMPLEMENTADA PARA REDONDEAR PROMEDIO HACIA ARRIBA
    		String  nombre = "Unlam";
        	Universidad unlam = new Universidad (nombre);
        	
        	Integer codigoCurso= 1;
        	 Integer idCiclo=1;
         	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
         	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
         	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
         	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
         	Turno turno= Turno.MAÑANA;     	
         	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
            Aula aula = new Aula (300,65);
            Materia pb2 = new Materia (1,"PB2");
         	
            Comision comision = new Comision (codigoCurso, turno, pb2, cl, aula);

        	unlam.crearNuevaComision(comision); //REGISTRO COMISION
    	
        	Integer id= 1;
        	String nombre2 = "Juan";
        	String apellido= "Perez";
        	
        	Alumno alumno = new Alumno (id,nombre2,apellido);
        	LocalDate fechaInscripcion = LocalDate.of(2023, 8, 10);
        	
        	unlam.registrarAlumno(alumno); //REGISTRO ALUMNO AL SISTEMA
            unlam.asignarAlumnoALaComision(alumno,comision,fechaInscripcion); //ASIGNO ALUMNO A COMISION

        	Nota primerNota = new Nota (TipoNota.PRIMER_PARCIAL,7);  
        	Nota segundaNota = new Nota (TipoNota.SEGUNDO_PARCIAL,10);
        	
        	unlam.registrarNota(alumno, comision, primerNota);
        	unlam.registrarNota(alumno, comision, segundaNota);
        	
        	ArrayList <RegistroNota> comi = comision.getRegistros();
        	ArrayList<RegistroNota> exitoso= unlam.obtenerNota(alumno, comision);
        	
        	assertEquals(exitoso,comi); 
     }
    	
    	@Test
    	public void queSePuedaoObtenerLasMateriasQueAproboElAlumno() { //TODOS DATOS CORRECTOS
    															//FUNCION MATH.ROUND IMPLEMENTADA PARA REDONDEAR PROMEDIO HACIA ARRIBA
    		String  nombre = "Unlam";
        	Universidad unlam = new Universidad (nombre);
        	
        	Integer codigoCurso= 1;
        	 Integer idCiclo=1;
         	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
         	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
         	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
         	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
         	Turno turno= Turno.MAÑANA;     	
         	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
            Aula aula = new Aula (300,65);
            Materia pb2 = new Materia (1,"PB2");
         	
            Comision comision = new Comision (codigoCurso, turno, pb2, cl, aula);

        	unlam.crearNuevaComision(comision); //REGISTRO COMISION
    	
        	Integer id= 1;
        	String nombre2 = "Juan";
        	String apellido= "Perez";
        	
        	Alumno alumno = new Alumno (id,nombre2,apellido);
        	LocalDate fechaInscripcion = LocalDate.of(2023, 8, 10);
        	
        	unlam.registrarAlumno(alumno); //REGISTRO ALUMNO AL SISTEMA
            unlam.asignarAlumnoALaComision(alumno,comision,fechaInscripcion); //ASIGNO ALUMNO A COMISION

        	Nota primerNota = new Nota (TipoNota.PRIMER_PARCIAL,7);  
        	Nota segundaNota = new Nota (TipoNota.SEGUNDO_PARCIAL,10);
        	
        	unlam.registrarNota(alumno, comision, primerNota);
        	unlam.registrarNota(alumno, comision, segundaNota);
        	
        	//------------------------//
            Materia pb1 = new Materia (5,"PB1");
        	Comision comision2 = new Comision (2, turno, pb1, cl, aula);

         	unlam.crearNuevaComision(comision2); //REGISTRO COMISION
         	
         	
         	unlam.registrarAlumno(alumno); //REGISTRO ALUMNO AL SISTEMA
            unlam.asignarAlumnoALaComision(alumno,comision2,fechaInscripcion); //ASIGNO ALUMNO A COMISION

         	Nota primerNota2 = new Nota (TipoNota.PRIMER_PARCIAL,7);  
         	Nota segundaNota2 = new Nota (TipoNota.SEGUNDO_PARCIAL,10);
         	
         	unlam.registrarNota(alumno, comision2, primerNota2);
         	unlam.registrarNota(alumno, comision2, segundaNota2);
        	
         	unlam.aproboLaMateria(alumno, comision);
         	unlam.aproboLaMateria(alumno, comision2);
         	
        	ArrayList <Materia> materiasAprobadas = alumno.getMateriasAprobadas();
        	
        	assertTrue(materiasAprobadas.contains(pb1));
        	assertTrue(materiasAprobadas.contains(pb2));
        	       
    	}
	
    	
    	@Test
    	public void queSePuedaObtenerUnaListaDeMateriasFaltantesDeCursarParaUnAlumno() { //TODOS DATOS CORRECTOS
    															//FUNCION MATH.ROUND IMPLEMENTADA PARA REDONDEAR PROMEDIO HACIA ARRIBA
    		String  nombre = "Unlam";
        	Universidad unlam = new Universidad (nombre);
        	
        	Integer codigoCurso= 1;
        	 Integer idCiclo=1;
         	LocalDate fechaInicioCiclo= LocalDate.of(2023, 8, 20);
         	LocalDate fechaFinCiclo= LocalDate.of(2023, 11, 20);
         	LocalDate fechaInicioInscripcion= LocalDate.of(2023, 8, 7);
         	LocalDate fechaFinInscripcion= LocalDate.of(2023, 8, 14);
         	Turno turno= Turno.MAÑANA;     	
         	CicloLectivo cl = new CicloLectivo(idCiclo,fechaInicioCiclo,fechaFinCiclo,fechaInicioInscripcion,fechaFinInscripcion);
            Aula aula = new Aula (300,65);
            Materia pb2 = new Materia (1,"PB2");
         	
            Materia pb1 = new Materia (2,"PB1");
            Materia base = new Materia (3,"BDD");

            unlam.registraMateria(pb2);
            unlam.registraMateria(base);
            unlam.registraMateria(pb1);
            
            Comision comision = new Comision (codigoCurso, turno, pb2, cl, aula);

        	unlam.crearNuevaComision(comision); //REGISTRO COMISION
    	
        	Integer id= 1;
        	String nombre2 = "Juan";
        	String apellido= "Perez";
        	
        	Alumno alumno = new Alumno (id,nombre2,apellido);
        	LocalDate fechaInscripcion = LocalDate.of(2023, 8, 10);
        	
        	unlam.registrarAlumno(alumno); //REGISTRO ALUMNO AL SISTEMA
            unlam.asignarAlumnoALaComision(alumno,comision,fechaInscripcion); //ASIGNO ALUMNO A COMISION

        	Nota primerNota = new Nota (TipoNota.PRIMER_PARCIAL,7);  
        	Nota segundaNota = new Nota (TipoNota.SEGUNDO_PARCIAL,10);
        	
        	unlam.registrarNota(alumno, comision, primerNota);
        	unlam.registrarNota(alumno, comision, segundaNota);
        	unlam.aproboLaMateria(alumno, comision);
        	
        	ArrayList <Materia> materias = unlam.obtenerMateriasFaltantes(alumno);
        	
        	//------------------------//
          
        	assertTrue(materias.contains(pb1));
        	assertFalse(materias.contains(pb2));
        	assertTrue(materias.contains(base));
      
    	}
	  	
}