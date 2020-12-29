/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.model.dao;

import agendams.model.entity.Usuario;
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
public class UsuarioDao {
    
    private Connection connection;
    private String mensagemSQLErro = "";

    public String getMensagemSQLErro() {
        return mensagemSQLErro;
    }
    
    public void incluir(Usuario usuario){
        
        this.connection = new ConexaoSQLite().getConnection();
        
        String sql = "INSERT INTO Usuario (IdConta, Nome, Login, Senha) VALUES (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, usuario.getIdConta());
            preparedStatement.setString(2, usuario.getNome());
            preparedStatement.setString(3, usuario.getLogin());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
	}
        catch(SQLException e){
            mensagemSQLErro = e.getMessage();
	}
        
    }
    public void alterar(Usuario usuario){
        
        this.connection = new ConexaoSQLite().getConnection();
       
        try{
            PreparedStatement preparedStatement = null;
            if(usuario.getSenha().isEmpty()){
                
                String sql = "UPDATE Usuario SET IdConta=?, Nome=?, Login=?, Senha=? WHERE IdUsuario=?;";
                preparedStatement = connection.prepareStatement(sql);	
                preparedStatement.setInt(1, usuario.getIdConta());
                preparedStatement.setString(2, usuario.getNome());
                preparedStatement.setString(3, usuario.getLogin());
                preparedStatement.setString(4, usuario.getSenha());
                preparedStatement.setInt(5, usuario.getIdUsuario());
                
            }
            else{
                
                String sql = "UPDATE Usuario SET IdConta=?, Nome=?, Login=? WHERE IdUsuario=?;";
                preparedStatement = connection.prepareStatement(sql);	
                preparedStatement.setInt(1, usuario.getIdConta());
                preparedStatement.setString(2, usuario.getNome());
                preparedStatement.setString(3, usuario.getLogin());
                preparedStatement.setInt(4, usuario.getIdUsuario());
                    
            }
            preparedStatement.execute();
            preparedStatement.close();	
            this.connection.close();
	}
        catch(SQLException e){
             mensagemSQLErro = e.getMessage();
	}
        
    }
    public void excluir(Usuario usuario){
        
        this.connection = new ConexaoSQLite().getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM Usuario WHERE IdUsuario=?");
            stmt.setInt(1, usuario.getIdUsuario());
            stmt.execute();
            stmt.close();
            this.connection.close();
        }
	catch(SQLException e){
            mensagemSQLErro = e.getMessage();
	}
        
    }
    public Usuario consultar(int idUsuario){
        
        this.connection = new ConexaoSQLite().getConnection();
        Usuario usuario = new Usuario();
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM Usuario WHERE IdUsuario=?"); 
            preparedStatement.setInt(1, idUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            usuario.setIdUsuario(resultSet.getInt("IdUsuario"));
            usuario.setIdConta(resultSet.getInt("IdConta"));
            usuario.setNome(resultSet.getString("Nome"));
            usuario.setLogin(resultSet.getString("Login"));
            usuario.setSenha(resultSet.getString("Senha"));
            resultSet.close();
            this.connection.close();
            return usuario;
        }
        catch(SQLException e){
            mensagemSQLErro = e.getMessage();
        }
        return null;
    }
    public Usuario consultar(String login){
        
        this.connection = new ConexaoSQLite().getConnection();
        Usuario usuario = new Usuario();
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM Usuario WHERE Login=?"); 
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            usuario.setIdUsuario(resultSet.getInt("IdUsuario"));
            usuario.setIdConta(resultSet.getInt("IdConta"));
            usuario.setNome(resultSet.getString("Nome"));
            usuario.setLogin(resultSet.getString("Login"));
            usuario.setSenha(resultSet.getString("Senha"));
            resultSet.close();
            this.connection.close();
            return usuario;
        }
        catch(SQLException e){
            mensagemSQLErro = e.getMessage();
        }
        return null;
    }
    
    public List<Usuario> consultar(){
        
        this.connection = new ConexaoSQLite().getConnection();
        try{
            List<Usuario> usuarios = new ArrayList<Usuario>(); 
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM Usuario"); 
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getInt("IdUsuario"));
                usuario.setIdConta(resultSet.getInt("IdConta"));
                usuario.setNome(resultSet.getString("Nome"));
                usuario.setLogin(resultSet.getString("Login"));
                usuario.setSenha(resultSet.getString("Senha"));
                usuarios.add(usuario);
            }
            
            this.connection.close();
            return usuarios;
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
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT COUNT(*) FROM Usuario");
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
