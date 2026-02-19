import java.util.UUID;

public class Cliente {

    private UUID idCliente;
    private String nombre;
    private String email;
    private boolean activo;

    public Cliente(String nombre, String email) {
        this.idCliente = UUID.randomUUID();
        this.nombre = nombre;
        this.email = email;
        this.activo = true;
    }

    public void actualizarDatos(String nombre, String email) {
        if (!activo) {
            System.out.println("Cliente inactivo. No se pueden actualizar datos.");
            return;
        }
        this.nombre = nombre;
        this.email = email;
    }

    public void desactivar() {
        this.activo = false;
    }

    // Getters
    public UUID getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public boolean isActivo() { return activo; }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " | Email: " + email;
    }
}
