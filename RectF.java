public class RectF{
   public double left, top, right, bottom;
   public RectF(){
      left = top = right = bottom = 0;   
      
      
   }
   public RectF(double left, double top, double right, double bottom) {
      this.left = left;                //sets the instance variable (this.left) to the value of the local variable (left)
      this.top = top;
      this.right = right;
      this.bottom = bottom;
   }
       
   public RectF(RectF rectF) {
      if (rectF == null) {                //handles if null is passed in, sets all values to zero
         left = top = right = bottom = 0;
      } else {
         left = rectF.left;               //sets the attributes to the argument's values 
         top = rectF.top;
         right = rectF.right;
         bottom = rectF.bottom;
      
      }
   }
   
   public boolean intersects(RectF rectF){
      if(left > right || right < left || bottom < top)
      {
         return false;
      }
      else//if(left < right && right > left && bottom > top)
      {
         return true;
      }
   }
      
   public boolean intersects(int left, int right, int bottom, int top){
      if(left > right || right < left || bottom < top)
      {
         return false;
      }
      else//if(left < right && right > left && bottom > top)
      {
         return true;
      }
   }

      
   public boolean isEmpty( RectF rectF){
      if(left > right || right < left || bottom < top )
      {
         return false;
      }
      else//if(left < right && right > left && bottom > top)
      {
         return true;
      }
   }
      
   public boolean isEmpty(){
      if(left > right || right < left || bottom < top )
      {
         return false;
      }
      else//if(left < right && right > left && bottom > top)
      {
         return true;
      }
   }

   public boolean contains(double x, double y) {
      // check for empty first then check for containment
      return !isEmpty()  && x >= left && x < right && y >= top && y < bottom;
   }
   
   public boolean contains(double left, double top, double right, double bottom) {
                // check for empty first then check for containment
      return !isEmpty()&& this.left <= left && this.top <= top && this.right >= right && this.bottom >= bottom;
   }
   
   public boolean contains(RectF r) {
                // check for empty first then check for containment
      return !isEmpty()&& left <= r.left && top <= r.top && right >= r.right && bottom >= r.bottom;
   }
           
                 
   
   
   
   
   public final double centerX() {
      return (left + right) * 0.5;
   }
   
   public final double centerY() {
      return (top + bottom) * 0.5;
   }
   
   public double getWidth() {
      return right - left;
   }
   public double getHeight() {
      return bottom - top;
   }
   public String toString() {
      return "RectF(" + left + ", " + top + ", " + right + ", " + bottom + ")";
   }
   
   
  
         
   public void set(float left, float top, float right, float bottom) {
      this.left   = left;
      this.top    = top;
      this.right  = right;
      this.bottom = bottom;
   }
   public void set(RectF src) {
      this.left   = src.left;
      this.top    = src.top;
      this.right  = src.right;
      this.bottom = src.bottom;
   }
   public void setEmpty() {
      left = right = top = bottom = 0;
   }
   public void offset(double dx, double dy) {
      left    += dx;
      top     += dy;
      right   += dx;
      bottom  += dy;
   }
   
   public void offsetTo(double newLeft, double newTop) {
      right += newLeft - left;
      bottom += newTop - top;
      left = newLeft;
      top = newTop;
      }
      
        }
   
       
       
      
  