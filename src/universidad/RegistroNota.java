package universidad;

public class RegistroNota {

	private Alumno alumno;
	private Nota nota;
	
	public RegistroNota(Alumno alumno, Nota nota) {
		this.alumno=alumno;
		this.nota=nota;
	
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	
}
