/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author David
 */
public class Escuderia {
    int codigo;
    String contraseña;
    String nombre;
    int mundiales;

    public Escuderia(int codigo, String contraseña, String nombre, int mundiales) {
        this.codigo = codigo;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.mundiales = mundiales;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMundiales() {
        return mundiales;
    }

    public void setMundiales(int mundiales) {
        this.mundiales = mundiales;
    }
    
    
}
