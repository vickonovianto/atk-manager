package atkmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles connection to database
 * @author adinb
 */
public class DBHelper {
    Connection connection;
    
    /**
     * Constructor for DBHelper class, which will create new connection to the database.
     */
    public DBHelper(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:atkmanager.db");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    /**
     * Returns a ResultSet containing the result from the query it ran.
     * @param query query to be ran
     * @return ResultSet of the query
     */
    public ResultSet runQuery(String query){
        Statement stmt = null;
        ResultSet result = null;
        try {
            stmt = this.getConnection().createStatement();
            result = stmt.executeQuery(query);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
