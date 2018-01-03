/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplo1;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Lab 3
 */
class RectanguloGrafico extends Rectangulo implements Dibujable{
        Color color;
        
        public RectanguloGrafico(double x1, double y1, double x2, double y2, Color unColor){
            super(x1, y1, x2, y2);
            this.color = unColor;
        }
        public void dibujar(Graphics dw){
            dw.setColor(color);
            dw.drawRect((int)x1, (int)y1, (int)(x2-x1), (int)(y2-y1));
        }
        
        public void setPosicion(double x, double y){
            ;
        }
        
    }