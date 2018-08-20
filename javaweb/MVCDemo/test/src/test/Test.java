/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author soderayi
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("a + b = " + Test.add(2, 3));
        System.out.println("a ^ b = " + Test.power(2, 3));
        System.out.println("a / b = " + Test.div(2, 3));
    }
    
    private static int add(int a, int b){
        return a + b;
    }
    
    private static double power(int a, int b){
        return Math.pow(a, b);
    }
    
    private static double div(int a, int b){
        return Float.valueOf(a) / b;
    }
    
    private static long round(double a){
        return Math.round(a);
    }
    
}
