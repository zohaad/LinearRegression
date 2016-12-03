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
}
