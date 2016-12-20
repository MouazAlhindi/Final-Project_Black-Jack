//imports
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//CPU Display Panel
public class CpuPanel extends JPanel{
   
   //Field
   private Dealer cpu;
   private ArrayList<Card> cpuHand = new ArrayList<Card>();
   private ArrayList<JLabel> cardsDisplay = new ArrayList<JLabel>();
   private ImageIcon fdCardIcon = new ImageIcon("Backface_Red.jpg");
   
   //Panel Constructor
   public CpuPanel(Dealer c){
      this.cpu = c;
            
      setPreferredSize(new Dimension(500, 300));  
      
      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
   }
   
   //Method to clear the panel of Images
   public void clearLabels(){
      
      for(int i = 0; i < cardsDisplay.size(); i++){
         remove(cardsDisplay.get(i));
      }
   
   }
   
   //Display the Cpu Hands with one card facing down
   public void getCpuHand(){
      clearLabels();
      cardsDisplay.clear();
      cpuHand = cpu.getHandCards();
      cardsDisplay.add(new JLabel(fdCardIcon));
      add(cardsDisplay.get(0));
      
      int i = 0;
      
      
      for (Card c: cpuHand){
         cardsDisplay.add(new JLabel(c.getIcon()));
         add(cardsDisplay.get(i));
         i++;
      }
      
      revalidate();
      repaint();
        
   }
   
   //Display the Cpu Hands with all cards facing up
   public void showCpuHand(){
      clearLabels();
      cpuHand = cpu.getHandCards();
      cardsDisplay.clear();
      int i = 0;
      
      for (Card c: cpuHand){
         cardsDisplay.add(new JLabel(c.getIcon()));
         add(cardsDisplay.get(i));
         i++;
      }
      
      revalidate();
      repaint();
   }
}