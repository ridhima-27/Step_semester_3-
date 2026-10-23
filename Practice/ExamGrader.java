import java.util.Scanner;

abstract class Question {
    abstract double grade(String correct, String student, int points);
}

class MCQ extends Question {
    double grade(String correct, String student, int points) {
        return correct.equalsIgnoreCase(student) ? points : 0;
    }
}

class TF extends Question {
    double grade(String correct, String student, int points) {
        return correct.equalsIgnoreCase(student) ? points : 0;
    }
}

class Essay extends Question {
    double grade(String correct, String student, int points) {
        String[] keywords = correct.split(",");
        int matchCount = 0;
        String studentLower = student.toLowerCase();
        for (String k : keywords) {
            if (studentLower.contains(k.trim().toLowerCase())) matchCount++;
        }
        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0;
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\"");
            String type = parts[0].trim();
            String correct = parts[3];
            String student = parts[5];
            int points = Integer.parseInt(parts[6].trim());
            
            Question q = switch (type) {
                case "MCQ" -> new MCQ();
                case "TF" -> new TF();
                case "ESSAY" -> new Essay();
                default -> null;
            };
            
            if (q != null) {
                double score = q.grade(correct, student, points);
                total += score;
                System.out.printf("%s: %.2f\n", type, score);
            }
        }
        System.out.printf("Total Score: %.2f\n", total);
    }
}