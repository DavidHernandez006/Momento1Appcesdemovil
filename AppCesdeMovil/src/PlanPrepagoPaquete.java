public class PlanPrepagoPaquete extends ServicioMovil {
    private int diasVigencia;
    private boolean aplicaPromocion;

    public PlanPrepagoPaquete(String codigoServicio, String nombreCliente, double costoBase,
                               int diasVigencia, boolean aplicaPromocion) {
        super(codigoServicio, nombreCliente, costoBase);
        this.diasVigencia = diasVigencia;
        this.aplicaPromocion = aplicaPromocion;
    }

    // Getters y Setters
    public int getDiasVigencia() {
        return diasVigencia;
    }

    public void setDiasVigencia(int diasVigencia) {
        this.diasVigencia = diasVigencia;
    }

    public boolean isAplicaPromocion() {
        return aplicaPromocion;
    }

    public void setAplicaPromocion(boolean aplicaPromocion) {
        this.aplicaPromocion = aplicaPromocion;
    }

    @Override
    public double calcularTotalPagar() {
        double subtotal = costoBase;

        if (aplicaPromocion) {
            subtotal = subtotal - (subtotal * 0.10);
        }

        return subtotal + (subtotal * 0.19);
    }

    @Override
    public void mostrarFactura() {
        super.mostrarFactura();
        System.out.println("Dias de vigencia: " + diasVigencia);
        System.out.println("Promocion aplicada: " + (aplicaPromocion ? "Si" : "No"));
        System.out.println("Total a pagar: $" + calcularTotalPagar());
    }
}
