public class Point {
    private double x;
    private double y;

    // constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public double getx() {
        return this.x;
    }

    public double gety() {
        return this.y;
    }
}
