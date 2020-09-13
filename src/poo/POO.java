/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import Clases.Registro;

/**
 *
 * @author ingri
 */
public class POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Login(new Registro("admin","admin"));
        
        
        String[] nombres = {"Alejandro", "Rony", "Bryan", "Daniel"};
        for(int i = 0; i < nombres.length; i++){
            String nombre = nombres[i];
            System.out.println(nombre);
        }
        
        System.out.println("FOREACH-----------------");
        for(String nombre : nombres){
            System.out.println(nombre);
        }
    }
    
}
