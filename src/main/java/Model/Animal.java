/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author b167460
 */
public class Animal {
    private int id;
    private String nome;
    private char sexo;
    private int idade;
    private int idEspecie;
    private int idCliente;


  
public Animal(int id, String nome, char sexo, int idade, int idEspecie, int idCliente) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.idEspecie = idEspecie;
        this.idCliente = idCliente;
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    

   
     @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", idade=" + idade + ", idEspecie=" + idEspecie + ", idCliente=" + idCliente + '}';
    }
}
