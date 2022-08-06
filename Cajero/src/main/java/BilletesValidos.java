public class BilletesValidos {
    private int Valor;
    private int Cantidad;

    private int Index;

    public BilletesValidos(int valor, int cantidad, int index) {
        Valor = valor;
        Cantidad = cantidad;
        Index = index;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int valor) {
        Valor = valor;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
}
