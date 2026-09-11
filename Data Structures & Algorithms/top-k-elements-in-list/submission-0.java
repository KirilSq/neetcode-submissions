class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] groupedByFrequency = new List[nums.length + 1];
        for (int key : occurrences.keySet()) {
            int frequency = occurrences.get(key);
            if (groupedByFrequency[frequency] == null) {
                groupedByFrequency[frequency] = new ArrayList<>();
            }
            groupedByFrequency[frequency].add(key);
        }

        int[] result = new int [k];
        int resultSize = 0;
        for (int i = groupedByFrequency.length - 1; i >= 0; i--) {
            List<Integer> currFreqList = groupedByFrequency[i];
            if(currFreqList == null) {
                continue;
            }
            for(int num : currFreqList) {
                result[resultSize++] = num;
                if(resultSize == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
