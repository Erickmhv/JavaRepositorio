import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ATM {

    private static final String PIN = "1234";
    private static double balance = 12050.25;
    private static final List<Menu> Menus = new ArrayList<>();
    private static final int[] Billetes = {1000, 500, 200};
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

        while (true) if (scan.nextLine().equals(PIN))
            Iniciar();
        else
            System.out.println("Pin Erroneo");
    }

    public static void MostrarMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("Bienvenido a su ATM BDI");
        System.out.println("-----------------------------------------------");
        for (Menu menu : Menus)
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
                        if (bal > balance) {
                            System.out.println("El retiro es mayor al balance");
                            Iniciar();
                        }

                    } catch (Exception e) {
                        System.out.println("El retiro tiene que ser un numero");
                    }

                    int total = 0;

                    List<BilletesValidos> ListaBilletesValidos = new ArrayList<>();

                    for (int i = 0; i < Billetes.length; i++) {

                        int billete = Billetes[i];

                        if (bal <= 0)
                            break;

                        int cantidad = bal / billete;

                        if (cantidad > 0) {
                            bal -= cantidad * billete;
                            ListaBilletesValidos.add(new BilletesValidos(billete, cantidad, i));
                        }

                        for (int e = 0; e < Billetes.length; e++) {
                            if (bal > 0 && Billetes.length - 1 == e) {
                                BilletesValidos eliminar = ListaBilletesValidos.get(ListaBilletesValidos.size() - 1);
                                i = eliminar.getIndex();
                                bal += eliminar.getCantidad() * eliminar.getValor();

                                ListaBilletesValidos.remove(eliminar);
                            }
                        }
                    }

                    for (BilletesValidos b : ListaBilletesValidos) {
                        texto += "Cantidad: " + b.getCantidad() + "  Billete: " + b.getValor() + "\n";
                        total += b.getCantidad() * b.getValor();
                    }

                    if (bal == 0) {
                        System.out.println(texto);
                        System.out.println("Total a retirar: " + total);
                        balance -= total;
                        System.out.println("Balance luego del retiro: " + (balance));
                    } else
                        System.out.println("El monto a retirar no se pudo procesar por: " + bal);
                    Iniciar();
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
}
