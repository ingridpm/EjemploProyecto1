/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import Clases.Usuario;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ingri
 */
public class Inicio {
    JFrame ventanaPrincipal;
    JTextField txtNombreTienda;
    Usuario usuarioActual;
    
    public Inicio(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
        ventanaPrincipal = new JFrame();
        configurarVentana();
        agregarUsuario();
        agregarBienvenido();
        agregarNombreTienda();
        agregarBotonPrincipal();
    }

    private void configurarVentana() {
        ventanaPrincipal.setTitle("Crear Tienda");
        ventanaPrincipal.setLayout(null);
        ventanaPrincipal.setSize(800,600);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void agregarUsuario() {
        JLabel lblBienvenido = new JLabel("User: " + this.usuarioActual.getNombre());
        lblBienvenido.setBounds(600, 10, 375, 50);
        lblBienvenido.setFont(new Font("Verdana", Font.PLAIN, 15));
        ventanaPrincipal.add(lblBienvenido);
    }

    private void agregarBienvenido() {
        JLabel lblBienvenido = new JLabel("Bienvenido!");
        lblBienvenido.setBounds(200, 125, 375, 50);
        lblBienvenido.setFont(new Font("Verdana", Font.PLAIN, 60));
        ventanaPrincipal.add(lblBienvenido);
    }

    private void agregarNombreTienda() {
        txtNombreTienda = new JTextField("Ingrese nombre");
        txtNombreTienda.setBounds(200, 200, 375, 50);
        ventanaPrincipal.add(txtNombreTienda);
        ventanaPrincipal.repaint();
    }

    private void agregarBotonPrincipal() {
        JButton btnPrincipal = new JButton("Crear Tienda");
        btnPrincipal.setBounds(200, 275, 375, 50);
        ventanaPrincipal.add(btnPrincipal);
        ventanaPrincipal.repaint();
        btnPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Nombre elegido: " + txtNombreTienda.getText());
                new Tienda(usuarioActual, new Clases.Tienda(txtNombreTienda.getText()));
                ventanaPrincipal.setVisible(false);
                ventanaPrincipal.dispose();
            }
        });
    }
    
}
