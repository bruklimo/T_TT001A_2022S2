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
 
  public void insertCliente (int id, String nome, String end, String cep, String email, String telefone, Animal a){
      
     cliente.add(id,new Cliente(id,nome,end, cep, email, telefone, a));
  }
  
  
  public void insertAnimal (int id, Animal a){
     cli=cliente.get(id);
     cli.setAnimal(a);
  }
  
    public String readCliente (int id){
     return cliente.get(id).toString();
  }
    
    public List<Animal> retornaAimal(int id){
        return cliente.get(id).getAnimal();
    }
  
    public int getSize(){
        return cliente.size();
    }
    
    public void deleteCliente (int id){
        
        cliente.remove(id);
    }
    
    public void updateCliente(int id, String nome, String end, String cep, String email, String telefone, Animal a){
        
        cliente.remove(id);
        cliente.add(id,new Cliente(id,nome,end, cep, email, telefone, a));
        
    }
    
    
}
