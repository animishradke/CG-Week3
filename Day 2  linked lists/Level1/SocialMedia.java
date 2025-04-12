    import java.util.*;

class User {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    User head;

    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) {
            head = newUser;
            return;
        }
        User current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newUser;
    }

    public void addFriendConnection(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);
        if (user1 == null || user2 == null || id1 == id2) return;
        if (!user1.friendIDs.contains(id2)) user1.friendIDs.add(id2);
        if (!user2.friendIDs.contains(id1)) user2.friendIDs.add(id1);
    }

    public void removeFriendConnection(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);
        if (user1 == null || user2 == null) return;
        user1.friendIDs.remove(Integer.valueOf(id2));
        user2.friendIDs.remove(Integer.valueOf(id1));
    }

    public void findMutualFriends(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);
        if (user1 == null || user2 == null) return;
        Set<Integer> set = new HashSet<>(user1.friendIDs);
        System.out.println("Mutual Friends:");
        for (int id : user2.friendIDs) {
            if (set.contains(id)) {
                User mutual = findUserById(id);
                System.out.println(mutual.userID + " - " + mutual.name);
            }
        }
    }

    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) return;
        System.out.println("Friends of " + user.name + ":");
        for (int id : user.friendIDs) {
            User friend = findUserById(id);
            System.out.println(friend.userID + " - " + friend.name);
        }
    }

    public void searchUser(String keyword) {
        User current = head;
        boolean found = false;
        while (current != null) {
            if (current.name.equalsIgnoreCase(keyword) || String.valueOf(current.userID).equals(keyword)) {
                System.out.println("User Found: " + current.userID + " - " + current.name);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("User not found.");
    }

    public void countFriends() {
        User current = head;
        while (current != null) {
            System.out.println(current.name + " has " + current.friendIDs.size() + " friends.");
            current = current.next;
        }
    }

    private User findUserById(int id) {
        User current = head;
        while (current != null) {
            if (current.userID == id) return current;
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 20);
        sm.addUser(2, "Bob", 22);
        sm.addUser(3, "Charlie", 25);
        sm.addUser(4, "David", 23);
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(2, 4);
        sm.displayFriends(2);
        sm.findMutualFriends(1, 2);
        sm.searchUser("Charlie");
        sm.countFriends();
        sm.removeFriendConnection(2, 3);
        sm.displayFriends(2);
    }
}

