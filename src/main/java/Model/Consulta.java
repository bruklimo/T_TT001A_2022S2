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
public class Consulta {
    private int id;
    private String data;
    private String historico;
    private int idVet;
    private int idTratamento;
    private int idAnimal;
    private boolean terminou;
    private int hora;

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", data=" + data + ", historico=" + historico + ", idVet=" + idVet + ", idTratamento=" + idTratamento + ", idAnimal=" + idAnimal + ", terminou=" + terminou + ", hora=" + hora + '}';
    }
   

    public int getId() {
        return id;
    }

    public Consulta(int id, String data, String historico, int idVet, int idTratamento, int idAnimal, boolean terminou, int hora) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
