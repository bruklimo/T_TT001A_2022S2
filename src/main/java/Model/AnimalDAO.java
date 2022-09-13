/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static Model.DAO.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class AnimalDAO extends DAO {
      private static AnimalDAO instance;

    private AnimalDAO() {
        getConnection();
        createTable();
    }

    // Singleton
    public static AnimalDAO getInstance() {
        return (instance==null?(instance = new AnimalDAO()):instance);
    }

// CRUD    
    public Animal create(String nome, char sexo, int idade, int idEspecie, int idCliente) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO animal (nome, sexo, idade, idEspecie, idCliente) VALUES (?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, sexo);
            stmt.setInt(3, idade);
            stmt.setInt(4, idEspecie);
            stmt.setInt(5, idCliente);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("animal","id"));
    }
    
    // Uma pequena gambiarra, depois explico...
    public boolean isLastEmpty(){
        Animal lastAnimal = this.retrieveById(lastId("animal","id"));
        if (lastAnimal != null) {
            return lastAnimal.getNome().isBlank();
        }
        return false;
    }

    private Animal buildObject(ResultSet rs) {
        Animal animal = null;
        try {
            animal = new Animal(rs.getInt("id"), rs.getString("nome"), rs.getString("sexo"), rs.getInt("idade"), rs.getInt("idEspecie"), rs.getInt("idCliente"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animal;
    }

    // Generic Retriever
    public List retrieve(String query) {
        List<Animal> animais = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                animais.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animais;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM animal");
    }
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM animal WHERE id = " + lastId("animal","id"));
    }

    // RetrieveById
    public Animal retrieveById(int id) {
        List<Cliente> animais = this.retrieve("SELECT * FROM animal WHERE id = " + id);
        return (animais.isEmpty()?null:animais.get(0));
    }

    // RetrieveBySimilarName
    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM animal WHERE nome LIKE '%" + nome + "%'");
    }    
        
    // Updade
    public void update(Animal animal) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE animal SET nome=?, sexo=?, idade=?, idEspecie=?, idCliente=? WHERE id=?");
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getSexo());
            stmt.setString(3, animal.getIdade());
            stmt.setString(4, animal.getIdEspecie());
            stmt.setString(5, animal.getIdCliente());
            stmt.setInt(6, animal.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
        // Delete   
    public void delete(Animal animal) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM animal WHERE id = ?");
            stmt.setInt(1, animal.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
