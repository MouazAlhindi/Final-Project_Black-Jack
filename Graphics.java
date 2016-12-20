//Imports
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Graphics Class: Main Frame
public class Graphics extends JFrame {
   
   //Card Objects
   private Deck deck;
   private Card[] cards;
   
   
   //JPanel Object
   private PlayerPanel pPanel;
   private CpuPanel cPanel;
   
   //Button Panel
   private JPanel buttonPanel;
   private JTextField asset;
   private JTextField bet;
   private JTextField messageBoard;
   private JButton placeBet;
   private JButton hit;
   private JButton stay;
   private JButton doubleDown;
   private JButton split;
   private JButton surrender;
   private JButton nextHand;
   
   //Player Objects
   private Player user;
   private Dealer cpu;
   
   
   //Game Logic Components
   private int playerBet;
   private int cpuBet;
   private int pot;
   private boolean betPlaced;
   private boolean doubleDownLog;
   private boolean gameEnd;
   private boolean leftHand;
   
   public Graphics(){
      //Intialize Objects
      user = new Player();
      cpu = new Dealer();
      deck = new Deck();
      
      //Intialize Panel
      pPanel = new PlayerPanel(user);
      cPanel = new CpuPanel(cpu);
      
      //Making the button Panel      
      buttonPanel = new JPanel();
      makeButtonPanel();
      
      //set the layout for the frame
      setLayout(new BorderLayout());
      
      //Add all panels
      add(pPanel, BorderLayout.CENTER);
      add(cPanel, BorderLayout.NORTH);
      add(buttonPanel, BorderLayout.SOUTH);   

      //JFrame credentials
      setTitle("Black Jack");   
      setSize(700, 700);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      
      //test
      user.addAsset(1000);
      updateAsset();
      placeBets();
      
      //deal();
      
      
     
   }
   
   //Makes the button panel
   public void makeButtonPanel(){
      //text fields
      asset = new JTextField(7);
      asset.setEditable(false);
      bet = new JTextField(5);
      bet.setEditable(true);
      messageBoard = new JTextField(10);
      messageBoard.setEditable(false);
      
      //buttons
      placeBet = new JButton("Place Bet");
      placeBet.addActionListener(new BetButtonListener());
      hit = new JButton("Hit");
      hit.addActionListener(new HitButtonListener());
      stay = new JButton("Stay");
      stay.addActionListener(new StayButtonListener());
      doubleDown = new JButton("Double");
      doubleDown.addActionListener(new DoubleButtonListener());
      split = new JButton("Split");
      split.addActionListener(new SplitButtonListener());
      surrender = new JButton("Surrender");
      surrender.addActionListener(new SurrenderButtonListener());
      nextHand = new JButton("Next Hand");
      nextHand.addActionListener(new NextButtonListener());
      
      //layout for button panel
      buttonPanel.setLayout(new GridLayout(3, 3));
      
      //adding componenets to the button panel
      buttonPanel.add(messageBoard);
      buttonPanel.add(bet);
      buttonPanel.add(placeBet);
      buttonPanel.add(asset);
      buttonPanel.add(hit);
      buttonPanel.add(stay);
      //buttonPanel.add(split);
      buttonPanel.add(doubleDown);
      buttonPanel.add(surrender);
      buttonPanel.add(nextHand);
      
   }
   
   //System for dealers to hit and play their hand
   public void cpuHit(){
      while (cpu.getHandValue() < 17){
         cpu.addCpuCard(deck.pickRandomCard());
      }
   }
   
   //sends a messages to the message board to tell the user to place a bet
   public void placeBets(){
      messageBoard.setText("Place your Bet!");
   }
   
   //updates assest of the user
   public void updateAsset(){
      asset.setText("Asset: " + user.getAsset());
   }
   
   //check the user for the bust boolean value
   public boolean checkUserBust(){
      return user.getPlayerBust();
      
   }

   //Method used to deal
   public void deal(){
      Card one = deck.pickRandomCard();
      Card two = deck.pickRandomCard();
      user.addPlayerCard(one);
      user.addPlayerCard(two);
      
      Card three = deck.pickRandomCard();
      Card four = deck.pickRandomCard();
      cpu.addCpuCard(three);
      cpu.addCpuCard(four);
      
      cPanel.getCpuHand();
      pPanel.getUserHand();
      
      messageBoard.setText("Cards are placed, what are you going to do?");
      
   }
   
   //checks who won the round
   public void checkWinner(){
      cpuHit();
      cPanel.showCpuHand();
      gameEnd = true;
      betPlaced = false;
      
      if(user.getPlayerBust() == true){
         updateAsset();
         messageBoard.setText("You lost this hand! Place new Bet");
      } else if (cpu.getCpuBust() == true){
         user.addAsset(pot);
         updateAsset();
         messageBoard.setText("You won the hand! Place new Bet");
      } else if (user.getHandValue() > cpu.getHandValue() && user.getPlayerBust() == false){
         user.addAsset(pot);
         updateAsset();
         messageBoard.setText("You won the hand! Place new Bet");
      } else if (user.getHandValue() == cpu.getHandValue()){
         user.addAsset(playerBet);
         messageBoard.setText("its a draw!");
      } else  {
         updateAsset();
         messageBoard.setText("You lost this hand! Place new Bet");
      }
      
      
   }
   
   //hit method for the players to obtain a new card
   public void hit(){        
            user.addPlayerCard(deck.pickRandomCard());
            user.getValue();
            pPanel.getUserHand();
            System.out.println("Hit");    
            if (checkUserBust()){
               checkWinner();
            }
   }
   
   //Method use to reset the table and reset all values
   public void endRound(){
      user.clearPlayerHand();
      cpu.clearCpuHand();
      
      pot = 0;
      playerBet = 0;
      cpuBet = 0;
      betPlaced = false;
      doubleDownLog = false;
      gameEnd = false;
      
      System.out.println("Cleared Hands");
   }
   
   //Action Listener for bet button
   private class BetButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e){
      
         if (!betPlaced){
            endRound();
            int b = Integer.parseInt(bet.getText());
            
            if(user.getAsset() <= 0){
               messageBoard.setText("Sorry you cant play with no money!");
            } else {
       
               playerBet = b;
               user.subAsset(playerBet);
               updateAsset();
               cpuBet = b;
               pot = cpuBet + playerBet;
               betPlaced = true;
               System.out.println("Player placed bet");
               bet.setText("");
               deal();
            }
         } else {
            //if bet is already placed, do nothing
         }
         
      }
   }
   
   //Action Listener for hit button
   private class HitButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e){
      
         if(betPlaced && user.getSplitBool() == false){
            user.addPlayerCard(deck.pickRandomCard());
            user.getValue();
            pPanel.getUserHand();
            System.out.println("Hit");    
            if (checkUserBust()){
               checkWinner();
               //endRound();
            }
         } else if (user.getSplitBool() && leftHand == true) {
            user.addPlayerCard(deck.pickRandomCard());
            user.getHandValue();
            pPanel.getUserHand();
            if(checkUserBust()){
               leftHand = false;
            }  
         } else if (user.getSplitBool() && leftHand == false) {
            user.addCardToSplit(deck.pickRandomCard());
            user.getSplitValue();
            pPanel.getUserHand();
            if(checkUserBust()){
               checkWinner();  
            }
         }
         
         
      }
   }
   
   //Action Listener for stay button
   private class StayButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if(betPlaced && user.getSplitBool() == false){
            checkWinner();
         } else if (user.getSplitBool() && leftHand == true){
            leftHand = false;
         } else if(user.getSplitBool() && leftHand == false){
            checkWinner();
         }
      }
   }
   
   //Action Listener for Double down button
   private class DoubleButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
            
            if (!doubleDownLog && betPlaced){
               playerBet *= 2;
               cpuBet *= 2;
               pot = 0;
               pot = playerBet + cpuBet;
               user.subAsset(playerBet);
               updateAsset();
               hit();
               checkWinner();
               doubleDownLog = true;
               System.out.println("Player Doubled Down");
            }
         
      }
   }
   
   //Action Listener for Split Button
   private class SplitButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         
         if(betPlaced){
            user.makeSplitHand();
            user.getHandCards();
            pPanel.getUserHand();
            leftHand = true;
         
            messageBoard.setText("Player Split Hand: hit or stay LEFT HAND");
         }
      }   
   }
   
   //Action Listener for Surrender Button
   private class SurrenderButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         playerBet /= 2;
         user.addAsset(playerBet);
         updateAsset();
         endRound();
         placeBets();
         
         System.out.println("Player Surrendered");
      }
   }
   
   //Action Listener for next hand button
   private class NextButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         endRound();
         pPanel.getUserHand();
         cPanel.getCpuHand();
         placeBets();
      }
   }
   
   //Main Method
   public static void main(String[] args){
      Graphics game = new Graphics();
      
   }
   
}