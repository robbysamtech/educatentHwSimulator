/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c4d.edu.hardware.simulator.hwsimpkg;

/**
 *
 * @author ROBERT
 */
public class TagScannerAssociation 
{
    private String scanner = null;
    private String[] tags = null;
    
    public TagScannerAssociation(String scanner, String[] tags)
    {
        this.scanner = scanner;
        this.tags = tags;
    }
    
    public String[] getTags()
    {
        return tags;
    }
    
    public String getScanner()
    {
        return scanner;
    }
    
}
