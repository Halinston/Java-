
/**
 *
 * @author AV
 */
public class Rectangle implements Relatable
{
   private double length;
   private double width;

   /**
      Constructor
      @param len The length of the rectangle.
      @param w The width of the rectangle.
      @throws IllegalArgumentException when length or width are negative or 0
   */

   public Rectangle(double len, double wid) throws IllegalArgumentException
   {
      if(len<=0) throw new IllegalArgumentException("Length must be non-negative: "+ len);
      if(wid<=0) throw new IllegalArgumentException("Width must be non-negative: "+ wid);
      length = len;
      width = wid;
   }
 
   /**
    * Non-argument constructor sets both fields to 1.0
    */
   public Rectangle()
   {
       length = 1;
       width = 1;
   }

   /**
      The setLength method stores a value in the
      length field.
      @param len The value to store in length.
      @throws IllegalArgumentException when length argument is negative or 0
   */

   public void setLength(double len)
   {
       if(len<=0) throw new IllegalArgumentException("Length must be non-negative: "+ len);
       length = len;
   }

   /**
      The setWidth method stores a value in the
      width field.
      @param w The value to store in width.
      @throws IllegalArgumentException when width argument is negative or 0
   */

   public void setWidth(double wid)
   {
      if(wid<=0) throw new IllegalArgumentException("Width must be non-negative: "+ wid);
      width = wid;
   }

   /**
      The getLength method returns a Rectangle
      object's length.
      @return The value in the length field.
   */

   public double getLength()
   {
      return length;
   }

   /**
      The getWidth method returns a Rectangle
      object's width.
      @return The value in the width field.
   */
   
   public double getWidth()
   {
      return width;
   }

   /**
      The getArea method returns a Rectangle
      object's area.
      @return The product of length times width.
   */

   public double getArea()
   {
      return length * width;
   }
   
   @Override public boolean equals(Object s)
   {
        if(s == null) 
            return false;
        else if(getClass( ) != s.getClass( )) 
            return false;
        else
        {
            Rectangle obj = (Rectangle)s;
            return obj.getArea()==this.getArea();
        }
   }
   public boolean isGreater(Object s)
   {
       Rectangle obj = (Rectangle)s;
       return obj.getArea()<this.getArea();
       
   }
   public boolean isLess(Object s)
   {
       Rectangle obj = (Rectangle)s;
       return obj.getArea()>this.getArea();
       
   }
}
