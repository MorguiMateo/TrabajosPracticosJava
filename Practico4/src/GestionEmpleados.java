public class GestionEmpleados {
    public static void main(String[] args) {

        Empleado emp1 = new Empleado(1, "Ana López", "Desarrolladora", 2500.0);
        Empleado emp2 = new Empleado("Carlos Pérez", "Diseñador");
        Empleado emp3 = new Empleado(3, "María Gómez", "Gerente", 3500.0);
        Empleado emp4 = new Empleado("Juan Rodríguez", "Analista");

        System.out.println("=== Información Inicial de Empleados ===");
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println(emp4);

        emp1.actualizarSalario(10);
        emp2.actualizarSalario(500);
        emp3.actualizarSalario(15);

        System.out.println("\n=== Información Actualizada de Empleados ===");
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println(emp4);

        System.out.println("\nTotal de empleados creados: " + Empleado.mostrarTotalEmpleados());
    }
}
