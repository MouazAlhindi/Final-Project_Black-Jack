//Imports
import java.util.*;
import java.awt.*;
import javax.swing.*;

//Card Class
public class Card {

   //Fields
   private int cardValue;
   private String suite;
   private String iconFile;
   private ImageIcon picture;
   private boolean ace;

   //Constructor for specific cards
   public Card(int intCardVal, String su, String image){
         
         this.cardValue = intCardVal;
         this.suite = su;
         this.iconFile = image;

         picture = new ImageIcon(iconFile);
         
         
         
   }
   
   //Constructor for auto initalize
   public Card(int cardVal, String su){
      this.cardValue = cardVal;
      this.suite = su;
      
      if (cardValue == 11){
         iconFile = "Jack_" + suite + ".jpg";
      } else if (cardValue == 12) {
         iconFile = "Queen_" + suite + ".jpg";
      } else if (cardValue == 13){
         iconFile = "King_" + suite + ".jpg";
      } else if (cardValue == 14) {
         iconFile = "Ace_" + suite + ".jpg";
         ace = true;
      } else {
         iconFile = Integer.toString(cardValue) + "_" + suite + ".jpg";
      }
      
      picture = new ImageIcon(iconFile);
      
   }
   
   //Method that get the value of the card
   public int getCardValue(){
      if (cardValue == 11 || cardValue == 12 || cardValue == 13){
         return 10;
      }  else if (cardValue == 14){
         return 1;
      } else {
         return cardValue;
      }
   }
   
   //return the boolean value ace
   public boolean getAce(){
      return ace;
   }
   
   //get the card suit
   public String getSuit(){
      return suite;
   }
   
   //get the file name for the image icon for the card
   public String getFile(){
      return iconFile;
   }
   
   //get the image icon 
   public ImageIcon getIcon(){
      return picture;
   }

}