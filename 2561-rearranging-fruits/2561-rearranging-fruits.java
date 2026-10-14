import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = basket1.length;

        // Count all fruits in both baskets
        for (int val : basket1) freq.put(val, freq.getOrDefault(val, 0) + 1);
        for (int val : basket2) freq.put(val, freq.getOrDefault(val, 0) + 1);

        // If any fruit has odd total count, impossible
        for (int count : freq.values()) {
            if (count % 2 != 0) return -1;
        }

        // Map fruit to its differences
        Map<Integer, Integer> diff = new HashMap<>();
        for (int val : basket1) diff.put(val, diff.getOrDefault(val, 0) + 1);
        for (int val : basket2) diff.put(val, diff.getOrDefault(val, 0) - 1);

        List<Integer> swapList = new ArrayList<>();
        int minVal = Integer.MAX_VALUE;
        for (int key : diff.keySet()) {
            int cnt = Math.abs(diff.get(key));
            if (cnt > 0) {
                for (int i = 0; i < cnt / 2; i++) {
                    swapList.add(key);
                }
            }
            if (freq.containsKey(key)) {
                minVal = Math.min(minVal, key);
            }
        }

        Collections.sort(swapList);

        long cost = 0;
        int size = swapList.size();
        // Since every swap fixes 2 and each one must do half the changes
        for (int i = 0; i < size / 2; i++) {
            // cost for swap: min(between swap or double the global min value)
            cost += Math.min(swapList.get(i), minVal * 2);
        }
        return cost;
    }
}
