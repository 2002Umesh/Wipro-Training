//package dayfour_solution;
//
////package day5;
//
//
////package day5;
// 
////2.Default and Static Methods in Interfaces
////•          Declare interface Polygon with:
////o         double getArea()
////o         default method default double getPerimeter(int... sides) that computes sum of sides
////o         a static helper static String shapeInfo() returning a description string
////•          Implement classes Rectangle and Triangle, providing appropriate getArea().
////•          In Main, call getPerimeter(...) and Polygon.shapeInfo().
// 
////public interface Polygon {
////   double getArea();
////  
////   default double getPerimeter(int[] sides) {
////       double perimeter = 0;
////       if (sides != null) {
////           for (int side : sides) {
////              perimeter += side;
////           }
////       }
////       return perimeter;
////   }
////  
////   static String shapeInfo() {
////       return "Polygon: A shape with straight sides";
////   }
////}
// 
//
//public class Movable_problem {
//	
//	public interface Movable {
//		   void moveUp();
//		   void moveDown();
//		   void moveLeft();
//		   void moveRight();
//		}
//		//package day5;
//	public class MovablePoint implements Movable {
//		   private int x, y;
//		   private int xSpeed, ySpeed;
//		   public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
//		       this.x = x;
//		       this.y = y;
//		       this.xSpeed = xSpeed;
//		       this.ySpeed = ySpeed;
//		   }
//		   public void moveUp() { 
//		               y -= ySpeed; 
//		               }
//		   public void moveDown() {
//		               y += ySpeed;
//		               }
//		   public void moveLeft() {
//		               x -= xSpeed;
//		               }
//		   public void moveRight() {
//		               x += xSpeed;
//		               }
//		   public int getX() { 
//		               return x; 
//		               }
//		   public int getY() {
//		               return y; 
//		               }
//		   public int getXSpeed() {
//		               return xSpeed;
//		               }
//		   public int getYSpeed() {
//		               return ySpeed; 
//		               }
//		   public String toString() {
//		       return String.format("Point(%d, %d) speed(%d, %d)", x, y, xSpeed, ySpeed);
//		   }
//		}
//		//Moveable Shapes Simulation
//		// •         Define an interface Movable with methods: moveUp(), moveDown(), moveLeft(), moveRight().
//		// •         Implement classes:
//		// o        MovablePoint(x, y, xSpeed, ySpeed) implements Movable
//		// o        MovableCircle(radius, center: MovablePoint)
//		// o        MovableRectangle(topLeft: MovablePoint, bottomRight: MovablePoint) (ensuring both points have same speed)
//		 
//		public class MovableCircle implements Movable {
//		   private int radius;
//		   private MovablePoint center;
//		   public MovableCircle(int radius, MovablePoint center) {
//		       this.radius = radius; 
//		       this.center = center;
//		   }
//		   public void moveUp() { center.moveUp(); }
//		   public void moveDown() { center.moveDown(); }
//		   public void moveLeft() { center.moveLeft(); }
//		   public void moveRight() { center.moveRight(); }
//		   public String toString() {
//		       return String.format("Circle(radius=%d, center=%s)", radius, center);
//		   }
//		}
//		//package day5;
//		 
//		//Moveable Shapes Simulation
//		// •         Define an interface Movable with methods: moveUp(), moveDown(), moveLeft(), moveRight().
//		// •         Implement classes:
//		// o        MovablePoint(x, y, xSpeed, ySpeed) implements Movable
//		// o        MovableCircle(radius, center: MovablePoint)
//		// o        MovableRectangle(topLeft: MovablePoint, bottomRight: MovablePoint) (ensuring both points have same speed)
//		 
//	
//		//package day5;
//		 
//		//Moveable Shapes Simulation
//		// •         Define an interface Movable with methods: moveUp(), moveDown(), moveLeft(), moveRight().
//		// •         Implement classes:
//		// o        MovablePoint(x, y, xSpeed, ySpeed) implements Movable
//		// o        MovableCircle(radius, center: MovablePoint)
//		// o        MovableRectangle(topLeft: MovablePoint, bottomRight: MovablePoint) (ensuring both points have same speed)
//		 
//		public class MovableRectangle implements Movable {
//		   private MovablePoint topLeft;
//		   private MovablePoint bottomRight;
//		   public MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
//		       if (topLeft.getXSpeed() != bottomRight.getXSpeed() || topLeft.getYSpeed() != bottomRight.getYSpeed())
//		           throw new IllegalArgumentException("Both points must have same speed");
//		       this.topLeft = topLeft; this.bottomRight = bottomRight;
//		   }
//		   public void moveUp() { topLeft.moveUp(); bottomRight.moveUp(); }
//		   public void moveDown() { topLeft.moveDown(); bottomRight.moveDown(); }
//		   public void moveLeft() { topLeft.moveLeft(); bottomRight.moveLeft(); }
//		   public void moveRight() { topLeft.moveRight(); bottomRight.moveRight(); }
//		   public String toString() {
//		       return String.format("Rectangle(topLeft=%s, bottomRight=%s)", topLeft, bottomRight);
//		   }
//		  
//		}
//	 public static void main(String[] args) {
//	       MovablePoint point = new MovablePoint(0, 0, 1, 1);
//	       MovableCircle circle = new MovableCircle(5, new MovablePoint(10, 10, 2, 2));
//	      MovableRectangle rectangle = new MovableRectangle(new MovablePoint(0, 0, 1, 1), new MovablePoint(5, 5, 1, 1));
//	      System.out.println("Initial positions:");
//	      System.out.println(point);
//	      System.out.println(circle);
//	      System.out.println(rectangle);
//	      System.out.println("\nAfter moving right:");
//	      point.moveRight();
//	      circle.moveRight();
//	      rectangle.moveRight();
//	      System.out.println(point);
//	      System.out.println(circle);
//	       System.out.println(rectangle);
//	   }
//	}
//
//
