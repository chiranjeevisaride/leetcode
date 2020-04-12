class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length -1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++; right--;
        }
    }
}

// 2nd Approach
class Solution {
    public void reverseString(char[] s) {
        for(int i=0; i< s.length/2; i++){
             char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
}