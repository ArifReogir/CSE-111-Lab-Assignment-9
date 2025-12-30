/*Your task is to design the StudyRoom class with appropriate variables and methods such that the following tester code produces the expected output.
 Note: 
1. Assume that each StudyRoom can add two books.
2. You cannot use any arrays in the StudyRoom class.
3. You should use the given Library and SilentStudyRoom classes’ variables and methods as needed.
4. You cannot modify the given Library and SilentStudyRoom  classes. */

public class TestLibrary { // Driver code
    public static void main(String[] args) {
        Library library = new Library("The Mind Maze");
        library.showRoomInfo();
        StudyRoom room9 = new StudyRoom("Study Hub");
        SilentStudyRoom room9A = new SilentStudyRoom("Focus Room");
        room9.addBook("Data Structures");
        room9.addBook("Operating Systems");
        room9.showRoomInfo();
        System.out.println("Total books: " + StudyRoom.totalBooks);
        System.out.println("======== Add Book ========");
        room9A.addBook(library, room9);
        room9A.showRoomInfo();
        System.out.println("Total books: " + StudyRoom.totalBooks);
        System.out.println("======== Add Book Again ========");
        room9A.addBook(library, room9);
        room9A.showRoomInfo();
        System.out.println("Total books: " + StudyRoom.totalBooks);
    }
}

// Class starts here

class Library { // Grand Parent class
    public String name;

    public Library(String name) {
        this.name = name;
    }

    public void showRoomInfo() {
        System.out.println("Library Name: " + name);
    }
}

class StudyRoom extends Library { // Parent class
    public static int totalBooks;

    private String book_1;
    private String book_2;

    public StudyRoom(String name) {
        super(name);
    }

    public void setBook1(String name) {
        this.book_1 = name;
    }

    public void setBook2(String name) {
        this.book_2 = name;
    }

    public String getBook1() {
        return book_1;
    }

    public String getBook2() {
        return book_2;
    }

    public void addBook(String name) {
        if (book_1 == null) {
            setBook1(name);
            totalBooks++;
        } else if (book_2 == null) {
            setBook2(name);
            totalBooks++;
        }
    }

    public void removeBook(int x) {
        if (x == 1 && book_1 != null) {
            System.out.println("Book 1 Removed from " + name);
            book_1 = null;
            totalBooks--;
        } else if (x == 2 && book_2 != null) {
            System.out.println("Book 2 Removed from " + name);
            book_2 = null;
            totalBooks--;
        }
    }

    public void showRoomInfo() {
        System.out.println(name + " Details: ");
        if (book_1 != null) {
            System.out.println("Book 1: " + getBook1());
        } else {
            System.out.println("No book added");
        }

        if (book_2 != null) {
            System.out.println("Book 2: " + getBook2());
        }
    }

}

class SilentStudyRoom extends StudyRoom { // Child class

    public SilentStudyRoom(String name) {
        super(name);
    }

    public void addBook(Library lib, StudyRoom room) {
        lib.showRoomInfo();
        if (room.getBook1() != null) {
            System.out.println("Adding book: " + room.getBook1());
            this.setBook1(room.getBook1());
            room.removeBook(1);
            System.out.println("Book added successfully!");
        } else if (room.getBook2() != null) {
            System.out.println("Adding book: " + room.getBook2());
            this.setBook2(room.getBook2());
            room.removeBook(2);
            System.out.println("Book added successfully!");
        } else {
            System.out.println("No books available in " + room.name);
        }
    }
}
