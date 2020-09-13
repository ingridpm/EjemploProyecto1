/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import Clases.Producto;
import Clases.Usuario;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ingri
 */
public class ModificarProducto extends JFrame implements ActionListener {
    Clases.Tienda tienda;
    JTextField txtNombre, txtPrecio;
    JComboBox cbTipo;
    JButton btnAgregarProducto;
    Usuario usuarioActual;
    int codigoProducto;
    Producto productoActual;
    
    public ModificarProducto(Usuario usuarioActual, Clases.Tienda tienda, int codigoProducto){
        this.codigoProducto = codigoProducto;
        this.productoActual = tienda.getProducto(codigoProducto);
        this.usuarioActual = usuarioActual;
        this.tienda = tienda;
        configurarVentana();
        addLabel("Modificar Productos",50,50,400,40,30);
        addLabel("Nombre: ", 100,100,200,30,15);
        txtNombre = addTextField(this.productoActual.getNombre(),350,100,200,30);
        addLabel("Precio: ", 100,150,200,30,15);
        txtPrecio = addTextField(this.productoActual.getPrecio() + "",350,150,200,30);
        addLabel("Tipo: ", 100,200,200,30,15);
        String[] opciones = {"Comida","Limpieza"};
        cbTipo = addComboBox(opciones,350,200,200,30);
        cbTipo.setSelectedIndex(this.productoActual.getTipo()-1);
        btnAgregarProducto = addButton("Modificar Producto", 200,250,200,30);
    }
    
    private void configurarVentana() {
        setTitle("Modifiar Productos");
        setLayout(null);
        setSize(800,600);
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
    
    private JComboBox addComboBox(String[] opciones, int x, int y, int ancho, int altura){
        JComboBox lbl = new JComboBox(opciones);
        lbl.setBounds(x, y, ancho, altura);
        add(lbl);
        repaint();
        return lbl;
    }
    
    private JTextField addTextField(String texto, int x, int y, int ancho, int altura){
        JTextField txt = new JTextField(texto);
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
        if(ae.getSource() == this.btnAgregarProducto){
            this.tienda.modificarProducto(this.codigoProducto,txtNombre.getText(), Double.parseDouble(txtPrecio.getText()), cbTipo.getSelectedIndex() + 1);
            setVisible(false);
            new Tienda(usuarioActual, tienda);
            this.dispose();
        }
    }
}
