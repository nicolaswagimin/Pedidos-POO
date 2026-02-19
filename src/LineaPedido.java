public class LineaPedido {

    private Producto producto;
    private int cantidad;
    private double subtotal;

    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public void calcularSubtotal() {
        subtotal = producto.getPrecio() * cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void mostrarLinea() {
        System.out.println(producto.getNombre() +
                " x" + cantidad +
                " = $" + subtotal);
    }
}
