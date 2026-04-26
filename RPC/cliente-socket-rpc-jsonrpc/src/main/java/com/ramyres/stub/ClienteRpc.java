package com.ramyres.stub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.ramyres.protocolo.JsonRpcRequest;
import com.ramyres.protocolo.JsonRpcResponse;

public class ClienteRpc {
    private static Socket socket;

    public static String enviar(String req) {
        if (socket == null || socket.isClosed()) {
            try {
                socket = new Socket("localhost", 7654);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        try {
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            saida.println(req);

            String resposta;
            while((resposta = entrada.readLine()) != null){
                return resposta;
            }
            return "";

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String[] executar(String method, String[] params) {
        JsonRpcRequest req = new JsonRpcRequest();
        req.id = System.currentTimeMillis();
        req.jsonRpc = "2.0";
        req.method = method;
        req.params = params;

        Gson gson = new Gson();
        String reqJson = gson.toJson(req);
        String resJson = enviar(reqJson);

        JsonRpcResponse res = gson.fromJson(resJson, JsonRpcResponse.class);
        if (res.error != null) {
            System.err.println("Erro: " + res.error.code + " - " + res.error.message);
            throw new RuntimeException("Erro na execução do método: " + res.error.message);
        }

        ArrayList<String> resultados = (ArrayList<String>) res.result;
        return resultados.toArray(new String[0]);
    }
}
