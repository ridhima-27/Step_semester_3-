import java.util.Scanner;
import java.time.LocalDate;

abstract class Subscription {
    abstract LocalDate calculateRenewal(LocalDate start);
}

class BasicPlan extends Subscription {
    LocalDate calculateRenewal(LocalDate start) { return start.plusDays(30); }
}

class StandardPlan extends Subscription {
    LocalDate calculateRenewal(LocalDate start) { return start.plusDays(90); }
}

class PremiumPlan extends Subscription {
    LocalDate calculateRenewal(LocalDate start) { return start.plusDays(365); }
}

public class StreamingPlan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());
            
            Subscription sub = switch (type) {
                case "BASIC" -> new BasicPlan();
                case "STANDARD" -> new StandardPlan();
                case "PREMIUM" -> new PremiumPlan();
                default -> null;
            };
            
            if (sub != null) {
                System.out.println(name + ": " + sub.calculateRenewal(start));
            }
        }
    }
}