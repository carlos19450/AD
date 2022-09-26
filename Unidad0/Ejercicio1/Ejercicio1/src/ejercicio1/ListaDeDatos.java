/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class ListaDeDatos {

    ArrayList<String> listaCadena = new ArrayList<String>();

    public ListaDeDatos() {
    }

    public void incluir(String texto) {
        int n = 0;
        listaCadena.add(n, texto);
        n++;
    }

    public boolean contiene() {
        boolean correcto = true;
        if (listaCadena.size() == 0) {
            correcto = false;
        }
        return correcto;
    }

    public void MostrarDatosOrdenados() {
        for (int i = 0; i < listaCadena.size(); i++) {
            System.out.println(listaCadena.get(i));
        }
    }

}
