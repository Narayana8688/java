class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number
        java.util.Map<Integer, Integer> countMap = new java.util.HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets of frequencies
        @SuppressWarnings("unchecked")
        java.util.List<Integer>[] bucket = new java.util.List[nums.length + 1];
        for (int key : countMap.keySet()) {
            int freq = countMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new java.util.ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // Step 3: Collect the top k elements
        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res[index++] = num;
                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return res;
    }
}
