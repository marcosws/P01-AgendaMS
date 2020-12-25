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
import java.util.List;

/**
 *
 * @author Marcos
 */
public class ContatoDao {
    
    private Connection connection;
    
    public void incluir(Contato contato){
        
    }
    public void alterar(Contato contato){
        
    }
    public void excluir(Contato contato){
        
    }
    public Contato consultar(int idContato){
        return null;
    }
    public List<Contato> consultar(){
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return total;
    }
    
}
