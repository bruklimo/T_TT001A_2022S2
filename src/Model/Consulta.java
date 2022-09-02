/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author b167460
 */
public class Consulta {
    private int id;
    private Calendar data;
    private String historico;
    private int idVet;
    private int idTratamento;
    private int idAnimal;
    private boolean terminou;
    private int hora;

    public int getId() {
        return id;
    }

    public Consulta(int id, Calendar data, String historico, int idVet, int idTratamento, int idAnimal, boolean terminou, int hora) {
        this.id = id;
        this.data = data;
        this.historico = historico;
        this.idVet = idVet;
        this.idTratamento = idTratamento;
        this.idAnimal = idAnimal;
        this.terminou = terminou;
        this.hora = hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public int getIdVet() {
        return idVet;
    }

    public void setIdVet(int idVet) {
        this.idVet = idVet;
    }

    public int getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(int idTratamento) {
        this.idTratamento = idTratamento;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public boolean isTerminou() {
        return terminou;
    }

    public void setTerminou(boolean terminou) {
        this.terminou = terminou;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

   
    
    
}
