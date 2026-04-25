package com.ramyres.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;
import com.ramyres.protocolo.JsonRpcError;
import com.ramyres.protocolo.JsonRpcRequest;
import com.ramyres.protocolo.JsonRpcResponse;
import com.ramyres.servicos.BaskaraService;

public class Server {
    public void Run(int port) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        while (true) {
            Socket clientSocket = ss.accept();
            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private void handleClient(Socket socket) {
        try (
            Socket s = socket; 
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true)
        ) {
            String request = in.readLine();
            
            if (request != null) {
                String response = handleRequest(request);
                out.println(response);
                s.close();
            }
        }
        catch(IOException e){
            System.err.println("Erro ao comunicar com o cliente: " + e.getMessage());
        }
    }

    private String handleRequest(String request) {
        Gson gson = new Gson();
        try {
            JsonRpcRequest rpcRequest = gson.fromJson(request, JsonRpcRequest.class);
            String method = rpcRequest.method;
            String[] params = rpcRequest.params;

            String [] resultados;
            switch (method) {
                case "baskara":
                    String [] aux = new BaskaraService().Run(params);
                    resultados = aux;
                    break;
                default:
                    resultados = new String[0];
                    break;
            }
            
            JsonRpcResponse rpcResponse = new JsonRpcResponse();
            rpcResponse.id = rpcRequest.id;
            rpcResponse.result = resultados;
            return gson.toJson(rpcResponse);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JsonRpcResponse rpcResponse = new JsonRpcResponse();
            rpcResponse.error = new JsonRpcError(){
                {
                    code = -32603;
                    message = "Internal error: " + e.getMessage();
                }
            };            
            return gson.toJson(rpcResponse);
        }   
    }
}
