/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.model.dao;

import agendams.model.entity.Conta;
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
public class ContaDao {
    
    private Connection connection;
    
    public Conta consultar(int idConta){
        
        this.connection = new ConexaoSQLite().getConnection();
        Conta conta = new Conta();
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM Conta WHERE IdConta=?"); 
            preparedStatement.setInt(1, idConta);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            conta.setIdConta(resultSet.getInt("IdConta"));
            conta.setTipoConta(resultSet.getString("TipoConta"));
            resultSet.close();
            this.connection.close();
            return conta;
        }
        catch(SQLException e){

        }
        return null;
        
    }
    public List<Conta> consultar(){
        
        this.connection = new ConexaoSQLite().getConnection();
        List<Conta> contas = new ArrayList<Conta>();
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM Conta"); 
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Conta conta = new Conta();
                conta.setIdConta(resultSet.getInt("IdConta"));
                conta.setTipoConta(resultSet.getString("TipoConta"));
                contas.add(conta);
            }
            resultSet.close();
            this.connection.close();
            return contas;
        }
        catch(SQLException e){

        }
        return null;
    }
    
}
