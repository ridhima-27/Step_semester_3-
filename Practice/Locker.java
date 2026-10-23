
public class Locker {
    private String combination;
    private final int lockerNumber;

    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public boolean changeCode(
        String currentCode, String newCode
    ) {
        if (combination.equals(currentCode)) {
            combination = newCode;
            return true;
        }

        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");

        if (locker.changeCode("1234", "5678")) {
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Code change rejected.");
        }

        if (locker.changeCode("0000", "9999")) {
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Code change rejected.");
        }

        System.out.println(
            "Locker number: " + locker.getLockerNumber()
        );
    }
}
