/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class processFile 
{
    String filename;
    int total_line;
    int blank_line;
    int fpoint_line;
    List<clasFoo> clasList;
    //List<metodFoo> metodList;
    public processFile(){
        clasList = new ArrayList<> ();
//        metodList = new ArrayList<> ();
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    public int getTotal_line() {
        return total_line;
    }

    public void setTotal_line(int total_line) {
        this.total_line = total_line;
    }

    public int getBlank_line() {
        return blank_line;
    }

    public void setBlank_line(int blank_line) {
        this.blank_line = blank_line;
    }

    public int getFpoint_line() {
        return fpoint_line;
    }

    public void setFpoint_line(int fpoint_line) {
        this.fpoint_line = fpoint_line;
    }
 
    public List<clasFoo> getClasList() {
        return clasList;
    }

    public void setClasList(List<clasFoo> clasList) {
        this.clasList = clasList;
    }
    private String getFileExtension(){
      
          String extension="";
         int i = this.filename.lastIndexOf('.');
            if (i > 0) {
                extension = this.filename.substring(i); 
            }
             return extension;
    }      
  
    private String getFileName( )
    {
         String fileName = this.filename;
         
             return fileName;
    }  

    public void readFile(File file) throws IOException
    {
        int classLine = 0;
        String className="";        //      Variable to save the Class Name
        int methodLine = 0;         //      Variable to save the number of Method Lines 
        String methodName;          //      Variable to save the Method Name
        String fileName;            //      Variable to save the File Name
        int totalLine=0;            //      Variable to save the total of number of java Lines
        int fPointLine=0;           //      Variable to save the number of Funtion Points 
        int blankLines=0;           //      Variable to save the number of comment Lines
        
        

        /*Variables to count the keys  "{"   */
        int keyClassCount = 0;
        int keyMethodCount = 0;
        
        /*Variable to use like a flag, to count a method */

        int methodNumber = 0;
        
        clasFoo cl = new clasFoo();        

        
        fileName = file.getName();
        
        
        /* -----------------------------------------------------------
        *  --  ==     FOR CICLE WHILE JAVA FILE NOT ENDS         == --
        *  This section define the number of the java file lines readed
        *  Based in the number of keys char "{", decide if a class or 
        *  method ends.  
        *  Implement the BufferedReader interface to get the Line saved         
        *  in fileLine Variable. 
        *  All this values are saved in two arrayList class ant methods
        *  implemented in processFile and clasFoo classes.
        * -----------------------------------------------------------*/

        try(BufferedReader br = new BufferedReader(new FileReader(file))) 
        {   
            for(String fileLine;(fileLine=(br.readLine())) != null; ) 
            { 
                
                totalLine= totalLine + checkEmptyLine(fileLine); 
                
                if (fileLine.contains("class") || fileLine.contains("main"))
                {                        
                    cl.setClasName(getJavaClassName(file.getName()));
                    classLine=0;
                    fPointLine++;    
                    
                }     
                
                
                if ( fileLine.contains("{")   )
                {   
                    keyClassCount++;  
                     System.out.println("1 ++keyClassCount: "+keyClassCount+ "  " +fileLine);
                }     
                if ( fileLine.contains("}")   )
                {   
                    keyClassCount--;  
//                    System.out.println("1 --keyClassCount: "+keyClassCount + "  " +fileLine);
                } 
                 
                while ( keyClassCount>0 )
                {                            
                    if ((fileLine = br.readLine())!= null)
                    {
//                        System.out.println("keyClassCount: "+keyClassCount);
                         
                        totalLine= totalLine + checkEmptyLine(fileLine);               
                        
                        if ( fileLine.contains("{")  && !((fileLine.contains("public")    
                            ||  fileLine.contains("private")
                            ||  fileLine.contains("abstract")
                            ||  fileLine.contains("main")    )
                            &&  ( fileLine.contains("(")
                            &&  fileLine.contains(")"))
                            && (!fileLine.contains(";"))
//                            && (!fileLine.contains("main"))
                            && (!fileLine.contains("class"))) )
                        {   
                            keyClassCount++;     
//                            System.out.println("2 ++keyClassCount: "+keyClassCount+ "  " +fileLine);
                        }  
                        if ( fileLine.contains("}") )
                        {   
                            --keyClassCount;
//                            System.out.println("2 --keyClassCount: "+keyClassCount+ "  " +fileLine);
                        }

//                        if (keyClassCount > 0) 
//                        {
                            classLine++;
//                        }

                         
                        if ((fileLine.contains("public")    
                            ||  fileLine.contains("private")
                            ||  fileLine.contains("abstract")
                            ||  fileLine.contains("main")    )
                            &&  ( fileLine.contains("(")
                            &&  fileLine.contains(")"))
                            && (!fileLine.contains(";"))
                            && (!fileLine.contains("class")))
                        {
                            System.out.println(fileLine);
                            methodLine = 1; 
                            classLine++;
                            fPointLine++;
                            metodFoo ml = new metodFoo();
                            ml.setMethodName(getJavaMethodName (fileLine)); 
                            System.out.println(keyMethodCount); 
                        
  
                            if (fileLine.contains("{"))
                            {   
                                keyMethodCount++;  
                                methodLine++;
                                
                            }
                            else
                            {   
                                while (keyMethodCount>0 )
                                {                           
                                    if ((fileLine = br.readLine())!= null)
                                    {
                                        if (fileLine.contains("{"))
                                        {   
                                            keyMethodCount++;  
                                            methodLine++;
                                        }
                                    }
                                }    
                                
                            }
                            
                            
                            if ( fileLine.contains("}"))
                            {                                           
                                keyMethodCount--;  
                                methodLine++;

                            }   
                                
                            while ( keyMethodCount>0 )
                            {         
                                    if ((fileLine = br.readLine())!= null)
                                    {   
                                        fileLine = fileLine.trim();                                   
                                        totalLine= totalLine + checkEmptyLine(fileLine);                                 
                                        classLine++;  
                                        methodLine++;
                                    
                                        if ( fileLine.contains("{"))
                                        {                                           
                                            keyMethodCount++;   

                                        }   
                                        if ( fileLine.contains("}") )
                                        {                                           
                                            keyMethodCount--;  
                                        }
                                    }
                            }

                            ml.setNumberLines(methodLine);
                            cl.getMethodList().add(ml);
                            System.out.println(keyMethodCount); 
                        }   
                        
                         System.out.println("If method --- "); 
                    }  
                     System.out.println("If readline null 1 --- "+ keyClassCount); 
                      if (fileLine.contains("{"))
                            {   
                                keyClassCount++;  
                                                                 
                            }
                      if (fileLine.contains("}"))
                            {   
                                keyClassCount--;  
                                                                 
                            }
                }  System.out.println("If KeyClassCount  --- "); 
                
            }System.out.println("If readline null 2 --- ");   
            
        }    
        
        blankLines = readBlankLines(file);
        cl.setClasCommentLines(blankLines); 
        cl.setClasLines(totalLine);
        cl.setClasTotalPhysicalLines(getPhysicalLines (file));
        clasList.add(cl);  

    }
        
        /* -----------------------------------------------------------
        *         --  ==      getJavaClassName         == --
        *  This section returns a String, the name of the Java class 
        *  without a extension.
        * -----------------------------------------------------------*/
    public String getJavaClassName (String fileName)
    { 
        
        if (fileName == null) return null;
        int position = fileName.lastIndexOf(".");
        if (position == -1) return fileName;        

        return fileName.substring(0, position);
                    
    }        
        /* -----------------------------------------------------------
        *         --  ==      getJavaMethodName         == --
        *  This section returns a String, the name of the Java class 
        *  Method, receive the complete line and decide which is the 
        *  name based in the first parenthesis "("
        * -----------------------------------------------------------*/    
        public String getJavaMethodName (String methodName)
    { 
        
        if (methodName == null) return null;
        
        int position = methodName.lastIndexOf("(");
     
        
        methodName = methodName.substring(0,position);
        
        
        int firstPosition = methodName.lastIndexOf(" ");
        
        if (position == -1) return methodName;         
        return methodName.substring(firstPosition, position);
        
                    
    }   
            
    /* -----------------------------------------------------------
    *       --  ==      readFilesFromDirectory         == --
    *  This section read all directories and files that contains.  
    *  If the object readed is a file with ".java" extension, read
    *  executing the process or method "readFile"
    *  Receive a string, the path of the folder selected.
    * -----------------------------------------------------------*/ 
    public void readFilesFromDirectory(String path)
    {
         
        File root;
        root = new  File(path);
        File listFile[] = root.listFiles();
        int i=1;
        processFile processedFile = new processFile();
        if (listFile == null)
           return;
      
        for (File file: listFile)
        { 
            if (file.isDirectory())
            {                   
                readFilesFromDirectory(file.getAbsolutePath());               
                i++;
            }
            else 
            {
                processedFile.filename = file.getAbsolutePath(); 
                          
                if (".java".equals(processedFile.getFileExtension()))
                    try {                        
                        System.out.println(file.getName());
                        readFile(file);
                        
                        } catch (IOException ex) 
                        {
                            System.out.println("No se pudo leer el archivo: "+ processedFile.filename);
                            Logger.getLogger(processFile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
            }
        }        
    }    

    /* -----------------------------------------------------------
    *       --  ==      readBlankLines           == --
    *  This section read all blank lines, comments that start with "//"
    *  or coments between /* and files that contains.  
    *  Receive a file like a object, the file to examinate.
    *  Return a integer value
    * -----------------------------------------------------------*/ 
    
    public int readBlankLines(File file) throws IOException
    {    
        int commentLine=0;    //        Variable used to count the comments
        
        try(BufferedReader br = new BufferedReader(new FileReader(file))) 
        {
            /* -----------------------------------------------------------
            *  --  ==               Block Code                    == --
            *       Block that determine if the sentence or LOC is a comment
            * -----------------------------------------------------------*/
            

            for(String fileLine;(fileLine=(br.readLine())) != null; ) 
            {      
                fileLine = fileLine.trim();
                if(fileLine.equals(""))
                {
                    commentLine++;
                     
                }
                if(fileLine.startsWith("//"))
                {
                    commentLine++;
                     
                }
                /* -----------------------------------------------------------
                *  --  ==               Block Code                    == --
                *       Block that determine if the sentence or is between comment /**/ /*
                * -----------------------------------------------------------*/
                if(fileLine.contains("/*") && !fileLine.contains("*\\"))
                {
                    commentLine++;
                    
                    while(!fileLine.contains("*\\") && !fileLine.contains("*/"))
                    {
                        commentLine++;
                        while ((fileLine = br.readLine())== null)
                        {                                                       
                            System.out.println("3 ReadFile:::... **  " +fileLine   );
                        }
                    }                   
                }
            }    
        }   
         
        return commentLine;
    }            
    
    public int getPhysicalLines (File file) throws IOException
    {    
        int countPhysicalLines=0;    //        Variable used to count the comments
        String fileLine="";
        
        try(BufferedReader br = new BufferedReader(new FileReader(file))) 
        {
            while ( (fileLine=(br.readLine()))!= null)
            {
              countPhysicalLines++; 
            }            
        }
        return countPhysicalLines;
    }    
    
        
    public int checkEmptyLine (String fileLine) throws IOException
    {    
           
            if (fileLine.isEmpty() || fileLine.trim().equals("") || fileLine.trim().equals("\n"))
            {
              return 0; 
            }
            else
            {
              return 1; 
            }
        
    }  
}
