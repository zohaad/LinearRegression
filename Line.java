public class Line{
  
  private final double slope;
  private final double intercept;
  
  // constructor for a line with given slope and intercept
  public Line(double slope, double intercept){
      this.slope = slope;
      this.intercept = intercept;
  }
  
  // constructor for a line through points p and q
  // sets slope and intercept to Double.NaN for vertical lines
  public Line(Point p, Point q){
      if (p.getx() == q.getx()) { 
          this.slope = Double.NaN;
          this.intercept = Double.NaN;
      } 
      else {
          this.slope = (q.gety() - p.gety()) / (q.getx() - p.gety()); // simple algebra
          this.intercept = (q.gety() - getSlope() * q.getx());
      }
  }
  
  // returns the slope of this line
  public double getSlope(){
      return this.slope;
  }
  
  // returns the intercept of this line
  public double getIntercept(){
     return this.intercept;
  }
  
  // returns whether this line and the line g are parallel
  public boolean isParallel(Line g){
     if (this.slope == g.slope) { 
          return true;
     }
     else return false;
  }
  
  // returns whether this line contains the point p
  public boolean containsPoint(Point p){
      if (p.gety() == getSlope() * p.getx() + getIntercept()) {
          return true;
      }
      else return false;
  
  }
  
  // returns the x-intercept of the line
  // returns Double.NaN if slope = 0
  public double root(){
      if (this.slope == 0) {
          return Double.NaN;
      }
      else {
          return (-1 * getIntercept() / getSlope()); 
      }
  
  }  
  
  // returns the intersection point of this line and the line g
  // returns null if lines are parallel
  public Point intersection(Line g){
      if (isParallel(g)) {
          return null;
      }
      else {
          double isctX = (g.getIntercept() - getIntercept())/(getSlope() - g.getSlope());
          double isctY = (getSlope() * isctX + getIntercept()); 
          Point isct = new Point(isctX,isctY);
          return isct;
      }
  
  }

  public double evaluate(double myX) {
      return myX * getSlope() + getIntercept();
  }
  
  // return string representation of this line
  public String toString() {
    return "y = " + getSlope() + " x + " + getIntercept();
  }    
  public static void main(String args[]) {
      
  }
}


