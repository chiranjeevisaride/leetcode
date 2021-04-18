class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if(people == null || people.length < 0) return 0;
        int len = people.length, left = 0, right = len - 1, boats = 0;
        Arrays.sort(people);
        while(left <= right) {
            boats++;
            if(people[left] + people[right] <= limit) 
                left++;
            right--;  
        }
        return boats;
    }
}