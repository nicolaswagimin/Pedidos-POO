public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Juan Pérez", "juan@email.com");
        Repartidor repartidor1 = new Repartidor("Carlos López", "3001234567");

        Pedido pedido1 = new Pedido(1, cliente1);

        // Agregar productos
        pedido1.agregarProducto(new Producto(1, "Laptop", 2500));
        pedido1.agregarProducto(new Producto(2, "Mouse", 100));

        pedido1.aplicarDescuento(200);
        pedido1.aplicarImpuesto(0.19);

        System.out.println(pedido1);

        pedido1.confirmar();
        pedido1.pagar();
        pedido1.enviar(repartidor1);
        pedido1.entregar();

        System.out.println(pedido1);
    }
}