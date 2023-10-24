package com.liceolapaz.des.sfr;

import java.util.Scanner;

public class Principal {
    private static final int sin_cuenta = 0;
    private static final int cuenta_normal = 1;
    private static final int cuenta_premium = 2;

    private static int tipoCuenta = sin_cuenta;
    private static double saldoCuenta = 0;

    public static void main(String[] args) {
        do {
            //Escribir menú
            escribirMenu();
            //Escoger opción y guardarla
            int opcion = leerOpcion();
            escribirMensaje(opcion);
        } while (true);

    }

    private static void escribirMensaje(int opcion) {
        switch (opcion) {
            case 0:
                //Salir del menú
                System.exit(0);
                break;
            case 1:
                //Crear cuenta (aparece un nuevo menú)
                System.out.println
                        ("Tipo de cuenta\n" +
                                "1.Cuenta normal\n" +
                                "2.Cuenta premium\n" +
                                "0.Cancelar\n" +
                                "Escoja una opción ");

                //Leer opción escogida del menú y guardarla
                int opcion2 = leerOpcionMenu();
               //Si la opción escogida es 1:
                if(opcion2==1){
                    crearCuenta(cuenta_normal); }
                //Si la opción escogida es 2:
                    else if(opcion2==2){
                        crearCuenta(cuenta_premium); }
                //Si la opción escogida es 0:
                    else if (opcion2==0) { } //Se retorna al menú principal
                //Si es otra opción
                else{
                    //Mostrar mensaje de error
                    System.out.println("Opción no válida"); }
                break;
            case 2:
                //Ingresar dinero en la cuenta
                ingresarDinero();

        }

    }

    private static void ingresarDinero() {
        //Pedir cantidad
        pedirCantidad();
        //Leer cantidad y guardarla
        double cantidad= leerCantidad();
    }

    private static double leerCantidad() {
        Scanner teclado= new Scanner(System.in);
        return teclado.nextDouble();

    }

    private static void pedirCantidad() {
        System.out.println("Escriba la cantidad");
    }

    private static void crearCuenta(int tipo) {
        //Pedir saldo inicial
        pedirSaldoInicial();
        //Leer saldo y almacenarlo
        saldoCuenta= leerSaldo();
       //Si el saldo es negativo
        if(saldoCuenta<0) {
            //Mostrar error
            System.out.println("El saldo inicial no puede ser negativo");
            //Reiniciar el saldo
            saldoCuenta= 0;
            //Reiniciar tipo de cuenta
            tipoCuenta= sin_cuenta;
            //Salir de la opción
            return;
        }
        //Establecer tipo de cuenta normal
        tipoCuenta= tipo;
    }

    private static double leerSaldo() {
        Scanner teclado= new Scanner(System.in);
        return teclado.nextDouble();
    }

    private static void pedirSaldoInicial() {
        System.out.println("Escriba el saldo inicial: ");
    }


    private static int leerOpcionMenu () {
            Scanner teclado = new Scanner(System.in);
            return teclado.nextInt();
        }


        private static int leerOpcion () {
            Scanner teclado = new Scanner(System.in);
            return teclado.nextInt();
        }

        private static void escribirMenu () {
            System.out.println
                    ("BANCO\n" +
                            "1.Crear cuenta\n" +
                            "2.Ingresar dinero\n" +
                            "3.Retirar dinero\n" +
                            "4.Consultar saldo\n");


        }

    }
