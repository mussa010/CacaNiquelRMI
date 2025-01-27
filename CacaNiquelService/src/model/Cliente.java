package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Cliente implements Serializable{
    private String usuario;
    private String senha;
    private double saldo;
    private int id;
    private ArrayList<Historico> hist;

    public Cliente() {
    }

    public Cliente(String usuario, String senha, double saldo, int id) {
        this.usuario = usuario;
        this.senha = senha;
        this.saldo = saldo;
        this.id = id;
        
        this.hist = new ArrayList<>();
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void reduzirSaldo(double val) {
        this.saldo -= val;
    }
    
    public void aumentarSaldo(double val) {
        this.saldo += val;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Historico> getHist() {
        return hist;
    }
    

    public void addHist(Historico hist) {
        this.hist.addFirst(hist);
        
        if(this.hist.size() > 10) {
            this.hist.remove((this.hist.size() - 1));
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "usuario=" + usuario + ", senha=" + senha + ", jogadas=" + saldo + ", id=" + id + ", hist=" + hist + '}';
    } 
}