/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static Model.DAO.getConnection;
import java.sql.Date;
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
public class ConsultaDAO extends DAO {
    private static ConsultaDAO instance;

    private ConsultaDAO() {
        getConnection();
        createTable();
    }

    // Singleton
    public static ConsultaDAO getInstance() {
        return (instance==null?(instance = new ConsultaDAO()):instance);
    }

// CRUD    
    public Consulta create( String data,String historico, int idVet, int idTratamento,int idAnimal, boolean terminou, int hora) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consulta (data, historico, idVet,idTratamento, idAnimal, terminou, hora) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, data);
            stmt.setString(2, historico);
            stmt.setInt(3, idVet);
            stmt.setInt(4, idTratamento);
            stmt.setInt(5, idAnimal);
            stmt.setBoolean(6, terminou);
            stmt.setInt(7, hora);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("consulta","id"));
    }
    
    // Uma pequena gambiarra, depois explico...
    public boolean isLastEmpty(){
        Consulta lastConsulta = this.retrieveById(lastId("consulta","id"));
        if (lastConsulta != null) {
            return lastConsulta.getHistorico().isBlank();
        }
        return false;
    }

    private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        try {
            consulta = new Consulta(rs.getInt("id"), rs.getString("data"), rs.getString("historico"), rs.getInt("idVet"), rs.getInt("idTratamento"), rs.getInt("idAnimal"),rs.getBoolean("terminou"),rs.getInt("hora"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consulta;
    }

    // Generic Retriever
    public List retrieve(String query) {
        List<Consulta> consulta = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                consulta.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consulta;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM consulta");
    }
    
    
    /*
    
    data - tabela consulta
    nome cliente - tabela consulta, tem o id do animal q tem o id do cliente na tabela consulta
    nome animal - tem o id do animal na tabela consulta e da pra pegar o nome 
    nome vet - tem o id do vet na tabela consulta e da pra pegar o nome
    
    
    SELECT
    P.nome,
    P.preco,
    C.nome as Categoria
FROM
    produto P
INNER JOIN
  categoria_produto C
ON P.id_categoria = C.id
    
    
    SELECT
    c.data, 
    v.nome as Veterinario
    
    FROM
    consulta C
    INNER JOIN
    id_vet v
    ON 
    C.idVet = v.id
    
    */
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM consulta WHERE id = " + lastId("consulta","id"));
    }

    // RetrieveById
    public Consulta retrieveById(int id) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta WHERE id = " + id);
        return (consultas.isEmpty()?null:consultas.get(0));
    }

    // RetrieveBySimilarName
    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM consulta WHERE nome LIKE '%" + nome + "%'");
    }    
        
    // Updade
    public void update(Consulta consulta) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET data=?, historico=?, idVet=?, idTratamento=?, idAnimal=?, terminou=?, hora=? WHERE id=?");
            stmt.setString(1, consulta.getData());
            stmt.setString(2, consulta.getHistorico());
            stmt.setInt(3, consulta.getIdVet());
            stmt.setInt(4, consulta.getIdTratamento());
            stmt.setInt(5, consulta.getIdAnimal());
            stmt.setBoolean(6, consulta.isTerminou());
            stmt.setInt(7, consulta.getHora());
            stmt.setInt(8, consulta.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
        // Delete   
    public void delete(Consulta consulta) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM consulta WHERE id = ?");
            stmt.setInt(1, consulta.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
    
    
}
