package model;

import java.io.Serializable;

public class Historico implements Serializable{
    private String saldo;
    private String resultado1;
    private String resultado2;
    private String resultado3;

    public Historico() {
    }

    public Historico(String saldo, String resultado1, String resultado2, String resultado3) {
        this.saldo = saldo;
        this.resultado1 = resultado1;
        this.resultado2 = resultado2;
        this.resultado3 = resultado3;
    }

    public String getSaldo() {
        return this.saldo;
    }

    public String getResultado1() {
        return this.resultado1;
    }

    public String getResultado2() {
        return this.resultado2;
    }

    public String getResultado3() {
        return this.resultado3;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public void setResultado1(String resultado1) {
        this.resultado1 = resultado1;
    }

    public void setResultado2(String resultado2) {
        this.resultado2 = resultado2;
    }

    public void setResultado3(String resultado3) {
        this.resultado3 = resultado3;
    }

    @Override
    public String toString() {
        return "Historico" + "Saldo: R$" + saldo + "\tResultado 1: " + resultado1 + "\tResultado 2: " + resultado2 + "\tResultado 3: " + resultado3 + "\n";
    }
}