public class Main {
    public static void main(String[] args) {
        System.out.println("===== KATA 1.1: TICKET BÁSICO =====");

        TicketSoporte ticket1 = new TicketSoporte(1, "La impresora no funciona");
        System.out.println("Ticket creado:");
        System.out.println(ticket1.mostrarDetalle());


        ticket1.cerrarTicket();
        System.out.println("\nDespués de cerrar el ticket:");
        System.out.println(ticket1.mostrarDetalle());

        System.out.println("\n===== KATA 1.2: TICKET CON USUARIO =====");

        Usuario usuario1 = new Usuario(1, "Juan Pérez", "juan@ejemplo.com");


        TicketSoporte ticket2 = new TicketSoporte(2, "No puedo acceder al correo", usuario1);
        System.out.println("Ticket con usuario creado:");
        System.out.println(ticket2.mostrarDetalle());


        Tecnico tecnico1 = new Tecnico(1, "Ana López", "Soporte de Software");
        ticket2.asignarTecnico(tecnico1);

        System.out.println("\nDespués de asignar un técnico:");
        System.out.println(ticket2.mostrarDetalle());
    }
}
