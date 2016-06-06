/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package port_scanner;

import java.io.*;
import java.net.*;
import java.util.*;


/**
 *
 * @author Connor Pakenham D00166741
 */
public class PortScanner {
    
    private final String HOST;
    private final int PORT_MIN;
    private final int PORT_MAX;
    private final ArrayList<Integer> OPEN_PORTS;
    private final int TIMEOUT = 200;
    
    public PortScanner() {
        HOST = "127.0.0.1";
        PORT_MIN = 1;
        PORT_MAX = 65535;
        
        OPEN_PORTS = new ArrayList();
        this.scanPorts();
    }
    
    public PortScanner(String HOST, int PORT_MIN, int PORT_MAX) {
        this.HOST = HOST;
        this.PORT_MIN = PORT_MIN;
        this.PORT_MAX = PORT_MAX;
        
        OPEN_PORTS = new ArrayList();
        this.scanPorts();
    }
    
    private void scanPorts() {
        
        for(int i = PORT_MIN; i <= PORT_MAX; i++) {
            try {
                Socket soc = new Socket();
                soc.connect(new InetSocketAddress(HOST, i), TIMEOUT);
                soc.close();
                OPEN_PORTS.add(i);
            } catch(IOException ioe) {/*Ignore*/}
        }
    }
    
    /* Getters */

    public String getHost() {
        return HOST;
    }

    public int getPortMin() {
        return PORT_MIN;
    }

    public int getPortMax() {
        return PORT_MAX;
    }

    public ArrayList<Integer> getOpenPorts() {
        return OPEN_PORTS;
    }

    public int getTimeout() {
        return TIMEOUT;
    }
    
    public static void main(String[] args) {
        
        //Initialize Variables
        Scanner kbrd = new Scanner(System.in);
        String host;
        int port_lower = 0, port_higher =0 ;
        boolean error;
        
        //Flavour Text for User
        System.out.println("Welcome to Port Scanner!");
        
        //Get input from user
        System.out.print("\nPlease enter the host address or ip: ");
        host = kbrd.next();
        
        do {
            error = false;
            
            try {
                System.out.print("\nPlease enter the lower port boundry: ");
                port_lower = kbrd.nextInt();

                System.out.print("\nPlease enter the higher port boundry: ");
                port_higher = kbrd.nextInt();

                if(port_lower > port_higher) {
                    System.out.println("\nThe lower port boundry cannot be higher "
                            + "\nthan the upper boundry, please try again!");
                    error = true;
                }
            } catch(InputMismatchException ex) {
                System.out.println("Can only enter numbers, please try again.");
                kbrd.nextLine();
                error = true;
            }
        } while(error);
        
        
        PortScanner ps = new PortScanner(host, port_lower, port_higher);
        
        System.out.println("\nThe Open Ports on " + host);
        System.out.println("-----------------------------");
        ArrayList<Integer> openPorts = ps.getOpenPorts();
        for(int i = 0; i < openPorts.size(); i++) {
            System.out.println("Port " + openPorts.get(i) + " is open on "
                    + host);
        }
        
    }
    
}
