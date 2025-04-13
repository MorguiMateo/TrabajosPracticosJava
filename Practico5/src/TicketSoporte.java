import java.util.Date;

public class TicketSoporte {
    private int id;
    private String descripcion;
    private String estado;
    private Date fechaCreacion;
    private Usuario usuario;
    private Tecnico tecnico;

    private static int contadorTickets = 0;

    public TicketSoporte(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = "abierto";
        this.fechaCreacion = new Date();
        contadorTickets++;
    }

    public TicketSoporte(int id, String descripcion, Usuario usuario) {
        this(id, descripcion);
        this.usuario = usuario;
    }

    public TicketSoporte(int id, String descripcion, Usuario usuario, Tecnico tecnico) {
        this(id, descripcion, usuario);
        this.tecnico = tecnico;
    }

    public void cerrarTicket() {
        this.estado = "cerrado";
    }

    public void asignarTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
        if (this.estado.equals("abierto")) {
            this.estado = "en proceso";
        }
    }

    public String mostrarDetalle() {
        StringBuilder detalle = new StringBuilder();
        detalle.append("Ticket #").append(id)
                .append("\nDescripción: ").append(descripcion)
                .append("\nEstado: ").append(estado)
                .append("\nFecha de creación: ").append(fechaCreacion);

        if (usuario != null) {
            detalle.append("\nUsuario: ").append(usuario.getNombre());
        }

        if (tecnico != null) {
            detalle.append("\nTécnico asignado: ").append(tecnico.getNombre());
        }

        return detalle.toString();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public static int getContadorTickets() {
        return contadorTickets;
    }

    @Override
    public String toString() {
        return "TicketSoporte #" + id + " [estado=" + estado + ", creado=" + fechaCreacion +
                (usuario != null ? ", usuario=" + usuario.getNombre() : "") +
                (tecnico != null ? ", tecnico=" + tecnico.getNombre() : "") + "]";
    }
}
