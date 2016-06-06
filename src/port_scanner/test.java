/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package port_scanner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 *
 * @author Connor Pakenham D00166741
 */
public class test {
    public static void main(String[] args){
        String host = "127.0.0.1";
        
        int i =0 ;
        
        do {
            Socket soc = null;
            
            try{
                soc = new Socket();
                soc.connect(new InetSocketAddress(host, i), 200);
            } catch (IOException ioe) {
                
            } finally {
                if(soc != null) {
                    try {
                    
                    soc.close();
                    } catch(IOException ioe){/*Ignore*/}
                }
            }
        } while(i <= 55000);
        
    }
}
