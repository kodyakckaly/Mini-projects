/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplo1;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Lab 3
 */
 public class PanelDibujo extends Panel{
        private ArrayList v;
        
        public PanelDibujo(ArrayList va){
            super(new FlowLayout());
            this.v = va;
        }
        public void paint(Graphics g){
            Dibujable dib;
            Iterator it;
            it = v.iterator();
            while(it.hasNext()){
                dib = (Dibujable)it.next();
                dib.dibujar(g);
            }
        }
    }