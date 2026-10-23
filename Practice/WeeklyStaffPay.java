import java.util.Scanner;

abstract class Staff {
    protected String name;
    public Staff(String name) { this.name = name; }
    public abstract double calculatePay();
    public String getName() { return name; }
}

class FullTimeStaff extends Staff {
    private double weeklySalary;
    public FullTimeStaff(String name, double weeklySalary) { super(name); this.weeklySalary = weeklySalary; }
    public double calculatePay() { return weeklySalary; } //[cite: 30]
}

class HourlyStaff extends Staff {
    private double hours, rate;
    public HourlyStaff(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
    public double calculatePay() {
        if (hours <= 40) return hours * rate; //[cite: 30]
        return (40 * rate) + ((hours - 40) * rate * 1.5); //[cite: 30]
    }
}

class InternStaff extends Staff {
    private double stipend;
    public InternStaff(String name, double stipend) { super(name); this.stipend = stipend; }
    public double calculatePay() { return stipend; } //[cite: 30]
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff s = switch (type) {
                case "FULLTIME" -> new FullTimeStaff(name, sc.nextDouble());
                case "HOURLY" -> new HourlyStaff(name, sc.nextDouble(), sc.nextDouble());
                case "INTERN" -> new InternStaff(name, sc.nextDouble());
                default -> null;
            };

            if (s != null) {
                double pay = s.calculatePay();
                totalPayroll += pay;
                System.out.printf("%s: %.2f\n", s.getName(), pay);
            }
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
    }
}