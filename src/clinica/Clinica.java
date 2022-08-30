/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import Controller.ControllerCliente;
import static Controller.ControllerCliente.cliente;
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
        System.out.println(cliente()); //cliente();
      //  System.out.println();
        
    }
    
}
