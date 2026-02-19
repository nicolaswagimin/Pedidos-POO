public class Repartidor {

    private String nombreRepartidor;
    private String telefonoRepartidor;

    // Constructor
    public Repartidor(String nombreRepartidor, String telefonoRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
        this.telefonoRepartidor = telefonoRepartidor;
    }

    // Getters
    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public String getTelefonoRepartidor() {
        return telefonoRepartidor;
    }

    // Setters
    public void setNombreRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    public void setTelefonoRepartidor(String telefonoRepartidor) {
        this.telefonoRepartidor = telefonoRepartidor;
    }

    // Método toString
    @Override
    public String toString() {
        return "Repartidor: " + nombreRepartidor +
               " | Teléfono: " + telefonoRepartidor;
    }
}