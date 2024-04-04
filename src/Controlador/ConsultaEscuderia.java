/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Conexion;
import Modelo.Escuderia;
import Modelo.Patrocinador;
import Modelo.Piloto;
import Vista.PanelJtable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ConoMaster
 */
public class ConsultaEscuderia {

   
    
    public ConsultaEscuderia(Conexion con) {

    }

    public static Escuderia getEscuderia(String codigo, String contraseña) throws SQLException {

        Connection conexion = Conexion.getConnection();
        Statement st = conexion.createStatement();

        st.executeQuery("USE david");
        ResultSet rs = st.executeQuery("Select codigo, contraseña, nombre, mundiales from escuderia where codigo = '" + codigo + "'" + " AND contraseña = '" + contraseña + "'");

        return recorrer(rs);
    }

    public static Escuderia recorrer(ResultSet rs) throws SQLException {
        Escuderia escuderia = null;
        
        
        while (rs.next()) {

            int codigo = rs.getInt("codigo");
            String contraseña = rs.getString("contraseña");
            String nombre = rs.getString("nombre");
            int mundiales = rs.getInt("mundiales");

            escuderia = new Escuderia(codigo, contraseña, nombre, mundiales);

            System.out.println("Nombre de la escudería: " + nombre + " " + contraseña);
        }
        return escuderia;
    }

    public static ArrayList<Escuderia> listaEscuderias() throws SQLException {
        ArrayList<Escuderia> listaEscuderias = new ArrayList<>();
        Connection conexion = Conexion.getConnection();
        Statement st = conexion.createStatement();

        ResultSet rs = st.executeQuery("Select codigo, contraseña, nombre, mundiales from escuderia");
        Escuderia escuderia;
        while (rs.next()) {

            int codigo = rs.getInt("codigo");
            String contraseña = rs.getString("contraseña");
            String nombre = rs.getString("nombre");
            int mundiales = rs.getInt("mundiales");
            escuderia = new Escuderia(codigo, contraseña, nombre, mundiales);
            listaEscuderias.add(escuderia);
            
        }
        return listaEscuderias;

    }

    public static ArrayList<Piloto> listaPilotos(int codigo) throws SQLException {
        ArrayList<Piloto> listaPilotos = new ArrayList<>();
        Connection conexion = Conexion.getConnection();
        Statement st = conexion.createStatement();
        st.executeQuery("USE david");
        ResultSet rs = st.executeQuery("Select nif, nombre, fecha_nacimiento, sueldo, foto, escCodigo from piloto where escCodigo = '"+codigo+"'");
        Piloto piloto;
        while (rs.next()) {

            String nif = rs.getString("nif");
            String nombre = rs.getString("nombre");
            Date fechaNacimiento = rs.getDate("fecha_nacimiento");
            float sueldo = rs.getFloat("sueldo");
            String foto = rs.getString("foto");
            int escCodigo = rs.getInt("escCodigo");
            piloto = new Piloto(nif, nombre, fechaNacimiento, sueldo, foto, escCodigo);
            listaPilotos.add(piloto);
        }
        return listaPilotos;

    }

    public static ArrayList<Patrocinador> listaPatrocinadores(String nif) throws SQLException {
        ArrayList<Patrocinador> listaPatrocinadores = new ArrayList<>();
        Connection conexion = Conexion.getConnection();
        Statement st = conexion.createStatement();
        st.executeQuery("USE david");
        ResultSet rs = st.executeQuery("Select codigo, nombre, pilNif from patrocinador where pilNif = '"+nif+"'");
        Patrocinador patrocinador;
        while (rs.next()) {

            int codigo = rs.getInt("codigo");
            String nombre = rs.getString("nombre");
            String pilNif = rs.getString("pilNif");

            patrocinador = new Patrocinador(codigo, nombre, pilNif);
            listaPatrocinadores.add(patrocinador);
        }
        return listaPatrocinadores;

    }
    
    public static void eliminarPatrocinador(int codigo) throws SQLException {
    Connection conexion = null;
    Statement st = null;

    try {
        conexion = Conexion.getConnection();
        st = conexion.createStatement();
        st.executeQuery("USE david");
        st.executeUpdate("DELETE FROM patrocinador WHERE codigo = '" + codigo + "'");
    } finally {
        // Cerrar recursos
        if (st != null) {
            st.close();
        }
        if (conexion != null) {
            conexion.close();
        }
    }
    }
    
    public static void insertarPatrocinador(Patrocinador patrocinador) throws SQLException, MiExcepcion {
        Connection conexion = null;
        PreparedStatement pst = null;
        Statement st = null;

        try {
            conexion = Conexion.getConnection();
            st = conexion.createStatement();
            
            
            
            st.executeQuery("USE david");
            String query = "INSERT INTO patrocinador (codigo, nombre, pilNif) VALUES (?, ?, ?)";
            pst = conexion.prepareStatement(query);
            pst.setInt(1, patrocinador.getCodigo());
            pst.setString(2, patrocinador.getNombre());
            pst.setString(3, patrocinador.getPilNif());

            
            
            if (existePatrocinador(conexion, patrocinador.getCodigo())) {
            // Mostrar mensaje de error
            throw new MiExcepcion(110);
            //JOptionPane.showMessageDialog(null, "Error: El código de patrocinador ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            
            }
            
            pst.executeUpdate();
        } finally {
            // Cierra los recursos
            if (pst != null) {
                pst.close();
            }
            if (st != null){
                st.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
        
    }
    
    public static void actualizarPatrocinador(Patrocinador patrocinador, int codigo) throws SQLException {
        Connection conexion = null;
        PreparedStatement pst = null;
        Statement st = null;

        try {
            conexion = Conexion.getConnection();
            st = conexion.createStatement();
            
            
            
            st.executeQuery("USE david");
            String query = "UPDATE patrocinador SET codigo = ?, nombre = ?, pilNif = ? WHERE codigo = ?";
            pst = conexion.prepareStatement(query);
            pst.setInt(1, patrocinador.getCodigo()); // Puedes introducir el nuevo código aquí
            pst.setString(2, patrocinador.getNombre());
            pst.setString(3, patrocinador.getPilNif());
            pst.setInt(4, codigo); // Aquí se utiliza el código antiguo para la condición WHERE

            pst.executeUpdate();
        } finally {
            // Cierra los recursos
            if (pst != null) {
                pst.close();
            }
            if (st != null){
                st.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    public static void actualizarMundiales(Escuderia escuderia, int codigo) throws SQLException, MiExcepcion {
        Connection conexion = null;
        PreparedStatement pst = null;
        Statement st = null;

        int mundialesActuales = buscaMundiales(codigo);
        try {
            conexion = Conexion.getConnection();
            st = conexion.createStatement();
            
            if(mundialesActuales >= 20)
            {
                throw new MiExcepcion(109);
            }
            else
            {
                st.executeQuery("USE david");
                String query = "UPDATE escuderia SET mundiales = ? WHERE codigo = ?";
                pst = conexion.prepareStatement(query);
                pst.setInt(1, escuderia.getMundiales() + 1); // Puedes introducir el nuevo código aquí
                pst.setInt(2, escuderia.getCodigo());
            

            pst.executeUpdate();
            }
            
            
        } finally {
            // Cierra los recursos
            if (pst != null) {
                pst.close();
            }
            if (st != null){
                st.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    private static boolean existePatrocinador(Connection conexion, int codigo) throws SQLException {
    String query = "SELECT * FROM patrocinador WHERE codigo = ?";
    try (PreparedStatement pst = conexion.prepareStatement(query)) {
        pst.setInt(1, codigo);
        try (ResultSet rs = pst.executeQuery()) {
            return rs.next(); // Devuelve true si encuentra algún registro
        }
    }
    }
    
    public static int buscaMundiales(int cod) throws SQLException {
        Connection conexion = Conexion.getConnection();
        Statement st = conexion.createStatement();
        int mundialesActuales = 0;
        st.executeQuery("USE david");
        ResultSet rs = st.executeQuery("Select mundiales from escuderia where codigo = "+cod);
        Escuderia escuderia = null;
        while (rs.next()) {
            
            int mundiales = rs.getInt("mundiales");
            mundialesActuales = mundiales;
            
            
        }
        rs.close();
        return mundialesActuales;

    }
    
    public static void actualizarImagenPiloto(String nif, String nuevaRutaImagen) throws SQLException {
        Connection conexion = null;
        PreparedStatement pst = null;

        try {
            conexion = Conexion.getConnection();
            conexion.createStatement().executeQuery("USE david");

            // Query para actualizar la ruta de la imagen del piloto
            String query = "UPDATE piloto SET foto = ? WHERE nif = ?";
            pst = conexion.prepareStatement(query);
            pst.setString(1, nuevaRutaImagen);
            pst.setString(2, nif);

            pst.executeUpdate();
        } finally {
            // Cierra los recursos
            if (pst != null) {
                pst.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
}
