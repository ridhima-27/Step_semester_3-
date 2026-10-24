class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class PracticeM4 {
    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0); //[cite: 69]
        IdCard duplicate = ravi; //[cite: 69]

        duplicate.booksIssued = 3; //[cite: 69]

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued); //[cite: 69]
        System.out.println("duplicate == ravi: " + (duplicate == ravi)); //[cite: 69]

        IdCard separate = new IdCard("Ravi", 3); //[cite: 69]
        System.out.println("separate == ravi: " + (separate == ravi)); //[cite: 69]
    }
}