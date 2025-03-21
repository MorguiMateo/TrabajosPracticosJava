public class NaveEspacial {
    private String nombre;
    private int combustible;

    public NaveEspacial(String nombre, int combustible) {
        this.nombre = nombre;
        this.combustible = combustible;

        if (this.combustible > 100) {
            this.combustible = 100;
        }
    }

    public void despegar() {
        if (combustible >= 10) {
            combustible -= 10;
            System.out.println(nombre + " ha despegado.");
        } else {
            System.out.println("No hay suficiente combustible para despegar.");
        }
    }

    public void avanzar(int distancia) {
        if (combustible >= distancia) {
            combustible -= distancia;
            System.out.println(nombre + " ha avanzado " + distancia + " unidades.");
        } else {
            System.out.println("No hay suficiente combustible para avanzar " + distancia + " unidades.");
        }
    }

    public void recargarCombustible(int cantidad) {
        combustible += cantidad;

        if (combustible > 100) {
            combustible = 100;
        }

        System.out.println(nombre + " ha recargado combustible. Cantidad actual: " + combustible);
    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre + ", Combustible: " + combustible);
    }

}
