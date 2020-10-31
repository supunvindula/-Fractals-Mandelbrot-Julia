//package com.proj1 ;

//import com.proj1.Fractal;

//Class for checking the Mandelbrot number
public class Mandelbrot {													//variables defined same as the other classes
    private double xdiv;													//one x pixel is equal to
    private double ydiv;													//one y pixel is equal to
    private Complex initC ;
    //private Complex finC ;
    private double realN ;
    private double realP ; 
    private double complexN ; 
    private double ComplexP ;
    private int iter ;
    private Complex z0 = new Complex(0,0) ;									//holding Zn
    private Complex z1 = new Complex(0,0) ;									//holding Zn+1
    private Complex temp ;													//to hold a complex number temporarily
    public int i ;															//hold number of iterations 


    Mandelbrot(double realN, double realP, double complexN, double ComplexP, int iter){				//mandelbrot constructor
        this.realN = realN ;																		//assigning variables
        this.realP = realP ;
        this.complexN = complexN ;
        this.ComplexP = ComplexP ;
        this.iter = iter ;
        this.initC = new Complex(realN,ComplexP);
        //this.finC = new Complex(realP,complexN);
        temp = new Complex(realN,ComplexP) ;
        this.xdiv = (this.realP - this.realN)/800d ;												//calculating the value of one division
        this.ydiv = (this.ComplexP - this.complexN)/800d ;
    }

   


    private static Complex nextmandelbrot(Complex Z0,Complex C){									//method for Zn+1 =  Zn^2 + C to get the Zn+1
    	//System.out.println(realN);
       
        return Complex.Csum(Complex.sqr(Z0),C) ;
    }
    public boolean checkM(){																		//checking the numbers if they are mandelbrot or not
    	//t=t+1 ;
    	temp.real = initC.real + MandelbrotPanel.xco * xdiv ;										//argan x coordinate
    	temp.imag = initC.imag - MandelbrotPanel.yco *ydiv ;										//argan y coordinate
    	z0.real = 0 ;																				//make z0 = 0
    	z0.imag = 0 ;

        for(i = 0 ; i < iter ; i++ ){																//going through iterations
            z1 = nextmandelbrot(z0, temp) ;															//getting the next number
            if(Complex.chkabs(z0)){
                return true ;																		//not a mandelbrot number return true
            }
            else{
            	z0.real = z1.real ;																	//assigning Zn+1 to Zn
                z0.imag = z1.imag ;
            					
            }
        }
        return false ;																				//return false for a mandelbrot number
    	
    }
}