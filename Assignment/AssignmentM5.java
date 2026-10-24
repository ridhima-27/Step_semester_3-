class StaffMember { // Renamed from Employee to prevent class definition conflicts
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies"; //[cite: 74]
    static int employeeCount = 0; //[cite: 74]

    public StaffMember(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; //[cite: 74]
    }

    static void printCompanyInfo() {
        System.out.println(companyName); //[cite: 74]
        System.out.println("Employees on record: " + employeeCount); //[cite: 75]
    }
}

public class AssignmentM5 {
    public static void main(String[] args) {
        StaffMember e1 = new StaffMember("Asha", 50000);
        StaffMember e2 = new StaffMember("Ravi", 60000);
        StaffMember e3 = new StaffMember("Karan", 70000);

        StaffMember.printCompanyInfo(); //[cite: 74]
    }
}