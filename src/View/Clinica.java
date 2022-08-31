/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCliente;
import java.util.Scanner;

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
     
     ControllerCliente controllerCliente = new ControllerCliente();
     Scanner myInput = new Scanner( System.in );
     controllerCliente.animal(0,"tony");
     controllerCliente.cliente(0, "Bruno",0);
     controllerCliente.animal(1,"prin");
     controllerCliente.cliente(1,"Ana",1);

     for(int i=0; i<controllerCliente.getSize();i++){
         System.out.println(controllerCliente.tostring(i));
     }
     
        System.out.println("Escolha um id de cliente para pegar os animais");
        int a = myInput.nextInt();
        
        System.out.println(controllerCliente.getAnimal(a));
        
    }
    
}
