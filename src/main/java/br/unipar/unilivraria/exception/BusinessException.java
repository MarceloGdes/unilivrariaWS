package br.unipar.unilivraria.exception;

import jakarta.xml.ws.WebFault;

@WebFault
public class BusinessException extends Exception{
    public BusinessException(String message) {
        super(message);
    }
}
