package port_scanner;

import java.io.*;
import java.net.*;
import java.util.*;

/*
 *
 * @author Connor Pakenham D00166741
 */
public class Port_Scanner_Test {

    public static void main(String[] args) {
        
        //Initialize Variables
        Scanner kbrd = new Scanner(System.in);
        String host;
        int port_lower, port_higher;
        boolean error;
        
        //Flavour Text for User
        System.out.println("Welcome to Port Scanner!");
        
        //Get input from user
        System.out.print("\nPlease enter the host address or ip: ");
        host = kbrd.next();
        
        do {
            error = false;
            System.out.print("\nPlease enter the lower port boundry: ");
            port_lower = kbrd.nextInt();

            System.out.print("\nPlease enter the higher port boundry: ");
            port_higher = kbrd.nextInt();
            
            if(port_lower > port_higher) {
                System.out.println("\nThe lower port boundry cannot be higher "
                        + "\nthan the upper boundry, please try again!");
                error = true;
            }
            
        } while(error);
        
        
        PortScanner ps = new PortScanner(host, port_lower, port_higher);
        
        System.out.println("\nThe Open Ports on " + host);
        ArrayList<Integer> openPorts = ps.getOpenPorts();
        for(int i = 0; i < openPorts.size(); i++) {
            System.out.println("Port " + openPorts.get(i) + " is open on "
                    + host);
        }
        
    }
    
}
