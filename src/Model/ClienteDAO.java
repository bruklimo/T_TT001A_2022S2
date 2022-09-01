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
public class ClienteDAO {
    
 private List<Cliente> cliente = new ArrayList<Cliente> ();
 
 
  public void insert (int id, String nome, String end, String cep, String email, String telefone, Animal a) {
      
     cliente.add(id,new Cliente(id,nome,end, cep, email, telefone));
  }
  
    public Cliente read (int id){
      
     return cliente.get(id);
  }
    
    public void delete (int id){
        
        cliente.remove(id);
    }
    
    public void update(int id,String nome, String end, String cep, String email, String telefone, Animal a){
        
        cliente.remove(id);
        cliente.add(new Cliente(id,nome,end, cep, email, telefone));
    }
    
    public int getSize(){
        return cliente.size();
    }
    
    public List<Animal> getAnimal(int id){
        return cliente.get(id).getAnimal();
    }
    
}
