
package asgkit1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

        /*  CODIFICADO EL 18082016 PARA MCC.IS 
            POR EL LI SOCRATES BENITEZ DOMINGUEZ 
            SERA EVALUADO POR EL DR. MOISES GONZALEZ
        */
public class ASGKIT1 {
  
    public static void main(String[] args) throws FileNotFoundException {
        int inputOption = 0;
        String nextOption = "S"; 
        DecimalFormat f = new DecimalFormat("##.00");
        float nodeValue;   
        int i= 0;
        String sSummary;
        float stdDev=0;
        float summary;
        float mean;
         
        NodeList nl = new NodeList();
        
        System.out.println("Seleccione la opcion de ingreso de datos: ");
        System.out.println("1. Teclado");
        System.out.println("2. Archivo");
        Scanner MethodIng  = new Scanner(System.in);
        inputOption = MethodIng.nextInt();

        
        switch (inputOption){
            case 1:
                while (nextOption.equals("S") || nextOption.equals("s")){
                        System.out.println("Ingrese Valor de Nodo: ");
                        nodeValue = MethodIng.nextFloat();
                        System.out.println("¿Otro Valor? ");
                        nextOption = MethodIng.next();
                        nl.newNode(nodeValue);
                        i++;
                    }
                   break;
            case 2: 
                    Scanner x = new Scanner(new File("src/stdDev.txt"));

                    while(x.hasNext()){
                           String a = x.next(); 
                           nodeValue = Float.parseFloat(a);
                           nl.newNode(nodeValue);
                            i++;
                    }
                   
                   break;
            default:    
                 System.out.println("Opcion no valida..");
        }
        System.out.println("i: "+i);
        System.out.println(nl.printNodeList());
        sSummary = nl.getListSum().toString();         
        summary = Float.valueOf(sSummary);
        System.out.println("Summ: "+summary);
        mean   = summary/(i); 
        System.out.println("Mean: "+mean);
        stdDev = nl.getDevStd(i, mean);                  
        System.out.println("Desviacion Std: "+f.format(stdDev));                            
        System.out.println("Media: "+f.format(mean));
        
    }  
    
}
