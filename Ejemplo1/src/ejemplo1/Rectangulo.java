/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplo1;

/**
 *
 * @author Lab 3
 */
 public class Rectangulo extends Geometria{
        
        private  static int numRectangulos = 0;
        protected double x1,y1,x2,y2;
        
        public Rectangulo(double p1x,double p1y,double p2x,double p2y){
            x1 = p1x;
            x2 = p2x;
            y1 = p1y;
            y2 = p2y;
            numRectangulos++;
        }
        public Rectangulo(){ this(0,0,1.0,1.0);}
        
        public double perimetro(){return 2.0*((x1-x2)+(y1-y2));}
        public double area(){return(x1-x2)*(y1-y2);}
    }
