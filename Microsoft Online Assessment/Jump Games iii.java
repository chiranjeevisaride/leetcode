// Time O(n)
// Space O(n)
class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr != null || arr.length > 0 && start < arr.length) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.add(start);
            int len = arr.length;
            while(!queue.isEmpty()) {
                int index = queue.poll();
                if(arr[index] == 0) return true;
                if(visited.contains(index)) continue;
                visited.add(index);
                if(index + arr[index] < len)
                    queue.add(index + arr[index]);
                if(index - arr[index] >= 0)
                    queue.add(index - arr[index]);
            }
        }
        return false;
    }
}