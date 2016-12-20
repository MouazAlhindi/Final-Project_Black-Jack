//Imports
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GraphicsPanel extends JPanel {
   
   private Player user;
   private Dealer cpu;
   
   private ArrayList<Card> playerHand;
   private ArrayList<Card> cpuHand;
   
   
   
   private JLabel uCard1;
   private JLabel uCard2;
   private JLabel cCard1;
   private JLabel cCard2;
   
   public GraphicsPanel(Player u, Dealer c) {
      this.user = u;
      this.cpu = c;  
      
      //setBackground(Color.green);
      setPreferredSize(new Dimension(500, 400));
      
      Box cpuBox = Box.createHorizontalBox();
      Box userBox = Box.createHorizontalBox();
      

      
      
      uCard1 = new JLabel();
      uCard2 = new JLabel();
      cCard1 = new JLabel();
      cCard2 = new JLabel();
      
      
      setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

      add(cpuBox);
      add(userBox);      
      
      
      
   }
   
   public void getCardOnTable(){
      playerHand = user.getHandCards();
      cpuHand = cpu.getHandCards();
   }
   
   public void displayDeal(){
      uCard1.setIcon(playerHand.get(0).getIcon());
   }
   
   public void displayAddUserCard(JLabel l){
      //userBox.add(l);
      //userBox.add(Box.CreateHorizontalGlue());
   }
   
   public void displayAddCpuCard(JLabel l){
      //cpuBox.add(l);
      //cpuBox.add(Box.CreateHorizontalGlue());
   }
   
   
}