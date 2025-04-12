class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    Student head;

    public void addAtBeginning(int roll, String name, int age, String grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int roll, String name, int age, String grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }

    public void addAtPosition(int position, int roll, String name, int age, String grade) {
        if (position == 0) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        Student newStudent = new Student(roll, name, age, grade);
        Student current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of range.");
            return;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }

    public void deleteByRoll(int roll) {
        if (head == null) return;
        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Student deleted.");
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollNumber != roll) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Student deleted.");
        }
    }

    public void searchByRoll(int roll) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == roll) {
                System.out.println("Student Found:");
                displayStudent(current);
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No students to display.");
            return;
        }
        Student current = head;
        while (current != null) {
            displayStudent(current);
            current = current.next;
        }
    }

    public void updateGrade(int roll, String newGrade) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == roll) {
                current.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }

    private void displayStudent(Student s) {
        System.out.println("Roll: " + s.rollNumber + ", Name: " + s.name + ", Age: " + s.age + ", Grade: " + s.grade);
    }

    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        list.addAtBeginning(1, "Alice", 20, "A");
        list.addAtEnd(2, "Bob", 21, "B");
        list.addAtPosition(1, 3, "Charlie", 22, "C");
        System.out.println("All Students:");
        list.displayAll();
        System.out.println("\nSearch Roll No 2:");
        list.searchByRoll(2);
        System.out.println("\nUpdate Grade for Roll No 3:");
        list.updateGrade(3, "B+");
        System.out.println("All Students after update:");
        list.displayAll();
        System.out.println("\nDelete Roll No 1:");
        list.deleteByRoll(1);
        System.out.println("All Students after deletion:");
        list.displayAll();
    }
}