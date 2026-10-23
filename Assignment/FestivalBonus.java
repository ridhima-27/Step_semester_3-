import java.util.Scanner;

abstract class Employee {
    abstract double calculateBonus(double salary);
}

class FullTimeEmployee extends Employee {
    double calculateBonus(double salary) { return salary * 0.10; }
}

class PartTimeEmployee extends Employee {
    double calculateBonus(double salary) { return salary * 0.05; }
}

class Intern extends Employee {
    double calculateBonus(double salary) { return 2000.0; }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            
            Employee e = switch (type) {
                case "FULLTIME" -> new FullTimeEmployee();
                case "PARTTIME" -> new PartTimeEmployee();
                case "INTERN" -> new Intern();
                default -> null;
            };
            
            if (e != null) {
                double bonus = e.calculateBonus(salary);
                total += bonus;
                System.out.printf("%s: %.2f\n", name, bonus);
            }
        }
        System.out.printf("Total Bonus: %.2f\n", total);
    }
}