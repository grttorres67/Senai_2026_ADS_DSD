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
import com.ramyres.servicos.PalavrasService;

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
            BufferedReader entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter saida = new PrintWriter(s.getOutputStream(), true)
        ) {
            String request = entrada.readLine();
            if (request != null) {
                String response = handleRequest(request);
                saida.println(response);
                s.close();
            }
        }
        catch(IOException e){
            System.err.println("Erro ao comunicar com o cliente: " + e.getMessage());
        }
    }

    public String handleRequest(String request) {
        Gson gson = new Gson();
        
        try {
            JsonRpcRequest rpcRequest = gson.fromJson(request, JsonRpcRequest.class);
            
            String method = rpcRequest.method;
            String[] params = rpcRequest.params;
            
            JsonRpcResponse rpcResponse = new JsonRpcResponse();
            rpcResponse.id = rpcRequest.id;
            rpcResponse.result = new String[0]; // Valor padrão para o resultado

            switch (method) {
                case "baskara":
                    String [] auxB = new BaskaraService().Run(params);
                    rpcResponse.result = auxB;
                    break;
                case "palavras":
                    String [] auxP = new PalavrasService().Run(params);
                    rpcResponse.result = auxP;
                    break;
                default:
                    rpcResponse.error = new JsonRpcError(-32601, "Method not found: " + method);
                    break;
            }
            
            return gson.toJson(rpcResponse);

        } catch (Exception e) {
            System.err.println(e.getMessage());
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
