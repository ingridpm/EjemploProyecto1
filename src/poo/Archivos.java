/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ingri
 */
public class Archivos {
    public static String leerArchivo(JFrame ventana){
        String texto = "";
        try{
            JFileChooser selectorArchivos = new JFileChooser();
            selectorArchivos.showOpenDialog(ventana); //abrimos el selector
            
            File archivo = selectorArchivos.getSelectedFile(); //obtener el archivo seleccionado
            
            if(archivo!=null){
                FileReader lector = new FileReader(archivo);
                BufferedReader leer = new BufferedReader(lector);
                String auxiliar = "";
                while((auxiliar = leer.readLine())!= null){
                    texto += auxiliar + "\n";
                }
                leer.close();
            }
            
        } catch (IOException ex){
            JOptionPane.showMessageDialog(ventana, ex + "\nNo se ha encontrado el archivo","", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }
}
