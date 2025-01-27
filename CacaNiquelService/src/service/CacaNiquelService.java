package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.Cliente;

public interface CacaNiquelService extends Remote{
    //Parâmetros de comunicação
    public static final String HOST = "127.0.0.1";
    public static final String NOME = "Slot machine";
    public static final int PORTA = 1099;
    
    //Assinaturas dos Métodos
    public abstract int novoUsuario(String usuario, String senha) throws RemoteException;
    public abstract int verificarUsuario(String usuario, String senha) throws RemoteException;
    public abstract Cliente reduzirSaldo(Cliente c, double val) throws RemoteException;
    public abstract Cliente aumentarSaldo(Cliente c, ArrayList<String> seq) 
        throws RemoteException;
    public abstract Cliente retornaUsuarioLogado(String usuario, String senha)
            throws RemoteException;
    public abstract void atualizarInformacoesUsuario(Cliente c)
            throws RemoteException;
    public abstract ArrayList<String> gerador() throws RemoteException;
    public abstract void adicionarHistoricoUsuario
        (Cliente c, ArrayList<String> seq, double saldoAntesJogada) throws RemoteException;
}