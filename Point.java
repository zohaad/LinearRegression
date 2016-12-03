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

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
