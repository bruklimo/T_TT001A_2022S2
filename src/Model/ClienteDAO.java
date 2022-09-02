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
 Cliente cli;
 
  public void insert (int id, String nome, String end, String cep, String email, String telefone, Animal a) {
      
     cliente.add(id,new Cliente(id,nome,end, cep, email, telefone, a));
  }
  
  
  public void insertA (int id, Animal a){
      
     cli= cliente.get(id);
     cli.setAnimal(a);
      
      
  }
  
    public String read (int id){
      
     return cliente.get(id).toString();
  }
    
    public List<Animal> retornaA(int id){
        return cliente.get(id).getAnimal();
    }
  
    public int getSize(){
        return cliente.size();
    }
    
    
}
