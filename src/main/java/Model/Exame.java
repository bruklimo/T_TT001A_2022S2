/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bruno
 */
public class Exame {
     private int id;
    private String descricao;
    private int idConsulta;

    @Override
    public String toString() {
        return "Exame{" + "id=" + id + ", descricao=" + descricao + ", idConsulta=" + idConsulta + '}';
    }

   

    public int getId() {
        return id;
    }

    public Exame(int id, String descricao, int idConsulta) {
        this.id = id;
        this.descricao = descricao;
        this.idConsulta = idConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
