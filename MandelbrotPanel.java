import java.awt.*; /* java abstract window toolkit */
import javax.swing.*;
import java.awt.geom.Line2D;
public class MandelbrotPanel extends JPanel{													//inherited mandelbrotpanel class from jpanel

	private static final long serialVersionUID = 1L;											//serial version UID for Mandelbrot Panel
	private double realN ;																		//variable to holding the real negative value of the range
    private double realP ;																		//variable for holding the real positive value of the range 
    private double complexN ; 																	//variable for holding the complex negative value of the range
    private double ComplexP ;																	//variable for holding the complex positive value of the range
    private int iter ;																			//variable for holding the number of iterations
    public static double xco = 0;																//variable for holding the pixel value towards x direction
    public static double yco = 0;																//variable value for holding the pixel value towards y direction
    
    

    {
        setPreferredSize(new Dimension(800, 800));												//setting the size of the mandelbrot panel as 800X800px
    }

    private static void printPoint(Graphics2D frame, Color c, int x,int y) {					//printpoint constructor for print a point

        frame.setColor(c); 
        frame.draw(new Line2D.Double(x, y, 
                         x,y)); 
    }

    //default constructor of the class
    MandelbrotPanel(double realN, double realP, double complexN, double ComplexP, int iter){
       ///assigning variables
       this.realN = realN ;
       this.realP = realP ;
       this.complexN = complexN ;
       this.ComplexP = ComplexP ;
       this.iter =iter ;
    }
    
    public void paintComponent(Graphics g) { 													//paint component method for printing colors on the panel
        // call paintComponent from parent class 
        super.paintComponent(g); 
        Mandelbrot obj = new Mandelbrot(realN,realP , complexN , ComplexP , iter);				//making Mandelbrot Object

        for(yco=0; yco<800 ; yco++) {																//for going towards y direction in the panel
            for (xco=0;xco<800 ; xco++){															//for going towards x direction in the panel
            	if(obj.checkM()){																	//not a mandelbrot number
                    printPoint((Graphics2D)g, Color.getHSBColor(obj.i/256f,1,obj.i/(obj.i+8f)), (int)xco,(int)yco);						//printing the coloraccording to iterations
                }
                else{
                    printPoint((Graphics2D)g, Color.BLACK, (int)xco,(int)yco);						//printing black if it is a mandelbrot number
                } 
            }
        }
    }
}