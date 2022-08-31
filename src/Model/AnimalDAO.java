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
 
 
  public void insert (int id, String nome, char sexo, int idade) {
      
     animal.add(new Animal(id,nome,sexo,idade));
  }
  
    public Animal read (int id){
      
     return animal.get(id);
  }
    
    public void delete (int id){
        
        animal.remove(id);
    }
    
    public void update(int id, String nome, char sexo, int idade){
        
        animal.remove(id);
        animal.add(new Animal(id,nome,sexo,idade));
    }
    
    public int getSize(){
        return animal.size();
    }
    
}
