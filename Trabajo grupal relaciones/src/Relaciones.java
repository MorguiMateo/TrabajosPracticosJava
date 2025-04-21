import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Relaciones {
    public static void main(String[] args) {

        Escuela escuela = new Escuela(1, "Escuela Nacional");

        DivisionCurso division = new DivisionCurso(101, 2023, 1);
        division.setEscuela(escuela);

        escuela.getDivisionCursos().add(division);

        Catedra matematica = new Catedra(1001, "Matemática");
        Catedra historia = new Catedra(1002, "Historia");
        matematica.setDivisionCurso(division);
        historia.setDivisionCurso(division);

        division.getCatedras().add(matematica);
        division.getCatedras().add(historia);

        Alumno juan = new Alumno(123, "Juan", "Pérez", new Date(2000-1900, 4, 8));
        Alumno ana = new Alumno(124, "Ana", "García", new Date(2000-1900, 10, 10));
        Alumno pedro = new Alumno(125, "Pedro", "López", new Date(2000-1900, 2, 15));

        juan.setCatedra(matematica);
        ana.setCatedra(historia);
        pedro.setCatedra(matematica);

        matematica.getAlumnos().add(juan);
        matematica.getAlumnos().add(pedro);
        historia.getAlumnos().add(ana);

        juan.getNotas().add(new Nota(1, 8.5, new Date(), false));
        juan.getNotas().add(new Nota(2, 9.0, new Date(), false));
        juan.getNotas().add(new Nota(3, 7.5, new Date(), false));
        juan.getNotas().add(new Nota(4, 8.0, new Date(), false));
        juan.getNotas().add(new Nota(5, 8.0, new Date(), false));
        for (Nota n : juan.getNotas()) {
            n.setCatedra(matematica);
            n.setAlumno(juan);
            matematica.getNotas().add(n);
        }

        ana.getNotas().add(new Nota(6, 9.0, new Date(), false));
        ana.getNotas().add(new Nota(7, 9.5, new Date(), false));
        ana.getNotas().add(new Nota(8, 8.0, new Date(), false));
        ana.getNotas().add(new Nota(9, 7.5, new Date(), false));
        ana.getNotas().add(new Nota(10, 8.5, new Date(), false));
        for (Nota n : ana.getNotas()) {
            n.setCatedra(historia);
            n.setAlumno(ana);
            historia.getNotas().add(n);
        }

        pedro.getNotas().add(new Nota(11, 7.0, new Date(), false));
        pedro.getNotas().add(new Nota(12, 7.5, new Date(), false));
        pedro.getNotas().add(new Nota(13, 8.0, new Date(), false));
        pedro.getNotas().add(new Nota(14, 8.5, new Date(), false));
        pedro.getNotas().add(new Nota(15, 9.0, new Date(), false));
        for (Nota n : pedro.getNotas()) {
            n.setCatedra(matematica);
            n.setAlumno(pedro);
            matematica.getNotas().add(n);
        }

        System.out.println("Promedio de Juan en Matemática: " + juan.promedioNotas(matematica.getCodigo()));
        System.out.println("Promedio de Ana en Historia: " + ana.promedioNotas(historia.getCodigo()));
        System.out.println("Promedio de Pedro en Matemática: " + pedro.promedioNotas(matematica.getCodigo()));

        System.out.println("Mejor nota de Juan en Matemática: " + juan.mejorNota(matematica.getCodigo()).getValor());

        System.out.println("Mejor alumno de Matemática: " +
                matematica.mejorAlumnoCatedra().getNombre() + " " + matematica.mejorAlumnoCatedra().getApellido());
        System.out.println("Mejor alumno de Historia: " +
                historia.mejorAlumnoCatedra().getNombre() + " " + historia.mejorAlumnoCatedra().getApellido());

        Alumno mejorDivision = division.mejorAlumnoDivisionCurso();
        if (mejorDivision != null)
            System.out.println("Mejor alumno de la división: " + mejorDivision.getNombre() + " " + mejorDivision.getApellido());
        else
            System.out.println("No hay mejor alumno en la división.");

        List<Alumno> mejoresAlumnos = escuela.getMejoresAlumnos(2000);
        System.out.println("Los 3 mejores alumnos nacidos en 2000 son:");
        for (Alumno alumno : mejoresAlumnos) {
            System.out.println(alumno.getNombre() + " " + alumno.getApellido());
        }

        Alumno mejorEscuela = escuela.getMejorAlumnoEscuela(2000);
        if (mejorEscuela != null)
            System.out.println("Mejor alumno de la escuela nacido en 2000: " +
                    mejorEscuela.getNombre() + " " + mejorEscuela.getApellido());
        else
            System.out.println("No hay mejor alumno nacido en 2000.");
    }
}
