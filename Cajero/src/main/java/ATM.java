import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {

    private static final String PIN = "1234";
    private static double balance = 12050.25;
    private static final List<Menu> MENUS = new ArrayList<>();
    private static final int[] BILLETES = {2000, 1000, 500, 200, 100, 50};

    private static Scanner scan;

    public static void main(String[] args) {

        MENUS.add(new Menu(1, "Consultar Balance"));
        MENUS.add(new Menu(2, "Retiro de Efectivo"));
        MENUS.add(new Menu(3, "Salir"));

        ValidarPin();
    }

    private static void ValidarPin() {
        System.out.println("Introducir su PIN");
        scan = new Scanner(System.in);

        while (true) if (scan.nextLine().equals(PIN))
            Iniciar();
        else
            System.out.println("Pin Erroneo");
    }

    public static void MostrarMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("Bienvenido a su ATM BDI");
        System.out.println("-----------------------------------------------");
        for (Menu menu : MENUS)
            System.out.println(menu.getId() + "-" + menu.getDescription());
        System.out.println("-----------------------------------------------");

    }

    public static void Iniciar() {

        MostrarMenu();

        while (true) {
            scan = new Scanner(System.in);
            String texto = "";

            switch (scan.nextLine()) {
                case "1":
                    System.out.println("Su balance es de: " + balance);
                    Iniciar();
                case "2":
                    int bal = 0;
                    System.out.println("Digitar el monto a retirar");
                    String retiro = scan.nextLine();

                    try {
                        bal = Integer.parseInt(retiro);
                    } catch (Exception e) {
                        System.out.println("El retiro tiene que ser un numero");
                    }

                    int total = 0;

                    for (int i : BILLETES) {

                        if (bal <= 0)
                            break;

                        int cantidad = bal / i;

                        if (cantidad > 0) {
                            texto += "Cantidad: " + cantidad + "  Billete: " + i + "\n";
                            bal -= cantidad * i;
                            total += cantidad * i;
                        }
                    }
                    if ( bal == 0 )
                    {
                        System.out.println(texto);
                        System.out.println("Total a retirar: " + total);
                        balance -= total;
                        System.out.println("Balance luego del retiro: " + (balance));
                    }
                    else
                        System.out.println("El monto a retirar no se pudo procesar por: " + bal);
                    Iniciar();
                case "3":
                    System.out.println("Salir del sistema");
                    break;

                default:
                    String opciones = ", las opciones disponibles son: ";
                    for (Menu menu : MENUS) {
                        opciones += menu.getId() + " , ";
                    }
                    System.out.println("No se encontro una opcion valida" + opciones);
                    continue;
            }

            System.exit(0);
        }
    }
}
