class EmployeeInfo { // Renamed from Employee to prevent class definition conflicts
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeInfo(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false; //[cite: 73]
    }

    public EmployeeInfo(String empId, String empName) {
        this(empId, empName, 0); //[cite: 73]
        this.isIntern = true; //[cite: 73]
    }

    public void printProfile() {
        System.out.printf("%s - %s | Rs %.1f | Intern: %b\n", empId, empName, salary, isIntern); //[cite: 73]
    }
}

public class AssignmentM3 {
    public static void main(String[] args) {
        EmployeeInfo permanent = new EmployeeInfo("E101", "Divya", 65000);
        permanent.printProfile(); //[cite: 73]

        EmployeeInfo intern = new EmployeeInfo("E102", "Arjun");
        intern.printProfile(); //[cite: 73]
    }
}