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
public class Patrocinador {
    int codigo;
    String nombre;
    String pilNif;

    public Patrocinador(int codigo, String nombre, String pilNif) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pilNif = pilNif;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPilNif() {
        return pilNif;
    }

    public void setPilNif(String pilNif) {
        this.pilNif = pilNif;
    }
}
