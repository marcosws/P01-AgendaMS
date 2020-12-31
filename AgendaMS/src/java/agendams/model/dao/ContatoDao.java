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
       
        this.connection = new ConexaoSQLite().getConnection();
                     
        String sql = "INSERT INTO Contato (IdUsuario, Nome, Cpf, Telefone, Celular, Email, Site) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);	
            preparedStatement.setInt(1, contato.getIdUsuario());
            preparedStatement.setString(2, contato.getNome());
            preparedStatement.setString(3, contato.getCpf());
            preparedStatement.setString(4, contato.getTelefone());
            preparedStatement.setString(5, contato.getCelular());
            preparedStatement.setString(6, contato.getEmail());
            preparedStatement.setString(7, contato.getSite());
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
	}
        catch(SQLException e){
            mensagemSQLErro = e.getMessage();
	}
        
    }
    public void alterar(Contato contato){
        
        this.connection = new ConexaoSQLite().getConnection();
        String sql = "UPDATE Contato SET IdUsuario=?, Nome=?, Cpf=? ,Telefone=?, Celular=?, Email=?, Site=? WHERE IdContato=?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);	
            preparedStatement.setInt(1, contato.getIdUsuario());
            preparedStatement.setString(2, contato.getNome());
            preparedStatement.setString(3, contato.getCpf());
            preparedStatement.setString(4, contato.getTelefone());
            preparedStatement.setString(5, contato.getCelular());
            preparedStatement.setString(6, contato.getEmail());
            preparedStatement.setString(7, contato.getSite());
            preparedStatement.setInt(8, contato.getIdContato());
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
	}
        catch(SQLException e){
            mensagemSQLErro = e.getMessage();
	}
        
    }
    public void excluir(Contato contato){
        
        this.connection = new ConexaoSQLite().getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Contato WHERE IdContato=?");
            preparedStatement.setInt(1, contato.getIdContato());
            preparedStatement.execute();
            preparedStatement.close();
            this.connection.close();
        }
	catch(SQLException e){
            mensagemSQLErro = e.getMessage();
	}   
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
    
     public Contato consultarContato(int idContato){
        
        this.connection = new ConexaoSQLite().getConnection();
        
        try{
            PreparedStatement ptmt = this.connection.prepareStatement("SELECT * FROM Contato WHERE IdContato=?"); 
            ptmt.setInt(1, idContato);
            ResultSet resultSet = ptmt.executeQuery();
            resultSet.next();
            Contato contato = new Contato();
            contato.setIdContato(resultSet.getInt("IdContato"));
            contato.setIdUsuario(resultSet.getInt("IdUsuario"));
            contato.setNome(resultSet.getString("Nome"));
            contato.setCpf(resultSet.getString("Cpf"));
            contato.setTelefone(resultSet.getString("Telefone"));
            contato.setCelular(resultSet.getString("Celular"));
            contato.setEmail(resultSet.getString("Email"));
            contato.setSite(resultSet.getString("Site"));
            resultSet.close();
            this.connection.close();
            return contato;
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
