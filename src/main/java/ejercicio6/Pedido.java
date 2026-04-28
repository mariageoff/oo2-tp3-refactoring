package oop2.tp3.ejercicio6;

public class Pedido {

    private double subtotal;
    private boolean clienteVip;
    private boolean envioPrioritario;

    public Pedido(double subtotal, boolean clienteVip, boolean envioPrioritario) {
        this.subtotal = subtotal;
        this.clienteVip = clienteVip;
        this.envioPrioritario = envioPrioritario;
    }

    public double subtotal() {
        return this.subtotal;
    }

    public boolean clienteVip() {
        return this.clienteVip;
    }

    public boolean envioPrioritario() {
        return this.envioPrioritario;
    }
}

