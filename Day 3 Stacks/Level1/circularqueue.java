class circularqueue {
    static int tour(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0, curr_petrol = 0, total_surplus = 0;

        for (int i = 0; i < n; i++) {
            int diff = petrol[i] - distance[i];
            curr_petrol += diff;
            total_surplus += diff;
            if (curr_petrol < 0) {
                start = i + 1;
                curr_petrol = 0;
            }
        }

        return (total_surplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        System.out.println("Start at pump: " + tour(petrol, distance));
    }
}
