import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivisionCurso {

    private int codigo;
    private int anio;
    private int division;
    private Escuela escuela;
    private List<Catedra> catedras = new ArrayList<>();

    public DivisionCurso() {
    }

    public DivisionCurso(int codigo, int anio, int division) {
        this.codigo = codigo;
        this.anio = anio;
        this.division = division;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public List<Catedra> getCatedras() {
        return catedras;
    }

    public void setCatedras(List<Catedra> catedras) {
        this.catedras = catedras;
    }


    public Alumno mejorAlumnoDivisionCurso() {
        Alumno mejorAlumno = null;
        double mejorPromedio = -1;


        Map<Alumno, List<Double>> alumnoNotasMap = new HashMap<>();


        for (Catedra catedra : catedras) {
            for (Alumno alumno : catedra.getAlumnos()) {

                for (Nota nota : alumno.getNotas()) {
                    if (!nota.isEsRecuperatorio()) {
                        alumnoNotasMap.putIfAbsent(alumno, new ArrayList<>());
                        alumnoNotasMap.get(alumno).add(nota.getValor());
                    }
                }
            }
        }


        for (Map.Entry<Alumno, List<Double>> entry : alumnoNotasMap.entrySet()) {
            Alumno alumno = entry.getKey();
            List<Double> notas = entry.getValue();

            if (notas.size() >= 5) {
                double promedio = notas.stream().mapToDouble(Double::doubleValue).average().orElse(0);

                if (promedio > mejorPromedio) {
                    mejorPromedio = promedio;
                    mejorAlumno = alumno;
                }
            }
        }

        return mejorAlumno;
    }
}
