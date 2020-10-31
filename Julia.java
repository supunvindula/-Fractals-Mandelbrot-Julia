//method for checking a number is julia or not
public class Julia {

    private int iter ;											//variables same as other classes
    private static Complex z0 = new Complex(0,0) ;
    private static Complex z1 = new Complex(0,0) ;
    private Complex juliaC = new Complex(0,0);
    private Complex initC = new Complex(-1,1) ;
    private static double xdiv = (2d/800d) ;					//calculating the value of one x division
    private static double ydiv = (2d/800d) ;					//calculating the value of one y division
    public int i ;												//number of iterations

    Julia(Complex juliaC , int iter){							//Julia constructor
        this.juliaC = juliaC ;
        this.iter = iter; 
    }

    public static Complex nextJulia(Complex Zpoint,Complex C){		//getting Zn+1
        return Complex.Csum(Complex.sqr(Zpoint),C) ;
    }

    public boolean check(){											//method for checking the julia set number
    	z0.real = initC.real + JuliaPanel.xco * xdiv ;				//getting the argan x value
    	z0.imag = initC.imag - JuliaPanel.yco *ydiv ;				//getting the argan y value
        for(i = 0 ; i < iter ; i++ ){								//going through iterations for a single coordinate
            z1 = nextJulia(z0,juliaC) ;								//getting Zn+1 by the equations
            if(Complex.chkabs(z0)){									//returning true if the numberis not a Julia
                return true;
            }
            else{
            	z0 = z1 ;											//Zn = Zn+1
            	
            }
        }

        return false ;												//returning true if the number is Julia
    }
}