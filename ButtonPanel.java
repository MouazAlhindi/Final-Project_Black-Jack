//Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ButtonPanel extends JPanel{
   
   private JTextField asset;
   private JTextField bet;
   private JButton placeBet;
   private JButton hit;
   private JButton stay;
   
   private Player userPlayer;
   private Dealer cpuDealer;
   
   public ButtonPanel(Player u, Dealer c) {
      asset = new JTextField(7);
      asset.setEditable(false);
      bet = new JTextField(5);
      bet.setEditable(true);
      placeBet = new JButton("Place Bet");
      placeBet.addActionListener(new BetButtonListener());
      hit = new JButton("Hit");
      hit.addActionListener(new HitButtonListener());
      stay = new JButton("Stay");
      stay.addActionListener(new StayButtonListener());
      
      add(asset);
      add(bet);
      add(placeBet);
      add(hit);
      add(stay);
      
      this.userPlayer = u;
      this.cpuDealer = c;
   }
   
   //Action Listener for placeBet button   
   private class BetButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e){
         
      }
   }
   
   //Action Listener for hit button
   private class HitButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e){
         
      }
   }
   
   //Action Listener for stay button
   private class StayButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
      
      }
   }
   
}

