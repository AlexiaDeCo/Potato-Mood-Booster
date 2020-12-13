import javax.swing.*;                  //to access ImageIcon
import java.awt.*;                     //to access Grpahics and Color
import java.awt.geom.*;                //to access Ellipse2D
public class Ellipse extends Sprite{    //inherits everything from Sprite
     private double xRadius,yRadius;
      public Ellipse(){
      this(0,0,0,0);
   }
      public Ellipse(double left, double top, double right, double bottom) {
      super(left,top,right,bottom);
      xRadius=(right-left)/2;
      yRadius=(bottom-top)/2;
   }
     public Ellipse(RectF rect){
      super(rect);
      xRadius=getWidth()/2;
      yRadius=getHeight()/2;
   }
   public void draw(Graphics g){
      if(getImage()!=null){                            //if the ellipse has an image
         Graphics2D g2D = (Graphics2D)g;           //cast to Graphics2D
         g2D.setClip(new Ellipse2D.Float((float) left,(float) top,(float) getWidth(),(float) getHeight()));      //defines the path of ellipse
         g2D.drawImage(getImage().getImage(),(int) left,(int) top,(int) getWidth(),(int) getHeight(), null); //draws circular image
         g.setClip(null);                                                                                //resets clipping to null
      } else {
         g.setColor(getColor());
         if(getWidth()>0)
            g.fillOval((int)left, (int)top, (int)getWidth(), (int)getHeight());
         else
            g.fillOval((int)left, (int)top, 2, 2);
      }
   };
      public void update(){
      offset(getdX(),getdY());
   };
      public void update(int left, int top, int right, int bottom){
      if(this.left<left||this.right>right||this.top<top||this.bottom>bottom)  //verify in bounds
         offsetTo((right+left)/2,(bottom+top)/2);             //teleport to center of bounds if needed
      if(this.left+getdX()<left||this.right+getdX()>right)                              //if left or right boundary exceeded
         setdX(getdX()*-1);                                                              //invert horizontal speed
      if(this.top+getdY()<top||this.bottom+getdY()>bottom)                              //if top or bottom boundary exceeded
         setdY(getdY()*-1);                                                              //invert vertical speed
      offset(getdX(),getdY());
   }
      public void update(RectF r){
      update((int)r.left,(int)r.top,(int)r.right,(int)r.bottom);
   }
      public boolean intersects(RectF r){
      if(super.intersects(r)){
         return new Ellipse2D.Double(left,top,getWidth(),getHeight()).intersects(
                 new Rectangle2D.Double(r.left,r.top,r.getWidth(),r.getHeight()));
      }
      return false;
   }
      public boolean contains(double x, double y) {
      /*if(isEmpty())
         return false;*/
      double normx = (x - left) / getWidth() - 0.5;
      double normy = (y - top) / getHeight() - 0.5;
      return (normx * normx + normy * normy) < 0.25;
   }
      public boolean contains(double left, double top, double right, double bottom) {
      if(isEmpty()||!super.contains(left,top,right,bottom))//check if this ellipse contains target rectangle
         return false;
         //check every point boundary points of rectangle
      return  contains(left,top)&&contains(left,bottom)&&contains(right,top)&&contains(right,bottom);
   }
      public boolean contains(RectF r) {
      return contains(r.left,r.top,r.right,r.bottom);
   }
      public double getxRadius() {
      return xRadius;
   }
      public void setxRadius(double xRadius) {
      this.xRadius = xRadius;
   }
      public double getyRadius() {
      return yRadius;
   }
      public void setyRadius(double yRadius) {
      this.yRadius = yRadius;
   }
      public String toString() {
      return "Ellipse(" + centerX() + ", " + centerY() + ", " + xRadius + ", " + yRadius + ", " + getColor() + ", " + getImage() + ")";
   }
}