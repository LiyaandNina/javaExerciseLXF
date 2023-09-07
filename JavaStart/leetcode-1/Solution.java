class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        System.out.println(hashtable);
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        var nums = new int[]{0, 1, 2, 3, 4};
        var target = 6;
        var result = twoSum(nums, target);
        System.out.println(result);
    }
}