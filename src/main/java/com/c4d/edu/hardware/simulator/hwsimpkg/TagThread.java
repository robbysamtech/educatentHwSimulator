/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c4d.edu.hardware.simulator.hwsimpkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ROBERT
 */
public class TagThread extends Thread{
    
    private TagScannerAssociation tsa = null;
    private long sleepTime = -1l;
    
    public TagThread(TagScannerAssociation tsa, long sleepTime)
    {
     this.tsa = tsa;
     this.sleepTime = sleepTime;
     setName("ThreadName :"+ tsa.getScanner());
    }
    
    public void run() 
    {
        for(int i=0;i < tsa.getTags().length;i++)
        {
            System.out.println("Scanner "+tsa.getScanner()+" is now holds " + tsa.getTags()[i]);
            Connection conn = null;
            try{
                conn = ConnectionManager.getConnection();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Timestamp timestamp = new java.sql.Timestamp(new Date().getTime());
                PreparedStatement ps = conn.prepareStatement("insert into edudb.hw_int values(?,?,?)");
                ps.setString(1,tsa.getTags()[i]);
                ps.setString(2, tsa.getScanner());
                ps.setTimestamp(3, timestamp);
                
               // String query = "insert into edudb.hw_int values('"+tsa.getTags()[i]+"','"+tsa.getScanner()+"','"+new Date().getTime()+"')";
                ps.execute();
                System.out.println("Connection opened and updated successfully " + timestamp);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
            try{
                if(conn!=null) conn.close();
                }catch(Exception e)
                {
                }
                
            }
            
            try{Thread.sleep(sleepTime);} catch(Exception e){}
        }
    }
    
}
