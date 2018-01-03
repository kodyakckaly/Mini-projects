/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1;

import java.awt.*;
import java.awt.event.*;

public abstract class VentanaCerrable extends Frame implements WindowListener {

    //Constructores
    public VentanaCerrable() {
        super();
    }

    public VentanaCerrable(String title) {
        super(title);
        setSize(500, 500);
        addWindowListener(this);
    }

    //métodos de la interface 
    public void WindowActivated(WindowEvent e) {;
    }

    public void WindowClosed(WindowEvent e) {;
    }

    public void WindowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowDeactivated(WindowEvent e) {;
    }

    public void windowDeiconified(WindowEvent e) {;
    }

    public void windowIconified(WindowEvent e) {;
    }

    public void windowOpened(WindowEvent e) {;
    }
}
