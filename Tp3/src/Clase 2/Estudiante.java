
public class Estudiante {

        String nombre;
        String apellido;
        String curso;
        int calificacion;

    public Estudiante(String nombre, String apellido, String curso, int calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public void mostrarInfo(){
            System.out.println("Nombre: " + this.nombre + " Apellido: " + this.apellido + " Curso: " + this.curso + " Calificacion: " + this.calificacion);
        }

        public void subirCalificacion(double puntos){
            if (puntos >= 0 && puntos <= 10) {
                if (this.calificacion + puntos > 10) {
                    this.calificacion = 10;
                } else {
                    this.calificacion += puntos;
                }
            }
        }

        public void bajarCalificacion(double puntos){
            if (puntos >= 0 && puntos <= 10){
                if (this.calificacion - puntos < 0){
                    this.calificacion = 0;
                } else {
                    this.calificacion -= puntos;
                }
            }
        }
}
