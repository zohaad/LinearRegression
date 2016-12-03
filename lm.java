import java.util.*;
import java.io.*;

public class lm {
    public static void main(String[] args) {
        //read file
        String filename = args[0];
        Point[] pointArray = null;

        try {
            pointArray = readCSV(filename);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int m = pointArray.length; // number of training examples
        double alpha = 0.0005; // learning rate
        Line regressLine = fit(pointArray, alpha, m);

        System.out.println(regressLine.toString());

        
        //return line
        //print line
        //print SSE ()
    }

    // reads CSV, makes Point array
    public static Point[] readCSV(String filename)
        throws java.io.FileNotFoundException { 
            File file = new File(filename);
            Scanner scan = new Scanner(file);

            String nStr = scan.next();
            int n = Integer.parseInt(nStr.substring(0, nStr.length()-1));
            Point[] csvArray = new Point[n];

            for (int i = 0; i < n; i++) {
                double[] precursor = new double[2];
                String[] myNextScan = scan.next().split(",");
                for (int j = 0; j < 2; j++) {
                    precursor[j] = Double.parseDouble(myNextScan[j]);
                }
                csvArray[i] = new Point(precursor[0], precursor[1]); // convert to Point object
                
            }

            return csvArray;
    }     

    public static Line fit(Point[] pointArray, double alpha, int m) {
        // make first line
        Line myLine = new Line(pointArray[0], pointArray[(int)(Math.random()*m)]); // yolo 
        while (pointArray[0].getx() == pointArray[(int)(Math.random() * m)].getx()) {
            myLine = new Line(pointArray[0], pointArray[(int)(Math.random()*m)]); // yolo 
        }

        // error margin: 0.001
        while (Cost.derivative_0(pointArray, myLine) > 0.00001 && Cost.derivative_1(pointArray, myLine) > 0.00001) {
            double theta_0 = myLine.getSlope() - alpha * Cost.derivative_0(pointArray, myLine);
            double theta_1 = myLine.getIntercept() - alpha * Cost.derivative_1(pointArray, myLine);
            myLine = new Line(theta_0, theta_1);
        }

        return myLine;
    }
}
