//Imports
import java.util.*;

public interface BlackJackPlayer{
   
   //arraylist of cards that can add and remove cards from the hand
   public ArrayList<Card> getHandCards();
   
   //method that will return the cards in a hand
   public int getHandValue();
  
}