import java.util.*;
import java.io.*;
import java.util.stream.*;

public class ImageProcessor {

    private static String getFileName(String[] args) {
	if (args.length < 1) {
	    System.err.println("Image file not specified");
	    System.exit(1);
	}
      
	return args[0];
    }

    private static void outputStream(String filename, List<Point> points) {
	try {
	    PrintStream ps = new PrintStream("drawMe.txt");
	    
	    for (Point p : points) 
		ps.println(p);

	} catch (Exception e) {
	    System.out.println("Can't open output file");
	}
    }

    private static void populateList(String filename, List<Point> points) {
	try {
	    Scanner sc = new Scanner(new File(filename));

	    while (sc.hasNextLine()) {
		String data = sc.nextLine();
		String[] pieces = data.split(", ", 3);

		double x = Double.parseDouble(pieces[0]);
		double y = Double.parseDouble(pieces[1]);
		double z = Double.parseDouble(pieces[2]);

		points.add(new Point(x, y , z));
	    }
	} catch (Exception e) {
	    System.out.println("Can't open the input file");
	}
    }

    private static List<Point> processPoints(List<Point> points) {
	List<Point> processedPoints = 
	    points.stream()
	    .filter(p -> p.z <= 2.0)
	    .map(p -> new Point(p.x * 0.5 - 150,
				p.y * 0.5 -37,
				p.z * 0.5))
	    .collect(Collectors.toList());

	return processedPoints;
    }

	
    public static void main(String[] args)
    {
	final String filename = getFileName(args);
	final LinkedList points = new LinkedList<Point>();
	

	try {
	    populateList(filename, points);
	    List<Point> processedPoints = processPoints(points);
	    outputStream(filename, processedPoints);
	} catch (Exception e) {
	    System.err.println(e.getMessage());
	}
    }
		
}
