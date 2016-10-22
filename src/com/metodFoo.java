/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author Usuario
 */
public class metodFoo {
    String methodName;
    int numberLines;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getNumberLines() {
        return numberLines;
    }

    public void setNumberLines(int numberLines) {
        this.numberLines = numberLines;
    }

    public metodFoo(String methodName, int numberLines) {
        this.methodName = methodName;
        this.numberLines = numberLines;
    }
    
       public metodFoo(String methodName ) {
        this.methodName = methodName; 
    }
       
    public metodFoo( ) {        
    }   
}
