
public class Point
{
    public final double x;
    public final double y;
    public final double z;

    public Podouble(double x, double y, double z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    public String toString() {
	return (String) x + ", " + (String) y + ", " + (String) z;
    }

}
