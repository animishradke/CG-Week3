class Item {
    String name;
    double price;
    int quantity;
    Item next;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.next = null;
    }
}

class Inventory {
    Item head;

    public void addItem(String name, double price, int quantity) {
        Item newItem = new Item(name, price, quantity);
        newItem.next = head;
        head = newItem;
    }

    public void displayItems() {
        Item current = head;
        while (current != null) {
            System.out.println("Item: " + current.name + ", Price: " + current.price + ", Qty: " + current.quantity);
            current = current.next;
        }
    }

    public double calculateTotalValue() {
        double total = 0;
        Item current = head;
        while (current != null) {
            total += current.price * current.quantity;
            current = current.next;
        }
        return total;
    }

    public void sortByName(boolean ascending) {
        head = mergeSort(head, "name", ascending);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, "price", ascending);
    }

    private Item mergeSort(Item head, String key, boolean ascending) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSort(head, key, ascending);
        Item right = mergeSort(nextOfMiddle, key, ascending);
        return sortedMerge(left, right, key, ascending);
    }

    private Item sortedMerge(Item a, Item b, String key, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (key.equals("name")) {
            condition = asc ? a.name.compareTo(b.name) <= 0 : a.name.compareTo(b.name) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = sortedMerge(a.next, b, key, asc);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, key, asc);
            return b;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addItem("Mouse", 800.0, 10);
        inv.addItem("Keyboard", 1500.0, 5);
        inv.addItem("Monitor", 10000.0, 2);
        inv.addItem("Laptop", 60000.0, 1);

        System.out.println("All Items:");
        inv.displayItems();

        System.out.println("\nTotal Inventory Value: " + inv.calculateTotalValue());

        System.out.println("\nSorted by Name Ascending:");
        inv.sortByName(true);
        inv.displayItems();

        System.out.println("\nSorted by Price Descending:");
        inv.sortByPrice(false);
        inv.displayItems();
    }
}