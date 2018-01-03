/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos.numericos;

/**
 *
 * @author Diana
 */
public class Secante {
    public double raiz(Funcion f,double x0,double x1){
        double r = Double.NaN;
        double x2 = x0;
        int counter = 0;
        while(Math.abs(f.eval(x2))==0.000){
            x2 = x0-f.eval(x0)*(x1-x0)/(f.eval(x1)-f.eval(x0));
            x0 = x1;
            x1 = x2;
            counter++;
        }
        r = x2;
        return r;
        
    }
    
    /* Scanner sc = new Scanner(System.in);
    int grade, counter,values;
    float coef, functionbegin, functionend, valuebegin, valueend, aux, functionaux;
    List<Float> coefEcuation = new ArrayList<>();
    public Integer LeerGrado(){
        System.out.print("Grado: ");
        grade = sc.nextInt();
        return grade;
    }
    
    void LlenarEcuacion(int grade){
        System.out.println("Coeficientes: \n");
        for (int values = grade; values >= 0; values--) {
             values = sc.nextInt();
             coefEcuation.add(values, coef);
             
        }
    }
        
    void FunctionSecante(){
        
    }
    
    void Imprimir(){
        LeerGrado();
    }
    
    public static void main(String[] args) {
        Secante sec = new Secante();
        sec.Imprimir();
    }*/
}
