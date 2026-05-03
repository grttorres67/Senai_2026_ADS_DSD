package com.ramyres;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServicoRemotoImpl extends UnicastRemoteObject implements ServicoRemoto {
    private static final long serialVersionUID = 1L;

    public ServicoRemotoImpl() throws RemoteException {
        super();
    }

    @Override
    public String exibir(String mensagem) throws RemoteException {
        String timestamp = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        
        String resposta = "[" + timestamp + "] Servidor recebeu: " + mensagem;
        System.out.println(resposta);
        
        return resposta;
    }
}
