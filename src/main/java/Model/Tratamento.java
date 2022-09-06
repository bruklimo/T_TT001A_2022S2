/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Calendar;

/**
 *
 * @author b167460
 */
public class Tratamento {
    private int id;
    private String nome;
    private Calendar data_ini;
    private Calendar data_final;
    private int idAnimal;
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

    public Calendar getData_ini() {
        return data_ini;
    }

    public void setData_ini(Calendar data_ini) {
        this.data_ini = data_ini;
    }

    public Calendar getData_final() {
        return data_final;
    }

    public void setData_final(Calendar data_final) {
        this.data_final = data_final;
    }

    public boolean isTerminou() {
        return terminou;
    }

    public void setTerminou(boolean terminou) {
        this.terminou = terminou;
    }

    public Tratamento(int id, String nome, Calendar data_ini, Calendar data_final, int idAnimal, boolean terminou) {
        this.id = id;
        this.nome = nome;
        this.data_ini = data_ini;
        this.data_final = data_final;
        this.idAnimal = idAnimal;
        this.terminou = terminou;
    }



}
