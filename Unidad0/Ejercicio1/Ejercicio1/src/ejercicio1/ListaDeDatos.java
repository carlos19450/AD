/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1.src.ejercicio1;

import java.util.ArrayList;
public class ListaDeDatos {

    ArrayList<String> listaCadena = new ArrayList<String>();

    public ListaDeDatos() {
    }

    public void incluir(String cadena) {
        listaCadena.add(cadena);
    }

    public boolean contiene(String cadena) {
        return listaCadena.contains(cadena);
    }

    public void MostrarDatosOrdenados() {
        for (int i = 0; i < listaCadena.size(); i++) {
            System.out.println(listaCadena.get(i));
        }
    }

}
