/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1;

import java.awt.Graphics;
import java.awt.Color;

public class CirculoGrafico extends Circulo implements Dibujable {

    Color color;

    public CirculoGrafico(double x, double y, double r, Color unColor) {
        super(x, y, r);
        this.color = unColor;
    }

    public void dibujar(Graphics dw) {
        dw.setColor(color);
        dw.drawOval((int) (x - r), (int) (y - r), (int) (2 * r), (int) (2 * r));
    }

    public void setPosicion(double x, double y) {
        ;
    }

}
