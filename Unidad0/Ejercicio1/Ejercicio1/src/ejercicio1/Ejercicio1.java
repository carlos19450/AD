package Ejercicio1.src.ejercicio1;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;

public class Ejercicio1 {
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
        ArrayList<Integer> list = new ArrayList();
        int numero, numCop;
        System.out.println("Introduce un numero entero: ");
        numero = entrada.nextInt();
        numCop = numero;

        for (int i = 2; sqrt(numero) >= i; i++) {
            while ((numero % i == 0) && (numero != i)) {
                numero = numero / i;
                list.add(i);
            }
        }
        list.add(numero);
        System.out.println(numCop + " = " + list.stream().map(String::valueOf).collect(Collectors.joining(" * ")));
        */
        /*
        //Ejercicio 1.3:
        System.out.println("Dame un numero del 1 al 12");
        int num = entrada.nextInt();
        String mes = "";
        switch (num) {
            case 1 -> mes = "Enero";
            case 2 -> mes = "Febrero";
            case 3 -> mes = "Marzo";
            case 4 -> mes = "Abril";
            case 5 -> mes = "Mayo";
            case 6 -> mes = "Junio";
            case 7 -> mes = "Julio";
            case 8 -> mes = "Agosto";
            case 9 -> mes = "Septiembre";
            case 10 -> mes = "Octubre";
            case 11 -> mes = "Noviembre";
            case 12 -> mes = "Diciembre";
            default -> mes = "Error. Dame un número del 1 al 12";
        }
        System.out.println("El mes es: "+ mes);
        */
        /*
        //Ejercicio 1.4:
        String[] mes = {"","Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
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
        if (num <= 1 || num % 2 == 0) {
            esPrimo = false;
        }

        for (int x = 3; x * x < num / 2; x += 2) {
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
            System.out.println("Introduce numeros enteros positivos, para terminar introduce uno negativo.");
                num = entrada.nextInt();
                cadena = String.valueOf(num);
                    if (num >= 1) {
                        listaNumeros.add(cadena);
                    }
        } while (num >= 1);

        do {
            System.out.println("Introduce un numero para saber si esta en la lista, para salir introduce un numero negativo");
                num = entrada.nextInt();
                cadena = String.valueOf(num);
            if (num >= 1) {
                if (listaNumeros.contains(cadena)) {
                    System.out.println("El numero "+ cadena +" si esta en la lista.");
                } else {
                    System.out.println("El numero "+ cadena +" no esta en la lista.");
                }
            }
        } while (num >= 1);
        */
        /*
        //Ejercicio 1.7:
        ArrayList<String> listaCadena = new ArrayList<String>();
        String cadena;
        int n = 0;
        do {
            System.out.println("Introduce cadenas, para terminar introduce 'fin'.");
            cadena = entrada.next();
            if (!cadena.equalsIgnoreCase("Fin")) {
                listaCadena.add(cadena);
            }
        } while (!cadena.equalsIgnoreCase("Fin"));
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
            System.out.println("Introduce cadenas, para terminar introduce 'fin'.");
            cadena = entrada.nextLine();
            if (!cadena.equalsIgnoreCase("Fin")) {
                datos.incluir(cadena);
            }
        } while (!cadena.equalsIgnoreCase("Fin"));
            System.out.println("Tu lista es:");
            datos.MostrarDatosOrdenados();
        }
        */
    }
}
