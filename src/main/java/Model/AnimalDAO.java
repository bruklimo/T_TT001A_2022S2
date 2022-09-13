/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class AnimalDAO {
     private List<Animal> animal = new ArrayList<Animal> ();
 
 
  public void insertAnimal (int id, String nome, char sexo, int idade, int idCliente, int idEspecie) {
      
     animal.add(new Animal(id,nome,sexo,idade,idCliente,idEspecie));
  }
  
    public Animal readAnimal (int id){
      
     return animal.get(id);
  }
    
    public void deleteAnimal (int id){
        
        animal.remove(id);
    }
    
    public void updateAnimal(int id, String nome, char sexo, int idade, int idCliente, int idEspecie){
        
        animal.remove(id);
        animal.add(new Animal(id,nome,sexo,idade,idCliente, idEspecie));
    }
    
    public int getSize(){
        return animal.size();
    }
    
}
