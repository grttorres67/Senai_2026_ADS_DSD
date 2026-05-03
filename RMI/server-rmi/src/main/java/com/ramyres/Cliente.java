package com.ramyres;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Localizar o registry do servidor
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // Obter a referência do serviço remoto
            ServicoRemoto servico = (ServicoRemoto) registry.lookup("ServicoRemoto");
            
            // Chamar o método remoto
            String mensagem = "Olá, Servidor RMI!";
            String resposta = servico.exibir(mensagem);
            
            System.out.println("Resposta do servidor: " + resposta);
            
        } catch (RemoteException e) {
            System.err.println("Erro na comunicação com o servidor:");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.err.println("Serviço não encontrado no registry:");
            e.printStackTrace();
        }
    }
}
