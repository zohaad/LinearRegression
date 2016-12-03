interface Cost {
    public static double fn(Point[] pointArray, Line hypothesis) {
        int m = pointArray.length;
        double SSE = 0.0;

        for (int i = 0; i < m; i++){
            SSE += Math.pow((hypothesis.evaluate(pointArray[i].getx()) - pointArray[i].gety()), 2);
        }
        return SSE;
    }

    public static double derivative_0(Point[] pointArray, Line hypothesis) {
        int m = pointArray.length;
        double derivative_0 = 0.0;

        for (int i = 0; i < m; i++) {
            derivative_0 += (hypothesis.evaluate(pointArray[i].getx()) - pointArray[i].gety());
        }
        derivative_0 = derivative_0 / m;
        return derivative_0;
    }

    public static double derivative_1(Point[] pointArray, Line hypothesis) {
        int m = pointArray.length;
        double derivative_1 = 0.0;

        for (int i = 0; i < m; i++) {
            derivative_1 += ((hypothesis.evaluate(pointArray[i].getx()) - pointArray[i].gety()) * pointArray[i].getx());
        }
        derivative_1 = derivative_1 / m;
        return derivative_1;
    }
    
}
