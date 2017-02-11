/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c4d.edu.hardware.simulator.hwsimpkg;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author ROBERT
 */
public class SimulatorMain 
{
    public static void main(String arg[])
    {
        System.out.println("Running");
        TagScannerAssociation tsas[] = null;
        ArrayList<TagScannerAssociation> tsaList = new ArrayList<TagScannerAssociation>();
        for(int j=0 ; j< arg.length; j++)
        {
            StringTokenizer pipeTokenizer = new StringTokenizer(arg[j],"|");
            
            boolean first = true;
            ArrayList<String> tagList = new ArrayList<String>();
            String scanner = null;
            while(pipeTokenizer.hasMoreTokens())
            {
                if(first)
                {
                    scanner = pipeTokenizer.nextToken();
                    first = false;
                }
                else
                {
                    tagList.add(pipeTokenizer.nextToken());
                }    
            }
            
            
            String[] tags = new String[tagList.size()];
            int k = 0;
            for(String tag: tagList)
            {
                tags[k]=tag;
                k++;
            }
            
            tsaList.add(new TagScannerAssociation(scanner, tags));
        }
        
        tsas = new TagScannerAssociation[tsaList.size()];
        int l = 0;
        
        for(TagScannerAssociation tsa: tsaList)
        {
                tsas[l]=tsa;
                l++;
        }
        
        BLEHWSimulator blehws = new BLEHWSimulator(tsas, 1000l);
        
    }
}
