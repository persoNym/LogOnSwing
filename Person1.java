package users1;

import java.io.*; 

public class Person1 implements Serializable{//user class
         
         //private members
         private String Name;
         private String ID;
         private String Password;
     
    public Person1() {}

    Person1(String Name, String ID, String Password) { //constructor
        
         this.Name = Name;
    
         this.ID = ID;
     
         this.Password = Password;
         
    }

      //public Accessors
        
        public String getName() {return Name;}
        public String getID() {return ID;}
        public String getPassword() {return Password;}
        public void setPassword(String x) {this.Password = x;} //mutator for changing password
        
        @Override
   public String toString()
   {
       return "\t"+ "  " + " User ID is: " + ID + "\t" + "        " + " Name is: " + Name + "\n"+"\n";
   }
    
        
   
    
}