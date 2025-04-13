import java.util.ArrayList;
import java.util.List;

public class SistemaSoporte {
    private List<TicketSoporte> tickets;
    private List<Usuario> usuarios;
    private List<Tecnico> tecnicos;

    public SistemaSoporte() {
        this.tickets = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.tecnicos = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public void agregarTecnico(Tecnico tecnico) {
        tecnicos.add(tecnico);
    }

    public Tecnico buscarTecnico(int id) {
        for (Tecnico tecnico : tecnicos) {
            if (tecnico.getId() == id) {
                return tecnico;
            }
        }
        return null;
    }

    public TicketSoporte crearTicket(String descripcion, Usuario usuario) {
        int nuevoId = tickets.size() + 1;
        TicketSoporte ticket = new TicketSoporte(nuevoId, descripcion, usuario);
        tickets.add(ticket);
        return ticket;
    }

    public void asignarTecnicoATicket(int ticketId, int tecnicoId) {
        TicketSoporte ticket = buscarTicket(ticketId);
        Tecnico tecnico = buscarTecnico(tecnicoId);

        if (ticket != null && tecnico != null) {
            ticket.asignarTecnico(tecnico);
        }
    }

    public void cerrarTicket(int ticketId) {
        TicketSoporte ticket = buscarTicket(ticketId);
        if (ticket != null) {
            ticket.cerrarTicket();
        }
    }

    private TicketSoporte buscarTicket(int id) {
        for (TicketSoporte ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public List<TicketSoporte> listarTicketsAbiertos() {
        List<TicketSoporte> abiertos = new ArrayList<>();
        for (TicketSoporte ticket : tickets) {
            if (!ticket.getEstado().equals("cerrado")) {
                abiertos.add(ticket);
            }
        }
        return abiertos;
    }

    public List<TicketSoporte> listarTicketsCerrados() {
        List<TicketSoporte> cerrados = new ArrayList<>();
        for (TicketSoporte ticket : tickets) {
            if (ticket.getEstado().equals("cerrado")) {
                cerrados.add(ticket);
            }
        }
        return cerrados;
    }

    public int contarTicketsAbiertos() {
        return listarTicketsAbiertos().size();
    }

    public int contarTicketsCerrados() {
        return listarTicketsCerrados().size();
    }

    public int contarTotalTickets() {
        return tickets.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sistema de Soporte\n");
        sb.append("------------------\n");
        sb.append("Total tickets: ").append(contarTotalTickets()).append("\n");
        sb.append("Tickets abiertos: ").append(contarTicketsAbiertos()).append("\n");
        sb.append("Tickets cerrados: ").append(contarTicketsCerrados()).append("\n");
        return sb.toString();
    }
}
