class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class AssignmentM4 {
    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0); //[cite: 74]
        HallTicket copy = priya; //[cite: 74]

        copy.seatNumber = 45; //[cite: 74]

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber); //[cite: 74]
        System.out.println("copy == priya: " + (copy == priya)); //[cite: 74]

        HallTicket separate = new HallTicket("Priya", 45); //[cite: 74]
        System.out.println("separate == priya: " + (separate == priya)); //[cite: 74]
    }
}