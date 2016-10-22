/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class clasFoo {
    private String clasName;
    private int clasLines;
    private int clasCommentLines;
    private int clasTotalPhysicalLines;
    private List<metodFoo> methodList;

    public String getClasName() {
        return clasName;
    }

    public void setClasName(String clasName) {
        this.clasName = clasName;
    }

    public int getClasLines() {
        return clasLines;
    }

    public void setClasLines(int clasLines) {
        this.clasLines = clasLines;
    }

    public int getClasCommentLines() {
        return clasCommentLines;
    }

    public void setClasCommentLines(int clasCommentLines) {
        this.clasCommentLines = clasCommentLines;
    }

    public clasFoo() {
        methodList = new ArrayList<> ();
    }

    public List<metodFoo> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<metodFoo> methodList) {
        this.methodList = methodList;
    }

    public int getClasTotalPhysicalLines() {
        return clasTotalPhysicalLines;
    }

    public void setClasTotalPhysicalLines(int clasTotalPhysicalLines) {
        this.clasTotalPhysicalLines = clasTotalPhysicalLines;
    }



    
        
}
