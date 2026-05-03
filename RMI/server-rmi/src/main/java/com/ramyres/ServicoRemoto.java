package com.ramyres;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoRemoto extends Remote {
    String exibir(String mensagem) throws RemoteException;
}
