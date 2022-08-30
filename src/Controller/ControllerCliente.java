/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ClienteDAO;

/**
 *
 * @author Bruno
 */
public class ControllerCliente {
    
    
    ClienteDAO clientedao = new ClienteDAO();
    
    public void cliente(int id){
        
        
        
        clientedao.insert(0,"Bruno","Bende","16151551","babab@baba.com","919191");
        clientedao.insert(1,"xande","huehue","187871781","ahahha@haahha.com","10982981982");
        
        
       
        
    
    
}
    
    public int getSize (){
        
        return clientedao.getSize();
    }
    
    public String tostring(int id){
        return clientedao.read(id).toString();
    }
    
    
    
}
