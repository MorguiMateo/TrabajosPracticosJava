public class MainAvanzado {
    public static void main(String[] args) {
        System.out.println("===== KATA 1.3: SISTEMA DE SOPORTE =====");

        SistemaSoporte sistema = new SistemaSoporte();

        Usuario usuario1 = new Usuario(1, "Carlos Gómez", "carlos@ejemplo.com");
        Usuario usuario2 = new Usuario(2, "Laura Martínez", "laura@ejemplo.com");
        sistema.agregarUsuario(usuario1);
        sistema.agregarUsuario(usuario2);

        Tecnico tecnico1 = new Tecnico(1, "Miguel Ángel", "Redes");
        Tecnico tecnico2 = new Tecnico(2, "Sofía Torres", "Hardware");
        sistema.agregarTecnico(tecnico1);
        sistema.agregarTecnico(tecnico2);

        TicketSoporte ticket1 = sistema.crearTicket("No puedo conectarme a internet", usuario1);
        TicketSoporte ticket2 = sistema.crearTicket("Mi computadora no enciende", usuario2);
        TicketSoporte ticket3 = sistema.crearTicket("Necesito instalar una aplicación", usuario1);

        sistema.asignarTecnicoATicket(1, 1);
        sistema.asignarTecnicoATicket(2, 2);

        System.out.println("Estado Inicial del Sistema:");
        System.out.println(sistema);

        System.out.println("\nTickets abiertos:");
        for (TicketSoporte ticket : sistema.listarTicketsAbiertos()) {
            System.out.println(ticket);
        }

        System.out.println("\nCerrando ticket #2...");
        sistema.cerrarTicket(2);

        System.out.println("\nEstado actual del Sistema:");
        System.out.println(sistema);

        System.out.println("\nTickets cerrados:");
        for (TicketSoporte ticket : sistema.listarTicketsCerrados()) {
            System.out.println(ticket);
        }

        System.out.println("\nTotal de tickets creados en el sistema: " + TicketSoporte.getContadorTickets());
    }
}
