import java.util.Scanner;
import java.time.LocalDate;

abstract class LibraryItem {
    abstract LocalDate calculateDueDate(LocalDate current);
}

class Book extends LibraryItem {
    LocalDate calculateDueDate(LocalDate current) { return current.plusDays(14); }
}

class DVD extends LibraryItem {
    LocalDate calculateDueDate(LocalDate current) { return current.plusDays(7); }
}

class Magazine extends LibraryItem {
    LocalDate calculateDueDate(LocalDate current) { return current.plusDays(3); }
}

public class LibraryItemCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);
            String type = parts[0];
            String title = parts[1].replace("\"", "");
            
            LibraryItem item = switch (type) {
                case "BOOK" -> new Book();
                case "DVD" -> new DVD();
                case "MAGAZINE" -> new Magazine();
                default -> null;
            };
            
            if (item != null) {
                System.out.println(title + ": " + item.calculateDueDate(currentDate));
            }
        }
    }
}