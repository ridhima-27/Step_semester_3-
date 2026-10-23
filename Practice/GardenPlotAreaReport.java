import java.util.Scanner;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public abstract double calculateArea();
    public String getOwner() { return owner; }
}

class CirclePlot extends Plot {
    private double radius;
    public CirclePlot(String owner, double radius) { super(owner); this.radius = radius; }
    public double calculateArea() { return Math.PI * radius * radius; } //[cite: 29]
}

class RectanglePlot extends Plot {
    private double length, width;
    public RectanglePlot(String owner, double length, double width) { super(owner); this.length = length; this.width = width; }
    public double calculateArea() { return length * width; } //[cite: 29]
}

class TrianglePlot extends Plot {
    private double base, height;
    public TrianglePlot(String owner, double base, double height) { super(owner); this.base = base; this.height = height; }
    public double calculateArea() { return 0.5 * base * height; } //[cite: 29]
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot p = switch (shape) {
                case "CIRCLE" -> new CirclePlot(owner, sc.nextDouble());
                case "RECTANGLE" -> new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble());
                case "TRIANGLE" -> new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble());
                default -> null;
            };

            if (p != null) {
                double area = p.calculateArea();
                totalArea += area;
                System.out.printf("%s (%s): %.2f\n", p.getOwner(), shape, area);
            }
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
    }
}