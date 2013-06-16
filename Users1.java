package users1;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Users1 implements Serializable {//main class
    

    
    public static void main(String[] args) {
    
        
        
        System.out.println("Security java program by Victoria");
       java.util.Date date = new java.util.Date();
       System.out.println("Last acessed:" + date.toGMTString());
       try{
       Administrator1 AdministratorInstance = new Administrator1(); 
     //  AdminGUI ad = new AdminGUI(AdministratorInstance );
       }
      
      catch (IOException io) { 
        System.out.println("General I/O exception: " + io.getMessage() );
        io.printStackTrace();
        System.exit(-1);
      }

    }
}
