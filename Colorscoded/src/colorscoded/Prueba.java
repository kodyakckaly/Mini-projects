package colorscoded;

import java.awt.Color;
import javax.swing.JOptionPane;

public class Prueba {
    
    String firstband = "", secondband = "", thirdband = "", fourthband = "";
    String auxforsilver = "", auxforgold = "";
    String resistencias;

    public void cambiarColorPrimero(Color color){
    Pruebas.jButton1.setBackground(color);
    }
    
    public void cambiarColorSegundo(Color color){
      Pruebas.jButton2.setBackground(color);
    }
    
     public void cambiarColorTercero(Color color){
         Pruebas.jButton3.setBackground(color);
    }
     
    public void cambiarColorcUARTO(Color color){
         Pruebas.jButton4.setBackground(color);
    }
    
     public void getfirstband(String boxfirstband) {
        firstband = boxfirstband;
    }
     
    public void getsecondband(String boxsecondband) {
        secondband = boxsecondband;
    }

    public void getthirdband(String boxthirdband) {
        thirdband = boxthirdband;
    }

    public void getfourthband(String boxfourthband) {
        fourthband = boxfourthband;
    }

    public String seedates() {

        if (firstband.equals("Café")) {
            firstband = "1";
        } else if (firstband.equals("Rojo")) {
            firstband = "2";
        } else if (firstband.equals("Naranja")) {
            firstband = "3";
        } else if (firstband.equals("Amarillo")) {
            firstband = "4";
        } else if (firstband.equals("Verde")) {
            firstband = "5";
        } else if (firstband.equals("Azul")) {
            firstband = "6";
        } else if (firstband.equals("Violeta")) {
            firstband = "7";
        } else if (firstband.equals("Gris")) {
            firstband = "8";
        } else if (firstband.equals("Blanco")) {
            firstband = "9";
        }

        if (secondband.equals("Negro")) {
            secondband = "0";
        } else if (secondband.equals("Café")) {
            secondband = "1";
        } else if (secondband.equals("Rojo")) {
            secondband = "2";
        } else if (secondband.equals("Naranja")) {
            secondband = "3";
        } else if (secondband.equals("Amarillo")) {
            secondband = "4";
        } else if (secondband.equals("Verde")) {
            secondband = "5";
        } else if (secondband.equals("Azul")) {
            secondband = "6";
        } else if (secondband.equals("Violeta")) {
            secondband = "7";
        } else if (secondband.equals("Gris")) {
            secondband = "8";
        } else if (secondband.equals("Blanco")) {
            secondband = "9";
        }

        if (thirdband.equals("Negro")) {
            thirdband = " Ohms";
            resistencias = "" + firstband + "" + secondband + "" + thirdband;
        } else if (thirdband.equals("Café")) {
            thirdband = "0 Ohms";
            resistencias = "" + firstband + "" + secondband + "" + thirdband;
        } else if (thirdband.equals("Rojo")) {
            thirdband = "00 Ohms";
            resistencias = "" + firstband + "" + secondband + "" + thirdband;
        } else if (thirdband.equals("Naranja")) {
            thirdband = "000 Ohms";
            resistencias = "" + firstband + "" + secondband + "" + thirdband;
        } else if (thirdband.equals("Amarillo")) {
            thirdband = "0 000 Ohms";
            resistencias = "" + firstband + "" + secondband + "" + thirdband;
        } else if (thirdband.equals("Verde")) {
            thirdband = "00 000 Ohms";
            resistencias = "" + firstband + "" + secondband + "" + thirdband;
        } else if (thirdband.equals("Azul")) {
            thirdband = " m Ohms";
            resistencias = "" + firstband + "" + secondband + "" + thirdband;
            
        } else if (thirdband.equals("Oro")) {
            thirdband = ".1";
            auxforgold = "" + firstband + "" + secondband;
            double auxgold =  Double.parseDouble(auxforgold);
            double thirdband3 =  Double.parseDouble(thirdband);
            
           thirdband3 = (auxgold * thirdband3);
            thirdband = Double.toString(thirdband3);
            resistencias = "" + thirdband;
            JOptionPane.showMessageDialog(null, "Resistencia con Oro: " + thirdband);
            
        } else if (thirdband.equals("Plata")) {
            thirdband = ".01";
            
            auxforsilver = "" + firstband + "" + secondband;
            double auxsilver =  Double.parseDouble(auxforsilver);
            double thirdband3 =  Double.parseDouble(thirdband);
            
            thirdband3 = (auxsilver * thirdband3);
            thirdband = Double.toString(thirdband3);
            resistencias = "" + thirdband;
            JOptionPane.showMessageDialog(null,"Resistencia con Plata: " + thirdband);
        }

       /* JOptionPane.showMessageDialog(null, " Resistencia: " + firstband + "" + secondband
                + "" + thirdband);*/
        return resistencias;
    }

    public String seetolerancia() {
        if (fourthband.equals("Café")) {
            fourthband = "+- 1% (G)";
        } else if (fourthband.equals("Rojo")) {
            fourthband = "+- 2% (G)";
        } else if (fourthband.equals("Verde")) {
            fourthband = "+- 0.5% (D)";
        } else if (fourthband.equals("Azul")) {
            fourthband = "+-0.25% (C)";
        } else if (fourthband.equals("Plata")) {
            fourthband = "+- 10% (K)";
        } else if (fourthband.equals("Oro")) {
            fourthband = "+- 5% (J)";
        }
        //JOptionPane.showMessageDialog(null, " Tolerancia: " + fourthband);
        return fourthband;

    
    }
}

   

