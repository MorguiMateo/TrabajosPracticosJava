public class Empleado {

    private int id;
    private String nombre;
    private String puesto;
    private double salario;


    private static int totalEmpleados = 0;


    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++;
    }


    public Empleado(String nombre, String puesto) {
        this.id = totalEmpleados + 1;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 1000.0;
        totalEmpleados++;
    }


    public void actualizarSalario(double porcentaje) {
        this.salario += this.salario * (porcentaje / 100);
    }


    public void actualizarSalario(int cantidadFija) {
        this.salario += cantidadFija;
    }


    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }


    @Override
    public String toString() {
        return "Empleado [ID: " + id + ", Nombre: " + nombre +
                ", Puesto: " + puesto + ", Salario: $" + salario + "]";
    }
}
