class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < length; ++i) {
            queue.add(arr[i]);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = queue.poll();
        }
        return result;
    }
}