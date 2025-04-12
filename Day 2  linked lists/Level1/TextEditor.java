class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head;
    private TextState current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void addState(String newContent) {
        TextState newState = new TextState(newContent);
        if (head == null) {
            head = newState;
            current = head;
            size = 1;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;

            TextState temp = current;
            int count = 1;
            while (temp.prev != null && count < MAX_HISTORY) {
                temp = temp.prev;
                count++;
            }
            if (temp.prev != null) {
                temp.prev.next = null;
                temp.prev = null;
                head = temp;
                size = MAX_HISTORY;
            } else {
                head = temp;
                size = count;
            }
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("Editor is empty.");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! This");
        editor.addState("Hello World! This is");
        editor.addState("Hello World! This is Java");

        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("New Text After Redo");
        editor.displayCurrentState();

        for (int i = 0; i < 10; i++) {
            editor.addState("State " + i);
        }

        editor.displayCurrentState();
    }
}

