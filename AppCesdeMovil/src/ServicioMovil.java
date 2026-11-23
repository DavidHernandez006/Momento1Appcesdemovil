public class ServicioMovil {
    protected String codigoServicio;
    protected String nombreCliente;
    protected double costoBase;

    public ServicioMovil(String codigoServicio, String nombreCliente, double costoBase) {
        this.codigoServicio = codigoServicio;
        this.nombreCliente = nombreCliente;

        if (costoBase < 15000) {
            System.out.println("Aviso: el costo base no puede ser menor a $15.000. Se ajusta a $15.000.");
            this.costoBase = 15000;
        } else {
            this.costoBase = costoBase;
        }
    }

    // Getters y Setters
    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        if (costoBase < 15000) {
            System.out.println("Aviso: el costo base no puede ser menor a $15.000. No se cambio el valor.");
        } else {
            this.costoBase = costoBase;
        }
    }

    public double calcularTotalPagar() {
        return costoBase + (costoBase * 0.19);
    }

    public void mostrarFactura() {
        System.out.println("Codigo: " + codigoServicio);
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Costo base: $" + costoBase);
    }
}
