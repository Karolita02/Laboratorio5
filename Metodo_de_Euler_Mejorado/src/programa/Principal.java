package programa;

import java.util.Scanner;

import euler.Euler_Mejorado;
import funcion.Funcion;

public class Principal 
{
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) 
    {

        Funcion f = (x,y)-> x*Math.sqrt(y); // funcion ingresada mediante código
        Euler_Mejorado eulerMejorado;
        mostrar_Presentacion();

        var x0 = ingresar_Datos("X0");
        var y0 = ingresar_Datos("Y0");       
        var xn = ingresar_Datos("Xn");
        var h = 0.0;
        var n = 0;

        if(!es_N())
        {
            h =ingresar_Datos("H");
            eulerMejorado = new Euler_Mejorado(f, x0, y0, xn,h);
            n = eulerMejorado.n;
        }
        else
        {
            n = (int)ingresar_Datos("N");
            eulerMejorado = new Euler_Mejorado(f, x0, y0, xn,n);
            h = eulerMejorado.h;
        }
        
        mostrar_Presentacion();
        mostrar_Datos("x*Sqrt(y)",x0,y0,xn,n,h);
        mostrar_Encabezado();
        var iteraciones = 0;
        System.out.println(String.format("       %2d            %.2f          %.9f",iteraciones,eulerMejorado.xi, eulerMejorado.yi)); // valores iniciales de xi , yi

        while (iteraciones < n) 
        {
            eulerMejorado.metodo_Euler();
            System.out.println(String.format("       %2d            %.2f          %.9f",++iteraciones,eulerMejorado.xi, eulerMejorado.yi));
        }
    }
    
    public static void mostrar_Presentacion()
    {
        limpiarPantalla();
        System.out.println("               _ _ _ _ _ _ _ _ _  _ _ _ _ _ _ _ _ ");
        System.out.println("              |         Laboratorio N° 5         |");
        System.out.println("              |     Método de Euler Mejorado     |");
        System.out.println("              | Desarrollado por : Thaís Samudio |");
        System.out.println("              |_ _ _ _ _ _ _ _ _  _ _ _ _ _ _ _ _|");
        System.out.println();
    }

    public static void mostrar_Encabezado()
    {
        System.out.println(" ________________________________________________");
        System.out.println("|      n             Xi               Yi         |");
        System.out.println("|________________________________________________|");

    }

    public static double ingresar_Datos(String datoIngresado)
    {
        System.out.print("Ingrese el valor de "+ datoIngresado + ": ");
        return leer.nextDouble();
        
    }

    public static boolean es_N()
    {
        System.out.print("¿Para este problema desea ingresar la h o la n?: ");
        String H_o_N =leer.next();
        return H_o_N.equalsIgnoreCase("n");
        
    }

    public static void mostrar_Datos(String f, double x0, double y0, double xn,int n, double h)
    {
        System.out.println("----Datos del problema----");
        System.out.println(String.format("Función ingresada: %s\n X0: %.2f\n Y0: %.2f\n Xn: %.2f\n n: %d\n h: %.2f\n",f,x0,y0,xn,n,h));

    }

    public static void limpiarPantalla() 
    {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {

        }
    }
}
