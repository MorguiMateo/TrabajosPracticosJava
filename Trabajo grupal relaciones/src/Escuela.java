import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class Escuela {

    private int numero;
    private String denominacion;
    private List<DivisionCurso> divisionCursos = new ArrayList<>();

    public Escuela() {
    }

    public Escuela(int numero, String denominacion) {
        this.numero = numero;
        this.denominacion = denominacion;
    }

    public Escuela(int numero, String denominacion, List<DivisionCurso> divisionCursos) {
        this.numero = numero;
        this.denominacion = denominacion;
        this.divisionCursos = divisionCursos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<DivisionCurso> getDivisionCursos() {
        return divisionCursos;
    }

    public void setDivisionCursos(List<DivisionCurso> divisionCursos) {
        this.divisionCursos = divisionCursos;
    }

    public List<Alumno> getMejoresAlumnos(int anioNacimientoAlumno) {

        List<AlumnoConPromedio> alumnosConPromedio = new ArrayList<>();


        for (DivisionCurso division : divisionCursos) {

            for (Catedra catedra : division.getCatedras()) {

                for (Alumno alumno : catedra.getAlumnos()) {

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(alumno.getFechaNacimiento());
                    int anioNacimiento = cal.get(Calendar.YEAR);

                    if (anioNacimiento == anioNacimientoAlumno) {

                        boolean nuncaDesaprobado = true;
                        int cantidadDeNotas = 0;
                        double sumaNotas = 0;

                        for (Nota nota : alumno.getNotas()) {
                            if (nota.getValor() < 6.0) {
                                nuncaDesaprobado = false;
                                break;
                            }
                            sumaNotas += nota.getValor();
                            cantidadDeNotas++;
                        }


                        if (nuncaDesaprobado && cantidadDeNotas > 0) {
                            double promedio = sumaNotas / cantidadDeNotas;
                            alumnosConPromedio.add(new AlumnoConPromedio(alumno, promedio));
                        }
                    }
                }
            }
        }


        alumnosConPromedio.sort(Comparator.comparing(AlumnoConPromedio::getPromedio).reversed());


        List<Alumno> mejoresAlumnos = new ArrayList<>();
        int count = Math.min(3, alumnosConPromedio.size());
        for (int i = 0; i < count; i++) {
            mejoresAlumnos.add(alumnosConPromedio.get(i).getAlumno());
        }

        return mejoresAlumnos;
    }


    public Alumno getMejorAlumnoEscuela(int anioNacimientoAlumno) {
        Alumno mejorAlumno = null;
        double mejorPromedio = -1;

        for (DivisionCurso division : divisionCursos) {
            for (Catedra catedra : division.getCatedras()) {
                for (Alumno alumno : catedra.getAlumnos()) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(alumno.getFechaNacimiento());
                    int anioNacimiento = cal.get(Calendar.YEAR);

                    if (anioNacimiento == anioNacimientoAlumno) {
                        boolean nuncaDesaprobado = true;
                        int cantidadDeNotas = 0;
                        double sumaNotas = 0;

                        for (Nota nota : alumno.getNotas()) {
                            if (nota.getValor() < 6.0) {
                                nuncaDesaprobado = false;
                                break;
                            }
                            sumaNotas += nota.getValor();
                            cantidadDeNotas++;
                        }

                        if (nuncaDesaprobado && cantidadDeNotas > 0) {
                            double promedioActual = sumaNotas / cantidadDeNotas;

                            if (promedioActual > mejorPromedio) {
                                mejorPromedio = promedioActual;
                                mejorAlumno = alumno;
                            }
                        }
                    }
                }
            }
        }

        return mejorAlumno;
    }

    private static class AlumnoConPromedio {
        private final Alumno alumno;
        private final double promedio;

        public AlumnoConPromedio(Alumno alumno, double promedio) {
            this.alumno = alumno;
            this.promedio = promedio;
        }

        public Alumno getAlumno() {
            return alumno;
        }

        public double getPromedio() {
            return promedio;
        }
    }
}
