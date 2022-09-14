/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class DAO {
     public static final String DBURL = "jdbc:sqlite:vet2021.db";
    
 //  public static final String DBURL = "sqlite-jdbc";
    private static Connection con;
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Connect to SQLite
    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(DBURL);
                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        return con;
    }

    protected ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;
        try {
            s = (Statement) con.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return rs;
    }

    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    protected int lastId(String tableName, String primaryKey) {
        Statement s;
        int lastId = -1;
        try {
            s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(" + primaryKey + ") AS id FROM " + tableName);
            if (rs.next()) {
                lastId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return lastId;
    }

    public static void terminar() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    // Create table SQLite
    protected final boolean createTable() {
        try {
            PreparedStatement stmt;
            // Table client:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS cliente( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        end VARCHAR, 
                                                        cep VARCHAR, 
                                                        email VARCHAR, 
                                                        telefone VARCHAR); 
                                                        """);
            executeUpdate(stmt);
            // Table animal:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS animal( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        sexo VARCHAR, 
                                                        idade int, 
                                                        id_especie INTEGER, 
                                                        id_cliente INTEGER); 
                                                        """);
            executeUpdate(stmt);
            // Table species:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS especie( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR); 
                                                        """);
            executeUpdate(stmt);
            // Table vet:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS vet( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        email VARCHAR, 
                                                        telefone VARCHAR); 
                                                        """);
            executeUpdate(stmt);        
            // Table treatment:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS tratamento( 
                                                        id INTEGER PRIMARY KEY, 
                                                        id_animal INTEGER, 
                                                        nome VARCHAR, 
                                                        dataIni TEXT, 
                                                        dataFim TEXT, 
                                                        terminado INTEGER); 
                                                        """);
            executeUpdate(stmt);
            // Table appointment:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS consulta( 
                                                        id INTEGER PRIMARY KEY, 
                                                        data TEXT, 
                                                        horario VARCHAR, 
                                                        comentario VARCHAR, 
                                                        id_animal INTEGER, 
                                                        id_vet INTEGER, 
                                                        id_tratamento INTEGER, 
                                                        terminado INTEGER); 
                                                        """);
            executeUpdate(stmt);            
             // Table exam:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS exame( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        id_consulta INTEGER); 
                                                        """);
            executeUpdate(stmt);      
            // Default element for species:
            stmt = DAO.getConnection().prepareStatement("INSERT OR IGNORE INTO especie (id, nome) VALUES (1, 'Cachorro')");
            executeUpdate(stmt);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
