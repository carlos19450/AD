package Ejercicio1.src.ejercicio1;

import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.Math.sqrt;

/**
 *
 * @author carlo
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        /*
        // Ejercicio 1.1:
        
        System.out.println("“Dime tu nombre:");
        String nombre = entrada.nextLine();

        for (int i = 0; i <= 4; i++) {
            System.out.println("Hola, " + nombre + "\n");
        }
         */

/*
        //Ejercicio 1.2:
        System.out.println("Introduce un numero entero: ");
        int numero = entrada.nextInt();

        for (int i = 2; sqrt(numero) >= i; i++) {
            while ((numero%i == 0) && (numero != i)) {
                System.out.print(i + " * ");
                numero = numero / i;
            }
        }
        System.out.println(numero);
*/
 /*
        //Ejercicio 1.3:
        System.out.println("Dame un numero del 1 al 12");
        int num = entrada.nextInt();

        switch (num) {
            case 1:
                System.out.println("Enero");
                break;
            case 2:
                System.out.println("Febrero");
                break;
            case 3:
                System.out.println("Marzo");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Mayo");
                break;
            case 6:
                System.out.println("Junio");
                break;
            case 7:
                System.out.println("Julio");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Septiembre");
                break;
            case 10:
                System.out.println("Octubre");
                break;
            case 11:
                System.out.println("Noviembre");
                break;
            case 12:
                System.out.println("Diciembre");
                break;
            default:
                System.out.println("Error. Dame un número del 1 al 12");
                break;
        }
         */
 /*
        //Ejercicio 1.4:
        String[] mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        System.out.println("Dame un numero del 1 al 12");
        int num = entrada.nextInt();
        System.out.println(mes[num]);
         */
 /*
        //Ejercicio 1.5:
        int num, rev, inverso = 0, cifra;
        boolean esPrimo = true, esPalindromo = true;
        System.out.println("Dame un numero entero");
        num = entrada.nextInt();
        if (num == 0 || num == 1 || num == 4) {
            esPrimo = false;
        }

        for (int x = 2; x < num / 2; x++) {
            if (num % x == 0) {
                esPrimo = false;
            }
        }
        
        rev = num;
        while (rev!=0){
            cifra = rev % 10;
            inverso = inverso * 10 + cifra;
            rev = rev / 10;
        }
        
        if(num != inverso){
            esPalindromo = false;
        }
        
        if (esPalindromo && esPrimo) {
            System.out.println("Es palindromo primo");
        }else{
            System.out.println("No es palindromo primo");
        }
         */
 /*
        //Ejercicio 1.6:
        ArrayList<String> listaNumeros = new ArrayList<String>();
        String cadena;
        int n = 0, num;
        boolean correcto;
        do {
            correcto = true;
            System.out.println("Introduce numeros enteros positivos, para terminar introduce uno negativo.");
            num = entrada.nextInt();
            if (num < 1) {
                correcto = false;
            } else {
                cadena = String.valueOf(num);
                listaNumeros.add(n, cadena);
                n++;
            }
        } while (correcto);
        if (correcto) {

        }
        if (listaNumeros.size() == 0) {
            System.out.println("La lista no contienen nada");
        } else {
            System.out.println("Tu lista es:");
            for (int i = 0; i < listaNumeros.size(); i++) {
                System.out.println(listaNumeros.get(i));
            }
        }
         */
 /*
        //Ejercicio 1.7:
        ArrayList<String> listaCadena = new ArrayList<String>();
        String cadena;
        int n = 0;
        boolean correcto;
        do {
            correcto = true;
            System.out.println("Introduce cadenas, para terminar introduce 'fin'.");
            cadena = entrada.next();
            if (cadena.equalsIgnoreCase("fin")) {
                correcto = false;
            } else {
                listaCadena.add(n, cadena);
                n++;
            }
        } while (correcto);
        if (correcto) {
            
        }
        if (listaCadena.size() == 0) {
            System.out.println("La lista no contienen nada");
        } else {
            System.out.println("Tu lista es:");
            for (int i = 0; i < listaCadena.size(); i++) {
                System.out.println(listaCadena.get(i));
            }
        }
         */
 /*
         //Ejercicio 1.8:
         ListaDeDatos datos = new ListaDeDatos();
        String cadena;
        boolean correcto;
        do {
            correcto = true;
            System.out.println("Introduce cadenas, para terminar introduce 'fin'.");
            cadena = entrada.next();
            if (cadena.equalsIgnoreCase("fin")) {
                correcto = false;
            } else {
                datos.incluir(cadena);
            }
        } while (correcto);
        if (correcto) {
            
        }
        if (datos.contiene() == false) {
            System.out.println("La lista no contienen nada");
        } else {
            System.out.println("Tu lista es:");
            datos.MostrarDatosOrdenados();
        }

  */
    }

}
