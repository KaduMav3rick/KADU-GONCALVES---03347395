package br.com.smartweb.airlines;

import java.util.Objects;

public class Reserva {

    private final String codigo;
    private final Voo_old voo;
    private final Passageiro passageiro;
    private int quantidadeBagagens;

    public Reserva(String codigo, Voo_old voo, String nomePassageiro) {
        Objects.requireNonNull(codigo);
        Objects.requireNonNull(voo);
        Objects.requireNonNull(nomePassageiro);
        this.codigo = codigo;
        this.voo = voo;
        this.passageiro = new Passageiro(nomePassageiro);
    }

    public String getCodigo() {
        return codigo;
    }

    public Voo_old getVoo() {
        return voo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public String getNomePassageiro() {
        return passageiro.getNome();
    }

    public int getQuantidadeBagagens() {
        return quantidadeBagagens;
    }

    public void adicionarBagagens(int quantidade) {
        this.quantidadeBagagens += quantidade;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo=" + codigo +
                ", voo=" + voo.getCodigo() + "(" + voo.getOrigem() + "-" + voo.getDestino() + ")" +
                ", passageiro=" + getNomePassageiro() +
                ", quantidadeBagagens=" + quantidadeBagagens +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return codigo.equals(reserva.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

}