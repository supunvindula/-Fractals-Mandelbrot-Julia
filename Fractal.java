// REG NO : E/16/377
// NAME	  : I B S VINDULA
// CO225
// PROJECT 1
import javax.swing.*;

//class Fractal containing the main method
public class Fractal{
    public static int iterations = 1000;									//default no of iterations
    private static double realn = -1;										//default real negative value of the range
    private static double realp = 1;										//default real positive value of the range
    private static double complexn = -1;									//default complex negative value of the range
    private static double complexp = 1;										//default complex positive value of the range
    static Complex juliaC = new Complex(-0.4, 0.6);							//default C value for Julia Fractal

    //main method
    public static void main(String args[]) {

        if (args[0].equals("Mandelbrot")) {									//first argument is mandelbrot
            if (args.length == 1) {											//get default value if there are no more arguments

            } else if (args.length == 5) {									//get the range as an input if there are 5 arguments
                realn = Double.parseDouble(args[1]);
                realp = Double.parseDouble(args[2]);
                complexn = Double.parseDouble(args[3]);
                complexp = Double.parseDouble(args[4]);
            } else if (args.length == 6) {									//get the range and the iterations as inputs if there are 6 arguments
                realn = Double.parseDouble(args[1]);
                realp = Double.parseDouble(args[2]);
                complexn = Double.parseDouble(args[3]);
                complexp = Double.parseDouble(args[4]);
                iterations = Integer.parseInt(args[5]);
            } else {														//if there are variable numbers pf arguments rather than above arguments
                System.out.println("Give the correct number of arguments"); //print error
                System.exit(0);												//exit from the code
            }

            // create a frame
	        JFrame frame = new JFrame("Mandelbrot Fractal"); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	        // set the content of the frame as one of this Mandelbrot panel
	        frame.setContentPane(new MandelbrotPanel(realn, realp , complexn , complexp , iterations)); 
	        frame.pack(); 
		    frame.setLocationRelativeTo(null); 
		    frame.setVisible(true); 
        }





         
        else if (args[0].equals("Julia")) {									//first argument is julia
            if (args.length == 1) {											//get default values as arguments if there are no inputs

            }
            
            else if (args.length == 3) {									//get C value as input if there are 3 arguments
                juliaC.real = (Double.parseDouble(args[1]));
                juliaC.imag = (Double.parseDouble(args[2])) ;
            }
            else if (args.length == 4) {									//get C value and iterations as inputs if there are 4 arguments
                juliaC.real = (Double.parseDouble(args[1]));
                juliaC.imag = (Double.parseDouble(args[2])) ;
                iterations = Integer.parseInt(args[3]) ;

            }
            else{
                System.out.println("Give the correct number of arguments"); //print an error if there are undefined number of variables
                System.exit(0);												//exit
            }

            // create a Julia frame
	        JFrame frame = new JFrame("Julia Fractal"); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	        // set the content of the frame as one of this panel
	        frame.setContentPane(new JuliaPanel(juliaC, iterations)); 
	        frame.pack(); 
		    frame.setLocationRelativeTo(null); 
		    frame.setVisible(true); 

	        
        }
        
        else{																//if the first argument | nameofthe fractal is not correct
            System.out.println("Enter the correct Name of the FRACTAL");	//print error
            System.exit(0) ;												//exit
        }

       }
}