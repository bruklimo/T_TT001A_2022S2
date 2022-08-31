/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Animal;
import Model.AnimalDAO;
import Model.ClienteDAO;

/**
 *
 * @author Bruno
 */
public class ControllerCliente {
    
    
    ClienteDAO clientedao = new ClienteDAO();
    AnimalDAO animal = new AnimalDAO();
    
    public void cliente(int id, String nome,int idAnimal){
        
        
        clientedao.insert(id,nome,"Bende","16151551","babab@baba.com","919191",animal.read(idAnimal));

}
    
    public void animal (int idAnimal, String nome){
         animal.insert(idAnimal,nome,'f',39);
    }
    
    public int getSize (){
        
        return clientedao.getSize();
    }
    
    public String tostring(int id){
        return clientedao.read(id).toString();
    }
    
public String getAnimal (int id){
   return clientedao.getAnimal(id);
    
}
    
    
}
