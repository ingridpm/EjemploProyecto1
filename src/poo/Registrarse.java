/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import Clases.Registro;
import Clases.Usuario;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ingri
 */
public class Registrarse extends JFrame implements ActionListener{

    JTextField txtUsuario;
    JPasswordField  txtContra;
    JButton btnRegistrarse;
    Registro registro;
    
    public Registrarse(Registro registro){
        this.registro = registro;
        configurarVentana();
        addLabel("Registrase",50,50,400,40,30);
        addLabel("Nombre",100,100,200,30,20);
        txtUsuario = addTextField("",350,100,200,30);
        addLabel("Contraseña",100,150,200,30,20);
        txtContra = addPasswordField("",350,150,200,30);
        btnRegistrarse = addButton("Registrarse",200,200,150,30);
    }
    
    private void configurarVentana() {
        setTitle("Registrarse");
        setLayout(null);
        setSize(700,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void addLabel(String texto, int x, int y, int ancho, int altura, int tamano){
        JLabel lbl = new JLabel(texto);
        lbl.setBounds(x, y, ancho, altura);
        lbl.setFont(new Font("Verdana", Font.PLAIN, tamano));
        add(lbl);
        repaint();
    }
    
    private JTextField addTextField(String texto, int x, int y, int ancho, int altura){
        JTextField txt = new JTextField(texto);
        txt.setBounds(x, y, ancho, altura);
        add(txt);
        repaint();
        return txt;
    }
    
    private JPasswordField addPasswordField(String texto, int x, int y, int ancho, int altura){
        JPasswordField txt = new JPasswordField(texto);
        txt.setBounds(x, y, ancho, altura);
        add(txt);
        repaint();
        return txt;
    }
    
    private JButton addButton(String texto, int x, int y, int ancho, int altura){
        JButton btn = new JButton(texto);
        btn.setBounds(x, y, ancho, altura);
        btn.addActionListener(this);
        add(btn);
        repaint();
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.btnRegistrarse){
            if(this.registro.agregarUsuario(txtUsuario.getText(), txtContra.getText())){
                JOptionPane.showMessageDialog(this, "Registro exitoso");
                this.setVisible(true);
                new Login(registro);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un usuario con este nombre.");
            }
        }
        
    }
    
}