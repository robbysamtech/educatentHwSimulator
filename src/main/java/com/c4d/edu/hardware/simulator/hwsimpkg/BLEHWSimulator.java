package com.c4d.edu.hardware.simulator.hwsimpkg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ROBERT
 */
public class BLEHWSimulator 
{
    private TagScannerAssociation tsa[] = null;
    private long sleepTime = -1l;
    
    public BLEHWSimulator(TagScannerAssociation tsa[], long sleepTime)
    {
     this.tsa = tsa;
     this.sleepTime = sleepTime;
     startSimulation();
    }
    
    private void startSimulation()
    {
        for(int i=0; i < tsa.length; i++)
        {
            TagThread t = new TagThread(tsa[i], sleepTime);
            t.start();
        }
    }
}
