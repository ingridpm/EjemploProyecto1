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
public class Registro {
    private Usuario[] usuarios;
    private Usuario maestro;

    public Registro(String nombre, String contrasena) {
        maestro = new Usuario(nombre, contrasena);
        usuarios = new Usuario[10];
    }
    
    public boolean agregarUsuario(String nombre, String contra){
        if(existeUsuario(nombre)) return false;
        for(int i = 0; i < usuarios.length; i++){
            if(usuarios[i] == null){
                usuarios[i] = new Usuario(nombre, contra);
                return true;
            }
        }
        return false;
    }
    
    public boolean estaLleno(){
        for(Usuario user : usuarios){
            if(user == null) return false;
        }
        return true;
    }
    
    public Usuario validarCredenciales(String nombre, String contrasena){
        if(!existeUsuario(nombre)) return null;
        if(maestro.validarCredenciales(nombre, contrasena)) return maestro;
        for(Usuario user : usuarios){
            if(user == null) continue;
            if(user.validarCredenciales(nombre, contrasena)) return user;
        }
        return null;
    }
    
    public boolean existeUsuario(String nombre){
        if(maestro.getNombre().equalsIgnoreCase(nombre)) return true;
        for(Usuario user : usuarios){
            if(user == null) continue;
            if(user.getNombre().equalsIgnoreCase(nombre)) return true;
        }
        return false;
    }

    /**
     * @return the usuarios
     */
    public Usuario[] getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the maestro
     */
    public Usuario getMaestro() {
        return maestro;
    }

    /**
     * @param maestro the maestro to set
     */
    public void setMaestro(Usuario maestro) {
        this.maestro = maestro;
    }
    
    
}
