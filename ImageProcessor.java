import java.util.*;
import java.io.*;
import java.util.streams.*;

public class ImageProcessor {

    private static String getFileName(String[] args) {
	if (args.length < 1) {
	    System.err.println("Image file not specified");
	    System.exit(1);
	}
      
	return args[0];
    }

    private static void outputStream(String filename) {
    }

    private static void populateList(String filename, List<Point> points) {
	try {
	    Scanner sc = new Scanner(new File(filename));
	    while (sc.hasNext()) {
		points.add(new Point(sc.nextDouble(),
				     sc.nextDouble(),
				     sc.nextDouble()));
	    }
	} catch (Exception e) {
	    System.out.println("Can't open the input file");
	}
    }
	
    public static void main(String[] args)
    {
	final String filename = getFilename(args);
	final LinkedList points = new LinkedList<Point>;
	

	try {
	    populateList(filename, points);
	    System.out.println(points.toString);
	} catch (FileNotFoundException e) {
	    System.err.println(e.getMessage());
	}
    }
		
}
