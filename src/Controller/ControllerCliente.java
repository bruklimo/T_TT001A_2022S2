/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Animal;
import Model.AnimalDAO;
import Model.Cliente;
import Model.ClienteDAO;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class ControllerCliente {
    
    
    ClienteDAO clientedao = new ClienteDAO();
    Animal animal;
    
    public void cliente(int id, String nome,int idAnimal){
        
        
        clientedao.insert(id,nome,"Bende","16151551","babab@baba.com","919191",animal);

}
    
    public void animal (int idAnimal, String nome, int idCliente){
         animal = new Animal(idAnimal,nome,'f',39,idCliente);
    }
    
    
    public int getSize (){
        
        return clientedao.getSize();
    }
    
    public String tostring(int id){
        return clientedao.read(id).toString();
    }
    
    public Cliente tostring2(int id){
        return clientedao.read(id);
    }
    
public List<Animal> getAnimal (int id){
   return clientedao.getAnimal(id);
    
}
    

    
}
