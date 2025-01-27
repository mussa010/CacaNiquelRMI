package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import model.Cliente;
import service.CacaNiquelService;
import java.util.Random;
import model.Historico;


public class Server extends UnicastRemoteObject implements CacaNiquelService{
    private final ArrayList<Cliente> listClient = new ArrayList<>();
    int id = 1;
    
    
    public Server() throws RemoteException {
        super();
        Cliente admin = new Cliente("mussa", "admin", 1000000, id);
        admin.setId(id);
        id++;
        listClient.add(admin);
    }
    
    @Override
    public int novoUsuario(String usuario, String senha) {
        Cliente user = new Cliente(
                usuario, 
                senha, 
                100, 
                id
            );
        
            id++;
            listClient.add(user);
            return 0;
    }
    
    @Override
    public int verificarUsuario(String usuario, String senha) {  
        for(int i = 0; i < listClient.size(); i++) {
            if(usuario.equals(listClient.get(i).getUsuario()) && 
                    senha.equals(listClient.get(i).getSenha())) {
                // Usuário cadastrado.
                return 0;
            } if(usuario.equals(listClient.get(i).getUsuario()) && 
                    !senha.equals(listClient.get(i).getSenha())) {
                // Usuário cadastrado, porém senha incorreta.
                return 2;
            }
        }
        // Usuário não cadastrado.
        return 1;
    }
    
    @Override
    public Cliente reduzirSaldo(Cliente c, double val) {
        for(int i = 0; i < listClient.size(); i++) {
            if(c.getUsuario().equals(listClient.get(i).
                    getUsuario())) {
                listClient.get(i).reduzirSaldo(val);
                return listClient.get(i);
            }
        }
        return null;
    }
    
    @Override
    public Cliente aumentarSaldo(Cliente c, ArrayList<String> seq) {
        int valSimbolo1, valSimbolo2, valSimbolo3, ganhoTotal = 0;
        String simbolo1 = seq.get(0), simbolo2 = seq.get(1), simbolo3 = seq.get(2);
        
        // Define valores para cada símbolo
        switch (simbolo1) {
            case "limao" -> valSimbolo1 = 10;
            case "cereja" -> valSimbolo1 = 20;
            case "sino" -> valSimbolo1 = 30;
            case "diamante" -> valSimbolo1 = 50;
            case "sete" -> valSimbolo1 = 100;
            default -> {
                valSimbolo1 = 0;
            }
        }
        
        switch (simbolo2) {
            case "limao" -> valSimbolo2 = 10;
            case "cereja" -> valSimbolo2 = 20;
            case "sino" -> valSimbolo2 = 30;
            case "diamante" -> valSimbolo2 = 50;
            case "sete" -> valSimbolo2 = 100;
            default -> {
                valSimbolo2 = 0;
            }
        }
        
        switch (simbolo3) {
            case "limao" -> valSimbolo3 = 10;
            case "cereja" -> valSimbolo3 = 20;
            case "sino" -> valSimbolo3 = 30;
            case "diamante" -> valSimbolo3 = 50;
            case "sete" -> valSimbolo3 = 100;
            default -> {
                valSimbolo3 = 0;
            }
        }

        if(simbolo1.equals(simbolo2) && simbolo1.equals(simbolo3)) {
            ganhoTotal = 3 * valSimbolo1;
        } else if(simbolo1.equals(simbolo2) && !simbolo1.equals(simbolo3) || !simbolo1.equals(simbolo2) && simbolo1.equals(simbolo3)) {
            ganhoTotal = valSimbolo1;
        } else if(simbolo2.equals(simbolo3)) {
            ganhoTotal = valSimbolo2;
        } else {
            ganhoTotal = 0;
        }
        
        for(int i = 0; i < listClient.size(); i++) {
            if(c.getUsuario().equals(listClient.get(i).
                    getUsuario())) {
                listClient.get(i).aumentarSaldo(ganhoTotal);
                return listClient.get(i);
            }
        }
        return null;
    }
    
    @Override
    public Cliente retornaUsuarioLogado(String usuario, String senha) {
        for(int i = 0; i < listClient.size(); i++) {
            if(usuario.equals(listClient.get(i).getUsuario()) &&
                    senha.equals(listClient.get(i).getSenha())) {
                return listClient.get(i);
            } 
        }
        
        return null;
    }
    
    @Override
    public void atualizarInformacoesUsuario(Cliente c) {
        for(int i = 0; i < listClient.size(); i++) {
            if(listClient.get(i).getId() == c.getId()) {
                listClient.set(i, c);
            }
        }
    }
    
    @Override
    public ArrayList<String> gerador() {
        // Limão - 0 -> 29
        // Cereja - 30 -> 54
        // Sino - 55 -> 74
        // Diamante - 75 - 89
        // Sete - 90 -> 99
        ArrayList<String> listaGerada = new ArrayList<>();
        Random random = new Random();
        
        int numAleatorio;
        
        for(int i = 0; i < 3; i++) {
            numAleatorio = random.nextInt(99);
            //limão
            if(numAleatorio >= 0 && numAleatorio <= 29) {
                listaGerada.add("limao");
            // cereja
            } else if(numAleatorio>= 30 && numAleatorio <= 54) {
                listaGerada.add("cereja");
            // sino
            } else if(numAleatorio>= 55 && numAleatorio <= 74) {
                listaGerada.add("sino");
            // diamante
            } else if(numAleatorio>= 75 && numAleatorio <= 89) {
                listaGerada.add("diamante");
            // sete
            } else {
                listaGerada.add("sete");
            }
        }
        return listaGerada;
    }
    
    @Override
    public void adicionarHistoricoUsuario
        (Cliente c, ArrayList<String> seq, double saldoAntesJogada) {
            Historico hist = new Historico(
                    Double.toString(saldoAntesJogada), 
                    seq.get(0), 
                    seq.get(1), 
                    seq.get(2)
            );
            for(int i = 0; i < listClient.size(); i++) {
                if(c.getUsuario().equals(listClient.get(i).
                        getUsuario())) {
                    listClient.get(i).addHist(hist);
                }
            }
        }
    //
    // Execução servidor
    //
    
    public static void main(String[] args) {
        try {
            CacaNiquelService srv = new Server();
            
            Registry rg = LocateRegistry.createRegistry(PORTA);
            rg.bind(NOME, srv);
            
            System.out.println("Servidor " + NOME + " iniciado!");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}