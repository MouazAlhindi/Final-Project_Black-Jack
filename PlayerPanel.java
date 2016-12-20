//Import
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Player Display Panel
public class PlayerPanel extends JPanel{
   
   //Fields
   private Player user;
   private ArrayList<Card> userHand = new ArrayList<Card>();
   private ArrayList<Card> splitHand = new ArrayList<Card>();
   private ArrayList<JLabel> cardsDisplay = new ArrayList<JLabel>();
   private ArrayList<JLabel> splitDisplay = new ArrayList<JLabel>();
   private ImageIcon blankCard;
   
   //Constructor
   public PlayerPanel(Player u){
      this.user = u;
      blankCard = new ImageIcon("Backface_Red.jpg");
      
      
      setPreferredSize(new Dimension(500, 300));  
      
      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
   }
   
   //Method that will clear all images on the panel
   public void clearLabels(){ 
      
      for(int i = 0; i < cardsDisplay.size(); i++){
         remove(cardsDisplay.get(i));
      }
   }
   
   //Method that will get the display of the users hand
   public void getUserHand(){
      clearLabels();
      cardsDisplay.clear();
      userHand = user.getHandCards();
      splitDisplay.clear();
      splitHand = user.getSplitHand();
      
      
      int i = 0;
      
      
      if (!(user.getSplitBool())) {
         for (Card c: userHand){
            cardsDisplay.add(new JLabel(c.getIcon()));
            add(cardsDisplay.get(i));
            i++;
         }
      } else {
      
         for (Card c: userHand){
            cardsDisplay.add(new JLabel(c.getIcon()));
            add(cardsDisplay.get(i));
            i++;
         }
         
         
         add(new JLabel(blankCard));
         
         i = 0;
         
         for (Card c : splitHand){
            splitDisplay.add(new JLabel(c.getIcon()));
            add(splitDisplay.get(i));
            i++;
         }
      }
      
      revalidate();
      repaint();
      
   }
}