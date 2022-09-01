/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCliente;
import Model.Animal;
import Model.Cliente;
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
     
    /* ControllerCliente controllerCliente = new ControllerCliente();
     controllerCliente.animal(0,"tony",0);
     controllerCliente.cliente(0, "Bruno",0);
     controllerCliente.animal(1,"prin",1);
     controllerCliente.cliente(1,"Ana",1);
     controllerCliente.animal(2,"hue",0);
     controllerCliente.cliente(0, "Bruno",2);

     
     for(int i=0; i<controllerCliente.getSize();i++){
         System.out.println(controllerCliente.tostring(i));
     }
        Scanner myInput = new Scanner( System.in );
        System.out.println("Escolha um id de cliente para pegar os animais");
        int a = myInput.nextInt();
        
        
        System.out.println(controllerCliente.tostring(a));
        
      //  System.out.println(controllerCliente.getAnimal(a));
        */
    
    Cliente c = new Cliente(1,"aa","aa","aa","ss","bb");
    Animal a = new Animal(1,"a",'a',1,1);
     Animal b = new Animal(100,"a",'a',1,1);
     Cliente c1 = new Cliente(1,"aa","aa","aa","ss","bb");
     Animal b1 = new Animal(200,"a",'a',1,1);
    c.setAnimal(a);
    c.setAnimal(b);
    c1.setAnimal(b1);
   // c.getAnimal();
        System.out.println(c1.getAnimal().get(0));
     //   System.out.println(c.toString());
    }
    
}
