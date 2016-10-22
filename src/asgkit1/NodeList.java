/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asgkit1;

public class NodeList { 
    public Node first= new Node ();
    public Node node;
    public Node last; 
    int count;
    
    	public NodeList()
	{
		first= new Node(0);
		count = 0;
	}
        
    

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }
    
       public void newNode(double nodeValue)
        {       
                Node n = new Node(nodeValue);
		Node nod = first;
	 
		while(nod.getNext() != null)
		{
		    nod = nod.getNext();             
		}
		
		nod.setNext(n); 
		count++;
     
        }      
       



        public Object getListSum(){                            
            double mean=0;
            double accum=0;
            String sValue;
            this.node =   first.getNext();
            
                   
            while(node != null)
            {    
                mean = node.getValor(); 
                accum = accum + mean;
                this.node = this.node.getNext(); 
            } 
           return accum;
        } 
        
        public String printNodeList()
	{
		Node current = first.getNext();
		String output = "";
               
                
		while(current != null)
		{
			output += "[" + current.getValor() + "]";
			current = current.getNext();
		}
		return output;
	}
                
        public float getDevStd(int i, float mean){                            
            double stdDev=0;
            double accum=0;
            String sValue;
            double mValue=0;
            this.node = first.getNext();
                            
              while(node != null)
		{                             
                 mValue =  node.getValor() ;                 
                 stdDev =  Math.pow(((mValue) - mean),2f);                 
                 this.node = this.node.getNext();       
                 accum = stdDev + accum;                  
                }
              
           return (float)Math.sqrt(accum/(i-1));

        }         
    }
    