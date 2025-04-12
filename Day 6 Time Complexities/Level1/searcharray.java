public boolean searchInArray(int[] arr, int target) {
    for (int num : arr) {
        if (num == target) return true;
    }
    return false;
}


import java.util.HashSet;

public boolean searchInHashSet(HashSet<Integer> set, int target) {
    return set.contains(target);
}


import java.util.TreeSet;

public boolean searchInTreeSet(TreeSet<Integer> treeSet, int target) {
    return treeSet.contains(target);
}

