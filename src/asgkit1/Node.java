/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asgkit1;

/**
 *
 * @author Usuario
 */
public class Node {
    double valor;
    Node next;
    
    public double getValor()
   {
        return valor;	
   }
		
    public void setData(double value)
   {
	valor = value;
   }

    public Node getNext() {
        return next;
    }

    public void setNext(Node n) {
        next =   n;
    }

    public Node(double valor) {
        this.valor = valor;
        this.next = null;
    }
    
        public Node(double valor, Node node) {
        this.valor = valor;
        this.next = node;
    }
        
        public Node() { 
    }
        
 
}
