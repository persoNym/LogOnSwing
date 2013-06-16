/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package users1;

import java.util.*;
import java.util.*;
import java.io.*; 
import java.security.*;
import java.util.logging.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author nezu
 */
public class Administrator1Model {//model for admin
    
    static ArrayList<Person1> userList = new ArrayList<Person1>();

    Person1 currentUser = new Person1();
    int UID = -1;
  

public Administrator1Model(){}

public int getUID() {return UID;}

}
