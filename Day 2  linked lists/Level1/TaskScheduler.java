class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    public void addTaskAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = current = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void addTaskAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = current = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add at specific position
    public void addTaskAtPosition(int id, String name, int priority, String dueDate, int position) {
        if (position <= 0 || head == null) {
            addTaskAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task currentTask = head;
        int index = 0;

        while (index < position - 1 && currentTask.next != head) {
            currentTask = currentTask.next;
            index++;
        }

        newTask.next = currentTask.next;
        currentTask.next = newTask;

        if (currentTask == tail) {
            tail = newTask;
        }
    }

    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task curr = head;
        Task prev = tail;

        do {
            if (curr.taskId == taskId) {
                if (curr == head && curr == tail) {
                    head = tail = current = null;
                } else if (curr == head) {
                    head = head.next;
                    tail.next = head;
                    if (current == curr) current = head;
                } else if (curr == tail) {
                    tail = prev;
                    tail.next = head;
                    if (current == curr) current = head;
                } else {
                    prev.next = curr.next;
                    if (current == curr) current = curr.next;
                }

                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }

            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }


    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No current task available.");
            return;
        }

        System.out.println("Current Task:");
        printTask(current);
    }

    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
            viewCurrentTask();
        } else {
            System.out.println("No tasks in the list.");
        }
    }


    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int targetPriority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        boolean found = false;
        Task temp = head;

        do {
            if (temp.priority == targetPriority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + targetPriority);
        }
    }

    private void printTask(Task t) {
        System.out.println("Task ID: " + t.taskId);
        System.out.println("Name: " + t.taskName);
        System.out.println("Priority: " + t.priority);
        System.out.println("Due Date: " + t.dueDate);
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTaskAtEnd(1, "Write Report", 2, "2025-05-24");
        scheduler.addTaskAtBeginning(2, "Prepare Slides", 1, "2025-05-23");
        scheduler.addTaskAtPosition(3, "Team Meeting", 3, "2025-05-25", 1);

        System.out.println("All Tasks:");
        scheduler.displayAllTasks();
        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.moveToNextTask();
        System.out.println("Tasks with Priority 1:");
        scheduler.searchByPriority(1);
        scheduler.removeTaskById(2);

        System.out.println("After removing Task ID 2:");
        scheduler.displayAllTasks();
    }
}