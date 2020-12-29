/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.model.service;

/**
 *
 * @author Marcos
 */
public class ContatoService {
    
    public String removeMascara(String valor){
        return valor.replaceAll("[^0-9]", "");
    }
    
    public String mascaraTelefone(String valor){
        switch (valor.length()) {
            case 10:
                return "(" + valor.substring(0, 2) + ")".concat(valor.substring(2, 6).concat("-")).concat(valor.substring(6, 10));
            case 8:
                return valor.substring(0, 4).concat("-").concat(valor.substring(4, 8));
            default:
                return valor;
        }
    }
    
    public String mascaraCelular(String valor){
        switch (valor.length()) {
            case 11:
                return "(" + valor.substring(0, 2) + ")".concat(valor.substring(2, 7).concat("-")).concat(valor.substring(7, 11));
            case 9:
                return valor.substring(0, 5).concat("-").concat(valor.substring(5, 9));
            default:
                return valor;
        }
    }
    
    public String mascaraCpf(String valor){
        return (new StringBuilder())
                .append(valor.substring(0, 3).concat("."))
                .append(valor.substring(3, 6).concat("."))
                .append(valor.substring(6, 9).concat("-"))
                .append(valor.substring(9, 11)).toString();
    }

}
