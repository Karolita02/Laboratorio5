package euler;

import funcion.Funcion;

public abstract class Euler 
{
    public Funcion f;
    public double x0, y0, xn, h, xi, yi;
    public int n;
  

    @Override
    public String toString() 
    {
        return  xi + "  " + yi + "\n";
    }



    public Euler(Funcion f,double x0, double y0, double xn) 
    {
        this.f = f;
        this.x0 = x0;
        this.y0 = y0;
        this.xn = xn;
        xi = x0;
        yi = y0;

    }

    public Euler(Funcion f,double x0, double y0, double xn, int n) 
    {
        this(f, x0, y0, xn);
        this.n = n;
        calcular_h();

    }
    
    public Euler(Funcion f,double x0, double y0, double xn, double h) 
    {
        this(f,x0, y0, xn);
        this.h = h;
        calcular_n();
    }


    public void calcular_h()
    {
        h = (xn-x0)/n;
    }

    public void calcular_n()
    {
        n = (int)((xn-x0)/h);
    }

    public abstract void metodo_Euler(); 
  
} 
