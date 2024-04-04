/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author David
 */
import Vista.PanelFilasUnaUna;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ControladorArrayList<T> {
    private ArrayList<T> lista;
    private int indiceActual;

    public ControladorArrayList(ArrayList<T> lista) {
        this.lista = lista;
        this.indiceActual = -1;
    }
    
    public ControladorArrayList() {}
    
    public int retrocedeIndex(JList jList, PanelFilasUnaUna panel)
    {        
        int index = jList.getSelectedIndex()-1;
        
        if(index < jList.getFirstVisibleIndex())
        {
            index++;
            JOptionPane.showMessageDialog(panel, "No hay mas pilotos");
        }
        
        return index;
    }
    
    public int avanzaIndex(JList jList, PanelFilasUnaUna panel)
    {        
        int index = jList.getSelectedIndex()+1;
        
        if(index > jList.getComponentCount())
        {
            index--;
           JOptionPane.showMessageDialog(panel, "No hay mas pilotos");
        }
        
        return index;
    }

    public int irPrimeroIndex(JList jList, PanelFilasUnaUna panel)
    {
        int numComprobacion = jList.getSelectedIndex();
        int index = jList.getFirstVisibleIndex();
        
        if(numComprobacion == index)
        {
            JOptionPane.showMessageDialog(panel, "Ya estás en el primer piloto");
            return index;
        }
        else
        {
            index = jList.getFirstVisibleIndex();
            return index;
        }
    }
    
    public int irUltimoIndex(JList jList, PanelFilasUnaUna panel)
    {
        int numComprobacion = jList.getSelectedIndex();
        int index = jList.getLastVisibleIndex();
        
        if(numComprobacion == index)
        {
            JOptionPane.showMessageDialog(panel, "Ya estás en el último piloto");
            return index;
        }
        else
        {
            index = jList.getLastVisibleIndex();
            return index;
        }
    }
    
    public T avanzar() {
        if (indiceActual < lista.size() - 1) {
            indiceActual++;
            return lista.get(indiceActual);
        } else {
            return null; // No hay siguiente elemento
        }
    }

    public T retroceder() {
        if (indiceActual > 0) {
            indiceActual--;
            return lista.get(indiceActual);
        } else {
            return null; // No hay elemento anterior
        }
    }

    public boolean isFirst() {
        if (indiceActual == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLast() {
        if (indiceActual == lista.size() - 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public void irPrimero() {
        indiceActual = 0;
    }

    public void irUltimo() {
        indiceActual = lista.size() - 1;
    }
    
    public T obtenerElementoActual() {
        if (indiceActual >= 0 && indiceActual < lista.size()) {
            return lista.get(indiceActual);
        } else {
            return null; // Puedes manejar este caso según tus necesidades
        }
    }
    
}
