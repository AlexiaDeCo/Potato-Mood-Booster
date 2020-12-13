import javax.swing.*;                           //access ImageIcon
import java.awt.*;                              //to access Grpahics and Color
public class Sprite extends RectF{     //inherits everything from RectF

      private double dX,dY;
     private ImageIcon mImage;
      private Color mColor=Color.green;

   public Sprite(double left, double top, double right, double bottom) {
      super(left,top,right,bottom);             //calls parent's constructor to build a RectF foundation
   }
   public Sprite(RectF rect){
      super(rect);                              //calls parent's constructor to build a RectF foundation
   }
      public void draw(Graphics g){ //draw itself
      if(getImage()!=null){                            //if the sprite has an image
         g.drawImage(getImage().getImage(),(int) left,(int) top,(int) getWidth(),(int) getHeight(), null); 
                                                                                        
      } else {
         g.setColor(getColor());
         if(getWidth()>0)
            g.fillRect((int)left, (int)top, (int)getWidth(), (int)getHeight());
         else
            g.fillRect((int)left, (int)top, 2, 2);
      }
   }
      public void update(){         //processes changes to itself
      offset(getdX(),getdY());
   }
      public double getdX(){
      return dX;
   }
      public void setdX(double dX){
      this.dX=dX;
   }
     public double getdY(){
      return dY;
   }
      public void setdY(double dY){
      this.dY=dY;
   }
      public ImageIcon getImage(){
      return mImage;
   }
      public void setImage(String i){
      mImage=new ImageIcon(("G:/My Drive/Foundations of CS/Units/Units/resources/"+(i)));
   }
     public Color getColor(){
      return mColor;
   }
     public void setColor(Color c){
      mColor=c;
   }
        public String toString() {
      return "Sprite(" + left + ", " + top + ", " + right + ", " + bottom + ")";
   }
}