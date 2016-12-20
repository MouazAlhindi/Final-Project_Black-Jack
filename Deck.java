//Imports
import java.util.*;
import java.awt.*;
import javax.swing.*;

//Deck Class: will hold
public class Deck {
   
   private Card[] cards = new Card[52]; //Hold indefinte array of card
   private ArrayList<Card> cardList = new ArrayList<Card>(); //holds changeable array of cards
   private int numCard; //holds the number of cards currently in the deck
   
   //Constructor
   public Deck(){
      
      setDeck(); //void method that sets up deck
      
      
      
      /*
      cards[0] = new Card(2, "Clubs" , "2_Clubs.jpg");
      cards[1] = new Card(3, "Clubs", "3_Clubs.jpg");
      cards[2] = new Card(4, "Clubs", "4_Clubs.jpg");
      cards[3] = new Card(5, "Clubs", "5_Clubs.jpg");
      cards[4] = new Card(6, "Clubs", "6_Clubs.jpg");
      cards[5] = new Card(7, "Clubs", "7_Clubs.jpg");
      cards[6] = new Card(8, "Clubs", "8_Clubs.jpg");
      cards[7] = new Card(9, "Clubs", "9_Clubs.jpg");
      cards[8] = new Card(10, "Clubs", "10_Clubs.jpg");
      cards[9] = new Card(11, "Clubs", "Jack_Clubs.jpg");
      cards[10] = new Card(12, "Clubs", "Queen_Clubs.jpg");
      cards[11] = new Card(13, "Clubs", "King_Clubs.jpg");
      cards[12] = new Card(14, "Clubs", "Ace_Clubs.jpg");
      cards[13] = new Card(2, "Spades", "2_Spades.jpg");
      cards[14] = new Card(3, "Spades", "3_Spades.jpg");
      cards[15] = new Card(4, "Spades", "4_Spades.jpg");
      cards[16] = new Card(5, "Spades", "5_Spades.jpg");
      cards[17] = new Card(6, "Spades", "6_Spades.jpg");
      cards[18] = new Card(7, "Spades", "7_Spades.jpg");
      cards[19] = new Card(8, "Spades", "8_Spades.jpg");
      cards[20] = new Card(9, "Spades", "9_Spades.jpg");
      cards[21] = new Card(10, "Spades", "10_Spades.jpg");
      cards[22] = new Card(11, "Spades", "Jack_Spades.jpg");
      cards[23] = new Card(12, "Spades", "Queen_Spades.jpg");
      cards[24] = new Card(13, "Spades", "King_Spades.jpg");
      cards[25] = new Card(14, "Spades", "Ace_Spades.jpg");
      cards[26] = new Card(2, "Diamonds", "2_Diamonds.jpg");
      cards[27] = new Card(3, "Diamonds", "3_Diamonds.jpg");
      cards[28] = new Card(4, "Diamonds", "4_Diamonds.jpg");
      cards[29] = new Card(5, "Diamonds", "5_Diamonds.jpg");
      cards[30] = new Card(6, "Diamonds", "6_Diamonds.jpg");
      cards[31] = new Card(7, "Diamonds", "7_Diamonds.jpg");
      cards[32] = new Card(8, "Diamonds", "8_Diamonds.jpg");
      cards[33] = new Card(9, "Diamonds", "9_Diamonds.jpg");
      cards[34] = new Card(10, "Diamonds", "10_Diamonds.jpg");
      cards[35] = new Card(11, "Diamonds", "Jack_Diamonds.jpg");
      cards[36] = new Card(12, "Diamonds", "Queen_Diamonds.jpg");
      cards[37] = new Card(13, "Diamonds", "King_Diamonds.jpg");
      cards[38] = new Card(14, "Diamonds", "Ace_Diamonds.jpg");
      cards[39] = new Card(2, "Hearts", "2_Hearts.jpg");
      cards[40] = new Card(3, "Hearts", "3_Hearts.jpg");
      cards[41] = new Card(4, "Hearts", "4_Hearts.jpg");
      cards[42] = new Card(5, "Hearts", "5_Hearts.jpg");
      cards[43] = new Card(6, "Hearts", "6_Hearts.jpg");
      cards[44] = new Card(7, "Hearts", "7_Hearts.jpg");
      cards[45] = new Card(8, "Hearts", "8_Hearts.jpg");
      cards[46] = new Card(9, "Hearts", "9_Hearts.jpg");
      cards[47] = new Card(10, "Hearts", "10_Hearts.jpg");
      cards[48] = new Card(11, "Hearts", "Jack_Hearts.jpg");
      cards[49] = new Card(12, "Hearts", "Queen_Hearts.jpg");
      cards[50] = new Card(13, "Hearts", "King_Hearts.jpg");
      cards[51] = new Card(14, "Hearts", "Ace_Hearts.jpg");
      */
   }
   
   //Runs a for loop that sets up the constructor for each card in the deck
   public void setDeck(){
      String[] suites = new String[4];
      
      suites[0] = "Hearts";
      suites[1] = "Diamonds";
      suites[2] = "Spades";
      suites[3] = "Clubs";
      
      int cardCount = 0;
      
      for(int i = 0; i <= 3; i++) {
         for(int j = 2; j <= 14; j++){
            cards[cardCount] = new Card(j, suites[i]);
            cardCount++;
         }
      }
      
      resetDeck();
   }
   
  
   //will reset the deck so the arraylist has the full 52 cards in a deck
   public void resetDeck(){
         cardList.clear();
         for(int i = 0; i < cards.length; i++){
            cardList.add(cards[i]);
         }
         
         numCard = cardList.size() - 1;
   }
   
   //method will return a random card from the deck
   public Card pickRandomCard(){
      int rand = (int)(Math.random() * numCard);
      Card randCard = cardList.get(rand);
      
      cardList.remove(rand);
      numCard--;
      
      if(cardList.size() < 8){
         resetDeck();
      }
      
      return randCard;
      
   }
   
   //will return the indefinte array of cards
   public Card[] getDeck() {
      return cards;
   }
   
   
   

}