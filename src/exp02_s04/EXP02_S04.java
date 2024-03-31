package exp02_s04;

import java.util.Scanner;

public class EXP02_S04 {

  public static void main(String[] args){

    Scanner inputUsuario = new Scanner(System.in);

    int opcionMenu;
    System.out.println(" -------------------------------------------");
    System.out.println("    SISTEMA GESTIÓN ENTRADAS TEATRO MORO    ");
    System.out.println(" -------------------------------------------");
    System.out.println("                  Menú                      ");
    System.out.println(" -------------------------------------------");
    System.out.println("[1] Comprar Entrada");
    System.out.println("[2] Salir");
    opcionMenu = inputUsuario.nextInt();

    int numeroEntradas = 0;
    double totalAcumulado = 0;

    while (opcionMenu == 1){
      /*
      PASO 1:
      Seleccionar la ubicación de la entrada, la cual tiene asociada un precio
      */
      int ubicacion;
      System.out.println("    Elige el número correspondiente al sector a comprar    ");
      System.out.println("[1] Palco");
      System.out.println("[2] Platea Alta");
      System.out.println("[3] Platea Baja");
      System.out.println("[4] VIP");
      ubicacion = inputUsuario.nextInt();

      // Se válida que el número ingresado por el usuario esté dentro del rango propuesto en el menú
      while (ubicacion == 0 || ubicacion > 4){
        System.out.println("Debe ingresar un número válido 1-2-3-4");
        ubicacion = inputUsuario.nextInt();
      }

      int precioEntrada = 0;
      String ubicacionSalida = "";
      switch (ubicacion){
        case 1:
          ubicacionSalida = "Palco";
          precioEntrada = 7200;
          break;
        case 2:
          ubicacionSalida = "Platea Alta";
          precioEntrada = 11000;
          break;
        case 3:
          ubicacionSalida = "Platea Baja";
          precioEntrada = 19000;
          break;
        case 4:
          ubicacionSalida = "VIP";
          precioEntrada = 25000;
          break;
      }

      /*
      PASO 2
      Se pregunta por la edad del usuario, ya que dependiendo de su edad, se puede aplicar un descuento
      */
      int edad;
      System.out.println("Ingresa la edad del comprador");
      edad = inputUsuario.nextInt();

      while( edad < 15 ){
        System.out.println("La obra de teatro es para mayores de 14 años");
        edad = inputUsuario.nextInt();
      }
      /*
      Si el usuario es Tercera Edad se le aplicará un descuento del 15% sobre el valor de la entrada.
      Ya que es el descuento más alto que se puede alcanzar, no se validará si este usuario es estudiante (10% de descuento).
      */
      double descuento, precioEntradaPagar;
      String descuentoSalida;
      if( edad >= 60){
        descuento = 0.85;
        precioEntradaPagar = precioEntrada * descuento;
        descuentoSalida = "Tienes un descuento del 15% (Tercera edad)";
      }
      else {
        int tipoPublico;
        System.out.println("Es estudiante?");
        System.out.println("[1]Si [2]No");
        tipoPublico = inputUsuario.nextInt();

        // Se valida que el número ingresado por el usuario esté dentro de las opciones presentadas.
        while(tipoPublico != 1 && tipoPublico != 2){
          System.out.println("Debe ingresar un número válido [1]Si - [2]No");
          tipoPublico = inputUsuario.nextInt();
        }

        // Se aplicará un 10% de descuento si el tipo de píblico es estudiante, de lo contrario ningún descuento se aplicará
        if ( tipoPublico == 1 ) {
          descuento = 0.90;
          precioEntradaPagar = precioEntrada * descuento;
          descuentoSalida = "Tienes un descuento del 10% (Estudiante)";
        }
        else {
          // Ningun descuento
          descuentoSalida = "No aplica descuento";
          precioEntradaPagar = precioEntrada;
        }
      }

      // Ya que tenemos toda la información, podemos hacer el resumen de la compra
      System.out.println("Resumen entrada: N˚" + (numeroEntradas += 1) );
      System.out.println("Ubicación: " + ubicacionSalida);
      System.out.println("Precio entrada: $" + precioEntrada);
      System.out.println("Descuento: " + descuentoSalida);
      if (precioEntradaPagar == 0){
        System.out.println("Total a pagar por la entrada: $" + precioEntrada);
      } else {
        System.out.println("Total a pagar por la entrada: $" + precioEntradaPagar);
      }
      System.out.println();

      totalAcumulado += precioEntradaPagar;

      System.out.println("[1]Comprar otra entrada [2]Salir y pagar entradas");
      opcionMenu = inputUsuario.nextInt();

    }
    if (numeroEntradas == 0){
      System.out.println("-------------------------------------------------------------------");
      System.out.println("                 No has comprado ninguna entrada                   ");
      System.out.println("-------------------------------------------------------------------");
    } else {
      System.out.println("-------------------------------------------------------------------");
      System.out.println("El total a pagar por las " + numeroEntradas + " entradas es de:");
      System.out.println("$" + totalAcumulado);
      System.out.println("-----------------------------------------------------------------");
      System.out.println("              Gracias por venir al Teatro Moro                   ");

    }
  }
  
}
