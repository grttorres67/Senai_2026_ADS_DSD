package com.ramyres.servicos;

public class PiService implements ServiceInterface {
    @Override
    public String[] Run(String[] params) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'Run'");
        return new String[]{ "3.141592653589793" };
    }
}