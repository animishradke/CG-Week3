  class Process {
    int processID;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime = 0;
    int turnAroundTime = 0;
    Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head = null;
    Process tail = null;
    int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int id, int burst, int priority) {
        Process newProcess = new Process(id, burst, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void simulate() {
        if (head == null) return;
        Process current = head;
        int currentTime = 0;

        while (hasRemainingProcess()) {
            if (current.remainingTime > 0) {
                int executed = Math.min(timeQuantum, current.remainingTime);
                currentTime += executed;
                current.remainingTime -= executed;
                Process temp = head;
                while (temp != null) {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += executed;
                    }
                    temp = temp.next;
                    if (temp == head) break;
                }
                if (current.remainingTime == 0) {
                    current.turnAroundTime = currentTime;
                }
            }
            displayQueue();
            current = current.next;
        }

        calculateAverages();
    }

    private boolean hasRemainingProcess() {
        Process temp = head;
        do {
            if (temp.remainingTime > 0) return true;
            temp = temp.next;
        } while (temp != head);
        return false;
    }

    public void displayQueue() {
        Process temp = head;
        System.out.println("Current Queue:");
        do {
            System.out.println("P" + temp.processID + " [Remaining: " + temp.remainingTime + "]");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void calculateAverages() {
        Process temp = head;
        int totalWaiting = 0, totalTurnaround = 0, count = 0;
        System.out.println("Final Process Info:");
        do {
            System.out.println("P" + temp.processID + ": Waiting Time = " + temp.waitingTime + ", Turnaround Time = " + temp.turnAroundTime);
            totalWaiting += temp.waitingTime;
            totalTurnaround += temp.turnAroundTime;
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("\nAverage Waiting Time: " + (totalWaiting / (double) count));
        System.out.println("Average Turnaround Time: " + (totalTurnaround / (double) count));
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.simulate();
    }
}
