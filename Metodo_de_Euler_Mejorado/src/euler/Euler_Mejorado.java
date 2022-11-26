package euler;

import funcion.Funcion;

public class Euler_Mejorado extends Euler
{
    
    public Euler_Mejorado(Funcion f, double x0, double y0, double xn, int n) 
    {
        super(f, x0, y0, xn, n);
    }
    
    public Euler_Mejorado(Funcion f, double x0, double y0, double xn, double h) 
    {
        super(f, x0, y0, xn, h);
    }

    @Override
    public void metodo_Euler() 
    {
        yi = yi + h * ((f.evaluar(xi, yi) + f.evaluar(xi + h, yi + h * f.evaluar(xi, yi))) / 2);
        xi += h;
    }
    
}

