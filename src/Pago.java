public class Pago {

    private double monto;
    private boolean aprobado;

    public Pago(double monto) {
        this.monto = monto;
    }

    public boolean procesarPago() {
        aprobado = true; // simulación simple
        return aprobado;
    }
}
