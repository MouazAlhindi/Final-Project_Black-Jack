//Imports
import java.util.*;

//Dealer class that implements the blackjackplayer
public class Dealer implements BlackJackPlayer{
   
   //fields
   private ArrayList<Card> cpuHand = new ArrayList<Card>();
   private int cpuHandValue;
   private boolean cpuBust;
   
   //constructor
   public Dealer() {
   
   }
   
   //returns the cards in the cpus hand
   public ArrayList<Card> getHandCards(){
      return cpuHand;
   }
   
   //get the value of the cards
   public int getHandValue(){
      int value = 0;
      
      for (Card c: cpuHand){
         value += c.getCardValue();
      }
      
      cpuHandValue = value;
      
      
      return cpuHandValue;
   }
   
   //adds a card to the cpus hand
   public void addCpuCard(Card c){
      cpuHand.add(c);
      
      
      if (getHandValue() > 21){
         cpuBust = true;
      }
   }
   
   //clears the cpus hand
   public void clearCpuHand(){
      cpuHand.clear(); 
      cpuBust = false;
   }
   
   //returns the cpu bust boolean value
   public boolean getCpuBust() {
      return cpuBust;
   }
   
  
   
   
}