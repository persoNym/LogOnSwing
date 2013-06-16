
package users1;

import java.util.*;
import java.io.*; 
import java.security.*;
import java.util.logging.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Administrator1 extends JFrame  implements ActionListener { //admin controller class

Scanner scan = new Scanner(System.in);
Scanner primeFile = null;
JFrame frame = new JFrame("Log In Menu");
private static String[] msg = {//popups for admin pw change
                     "User Name does not exist","Password change sucessful!"};


     
JTabbedPane tabbedPane = new JTabbedPane();
JPanel createUserPanel = new JPanel();
JLabel createLab = new JLabel("Input a number");//for istruction for create user to enter a number
JTextField createNF = new JTextField("",10);//text area for number input
JButton pSub = new JButton("Prime Me!"); //button to search for prime
JButton pLogOut = new JButton("LOGOUT");//but to log out in user tab
JPanel primePanel = new JPanel();//panel to put prime number components on
JPanel greenPanel = new JPanel();//panel to put the icon button in for user tab
JPanel exitPanel = new JPanel();//panel to put exit button and etc on
JButton infinityButt = new JButton();// picture button
JButton primeButt = new JButton();//what the prime image goes on

JPanel newUserCard = new JPanel();  //for newUser function
JPanel createCard = new JPanel(); //for admin tab
JPanel logInCard = new JPanel(); //for logging in tab
JPanel changePWCard = new JPanel(); //for change password tab
JButton submitButton = new JButton("SUBMIT");//new user
JButton quitButton = new JButton("LOGOUT"); //new user
JButton logInButt = new JButton("Log In"); //login panel
JPasswordField textPW = new JPasswordField(" ",35);//login panel
JTextField textID = new JTextField("",35); //login panel
JPasswordField cTextPW = new JPasswordField(" ",35);//change pw panel
JPasswordField nCTextPW = new JPasswordField(" ",35);//change pw panel
JPasswordField cVerify = new JPasswordField(" ",35);//change pw panel
//JTextField labelChangePW = new JTextField(" ",35);//text field to put in user name for admin in change pw
JTextField cUser = new JTextField(" ",35);//change pw panel
JButton changePW = new JButton("Change Password");//change pw panel
JButton findUs = new JButton("Select");//change pw panel for admin


JTextArea data = new JTextArea(3, 40); //for userlisst data
JScrollPane userPane = new JScrollPane( data );
        
JTextField textName = new JTextField("",20);
JTextField textUID = new JTextField("",20); //for new user
JPasswordField textPWord = new JPasswordField("",20);
JPasswordField textPPWord = new JPasswordField("",20);

StringBuilder S = new StringBuilder("\t\tREGISTERED USERS \n\n");

 Administrator1Model model = new Administrator1Model(); 


public Administrator1 () throws FileNotFoundException, IOException {
   

    
    try{ 
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.txt"));
        model.userList = (ArrayList<Person1>) ois.readObject(); 
        for(int k = 0; k < model.userList.size(); k++) {
        
        S.append(model.userList.get(k).toString());
        S.append("\n");
    }
        
        ois.close(); //close stream
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Administrator1.class.getName()).log(Level.SEVERE, null, ex);
        }    catch (FileNotFoundException e) {
        System.err.println("FileNotFoundException: File user.txt does not exist " + e);
                                    }
    try{
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt"));
        oos.writeObject(model.userList);
        }
    catch(IOException io) {
    System.out.println("IOException: Problem reading file user.txt. Throw to main " + io);
    throw io;
                          }
//----------------------------------------------------------------------------------------
    //new user panel for admin
 newUserCard.setLayout(new BoxLayout(newUserCard, BoxLayout.Y_AXIS));
    
        JPanel name = new JPanel( new FlowLayout());
        name.add(BorderLayout.CENTER,new JLabel("Name"));
        name.add(new JLabel("              "));
        name.add(BorderLayout.EAST,textName);
         
      
        JPanel UID = new JPanel( new FlowLayout());
        UID.add(BorderLayout.CENTER,new JLabel("Username"));
        UID.add(new JLabel("      "));
        UID.add(BorderLayout.EAST,textUID);
        
        
        JPanel pword = new JPanel( new FlowLayout());
        pword.add(BorderLayout.CENTER,new JLabel("Password"));
        pword.add(new JLabel("      "));
        pword.add(BorderLayout.EAST,textPWord);
        textPWord.setText(null);
        
        JPanel ppword = new JPanel( new FlowLayout());
        ppword.add(BorderLayout.CENTER,new JLabel("Verify"));
        ppword.add(new JLabel("              "));
        ppword.add(BorderLayout.EAST,textPPWord);
        textPPWord.setText(null);
        
        JPanel BPanel = new JPanel(new FlowLayout());
        BPanel.add(new JLabel("                         "));
        BPanel.add(BorderLayout.CENTER,submitButton);
        BPanel.add(BorderLayout.CENTER,quitButton);
        
        newUserCard.add(name);
        newUserCard.add(UID);
        newUserCard.add(pword);
        newUserCard.add(ppword);
        newUserCard.add(BPanel);
     //----------------------------------------------------------------------------------------     
        //action listeners
        submitButton.addActionListener(this);
        pLogOut.addActionListener(this);
        pSub.addActionListener(this);
        quitButton.addActionListener(this);
        logInButt.addActionListener(this);
        changePW.addActionListener(this);
 //------------------------------------------------------------------------------------------       
       data.setText(S.toString());
     
     //adds the text area and new user panel to one pane
        
        Container pane = getContentPane();
        pane.add(BorderLayout.WEST, newUserCard);
        pane.add(BorderLayout.EAST, userPane);
        //---------------------------------------------------------------------------------
        //change password
        
        changePWCard.setLayout(new BoxLayout(changePWCard, BoxLayout.Y_AXIS));
        
        JPanel fillIn = new JPanel( new GridLayout(4, 2));
        fillIn.add(new JLabel("              "));
        fillIn.add(new JLabel("              "));
        
        JPanel newPW = new JPanel( new FlowLayout());
        newPW.add(BorderLayout.CENTER,new JLabel("                             New Password"));
        newPW.add(new JLabel("      "));
        newPW.add(BorderLayout.EAST,nCTextPW);
        nCTextPW.setText(null);
        
        JPanel verPW = new JPanel( new FlowLayout());
        verPW.add(BorderLayout.CENTER,new JLabel("                          Verify Password"));
        verPW.add(new JLabel("      "));
        verPW.add(BorderLayout.EAST,cVerify);
        cVerify.setText(null);
        
        JPanel BPanelChange = new JPanel(new FlowLayout());
        BPanelChange.add(new JLabel("                                         "));
        BPanelChange.add(BorderLayout.CENTER,changePW);
        
     
        changePWCard.add(fillIn);
        changePWCard.add(newPW);
        changePWCard.add(verPW);
        changePWCard.add(BPanelChange);
        
        //-------------------------------------------------------------------------------
        //tabs and settings
        
        tabbedPane.addTab( "Log In",logInCard); 
        tabbedPane.addTab("Admin",pane);//admin tab
        tabbedPane.addTab("User",createCard);//new user and prime table
        tabbedPane.addTab("Change Password",changePWCard);
        tabbedPane.setEnabledAt(0,true);
        tabbedPane.setEnabledAt(1,false);
        tabbedPane.setEnabledAt(2,false);
        tabbedPane.setEnabledAt(3,false);
        
        //----------------------------------------------------------------------------------
        //log in panel
        
        
        
        
        JPanel fill = new JPanel( new GridLayout(8, 2));
        fill.add(new JLabel("              "));
        fill.add(new JLabel("              "));
        
        JPanel UID1 = new JPanel( new GridLayout(1, 3));
        UID1.add(new JLabel("                                                                            Username"));
        UID1.add(textID);
        UID1.add(new JLabel("              "));
        
        JPanel PWord1 = new JPanel( new GridLayout(1, 2));
        PWord1.add(new JLabel("                                                                            Password"));
        PWord1.add(textPW);
        textPW.setText(null);
        PWord1.add(new JLabel("               "));
        
        JPanel lButt = new JPanel( new GridLayout(1, 1));
        lButt.add(logInButt);
        
        logInCard.add(fill);
        logInCard.add(UID1);
        logInCard.add(PWord1);
        logInCard.add(lButt);
      
        
        
        //--------------------------------------------------------------------------------
                
        
        
        frame.add(tabbedPane);
        frame.setSize(950,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);  


//---------------------------------------------------------------------------------------
// for finding prime number 
        
       JPanel fillIt = new JPanel( new GridLayout(8, 4));
        fillIt.add(new JLabel("              "));
        fillIt.add(new JLabel("              "));
   
    JPanel primeLabel = new JPanel( new GridLayout(2, 3));//label instructions
        primeLabel.add(createLab);
      
        
    JPanel prime = new JPanel( new GridLayout(2, 3));//text box to put number
        prime.add(createNF);
        prime.add(pSub);//submit button
    
    primePanel.add(fillIt);
    primePanel.add(primeLabel); 
    primePanel.add(prime);
    
    
    
      JPanel fillIt1 = new JPanel( new GridLayout(4, 2));
        fillIt1.add(new JLabel("              "));
        fillIt1.add(new JLabel("              "));
        
    JPanel infiPanel = new JPanel(new GridLayout(1,1));
     Image img = ImageIO.read(getClass().getResource("prime.jpeg"));
    primeButt.setIcon(new ImageIcon(img));
    primeButt.setSize(20,20);
  
    infiPanel.add(BorderLayout.WEST,primeButt);
    
    
    JPanel buttPanel = new JPanel(new GridLayout(1,4));
    buttPanel.add(pLogOut);
    
    exitPanel.add(infiPanel);
    exitPanel.add(buttPanel);
    
    
    Image img1 = ImageIO.read(getClass().getResource("greendale.jpg"));
    infinityButt.setIcon(new ImageIcon(img1));
    infinityButt.setSize(20,20);
    greenPanel.add(infinityButt);
    
    createCard.add(BorderLayout.WEST,exitPanel);
    createCard.add(BorderLayout.EAST,primePanel);
    createCard.add(BorderLayout.SOUTH,greenPanel);
   
             
}
//----------------------------------------------------------------------------------------
          //compute Hash
     public static byte[] computeHash( String x )   
     throws NoSuchAlgorithmException  
     {
          MessageDigest d = MessageDigest.getInstance("SHA-1");
          d.update(x.getBytes());
          return  d.digest();
     }
//----------------------------------------------------------------------------------------
     //write users to file
     public void writeUsers() {
         
        try{
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt")); 
          oos.writeObject(model.userList);
           
            oos.close();
            System.out.print("Information has been saved to user.txt\n");
         
         }
        catch(FileNotFoundException fnf) {
            System.err.println("FileNotFoundException: File user.txt does not exist " + fnf);
        }
        catch(IOException eyeoh) {
            System.err.println("IOException: Error writing to user.txt " + eyeoh);
        }
     }       
     
//----------------------------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent ae ) {
      
        if(ae.getSource() == submitButton) {
          char[] P11= textPWord.getPassword();
          char[] P22= textPPWord.getPassword();
         String P1= new String(P11);
         String P2= new String(P22);
            if(P1.equals(P2)){ 
                try { //string compare and encrypts the password
                    P1 = new String(computeHash(P1));
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Administrator1.class.getName()).log(Level.SEVERE, null, ex);
                }

            int v = model.userList.size();
            Person1 newPerson;
            newPerson = new Person1(textName.getText(), textUID.getText(), P1 );
            model.userList.add(newPerson); 
            S.append(model.userList.get(v).toString()); 
            data.setText(S.toString());
            writeUsers();
            textName.setText("");
            textUID.setText("");
            textPWord.setText("");
            textPPWord.setText("");
            repaint();
        }
            else{ //popup to show incorrect password
               JPanel panel1 = new JPanel(new GridBagLayout());
               GridBagConstraints c = new GridBagConstraints();
               JFrame frame1 = new JFrame("\t\tERROR");
               JLabel label = new JLabel("INVALID PASSWORD");
               c.gridx = 1;
               c.gridy = 1;
               
               panel1.add(label,c);
               frame1.add(BorderLayout.CENTER,panel1);
               frame1.setSize(250,100);
               frame1.setLocationRelativeTo(null);
               frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
               frame1.setVisible(true); 

               textPWord.setText("");
               textPPWord.setText("");
               repaint();
               System.out.println("Password Error");
               
               
            }
            
        }
     else if(ae.getSource() == logInButt) {
         char[] logPW = textPW.getPassword();
         String logPW1 = new String(logPW);
          try { //string compare and encrypts the password
                    logPW1 = new String(computeHash(logPW1));
                } 
          catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Administrator1.class.getName()).log(Level.SEVERE, null, ex);
                }
          System.out.println("USERLIST " + model.userList.size());
        
          for(int j = 0; j < model.userList.size(); ++j) {
              Person1 person = model.userList.get(j);
   
              if(textID.getText().equals(person.getID()) && logPW1.equals(person.getPassword()) ){
                  model.UID=j;
               
                
              }
             
          }
          if(model.UID==-1){
              JPanel panelLog = new JPanel(new GridBagLayout());
               GridBagConstraints cc = new GridBagConstraints();
               JFrame frameLog = new JFrame("\t\tERROR");
               JLabel labelLog = new JLabel("INCORRECT LOGIN");
               cc.gridx = 1;
               cc.gridy = 1;
               
               panelLog.add(labelLog,cc);
               frameLog.add(BorderLayout.CENTER,panelLog);
               frameLog.setSize(250,100);
               frameLog.setLocationRelativeTo(null);
               frameLog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
               frameLog.setVisible(true); 
               textID.setText("");
               textPW.setText("");
               textPW.setText("");
               repaint();
                System.out.println("Incorrect Login");
                System.out.println(model.UID);
                
                
               }         
           else if(model.UID==0) { //admin can acess all tabs
              System.out.println("admin Login");
                   tabbedPane.setEnabledAt(1,true);
                   tabbedPane.setEnabledAt(2,false);
                   tabbedPane.setEnabledAt(3,true);
                   textID.setText("");
                   textPW.setText("");
                   textPW.setText("");
                   System.out.println(model.UID);
                   repaint();
                   
          }
          else {//sets accessible tab for non admin
              System.out.println("user Login");
                   tabbedPane.setEnabledAt(1,false);
                   tabbedPane.setEnabledAt(2,true);
                   tabbedPane.setEnabledAt(3,true);
                   textID.setText("");
                   textPW.setText("");
                   textPW.setText("");
                   System.out.println(model.UID);
                   repaint();
                   
          }
          repaint();
     
      }
        
        
        else if(ae.getSource() == quitButton) { //sets everything back to null and writes to the user.txt
            textName.setText("");//sets all back to null
            textUID.setText("");
            textPWord.setText("");
            textPPWord.setText("");           
            writeUsers();
            System.out.println(S);
            model.UID = -1;
            model.currentUser = null;
            tabbedPane.setSelectedComponent(logInCard);
	    tabbedPane.setEnabledAt(0,true); 
	    tabbedPane.setEnabledAt(1,false);
            tabbedPane.setEnabledAt(2,false);
            tabbedPane.setEnabledAt(3,false);
            
           
            
        }
        else if(ae.getSource() == pSub){
            int n = (Integer.parseInt(createNF.getText()));
            boolean prime = false;
           System.out.println("Your number is: " +n);
            if(n < 0 || n > 1000000) { 
               createLab.setText("Input Different Number");
               System.out.println("Input a different number");
                 repaint(); 
            }
           try{
             primeFile = new Scanner(new File("primes.txt"));
             while(primeFile.hasNext()){
                 int p = primeFile.nextInt();         
                 if(p%n == 0){
                     prime= true;
                 }                  
             }
            primeFile.close(); }
            catch(FileNotFoundException e){
                System.out.println("File not found. Please input file: " +e);                              
           }
           if(prime) createLab.setText("Is Prime");
           else createLab.setText("Is not Prime");
        }
        else if(ae.getSource() == pLogOut) {
            textName.setText("");//sets all back to null
            textUID.setText("");
            textPWord.setText("");
            textPPWord.setText("");
            writeUsers();
            model.UID = -1;
            model.currentUser = null;
            tabbedPane.setSelectedComponent(logInCard);
	    tabbedPane.setEnabledAt(0,true); 
	    tabbedPane.setEnabledAt(1,false);
            tabbedPane.setEnabledAt(2,false);
            tabbedPane.setEnabledAt(3,false);
            
        }
        else if(ae.getSource() == changePW) {
            
            char[] chPW1 = nCTextPW.getPassword();
            char[] chPW2 = cVerify.getPassword();
            String changePWNew = new String(chPW1);
            String changePWNew2 = new String(chPW2);

            
         if(!changePWNew.equals(changePWNew2)) {//popup for incorrect password
               JPanel panelBad = new JPanel(new GridBagLayout());
               GridBagConstraints bad = new GridBagConstraints();
               JFrame frameBad = new JFrame("\t\tERROR");
               JLabel labelBad = new JLabel("PASSWORDS DO NOT MATCH");
               bad.gridx = 1;
               bad.gridy = 1;
               
               panelBad.add(labelBad,bad);
               frameBad.add(BorderLayout.CENTER,panelBad);
               frameBad.setSize(250,100);
               frameBad.setLocationRelativeTo(null);
               frameBad.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
               frameBad.setVisible(true); 

               nCTextPW.setText("");
               cVerify.setText("");
               repaint();
               System.out.println("Password Error"); 
                }
                    
            else if(changePWNew.equals(changePWNew2)) {    //since pw are equal it encrypts then checks to see if admin or not
                try { 
                   changePWNew = new String(computeHash(changePWNew));
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Administrator1.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(model.UID == 0) {
                String s;
                int k = -1;
                s = JOptionPane.showInputDialog(null,"Enter name of User you wish to change the password of", "Admin Popup", JOptionPane.QUESTION_MESSAGE);
                System.out.println(s);
                for(int c = 0; c < model.userList.size();c++) {
                     Person1 person = model.userList.get(c);
                    if (s.equals(person.getID())) {
                      System.out.println(person.getID());  
                      k = c;
                      break;
                    }
                                                                }
                    if(k == -1) {
                        s = JOptionPane.showInputDialog(null, msg[0], "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                    else {
                        model.userList.get(k).setPassword(changePWNew );
                                cUser.setText("");
                                nCTextPW.setText("");
                                cVerify.setText("");
                                repaint();
                                JOptionPane.showMessageDialog(null, msg[1], "Update", JOptionPane.INFORMATION_MESSAGE);
                                writeUsers();
                    }
                }              
            else if(model.UID > 0) {//sets the password for non admin
                model.userList.get(model.UID).setPassword(changePWNew);
                    JOptionPane.showMessageDialog(null, msg[1], "Update", JOptionPane.INFORMATION_MESSAGE);
                                cUser.setText("");
                                nCTextPW.setText("");
                                cVerify.setText("");
                                repaint(); 
                                writeUsers();         
                                }
            }  
 }
    }  
    @Override
    public void paint(Graphics g){
        super.paint(g);
        data.setText(S.toString());
    } 
}
