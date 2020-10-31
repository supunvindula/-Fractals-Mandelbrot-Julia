//package com.proj1 ;
import java.lang.Math; 

//class for Complex number object
public class Complex {
    double real, imag ;																	//two local variables for real and complex part of the number

    Complex(double r, double i){														//constructor
        this.real = r;
        this.imag = i ;
    }

    public static Complex Csum(Complex no1, Complex no2){								//method for getting the sum of two complex numbers
        Complex sumcomp = new Complex(0,0);												//constructing the complex number for giving the output

        sumcomp.real = no1.real + no2.real ;											//adding the real part
        sumcomp.imag = no1.imag + no2.imag ;											//adding the imaginary part

        return sumcomp ;																//return the addition
    }

    public static Complex sqr(Complex no){												//method for getting the square of the complex number
        Complex sqrcomp = new Complex(0,0);												//constructing complex number for output

        sqrcomp.real = no.real*no.real - no.imag*no.imag ;								//getting the real part of complex square
        sqrcomp.imag = 2d* no.real * no.imag ;											//getting the imaginary part of the complex square
        return sqrcomp;																	//returning the squared complex number
    }

    public static boolean chkabs(Complex no){											//method for checking the condition of julia and mandelbrot
        if((Math.pow(no.real,2) + Math.pow(no.imag, 2))>4){								//condtion
            return true;																//return true if the number is not a mandelbrot
        }
        else{
        	return false;																//else return false if the number ismandelbrot
        }
    }
}