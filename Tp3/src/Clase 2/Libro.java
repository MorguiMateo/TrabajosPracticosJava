import java.util.Calendar;

public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        setAnioPublicacion(anioPublicacion);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int nuevoAnio) {
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        if (nuevoAnio >= 1900 && nuevoAnio <= anioActual) {
            this.anioPublicacion = nuevoAnio;
        } else {
            System.out.println("El año de publicación debe ser entre 1900 y " + anioActual);
        }
    }

    public void mostrarInformacion() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año de Publicación: " + getAnioPublicacion());
    }

}
