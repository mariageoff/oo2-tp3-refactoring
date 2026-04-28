package oop2.tp3.ejercicio6;

public class MainCalculadoraPedido {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(10000, true, true);
        CalculadoraPedido calculadora = new CalculadoraPedido();

        double totalVip = calculadora.calcularTotalConDescuentoVip(pedido);
        double totalPrioritario = calculadora.calcularTotalConDescuentoPrioritario(pedido);

        System.out.println("Total con descuento VIP: " + totalVip);
        System.out.println("Total con descuento por envio prioritario: " + totalPrioritario);
    }
}

