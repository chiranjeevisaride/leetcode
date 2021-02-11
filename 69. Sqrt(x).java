class Solution {
    public int mySqrt(int x) {
        if(x == 1) return x;
        int start = 2, end = x;
        while(start <= end) {
            long mid = start + (end - start)/2;
            long sqrt = mid * mid;
            if(sqrt == x) return (int) mid;
            else if(sqrt > x)
                end = (int) mid - 1;
            else
                start = (int) mid + 1;
        }
        return end;
    }
}