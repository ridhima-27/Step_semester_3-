class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.printf("%s by %s %d copies available\n", title, author, copiesAvailable); //[cite: 71]
    }
}

public class AssignmentM1 {
    public static void main(String[] args) {
        BookInventory[] inventory = new BookInventory[4]; //[cite: 71]
        inventory[0] = new BookInventory("Clean Code", "Robert C. Martin", 3);
        inventory[1] = new BookInventory("Effective Java", "Joshua Bloch", 5);
        inventory[2] = new BookInventory("Refactoring", "Martin Fowler", 0);
        inventory[3] = new BookInventory("Design Patterns", "GoF", 2);

        for (BookInventory book : inventory) {
            book.printEntry(); //[cite: 71]
        }
    }
}