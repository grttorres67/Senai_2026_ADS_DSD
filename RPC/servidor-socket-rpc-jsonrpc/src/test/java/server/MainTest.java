package server;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.ramyres.protocolo.JsonRpcResponse;
import com.ramyres.server.Server;

public class MainTest {
    @Test
    public void testHandleRequestBaskara() {
        Server server = new Server();
        String request = "{\"jsonrpc\": \"2.0\", \"method\": \"baskara\", \"params\": [\"1\", \"-3\", \"2\"], \"id\": 99}";
        String response = server.handleRequest(request);
        assert !response.isEmpty();
        assert response.contains("\"result\"");
        assert response.contains("\"id\":");
        
        Gson gson = new Gson();
        JsonRpcResponse rpcResponse = gson.fromJson(response, JsonRpcResponse.class);
        assert rpcResponse.result != null;
        assert rpcResponse.error == null;
        assert rpcResponse.id == 99;

        ArrayList<String> resultados = (ArrayList<String>) rpcResponse.result;
        assert resultados.size() == 2;
        assert resultados.get(0).equals("2.0");
        assert resultados.get(1).equals("1.0");
    }

    @Test
    public void testHandleRequestPalavras(){
        Server server = new Server();
        String request = "{\"jsonrpc\": \"2.0\", \"method\": \"palavras\", \"params\": [\"A vingança nunca é plena, mata a alma e envenena.\"], \"id\": 42}";
        String response = server.handleRequest(request);
        assert !response.isEmpty();
        assert response.contains("\"result\"");
        assert response.contains("\"id\":");
        
        Gson gson = new Gson();
        JsonRpcResponse rpcResponse = gson.fromJson(response, JsonRpcResponse.class);
        assert rpcResponse.result != null;
        assert rpcResponse.error == null;
        assert rpcResponse.id == 42;

        ArrayList<String> resultados = (ArrayList<String>) rpcResponse.result;
        assert resultados.size() == 9;
        assert resultados.get(0).equals("38"); // qtdLetras
        assert resultados.get(1).equals("10"); // qtdPalavras
        assert resultados.get(2).equals("18"); // qtdVogal
        assert resultados.get(3).equals("1"); // qtdVogalAcentuada
        assert resultados.get(4).equals("19"); // qtdConsoantes
        assert resultados.get(5).equals("9"); // qtdEspacos
        assert resultados.get(6).equals("4"); // qtdPalavrasPar
        assert resultados.get(7).equals("6"); // qtdPalavrasImpar
        assert resultados.get(8).equals("1"); // qtdDeLinhas
    }

    @Test
    public void testHandleRequestPi() {
        Server server = new Server();
        String request = "{\"jsonrpc\": \"2.0\", \"method\": \"pi\", \"params\": [\"15\"], \"id\": 123}";
        String response = server.handleRequest(request);
        assert !response.isEmpty();
        assert response.contains("\"result\"");
        assert response.contains("\"id\"");

        Gson gson = new Gson();
        JsonRpcResponse rpcResponse = gson.fromJson(response, JsonRpcResponse.class);
        assert rpcResponse.result != null;
        assert rpcResponse.error == null;
        assert rpcResponse.id == 123;
    }

    @Test
    public void testHandleRequestInvalidMethod() {  
        com.ramyres.server.Server server = new com.ramyres.server.Server();
        String request = "{\"jsonrpc\": \"2.0\", \"method\": \"invalidMethod\", \"params\": [], \"id\": 36}";
        String response = server.handleRequest(request);
        
        assert response.contains("\"result\"");
        assert response.contains("\"id\"");
        assert response.contains("\"error\"");

        Gson gson = new Gson();
        JsonRpcResponse rpcResponse = gson.fromJson(response, JsonRpcResponse.class);
        assert rpcResponse.result != null;
        assert rpcResponse.error != null;
        assert rpcResponse.id == 36;
        assert rpcResponse.error.code == -32601;
        assert rpcResponse.error.message.contains("Method not found");
    }
}
