/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.model.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author Marcos
 */
public class UsuarioService {
    
    private String mensagemException;

    public String getMensagemException() {
        return mensagemException;
    }

    public boolean verificaSeVazio(String valor){
        return valor.isEmpty();
    }
    public boolean comparaSenha(String NovaSenha, String ConfirmaSenha){
        return NovaSenha.equals(ConfirmaSenha);
    }
    public String hashSHA512(String valor){
        
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.reset();
            messageDigest.update(valor.getBytes("utf8"));
            return String.format("%0128x", new BigInteger(1, messageDigest.digest()));
        } 
        catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            mensagemException = e.getMessage();
        }
        return "";
        
    }
    public boolean isNullOrEmpty(String valor){
        return (valor == null || valor.isEmpty());
    }
    
}
