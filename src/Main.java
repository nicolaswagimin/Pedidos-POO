public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Juan Pérez", "juan@email.com");

        Pedido pedido1 = new Pedido(1, cliente1);

        System.out.println(pedido1);

        pedido1.pagar();      // ERROR (no confirmado)
        pedido1.confirmar();
        pedido1.pagar();
        pedido1.enviar();
        pedido1.entregar();
        pedido1.cancelar();   // ERROR (ya entregado)

        System.out.println(pedido1);
    }
}
