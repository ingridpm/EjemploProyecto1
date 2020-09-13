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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author ingri
 */
public class Tienda extends JFrame implements ActionListener{
    String nombre;
    Clases.Tienda tienda;
    Usuario usuarioActual;
    JButton btnAgregar, btnModificar, btnEliminar, btnLeerArchivo;
    JTable tblProductos;

    public Tienda(Usuario usuarioActual, Clases.Tienda tienda) {
        this.nombre = tienda.getNombre();
        this.tienda = tienda;
        this.usuarioActual = usuarioActual;
        configurarVentana();
        addLabel("user: " + this.usuarioActual.getNombre(),600, 10, 375, 50,15);
        addLabel(nombre, 50,50,400,40,30);
        addTable();
        btnAgregar = addButton("Agregar Producto", 600, 50, 150,50);
        btnModificar = addButton("Modificar Producto", 50,475,150,50);
        btnEliminar = addButton("Eliminar Producto", 225,475,150,50);
        btnLeerArchivo = addButton("Leer Archivo", 400,475,150,50);
    }

    private void configurarVentana() {
        setTitle(nombre);
        setLayout(null);
        setSize(800,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private JButton addButton(String texto, int x, int y, int ancho, int altura){
        JButton btn = new JButton(texto);
        btn.setBounds(x, y, ancho, altura);
        btn.addActionListener(this);
        add(btn);
        repaint();
        return btn;
    }

    
    private void addLabel(String texto, int x, int y, int ancho, int altura, int tamano){
        JLabel lbl = new JLabel(texto);
        lbl.setBounds(x, y, ancho, altura);
        lbl.setFont(new Font("Verdana", Font.PLAIN, tamano));
        add(lbl);
        repaint();
    }
    
    private void addTable(){
        String[] columnas = {"Codigo","Nombre","Precio","Tipo"};
        Object[][] datos = this.tienda.getTable();
        tblProductos = new JTable(datos, columnas);
        JScrollPane sp = new JScrollPane(tblProductos);
        sp.setBounds(50,100,700,350);
        this.add(sp);
        this.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this.btnAgregar){
            new AgregarProductos(usuarioActual, this.tienda);
            this.dispose();
        }
        
        if(ae.getSource() == this.btnModificar){
            String[] lista = this.tienda.elegirProducto();
            JComboBox cb = new JComboBox(lista);
            cb.setEditable(true);
            JOptionPane.showMessageDialog(this, cb, "Seleccione un producto a modificar",JOptionPane.QUESTION_MESSAGE);
            int indiceSeleccionado = cb.getSelectedIndex();
            String producto = lista[indiceSeleccionado];
            String[] datosProducto = producto.split(" - ");
            int indice = Integer.parseInt(datosProducto[0]);
            new ModificarProducto(this.usuarioActual, this.tienda, indice);
            this.dispose();
        }
        
        if(ae.getSource() == this.btnEliminar){
            int indice = this.tblProductos.getSelectedRow();
            this.tienda.eliminar(indice);
            new Tienda(this.usuarioActual, this.tienda);
            this.dispose();
        }
        
        if(ae.getSource() == this.btnLeerArchivo){
            String contenido = Archivos.leerArchivo(this);
            this.tienda.cargaMasiva(contenido);
            new Tienda(this.usuarioActual, this.tienda);
            this.dispose();
        }
    }
    
    
}
