      //to access KeyEvent and KeyAdapter
import javax.swing.*;         //to access JFrame and JPanel
import java.awt.*;            //to access Graphics and Color
import java.awt.event.*;//to access Listeners
import java.awt.geom.*; 
public class PotatoMoodBooster {
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Potato Mood Booster"); 
      frame.setSize(1280, 700);            
      frame.setLocation(100, 50);         
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      frame.setContentPane(new DrawPanelLab08());
      frame.setVisible(true);             
   } 
}
//ltrb
class DrawPanelLab08 extends JPanel implements MouseListener, MouseMotionListener{
   GeneralPath line = new GeneralPath();  
// (double left, double top, double right, double bottom)
   private Ellipse happy= new Ellipse(1, 129, 256,384);
   private Ellipse angry = new Ellipse(257, 129, 512,384);
   private Ellipse anxious= new Ellipse(513, 129, 768,384);
   private Ellipse confused= new Ellipse(769, 129, 1024,384);
   private Ellipse content= new Ellipse(1025, 129, 1280,384);
   private Ellipse disgust= new Ellipse(1,385 , 256,640);
   private Ellipse excited= new Ellipse(257, 385, 512,640);
   private Ellipse fearful= new Ellipse(513, 385, 768,640);
   private Ellipse sad= new Ellipse(769, 385, 1024,640);
   private Ellipse tired= new Ellipse(1025, 385, 1280,640);

   //private RectF redRect = new RectF(190, 240, 200,250);
   private int speed = 5;//speed for Ellipse
   private int player1,player2;
   public DrawPanelLab08(){
      addMouseListener(this);             //handles mouse click related events
      addMouseMotionListener(this);       //handles mouse motion events
      setFocusable(true);                 //JPanel must be focusable to listen to key events
      requestFocusInWindow();             //takes focus when window is selected  
      //leftPaddle.setImage("potato.png");
      happy.setImage("happy.png");   
      anxious.setImage("anxious.png"); 
      confused.setImage("confused.png"); 
      content.setImage("content.png"); 
      disgust.setImage("disgust.png"); 
      excited.setImage("excited.png"); 
      fearful.setImage("fearful.png"); 
      sad.setImage("sad.png"); 
      tired.setImage("tired.png"); 
      angry.setImage("angry.png"); 
     // happy.setImage("happy.png"); 
         
      
         
   }
   private double cX,cY;
   private int change = -1 ;
   private int neg;
   @Override public void mousePressed(MouseEvent e) {
      if(e.getButton()==MouseEvent.BUTTON1) {    //If left-click
         line.moveTo(e.getX(),e.getY());
         cX = e.getX();
         cY = e.getY();
         
      } 
      if(happy.contains(cX,cY)&&(change == -1)){
         neg = 0;
         change = 5;
      }
      if(angry.contains(cX,cY)&&(change == -1)){
         
         neg = 1;
         change = 5;
      }
      if(anxious.contains(cX,cY)&&(change == -1)){
         
         neg = 1;
         change = 5;
      }
      if(confused.contains(cX,cY)&&(change == -1)){
         
         neg = 1;
         change = 5;
      }
   
      if(content.contains(cX,cY)&&(change == -1)){
         neg = 0;
         change = 5;
      }
      if(disgust.contains(cX,cY)){
         neg = 1;
         change = 5;
      }
      if(excited.contains(cX,cY)&&(change == -1)){
         neg = 0;
         change = 5;
      }
      if(fearful.contains(cX,cY)&&(change == -1)){
         
         neg = 1;
         change = 5;
      }
      if(sad.contains(cX,cY)&&(change == -1)){
         neg = 1;
         change = 5;
      }
      if(tired.contains(cX,cY)&&(change == -1)){
         neg  =0;
         change = 5;
      }
   
   
    //picks up pen and places it at the clicked location
   }
   @Override public void mouseReleased(MouseEvent e) {}
   @Override public void mouseClicked(MouseEvent e) {}
   @Override public void mouseEntered(MouseEvent e) {}
   @Override public void mouseExited(MouseEvent e) {}
   @Override public void mouseMoved(MouseEvent e){}  
   @Override public void mouseDragged(MouseEvent e){}

   

   private double dXr=3,dYr=4;
   private int rand = (int)(Math.random()*(5-1)+1);
       

   public void paintComponent(Graphics g){
      int mode = 0;
      int count = 0;
   
   
      final float hue =57.07f;
   // Saturation between 0.1 and 0.3
      final float saturation = 41.84f;
      final float luminance = 98.00f;
      final Color color = Color.getHSBColor(hue, saturation, luminance);
      g.setColor(color);//selects background color
      g.fillRect(0, 0, getWidth()-1, getHeight()-1);//clears the screen
      g.setColor(Color.black);
      g.setColor(Color.BLACK);
      g.setFont(new Font("Arial", Font.BOLD, 75));
      g.drawString("Click on your potato mood! ", 25, 96);
           
      //>>>>>>>>>>>>>>Your drawing goes here<<<<<<<<<<<<<<
      happy.draw(g);  
      angry.draw(g); 
      anxious.draw(g); 
      confused.draw(g); 
      content.draw(g); 
      disgust.draw(g); 
      excited.draw(g); 
      fearful.draw(g); 
      sad.draw(g); 
      tired.draw(g); 
      move(g); //Ellipse draws itself
      if(change == 5){
         g.setColor(color);//selects background color
         g.fillRect(0, 0, getWidth()-1, getHeight()-1);//clears the screen
         if(neg == 1){
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 50));
                         
            if(rand == 1){
               g.drawString("'Success is not final, failure is not ", 25, 96);
               g.drawString("fatal ; it is the courage to continue  ",25, 175);
               g.drawString("that counts.'- Winston Churchhill", 25, 254);
            }
          
            if(rand==2){
               g.drawString("'Believe you can and you’re", 25, 96);
               g.drawString(" halfway there.' ",25, 175);
               g.drawString(" - Theodore Roosevelt",25,254);
            }
          
            if(rand==3){
               g.drawString("'We may encounter many defeats ", 25, 96);
               g.drawString("but we must not be defeated.'",25, 175);
               g.drawString(" - Maya Angelou",25,254);
            }
          
            if(rand ==4){
               g.drawString("'Don’t be pushed around by the ", 25, 96);
               g.drawString("fears in your mind. Be led by",25,175);
               g.drawString("the dreams in your heart.'",25,254);
               g.drawString("- Roy T. Bennett",25,333);
            }
          
            if(rand == 5){
               g.drawString("'You don’t have to be great to ", 25, 96);
               g.drawString("start, but you have to ",25,175);
               g.drawString("start to be great.'",25,254);
               g.drawString("- Zig Zigla",25,333);
            }
         }
         
         if(neg == 0){
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 50));
                         
            
            if(rand == 1){
               g.drawString("'All my life I thought air was free,", 25, 96);
               g.drawString("until I bought a bag of chips.' ",25, 175);
               g.drawString("- Anonymous ", 25, 254);
            }
            
            if(rand==2){
               g.drawString("A smile is a curve that sets ", 25, 96);
               g.drawString("everything straight.” - Phyllis Diller",25, 175);
            }
            
            if(rand==3){
               g.drawString("'I am so clever that sometimes", 25, 96);
               g.drawString("I don’t understand a single word ",25, 175);
               g.drawString("of what I am saying.'  ",25,254);
               g.drawString(" - Oscar Wilde",25,333);
            }
            
            if(rand ==4){
               g.drawString("'Knowledge is knowing that a ", 25, 96);
               g.drawString("tomato is a fruit. Wisdom is not ",25,175);
               g.drawString("putting it in a salad.' ",25,254);
               g.drawString(" - Miles Kington",25,333);
            }
            
            if(rand == 5){
               g.drawString("'A synonym is a word you use ", 25, 96);
               g.drawString("when you can’t spell the ",25,175);
               g.drawString("other one' ",25,254);
               g.drawString(" - Baltasar Gracián",25,333);
            }
            
         
         
         }
      
      }
      try{Thread.sleep(10);}
      catch(Exception e){}
      repaint();   
   }     //redraw image
   
   public void move(Graphics g){
   }
            


}

