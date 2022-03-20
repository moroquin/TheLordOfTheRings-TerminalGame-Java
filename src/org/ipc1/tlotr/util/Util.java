package org.ipc1.tlotr.util;

import java.util.Random;
import java.util.Scanner;

public class Util {

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static int tirarDadosNumeroMayor(int cantidad, int min, int max, String mensaje) {
        System.out.println("******* "+ mensaje);
        int res = 0;
        int tmp = 0;
        for (int i = 1; i <= cantidad; i++) {
            tmp = generarNumeroRandom(min, max);
            solicitarEnter("Presion cualquier tecla para tirar el dado:\n");
            System.out.println("Tirando el " + i + "dado ");
            System.out.println("El número obtenido es:"+tmp);
            if (tmp>res){
                res = tmp;
            }
        }
        System.out.println("El número mayor obtenido es:"+res);
        solicitarEnter("Presione para continuar");

        return res;

    }

    public static int generarNumeroRandom(int min, int max) {
        // int tmp = random.nextInt(max-min)+min;
        // System.out.println(tmp);

        // return tmp;
        return random.nextInt(max - (min-1)) + 1 + (min-1);
    }

    public static String solicitarString(String mensaje) {
        String respuesta = "";
        boolean hayErrorStringIngresado = false;

        do {
            System.out.println("\n" + mensaje);
            respuesta = scanner.nextLine();
            // scanner.nextLine();//probar
            respuesta = respuesta.trim();
            if (respuesta.length() > 0) {
                hayErrorStringIngresado = false;
            } else {
                hayErrorStringIngresado = true;
                System.out.println("Ingresa un caracter como minimo.");
            }

        } while (hayErrorStringIngresado);

        return respuesta;
    }

    public static String solicitarEnter(String mensaje) {
        String respuesta = "";

        System.out.println("\n" + mensaje);
        respuesta = scanner.nextLine();
        // scanner.nextLine();//probar

        return respuesta;
    }
}
