package com.ramyres.protocolo;
public class JsonRpcError{
    // {"code": -32600, "message": "Invalid Request"},
    public int code;
    public String message;

    public JsonRpcError() {
    }

    public JsonRpcError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}