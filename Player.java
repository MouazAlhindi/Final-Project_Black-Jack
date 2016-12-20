//Imports
import java.util.*;

//Player Class that implements the blackjackplayer class
public class Player implements BlackJackPlayer{
   
   //fields for hand
   private ArrayList<Card> playerHand = new ArrayList<Card>();
   private ArrayList<Card> splitHand = new ArrayList<Card>();
   private int playerHandValue;
   private int splitHandValue;
   
   //fields for game logic
   private boolean split;
   private boolean playerBust;
   private int asset;
   
   //constructor
   public Player() {
      
   }
   
   //returns the split boolean value
   public boolean getSplitBool(){
      return split;
   }
   
   //method that will create a split hand
   public void makeSplitHand(){
      split = true;
      splitHand.add(playerHand.get(1));
      playerHand.remove(1);
   }
   
   //returns the split hand
   public ArrayList<Card> getSplitHand(){
      return splitHand;
   }
   
   //returns Hand
   public ArrayList<Card> getHandCards(){
      return playerHand;
   }
   
   //get the value of the players hand
   public void getValue(){
      int value = 0;
      int aceIndex = 0;
      int ace1Value = 0;
      int ace2Value = 0;
      
      for (Card c: playerHand){
         if(!c.getAce()){
            value += c.getCardValue();
         } else {
            aceIndex = playerHand.indexOf(c);
            value = 0;
            for(Card i: playerHand){
               if (!(playerHand.indexOf(c) == aceIndex)){
                  value += c.getCardValue();
               }
            }
            
            ace1Value = value + 1;
            ace2Value = value + 11;
            
            if (ace2Value <= 21){
               playerHandValue = ace2Value; 
            } else {
               playerHandValue = ace1Value;
            }
               break;  
          }
         playerHandValue = value;  
      }
         
      
   }
   
   //gets the value of the split hand
   public int getSplitValue(){
      int value = 0;
      int aceIndex = 0;
      int ace1Value = 0;
      int ace2Value = 0;
      
      for (Card c: splitHand){
         if(!c.getAce()){
            value += c.getCardValue();
         } else {
            aceIndex = splitHand.indexOf(c);
            value = 0;
            for(Card i: splitHand){
               if (!(splitHand.indexOf(c) == aceIndex)){
                  value += c.getCardValue();
               }
            }
            
            ace1Value = value + 1;
            ace2Value = value + 11;
            
            if (ace2Value <= 21){
               splitHandValue = ace2Value; 
            } else {
               splitHandValue = ace1Value;
            }
               break;  
            }
            splitHandValue = value;  
         }
        return splitHandValue;
   }
   
   
   //gets the value of the hand and returns it
   public int getHandValue(){
      getValue();
      return playerHandValue;
   }
   
   //adds a card to the players hand
   public void addPlayerCard(Card c){
      playerHand.add(c);
      
      if (getHandValue() > 21){
         playerBust = true;
      }
   }
   
   //adds a card to the split hand of the players
   public void addCardToSplit(Card c){
      splitHand.add(c);
      
      if (getSplitValue() > 21){
         playerBust = true;
      }
   }
   
   //clears the players hand and readys feilds for a new round
   public void clearPlayerHand(){
      playerHand.clear();
      splitHand.clear();
      split = false;
      playerBust = false; 
   }
   
   //returns the players bust booelan value
   public boolean getPlayerBust() {
      return playerBust;
   }
   
   //returns amount of money the user has
   public int getAsset(){
      return asset;
   }
   
   //subtracts x amount of money from the asset var
   public void subAsset(int x){
      asset -= x; 
   }
   
   //adds x amount of money to the asset var
   public void addAsset(int x){
      asset += x;
   }
}