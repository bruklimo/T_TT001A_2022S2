package Model;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author b167460
 */
public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private String cep;
    private String email;
    private String telefone;
    private List<Animal> animal=new ArrayList<Animal>() ; 

    public List<Animal> getAnimal() {
        return this.animal;
    }

    public void setAnimal(Animal animal) {
        if(!animal.getNome().isBlank()){
            this.animal.add(animal);
        }
        
    }

    @Override
    public String toString() {
        String desc = "Cliente{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cep=" + cep + ", email=" + email + ", telefone=" + telefone + '}';
        String animals = animal.toString();
        return desc + animals;
    }
    

    public Cliente(int id, String nome, String endereco, String cep, String email, String telefone, Animal animal) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
        this.telefone = telefone;
         this.animal.add(animal);
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
