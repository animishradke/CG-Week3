class Book {
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    Book prev, next;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

class Library {
    Book head, tail;

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean status) {
        Book newBook = new Book(title, author, genre, bookId, status);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int bookId, boolean status) {
        Book newBook = new Book(title, author, genre, bookId, status);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(int pos, String title, String author, String genre, int bookId, boolean status) {
        if (pos == 0) {
            addAtBeginning(title, author, genre, bookId, status);
            return;
        }

        Book current = head;
        for (int i = 0; current != null && i < pos - 1; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of range.");
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, status);
        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) current.next.prev = newBook;
        current.next = newBook;
        if (newBook.next == null) tail = newBook;
    }

    public void removeByBookId(int bookId) {
        Book current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book not found.");
            return;
        }

        if (current.prev != null) current.prev.next = current.next;
        else head = current.next;

        if (current.next != null) current.next.prev = current.prev;
        else tail = current.prev;

        System.out.println("Book removed.");
    }

    public void searchByTitleOrAuthor(String keyword) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(keyword) || current.author.equalsIgnoreCase(keyword)) {
                displayBook(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("Book not found.");
    }

    public void updateAvailability(int bookId, boolean status) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    public void displayForward() {
        Book current = head;
        while (current != null) {
            displayBook(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        Book current = tail;
        while (current != null) {
            displayBook(current);
            current = current.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private void displayBook(Book b) {
        System.out.println("ID: " + b.bookId + ", Title: " + b.title + ", Author: " + b.author + ", Genre: " + b.genre + ", Available: " + b.isAvailable);
    }

    public static void main(String[] args) {
        Library lib = new Library();

        lib.addAtBeginning("The Alchemist", "Paulo Coelho", "Fiction", 101, true);
        lib.addAtEnd("1984", "George Orwell", "Dystopia", 102, false);
        lib.addAtPosition(1, "To Kill a Mockingbird", "Harper Lee", "Classic", 103, true);

        System.out.println("Library (Forward):");
        lib.displayForward();

        System.out.println("\nLibrary (Reverse):");
        lib.displayReverse();

        System.out.println("\nSearch by Title/Author:");
        lib.searchByTitleOrAuthor("George Orwell");

        System.out.println("\nUpdate Availability:");
        lib.updateAvailability(103, false);
        lib.displayForward();

        System.out.println("\nRemove Book ID 101:");
        lib.removeByBookId(101);
        lib.displayForward();

        System.out.println("\nTotal Books: " + lib.countBooks());
    }
}


