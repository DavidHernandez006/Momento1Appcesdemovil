public class PlanPospago extends ServicioMovil {
    private int gigasIncluidas;
    private int gigasConsumidas;
    private double cargoGigaAdicional;

    public PlanPospago(String codigoServicio, String nombreCliente, double costoBase,
                        int gigasIncluidas, int gigasConsumidas, double cargoGigaAdicional) {
        super(codigoServicio, nombreCliente, costoBase);
        this.gigasIncluidas = gigasIncluidas;
        this.gigasConsumidas = gigasConsumidas;
        this.cargoGigaAdicional = cargoGigaAdicional;
    }

    // Getters y Setters
    public int getGigasIncluidas() {
        return gigasIncluidas;
    }

    public void setGigasIncluidas(int gigasIncluidas) {
        this.gigasIncluidas = gigasIncluidas;
    }

    public int getGigasConsumidas() {
        return gigasConsumidas;
    }

    public void setGigasConsumidas(int gigasConsumidas) {
        this.gigasConsumidas = gigasConsumidas;
    }

    public double getCargoGigaAdicional() {
        return cargoGigaAdicional;
    }

    public void setCargoGigaAdicional(double cargoGigaAdicional) {
        this.cargoGigaAdicional = cargoGigaAdicional;
    }

    @Override
    public double calcularTotalPagar() {
        double subtotal = costoBase;

        if (gigasConsumidas > gigasIncluidas) {
            int gigasExtra = gigasConsumidas - gigasIncluidas;
            subtotal = subtotal + (gigasExtra * cargoGigaAdicional);
        }

        return subtotal + (subtotal * 0.19);
    }

    @Override
    public void mostrarFactura() {
        super.mostrarFactura();
        System.out.println("Gigas incluidas: " + gigasIncluidas);
        System.out.println("Gigas consumidas: " + gigasConsumidas);

        if (gigasConsumidas > gigasIncluidas) {
            int gigasExtra = gigasConsumidas - gigasIncluidas;
            System.out.println("Gigas extra cobradas: " + gigasExtra + " x $" + cargoGigaAdicional);
        }

        System.out.println("Total a pagar: $" + calcularTotalPagar());
    }
}
