package com.ramyres;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try {
            // Criar o objeto remoto
            ServicoRemoto servico = new ServicoRemotoImpl();
            
            // Criar registry na porta 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Registrar o serviço
            registry.rebind("ServicoRemoto", servico);
            
            System.out.println("Servidor RMI iniciado na porta 1099");
            System.out.println("Serviço 'ServicoRemoto' registrado com sucesso!");
            System.out.println("Aguardando conexões...");
            
        } catch (RemoteException e) {
            System.err.println("Erro ao iniciar o servidor RMI:");
            e.printStackTrace();
        }
    }
}
