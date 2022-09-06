/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Animal;
import Model.ClienteDAO;

/**
 *
 * @author Bruno
 */
public class ControllerCliente {
    
    
    ClienteDAO clientedao = new ClienteDAO();
    
    public void cliente(int id, String nome, Animal animal){
        clientedao.insertCliente(id,nome,"Bende","16151551","babab@baba.com","919191",animal);
}

    public int getSize (){   
        return clientedao.getSize();
    }
    
    public String tostring(int id){
        return clientedao.readCliente(id);
    }
    
 
    
}
