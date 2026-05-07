package dayfour_solution;

interface Polygon 
{
    double getArea();

    default double getPerimeter(int... sides) 
    {
        double sum = 0;
        for (int s : sides) sum += s;
        return sum;
    }

    static String shapeInfo() 
    {
        return "Polygon with area and perimeter";
    }
}

class Rectangle implements Polygon 
{
    int length, width;

    Rectangle(int length, int width) 
    {
        this.length = length;
        this.width = width;
    }

    public double getArea() 
    {
        return length * width;
    }
}

class Triangle implements Polygon 
{
    int base, height;

    Triangle(int base, int height) 
    {
        this.base = base;
        this.height = height;
    }

    public double getArea() 
    {
        return 0.5 * base * height;
    }
}

public class TaskTwo {

	public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 5);
        System.out.println(r.getArea());
        System.out.println(r.getPerimeter(10, 5, 10, 5));

        Triangle t = new Triangle(6, 4);
        System.out.println(t.getArea());
        System.out.println(t.getPerimeter(3, 4, 5));

        System.out.println(Polygon.shapeInfo());

	}

}
