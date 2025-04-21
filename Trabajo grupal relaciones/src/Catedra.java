import java.util.ArrayList;
import java.util.List;

public class Catedra {

    private int codigo;
    private String denominacion;
    private DivisionCurso divisionCurso;
    private List<Alumno> alumnos = new ArrayList<>();
    private List<Nota> notas = new ArrayList<>();

    public Catedra() {
    }

    public Catedra(int codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public DivisionCurso getDivisionCurso() {
        return divisionCurso;
    }

    public void setDivisionCurso(DivisionCurso divisionCurso) {
        this.divisionCurso = divisionCurso;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public double promedioNotas(List<Nota> notasAlumno, Integer codigoCatedra) {
        double sumaNotas = 0;
        int cantidadNotas = 0;

        for (Nota nota : notasAlumno) {
            if (codigoCatedra != null && codigoCatedra.equals(nota.getCatedra().getCodigo())) {
                sumaNotas += nota.getValor();
                cantidadNotas++;
            }
        }

        return (cantidadNotas > 0) ? sumaNotas / cantidadNotas : 0;
    }

    public Alumno mejorAlumnoCatedra() {
        Alumno mejorAlumno = null;
        double mejorPromedio = -1;

        for (Alumno alumno : alumnos) {
            List<Nota> notasAlumno = alumno.getNotas();
            double promedioAlumno = promedioNotas(notasAlumno, this.codigo);

            if (promedioAlumno > mejorPromedio) {
                mejorPromedio = promedioAlumno;
                mejorAlumno = alumno;
            }
        }

        return mejorAlumno;
    }
}
