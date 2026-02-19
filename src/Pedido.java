public class Pedido {

    private int idPedido;
    private Cliente cliente;
    private EstadoPedido estado;

    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.estado = EstadoPedido.CREADO;
    }

    public void confirmar() {
        if (estado == EstadoPedido.CREADO) {
            estado = EstadoPedido.CONFIRMADO;
            System.out.println("Pedido confirmado.");
        } else {
            System.out.println("No se puede confirmar. Estado actual: " + estado);
        }
    }

    public void pagar() {
        if (estado == EstadoPedido.CONFIRMADO) {
            estado = EstadoPedido.PAGADO;
            System.out.println("Pedido pagado.");
        } else {
            System.out.println("No se puede pagar. Estado actual: " + estado);
        }
    }

    public void enviar() {
        if (estado == EstadoPedido.PAGADO) {
            estado = EstadoPedido.ENVIADO;
            System.out.println("Pedido enviado.");
        } else {
            System.out.println("No se puede enviar. Estado actual: " + estado);
        }
    }

    public void entregar() {
        if (estado == EstadoPedido.ENVIADO) {
            estado = EstadoPedido.ENTREGADO;
            System.out.println("Pedido entregado.");
        } else {
            System.out.println("No se puede entregar. Estado actual: " + estado);
        }
    }

    public void cancelar() {
        if (estado != EstadoPedido.ENTREGADO && estado != EstadoPedido.CANCELADO) {
            estado = EstadoPedido.CANCELADO;
            System.out.println("Pedido cancelado.");
        } else {
            System.out.println("No se puede cancelar. Estado actual: " + estado);
        }
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Pedido #" + idPedido +
                " | Cliente: " + cliente.getNombre() +
                " | Estado: " + estado;
    }
}
