import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {

    private static final int PIN = 1234;
    private static final double BALANCE = 2555.25;
    private static final List<Menu> Menus = new ArrayList<Menu>();

    private static final int[] Billetes = {2000, 1000, 500, 200, 100, 50};

    private static Scanner scan;


    public static void main(String[] args) {

        Menus.add(new Menu(1, "Consultar Balance"));
        Menus.add(new Menu(2, "Retiro de Efectivo"));
        Menus.add(new Menu(3, "Salir"));

        ValidarPin();
    }

    private static void ValidarPin() {
        System.out.println("Introducir su PIN");
        scan = new Scanner(System.in);

        while (true) {
            if (scan.nextLine().equals(String.valueOf(PIN)))
                Iniciar();
            else {
                System.out.println("Pin Erroneo");
                continue;
            }
        }
    }

    public static void Iniciar() {

        MostrarMenu();

        while (true) {
            scan = new Scanner(System.in);

            switch (scan.nextLine()) {
                case "1":
                    System.out.println("Su balance es de: " + BALANCE);
                    Iniciar();
                case "2":
                    int balance = (int) BALANCE;
                    int total = 0;

                    for (int i : Billetes) {
                        int cantidad = balance / i;
                        if (cantidad > 0) {
                            System.out.println("Cantidad: " + cantidad + "  Billete: " + i);
                            balance -= cantidad * i;
                            total += cantidad * i;
                        }
                    }
                    System.out.println("Total a retirar: " + total);
                    System.out.println("Balance luego del retiro: " + (BALANCE-Double.valueOf(total)));
                    break;
                case "3":
                    System.out.println("Salir del sistema");
                    break;

                default:
                    System.out.println("No se encontro una opcion valida.");
                    continue;
            }

            System.exit(0);
        }
    }

    public static void MostrarMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("Bienvenido a su ATM BDI");
        System.out.println("-----------------------------------------------");
        for (Menu menu : Menus)
            System.out.println(menu.getId() + "-" + menu.getDescription());
        System.out.println("-----------------------------------------------");

    }

}
