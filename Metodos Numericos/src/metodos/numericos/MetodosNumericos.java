/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos.numericos;
import java.util.*;
import org.nfunk.jep.JEP;

public class MetodosNumericos {
    
    Scanner sc = new Scanner(System.in);
    float[] arraycoef = new float[11];
    int grado,operacion,x;
    double val1, val2, xm, f1, f2, fm;
    float resultone, resultwo, result3, valor1, valor2, valor3, precision;

    void abrirFalsa() {
       System.out.print("Indica el grado del polinomio: ");
       grado = sc.nextInt();
       System.out.println("Escribe coeficientes, desde variable mayor exponente.\n");
       for (x = 0; x <= grado; x++) {
           System.out.print("\nCoeficiente exponente " + (grado - x) + " : ");
           x = sc.nextInt();
       }
   }

    public double falsa(double valor) {
            double coef;
            int x, res = 0;
            for (x = 0; x <= grado; x++) {
                coef = x;
                res += (coef) * Math.pow(valor, grado - x);
            }
            return res;
        }

    void secante(){
        if(Math.abs(f1)<0.000001)
            System.out.println("La solución es x="+val1);
        else if(Math.abs(f2)<0.000001)
            System.out.println("La solución es x="+val2);
            else{
                do{
                    xm=val2-f2*(val2-val1)/(f2-f1);
                    fm=falsa(xm);
                    System.out.println(" Los valores son: x="+xm+" y f(x)="+fm);
                    val1=val2;
                    val2=xm;
                    f1=f2;
                    f2=fm;
                }while(Math.abs(fm)>0.000001);
                    System.out.println("La solución es x="+xm);
            }
    }

    void resuelveFalsa(){
        val1 = valor1;
        val2 = valor2;
        f1=falsa(val1);
        f2=falsa(val2);
        secante();
        }

    void RecibirVal(){

        System.out.println(" Valor 1: ");
        valor1 = sc.nextFloat();
        System.out.println("Valor 2: ");
        valor2 = sc.nextFloat();
        resuelveFalsa();
    }

    void abrir() {
        System.out.print("Indica el grado del polinomio: ");
        grado = sc.nextInt();
        System.out.println("Escribe coeficientes, desde variable mayor exponente.\n");
        for (x = 0; x <= grado; x++) {
            System.out.print("\nCoeficiente exponente " + (grado - x) + " : ");
            x = sc.nextInt();
        }
    }

    public double f(double valor) {
        double coef;
        int x, res = 0;
        for (x = 0; x <= grado; x++) {
            coef = x;
            res += (coef) * Math.pow(valor, grado - x);
        }
        return res;
    }

    public double derivada(double valor, double coef, double val1) {
        double[] der = new double[grado];
        int x, resul = 0;
        for (x = 0; x < grado; x++) {
            coef = x;
            der[x] = (coef) * (grado - x); //coeficientes de la derivada
        }
        for (x = 0; x < grado; x++) {
            resul += der[x] * Math.pow(valor, grado - x - 1);
        }
        return resul;
    }

    void continua() {
        val1 = valor1;
        f1 = f(val1);
        if (Math.abs(f1) < 0.000001) {
            System.out.println("La solución es x: " + val1);
        } else {
            double deri = derivada(valor1, val1, val1);
            if (deri == 0) {
                System.out.println("No se puede calcular la derivada en ese punto.");
            } else {
                do {
                    val1 = val1 - f1 / deri;
                    f1 = f(val1);
                    deri = derivada(valor1,val1,val1);
                    System.out.print("\nLos valores son: x: " + val1 + " & f(x): " + f1);
                } while (Math.abs(f1) > 0.00001);
                System.out.println("\nLa solución es x: " + val1);
            }
        }
    }

    float calculaValor(float num) {
        float valor = 0;
        for (int x = grado; x >= 0; x--) {
            valor += arraycoef[x] * Math.pow(num,x);
        }
        return valor;
    }

    void nuevoValor() {
        resultone = calculaValor(valor1);
        resultwo = calculaValor(valor2);
       // result3 = calculaValor(valor3);

        valor3 = (valor1 + valor2) / 2;
        result3 = calculaValor(valor3);

        if (resultone * result3 > 0) {
            valor1 = valor3;
        }
        else if (resultwo * result3 > 0) {
            valor2 = valor3;
        }
        //return;
    }

    public Integer leerGrado(String promp) {
        System.out.println("De qué grado será: ");
        grado = sc.nextInt();
        return grado;
    }

    void llenarEcuacion(int grado) {
        System.out.println("Escribe coeficientes: \n");
        for (int x = grado; x >= 0; x--) {
            arraycoef[x] = sc.nextFloat();
        }
    }

    void procesaEcuacion() {
        grado = leerGrado("Proporcione el grado de la ecuación"); //estoy en un miembro del objeto, la referencia es directa
        llenarEcuacion(grado);
        do {
            System.out.println("Escriba primer valor: ");
            valor1 = sc.nextFloat();
            resultone = calculaValor(valor1);
            System.out.println("Escriba segundo valor: ");
            valor2 = sc.nextFloat();
            resultwo = calculaValor(valor2);
        }while (resultone * resultwo > 0);

        System.out.println("Escriba Precisión: ");
        precision = sc.nextFloat();

        while (valor2 - valor1 > precision) {
            nuevoValor();
            if (calculaValor(valor1) == 0 || calculaValor(valor2) == 0) {
                break;
            }
        }
        System.out.printf("La solución es: %.2f \n", valor3);
        System.out.println(" " + valor3);
       // return;
    }
    
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int option;
        JEP j = new JEP();
        String funcion, polinomio = "";
        double x = 0, x0 = 0, x1 = 0, b0 = 0, b1,fx = 0, fx0 = Double.NaN, fx1 = 0;
        double a, b, fa = 0, fb = 0, Number, H, A, AT = 0;
        double  m = 0, xm = 0;
        int counter = 0,xcounter = 0,cantidad;
        double arrfx [] = new double[50];
        double arrx [] = new double[50];
        double arrxm [] = new double[50];
        double arrfxm [] = new double[50];
        double arrb [] = new double[50];
        double valor;
 
        do{
            System.out.println("..:: Metodos Numéricos ::.. \n1.- Bisección.\n"
                    + "2.- Newton Rpahson.\n3.- Regla Falsa.\n4.- Secante.\n"
                    + "5.- Interpolación.\n6.- Trapecio Múltiple.\n"
                    + "7.- Simpson Múltiple 1/3.");
            System.out.print("Elije un número: ");
            option = sc.nextInt();
            switch(option){
                case 1: 
                    MetodosNumericos biseccion = new MetodosNumericos();
                    biseccion.procesaEcuacion();
                    break;
                case 2:
                    MetodosNumericos NR = new MetodosNumericos();
                    NR.abrir();
                    System.out.print("\nValor 1: ");
                    NR.valor1 = sc.nextInt();
                    NR.continua();
                    break;
                case 3:
                    MetodosNumericos RF = new MetodosNumericos();
                    RF.abrirFalsa();
                    RF.RecibirVal();
                    break;
                case 4:
                    float lx0,lx1;
                    System.out.print("Ingrese su función: ");
                    funcion = sc.next();
                    System.out.print("X0: ");
                    lx0 = sc.nextFloat();
                    System.out.print("x1: ");
                    lx1 = sc.nextFloat();
                    Funcion f = new Funcion(funcion);
                    Secante s = new Secante();
                    float result = (float) s.raiz(f, lx0, lx1);
                    System.out.println(result);
                    break;
                case 5:
                    System.out.print("¿Cuántos datos ingresará? ");
                    cantidad = sc.nextInt();
                    System.out.println("por último, Introduzca sus datos(x) & f(x)");

                    for (counter = 0; counter < cantidad; counter++) {
                        x = sc.nextDouble();
                        fx = sc.nextDouble();

                        System.out.println("F(" + x + "): " + " Fx: " + fx); 
                        arrx[counter]+=x;
                        arrfx[counter]+=fx;
                    }
                    System.out.println("b(0): " + arrfx[0]);

                    /*for(int b = 0; b < cantidad; b++ ){
                        valor = (arrfx[1] - arrfx[0]) / (arrx[1] - arrfx[0]);
                        System.out.println("b(" + b + "): " + valor);
                        arrb[b]+=valor;
                    }*/
                    double b2, b3, b4, b5 ,b6;
                    double x1x2 = (arrfx[2]-arrfx[1])/(arrx[2]-arrx[1]);
                    double x0x1 = (arrfx[1] - arrfx[0]) / (arrx[1]-arrx[0]);
                    double x1x2x3 = (arrfx[3]-arrfx[2])/(arrx[3]-arrx[2]);
                    double x0x1x2 = (x1x2 - x0x1)/arrx[2] - arrx[0];
                    b1 = (arrfx[1]-arrfx[0]/arrx[1]-arrx[0]);
                    b2 = (x1x2 - x0x1)/arrx[2] - arrx[0];
                    b3 = x1x2x3 - x0x1x2 / arrx[3]-arrx[0];
                    if(cantidad == 1)
                        System.out.println("Es muy pequeña. No es válido.");
                    else if(cantidad == 2){
                        polinomio = "P(x)= b0 + b1(x-x1)";
                        for(int count = 0; count < counter; count++){
                            polinomio = "P(x)= "+arrfx[0]+" + "+(arrfx[1] - arrfx[0]) / (arrx[1] - arrfx[0])+"(x-"+arrx[count]+")";
                        }
                    }
                    else if(cantidad == 3){
                        polinomio = "P(x)= b0 + b1(x-x1)+b2(x-x1)(x-x2)";
                        for(int count = 0; count < counter; count++){
                            polinomio = "P(x)= "+arrfx[0]+" + "+b1+"(x-"+arrx[0]+")+"+b2+"(x-"+arrx[0]+")(x-" 
                                    + arrx[1]+")";
                        }
                    }
                    else if(cantidad == 4){
                        polinomio = "P(x)= b0 + b1(x-x1)+b2(x-x1)(x-x2)+b3(x-x1)(x-x2)(x-x3))";
                        for(int count = 0; count < counter; count++){
                            polinomio = "P(x)= "+arrb[0]+" + "+b1+"(x-"+arrx[0]+")+"+b2+"(x-"+arrx[0]+")(x-" +
                                    arrx[1]+")+"+b3+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")";
                        }
                    }
                    else if (cantidad == 5){
                        polinomio = "P(x)= b0 + b1(x-x1)+b2(x-x1)(x-x2)+b3(x-x1)(x-x2)(x-x3)"
                                + "+b4(x-x1)(x-x2)(x-x3)(x-x4))";
                        for(int count = 0; count < counter; count++){
                            polinomio = "P(x)= "+arrb[0]+" + "+b1+"(x-"+arrx[0]+")+"+b2+"(x-"+arrx[0]+")(x-" +
                                    arrx[1]+")+"+b3+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]
                                    + "+"+arrb[4]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")";
                        }
                    }
                    else if(cantidad == 6){
                        polinomio = "P(x)= b0 + b1(x-x1)+b2(x-x1)(x-x2)+b3(x-x1)(x-x2)(x-x3)"
                                + "+b4(x-x1)(x-x2)(x-x3)(x-x4)+b5(x-x1)(x-x2)(x-x3)(x-x4)(x-x5))";
                        for(int count = 0; count < counter; count++){
                            polinomio = "P(x)= "+arrb[0]+" + "+b1+"(x-"+arrx[0]+")+"+b2+"(x-"+arrx[0]+")(x-" +
                                    arrx[1]+")+"+b3+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]
                                    + "+"+arrb[4]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]
                                    +""+arrb[5]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")";
                        }
                    }
                    else if(cantidad == 7){
                        polinomio = "P(x)= b0 + b1(x-x1)+b2(x-x1)(x-x2)+b3(x-x1)(x-x2)(x-x3)+"
                                + "b4(x-x1)(x-x2)(x-x3)(x-x4)+b5(x-x1)(x-x2)(x-x3)(x-x4)(x-x5)+"
                                + "b6(x-x1)(x-x2)(x-x3)(x-x4)(x-x5)(x-x6))";
                         for(int count = 0; count < counter; count++){
                            polinomio = "P(x)= "+arrb[0]+" + "+b1+"(x-"+arrx[0]+")+"+b2+"(x-"+arrx[0]+")(x-" +
                                        arrx[1]+")+"+b3+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]
                                        + "+"+arrb[4]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]
                                        +""+arrb[5]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")"
                                    + ""+arrb[5]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")(x-"+arrx[5]+"))";
                        }
                    }
                    else if(cantidad == 8){
                        polinomio = "P(x)= b0 + b1(x-x1)+b2(x-x1)(x-x2)+b3(x-x1)(x-x2)(x-x3)+"
                                + "b4(x-x1)(x-x2)(x-x3)(x-x4)+b5(x-x1)(x-x2)(x-x3)(x-x4)(x-x5)"
                                + "+b6(x-x1)(x-x2)(x-x3)(x-x4)(x-x5)(x-x6)+b7(x-x1)(x-x2)(x-x3)"
                                + "(x-x4)(x-x5)(x-x6)(x-x7))";
                        for(int count = 0; count < counter; count++){
                            polinomio = "P(x)= "+arrb[0]+" + "+b1+"(x-"+arrx[0]+"+)"+b2+"(x-"+arrx[0]+")(x-" +
                                        arrx[1]+")+"+b3+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]
                                        + "+"+arrb[4]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]
                                        +""+arrb[5]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")"
                                    + ""+arrb[6]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")(x-"+arrx[5]+")"
                                    +""+arrb[7]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")(x-"+arrx[5]+")(x-"+arrx[6]+"))";
                        }
                    }
                    else if(cantidad == 9){
                        polinomio = "P(x)= b0 + b1(x-x1)+b2(x-x1)(x-x2)+b3(x-x1)(x-x2)(x-x3)"
                                + "+b4(x-x1)(x-x2)(x-x3)(x-x4)+b5(x-x1)(x-x2)(x-x3)(x-x4)(x-x5)"
                                + "+b6(x-x1)(x-x2)(x-x3)(x-x4)(x-x5)(x-x6)+b7(x-x1)(x-x2)(x-x3)"
                                + "(x-x4)(x-x5)(x-x6)(x-x7)+b8(x-x1)(x-x2)(x-x3)(x-x4)(x-x5)(x-x6)(x-x7)(x-x8))";
                        for(int count = 0; count < counter; count++){
                            polinomio = "P(x)= "+arrb[0]+" + "+b1+"(x-"+arrx[0]+")+b2(x-"+arrx[0]+")(x-" +
                                        arrx[1]+")+"+b3+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]
                                        + "+"+arrb[4]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]
                                        +"+"+arrb[5]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")"
                                    + "+"+arrb[6]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")(x-"+arrx[5]+")"
                                    +"+"+arrb[7]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")(x-"+arrx[5]+")(x-"+arrx[6]+")"
                                    + "+"+arrb[8]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")(x-"+arrx[5]+")(x-"+arrx[6]+")(x-"+arrx[7]+")";
                        }
                    }
                    else if(cantidad == 10){
                         for(int count = 0; count < counter; count++){
                            polinomio = "P(x)= "+arrb[0]+" + "+b1+"(x-"+arrx[0]+")+"+b2+"(x-"+arrx[0]+")(x-" +
                                        arrx[1]+")+"+b3+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]
                                        + "+"+arrb[4]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]
                                        +"+"+arrb[5]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")"
                                    + "+"+arrb[6]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")(x-"+arrx[5]+")"
                                    +"+"+arrb[7]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")(x-"+arrx[5]+")(x-"+arrx[6]+")"
                                    + "+"+arrb[8]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")(x-"+arrx[5]+")(x-"+arrx[6]+")(x-"+arrx[7]+")"
                                     + "+"+arrb[9]+"(x-"+arrx[0]+")(x-"+arrx[1]+")(x-"+arrx[2]+")(x-"+arrx[3]+")(x-"+arrx[4]+")(x-"+arrx[5]+")(x-"+arrx[6]+")(x-"+arrx[7]+")(x-"+arrx[8]+"))";
                        }
                    }else if(cantidad >10)
                        System.out.println("Inválido. Es muy grande.");
                    System.out.println("Polinomio Interpolación: " + polinomio);
                    break;
                case 6:
                    System.out.print("Bienvenido usuario, Introduzca su función: ");
                    funcion = sc.next();
                    System.out.print("Ahora introduzca los valores a usar.\nB: ");
                    b = sc.nextDouble();
                    System.out.print("A: ");
                    a = sc.nextDouble();
                    System.out.print("N: ");
                    Number = sc.nextDouble();
                    j.addStandardConstants();
                    j.addStandardFunctions();
                    H = (b - a) / Number;
                    for (xcounter = 0; x < b; xcounter++) {
                        x = (a)+(double)(xcounter * H);
                        j.addVariable("x", x);
                        j.parseExpression(funcion);
                        System.out.println("X: " + x + "    F(x): " + (fx = j.getValue()));

                        if(j.hasError()){
                        System.out.println(j.getErrorInfo());
                        }

                        arrfx[xcounter] += fx;
                        arrx[xcounter] +=x;
                    }
                    for(counter = 0; counter < xcounter; counter++)
                    {
                        x0 = arrx[counter];
                        fx0 = arrfx[counter];

                        for(counter = 1; counter < xcounter; counter++){
                            x1 = arrx[counter];
                            fx1 = arrfx[counter];
                        }

                        A = 0.5 * (x1 - x0)*(fx1 + fx0);
                        AT += A;
                    }
                    System.out.println("AT: "+ AT);
                    break;
                case 7:
                    System.out.print("Bienvenido usuario, Introduzca su función: ");
                    funcion = sc.next();
                    System.out.print("Ahora introduzca los valores a usar.\nB: ");
                    b = sc.nextDouble();
                    System.out.print("A: ");
                    a = sc.nextDouble();
                    System.out.print("N: ");
                    Number = sc.nextDouble();
                    j.addStandardConstants();
                    j.addStandardFunctions();
                    H = (b - a) / Number;
                    for (xcounter = 0; x < b; xcounter++) {
                        x = (a)+(double)(xcounter * H);
                        j.addVariable("x", x);
                        j.parseExpression(funcion);
                        
                        if(j.hasError()){
                        System.out.println(j.getErrorInfo());
                        }
                        
                        System.out.println("X: " + x + "    F(x): " + (fx = j.getValue()));
                        
                        arrfx[xcounter] += fx;
                        arrx[xcounter] +=x;
                    }
                    for(counter = 0; counter < xcounter; counter++)
                    {
                        x0 = arrx[counter];
                        fx0 = arrfx[counter];

                        for(counter = 1; counter < xcounter; counter++){
                            x1 = arrx[counter];
                            fx1 = arrfx[counter];
                            for(int mcounter = 0; mcounter < 1; mcounter++){
                                m = (x0 + x1) / 2;
                                j.addVariable("x", m);
                                j.parseExpression(funcion);
                                xm = j.getValue();
                                System.out.println("xm: " + m + "    F(xm): " + (xm));
                                arrxm[mcounter] += m; //Arreglo valores en m.
                                arrfxm[mcounter] += xm; // arreglo valor de función generados por m.
                            }
                        }

                        A = (x1 - x0) * ((fx0 + 4*(xm) + fx1)/6);
                        AT += A;
                    }
                    System.out.println("AT: "+ AT);
    
                    break;  
                default:
                    break;
            }
        } while(option<=7);
    }
}