/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.sqlite.SQLiteConfig;

/**
 *
 * @author Marcos
 */
public class ConexaoSQLite {
    
    private Properties connectionProperties = new Properties();
    private final String path = "C:/Projetos/Java/AgendaMS/P01-AgendaMS/AgendaMS/db/";
    private final String database = "agendams.db";
    public Connection getConnection() {
        
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        connectionProperties = config.toProperties();
        String strConexao = "jdbc:sqlite:" + path + database;
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(strConexao, connectionProperties);	
	}
	catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

}
