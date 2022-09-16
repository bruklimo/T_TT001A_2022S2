/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Bruno
 */
public class Tratamento {
     private int id;
    private String nome;
    private String data_ini;
    private String data_final;
    private int idAnimal;

    @Override
    public String toString() {
        return "Tratamento{" + "id=" + id + ", nome=" + nome + ", data_ini=" + data_ini + ", data_final=" + data_final + ", idAnimal=" + idAnimal + ", terminou=" + terminou + '}';
    }
    private boolean terminou;

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_ini() {
        return data_ini;
    }

    public void setData_ini(String data_ini) {
        this.data_ini = data_ini;
    }

    public String getData_final() {
        return data_final;
    }

    public void setData_final(String data_final) {
        this.data_final = data_final;
    }

    public boolean isTerminou() {
        return terminou;
    }

    public void setTerminou(boolean terminou) {
        this.terminou = terminou;
    }

    public Tratamento(int id, String nome, String data_ini, String data_final, int idAnimal, boolean terminou) {
        this.id = id;
        this.nome = nome;
        this.data_ini = data_ini;
        this.data_final = data_final;
        this.idAnimal = idAnimal;
        this.terminou = terminou;
    }

    
}
