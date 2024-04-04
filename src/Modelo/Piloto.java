/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author David
 */
public class Piloto {
    String nif;
    String nombre;
    Date fechaNacimiento;
    float sueldo;
    String foto;
    int escCodigo;

    public Piloto(String nif, String nombre, Date fechaNacimiento, float sueldo, String foto, int escCodigo) {
        this.nif = nif;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.foto = foto;
        this.escCodigo = escCodigo;
    }
    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getEscCodigo() {
        return escCodigo;
    }

    public void setEscCodigo(int escCodigo) {
        this.escCodigo = escCodigo;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
