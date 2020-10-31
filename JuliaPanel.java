import java.awt.*; /* java abstract window toolkit */
import javax.swing.*;
import java.awt.geom.Line2D;

//extended JuliaPanel from JPanel
public class JuliaPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private int iter;												//variables are same as in Fractal Class
    private Complex juliaC ;										
    public static int xco,yco ;										//pixels in JPanel

    {
        setPreferredSize(new Dimension(800, 800));					//size of the JuliaPanel
    }

    JuliaPanel(Complex juliaC , int iter1){							//JuliaPanel Constructor
        this.iter = iter1;
        this.juliaC = juliaC ;
    }

    

        public void paintComponent(Graphics g) { 
            // call paintComponent from parent class 
            super.paintComponent(g); 
            Julia Obj = new Julia(juliaC,iter);

            for(yco=0; yco<800 ; yco++) { 							//going through pixels in y directions
                for (xco=0;xco<800 ; xco++){						//going through pixels in x direction
                    if(Obj.check()){								//if the obj is not a julia
                    	printPoint((Graphics2D)g, Color.getHSBColor(Obj.i/256f,1,Obj.i/(Obj.i+8f)), (int)xco,(int)yco);
                    	//give colors
                    }
                    else{
                    	printPoint((Graphics2D)g, Color.BLACK, (int)xco,(int)yco);   					//if the obj is julia give black                        
                    } 
                }
                
            }
        
            }
        //method for printing a point
	    private static void printPoint(Graphics2D frame, Color c, int x,int y) {

        frame.setColor(c); 
        frame.draw(new Line2D.Double(x, y, 
                         x,y)); 
    }
}


       