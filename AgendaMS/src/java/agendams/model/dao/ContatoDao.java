/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.model.dao;

import agendams.model.entity.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class ContatoDao {
    
    private Connection connection;
    private String mensagemSQLErro = "";

    public String getMensagemSQLErro() {
        return mensagemSQLErro;
    }
    
    public void incluir(Contato contato){
       
    }
    public void alterar(Contato contato){
        
    }
    public void excluir(Contato contato){
        
    }

    public List<Contato> consultar(int idUsuario){
        
        this.connection = new ConexaoSQLite().getConnection();
        List<Contato> contatos = new ArrayList<Contato>();
        try{
            PreparedStatement ptmt = this.connection.prepareStatement("SELECT * FROM Contato WHERE IdUsuario=?"); 
            ptmt.setInt(1, idUsuario);
            ResultSet resultSet = ptmt.executeQuery();
            
            while(resultSet.next()){
                
                Contato contato = new Contato();
                contato.setIdContato(resultSet.getInt("IdContato"));
                contato.setIdUsuario(resultSet.getInt("IdUsuario"));
                contato.setNome(resultSet.getString("Nome"));
                contato.setCpf(resultSet.getString("Cpf"));
                contato.setTelefone(resultSet.getString("Telefone"));
                contato.setCelular(resultSet.getString("Celular"));
                contato.setEmail(resultSet.getString("Email"));
                contato.setSite(resultSet.getString("Site"));
                contatos.add(contato);
                
            }
            resultSet.close();
            this.connection.close();
            return contatos;
        }
        catch(SQLException e){
            mensagemSQLErro = e.getMessage();
        }
        return null;
    }
    
    public int getTotal(){
        
        this.connection = new ConexaoSQLite().getConnection();
        int total = 0;
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT COUNT(*) FROM Contato");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            total = resultSet.getInt("COUNT(*)");
            resultSet.close();
            this.connection.close();
        }
        catch(SQLException e){
            mensagemSQLErro = e.getMessage();
        }
        return total;
    }
    public int getTotal(int idUsuario){
        
        this.connection = new ConexaoSQLite().getConnection();
        int total = 0;
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT COUNT(*) FROM Contato WHERE IdUsuario = ?");
            preparedStatement.setInt(1,idUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            total = resultSet.getInt("COUNT(*)");
            resultSet.close();
            this.connection.close();
        }
        catch(SQLException e){
            mensagemSQLErro = e.getMessage();
        }
        return total;
    }
    
}
