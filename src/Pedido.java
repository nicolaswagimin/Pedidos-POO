import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Pedido {

    private int idPedido;
    private Date fecha;
    private EstadoPedido estado;
    private double total;
    private double descuento;
    private double impuesto;

    private Cliente cliente;
    private List<Producto> productos;
    private Repartidor repartidor;

    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.fecha = new Date();
        this.estado = EstadoPedido.CREADO;
        this.productos = new ArrayList<>();
        this.total = 0.0;
        this.descuento = 0.0;
        this.impuesto = 0.0;
    }

    // =============================
    // LÓGICA DE NEGOCIO
    // =============================

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        recalcularTotal();
    }

    private void recalcularTotal() {
        total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }

        total = total - descuento;
        total = total + (total * impuesto);
    }

    public void aplicarDescuento(double descuento) {
        this.descuento = descuento;
        recalcularTotal();
    }

    public void aplicarImpuesto(double impuesto) {
        this.impuesto = impuesto;
        recalcularTotal();
    }

    // =============================
    // MÁQUINA DE ESTADOS
    // =============================

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

    public void enviar(Repartidor repartidor) {
        if (estado == EstadoPedido.PAGADO) {
            this.repartidor = repartidor;
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

    // =============================
    // GETTERS Y SETTERS
    // =============================

    public int getIdPedido() {
        return idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    // =============================
    // toString
    // =============================

    @Override
    public String toString() {

        String infoProductos = "";
        for (Producto p : productos) {
            infoProductos += "\n   - " + p.getNombre() + " | $" + p.getPrecio();
        }

        return "\n========= PEDIDO =========" +
                "\nID: " + idPedido +
                "\nFecha: " + fecha +
                "\nCliente: " + cliente.getNombre() +
                "\nEstado: " + estado +
                "\nRepartidor: " + (repartidor != null ? repartidor.getNombreRepartidor() : "No asignado") +
                "\nProductos: " + (productos.isEmpty() ? "Sin productos" : infoProductos) +
                "\nDescuento: $" + descuento +
                "\nImpuesto: " + (impuesto * 100) + "%" +
                "\nTOTAL: $" + total +
                "\n==========================\n";
    }
}