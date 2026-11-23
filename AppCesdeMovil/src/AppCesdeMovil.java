import java.util.Scanner;

public class AppCesdeMovil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalFacturado = 0;
        int contadorServicios = 0;
        int opcion;

        do {
            System.out.println("CESDE-MOVIL ");
            System.out.println("1. Registrar y liquidar Plan Pospago");
            System.out.println("2. Registrar y liquidar Plan Prepago");
            System.out.println("3. Salir");
            System.out.print("Elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Codigo del servicio: ");
                String codigo = sc.nextLine();
                System.out.print("Nombre del cliente: ");
                String nombre = sc.nextLine();
                System.out.print("Costo base: ");
                double costo = sc.nextDouble();
                System.out.print("Gigas incluidas: ");
                int gigasInc = sc.nextInt();
                System.out.print("Gigas consumidas: ");
                int gigasCons = sc.nextInt();
                System.out.print("Cargo por giga adicional: ");
                double cargoGiga = sc.nextDouble();

                PlanPospago plan = new PlanPospago(codigo, nombre, costo, gigasInc, gigasCons, cargoGiga);
                System.out.println();
                plan.mostrarFactura();

                totalFacturado = totalFacturado + plan.calcularTotalPagar();
                contadorServicios++;

            } else if (opcion == 2) {
                System.out.print("Codigo del servicio: ");
                String codigo = sc.nextLine();
                System.out.print("Nombre del cliente: ");
                String nombre = sc.nextLine();
                System.out.print("Costo base: ");
                double costo = sc.nextDouble();
                System.out.print("Dias de vigencia: ");
                int dias = sc.nextInt();
                System.out.print("Aplica promocion (true/false): ");
                boolean promo = sc.nextBoolean();
                sc.nextLine();

                PlanPrepagoPaquete plan = new PlanPrepagoPaquete(codigo, nombre, costo, dias, promo);
                System.out.println();
                plan.mostrarFactura();

                totalFacturado = totalFacturado + plan.calcularTotalPagar();
                contadorServicios++;

            } else if (opcion == 3) {
                System.out.println("Resumen final");
                System.out.println("Servicios registrados: " + contadorServicios);
                System.out.println("Total facturado: $" + totalFacturado);
                System.out.println("Gracias por usar CESDE-Movil");
            } else {
                System.out.println("Opcion no valida, intente de nuevo.");
            }

        } while (opcion != 3);

        sc.close();
    }
}
