/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author ingri
 */
public class Tienda {
    private String nombre;
    private Producto[] catalogo;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.catalogo = new Producto[20];
    }
    
    public Object[][] getTable(){
        Object[][] tabla = new Object[20][4];
        for(int i = 0; i<tabla.length; i++){
            if(catalogo[i] == null) continue;
            tabla[i][0] = catalogo[i].getCodigo();
            tabla[i][1] = catalogo[i].getNombre();
            tabla[i][2] = catalogo[i].getPrecio();
            if(catalogo[i].getTipo() == 1){
                tabla[i][3] = "Comida";
            } else{
                tabla[i][3] = "Limpieza";
            }
        }
        return tabla;
    }
    
    public Producto getProducto(int indice){
        return catalogo[indice];
    }
    
    public String[] elegirProducto(){
        String cadena = "";
        for(Producto p : catalogo){
            if(p == null) continue;
            cadena += p.getCodigo() + " - " + p.getNombre() + "\n";
        }
        return cadena.split("\n");
    }
    
    public void modificarProducto(int codigo, String nombre, double precio, int tipo){
        this.catalogo[codigo].setNombre(nombre);
        this.catalogo[codigo].setPrecio(precio);
        this.catalogo[codigo].setTipo(tipo);
    }
    
    public boolean cargaMasiva(String texto){
        String[] productos = texto.split("\n");
        for(String producto : productos){
            String[] datos = producto.split(",");
            String nombre = datos[0];
            double precio = Double.parseDouble(datos[1]);
            int tipo = Integer.parseInt(datos[2]);
            if(!this.agregarProducto(nombre, precio, tipo)) return false;
        }
        return true;
    }
    
    public void eliminar(int codigo){
        this.catalogo[codigo] = null;
    }
    
    public boolean agregarProducto(String nombre, double precio, int tipo){
        int codigo = encontrarVacio(nombre);
        if(codigo==-1) return false;
        catalogo[codigo] = new Producto(nombre, precio, codigo, tipo);
        return true;
    }
    
    private int encontrarVacio(String nombre){
        for(int i = 0; i < catalogo.length; i++){
            if(catalogo[i] == null){
                return i;
            }
        }
        return -1;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the catalogo
     */
    public Producto[] getCatalogo() {
        return catalogo;
    }

    /**
     * @param catalogo the catalogo to set
     */
    public void setCatalogo(Producto[] catalogo) {
        this.catalogo = catalogo;
    }
    
    
    
    
}
