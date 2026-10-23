
public class AttendanceSheet {
    private final String[] students;
    private int presentCount;

    public AttendanceSheet(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(
                "Capacity cannot be negative."
            );
        }

        students = new String[capacity];
        presentCount = 0;
    }

    public void markPresent(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid student name.");
            return;
        }

        if (isPresent(name)) {
            return;
        }

        if (presentCount >= students.length) {
            System.out.println("Attendance sheet is full.");
            return;
        }

        students[presentCount] = name;
        presentCount++;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }

        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(
            "Present count: " + sheet.getPresentCount()
        );
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
