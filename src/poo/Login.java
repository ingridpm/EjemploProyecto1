/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import Clases.Registro;
import Clases.Usuario;
import java.awt.Font;
import java.awt.HeadlessException;
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
public class Login extends JFrame implements ActionListener{

    JTextField txtUsuario;
    JPasswordField  txtContra;
    JButton btnIngresar, btnRegistrarse;
    Registro registro;
    
    public Login(Registro registro){
        this.registro = registro;
        configurarVentana();
        addLabel("Iniciar Sesión",50,50,400,40,30);
        addLabel("Nombre",100,100,200,30,20);
        txtUsuario = addTextField("",350,100,200,30);
        addLabel("Contraseña",100,150,200,30,20);
        txtContra = addPasswordField("",350,150,200,30);
        btnIngresar = addButton("Iniciar Sesión",125,200,150,30);
        btnRegistrarse = addButton("Registrarse",375,200,150,30);
    }
    
    private void configurarVentana() {
        setTitle("Iniciar Sesión");
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
        if(ae.getSource() == this.btnIngresar){
            System.out.println("Usuario ingresado: " + this.txtUsuario.getText() + "\nContraseña ingresada: " + this.txtContra.getText());
            Usuario user = this.registro.validarCredenciales(this.txtUsuario.getText(), this.txtContra.getText());
            if(user == null){
                JOptionPane.showMessageDialog(this, "Usuario o contraseña inválidos");
            } else {
                this.setVisible(false);
                new Inicio(user);
                this.dispose();
            }
        }
        
        if(ae.getSource() == this.btnRegistrarse){
            if(registro.estaLleno()){
                JOptionPane.showMessageDialog(this, "Ya no hay más espacios.");
            } else {
                this.setVisible(false);
                new Registrarse(registro);
                this.dispose();
            }
        }
        
    }
    
}
