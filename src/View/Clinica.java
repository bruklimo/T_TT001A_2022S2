/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCliente;
//import static Controller.ControllerCliente.cliente;
import Model.ClienteDAO;

/**
 *
 * @author Bruno
 */
public class Clinica {
//metodo static pra nao precisar instanciar
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     //   ControllerCliente cliente = new ControllerCliente();
     
     ControllerCliente c = new ControllerCliente();
     
     c.cliente(0);
     c.cliente(1);
     for(int i=0; i<=c.getSize();i++){
         System.out.println(c.tostring(i));
     }
       // System.out.println(cliente(1)); //cliente();
      //  System.out.println();
        
    }
    
}
