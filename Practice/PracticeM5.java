class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology"; //[cite: 70]
    static int studentCount = 0; //[cite: 70]

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++; //[cite: 70]
    }

    static void printCollegeInfo() {
        System.out.println(collegeName); //[cite: 70]
        System.out.println("Students created: " + studentCount); //[cite: 70]
    }
}

public class PracticeM5 {
    public static void main(String[] args) {
        Student s1 = new Student("Asha", 85);
        Student s2 = new Student("Ravi", 90);
        
        Student.printCollegeInfo(); //[cite: 70]
    }
}