import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000.0; //[cite: 26]
}

abstract class Student {
    protected String name;
    
    public Student(String name) { this.name = name; }
    
    public double calculateTotalFee() {
        double fee = getTuitionAndHostelFee();
        if (this instanceof BusUser) {
            fee += BusUser.TRANSPORT_FEE;
        }
        return fee;
    }
    
    protected abstract double getTuitionAndHostelFee();
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) { super(name); }
    protected double getTuitionAndHostelFee() { return 40000.0; } //[cite: 26]
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    protected double getTuitionAndHostelFee() { return 40000.0 + 60000.0; } //[cite: 26]
}

class Scholar extends Student implements BusUser {
    public Scholar(String name) { super(name); }
    protected double getTuitionAndHostelFee() { return 20000.0; } //[cite: 26]
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalCollected = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equals("DAY")) {
                type += "_" + sc.next(); 
            }
            String name = sc.next();
            
            Student s = switch (type) {
                case "DAY_SCHOLAR" -> new DayScholar(name);
                case "HOSTELLER" -> new Hosteller(name);
                case "SCHOLAR" -> new Scholar(name);
                default -> null;
            };
            
            if (s != null) {
                double fee = s.calculateTotalFee();
                totalCollected += fee;
                System.out.printf("%s: %.2f\n", name, fee);
            }
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
    }
}