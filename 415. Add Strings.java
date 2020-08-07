class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null && num2 == null) return null;
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int sum  = 0;
            if(i >= 0 && j >= 0) {
                sum = Character.getNumericValue(num1.charAt(i--)) + Character.getNumericValue(num2.charAt(j--));
            } else if (i >= 0) {
                 sum = Character.getNumericValue(num1.charAt(i--)); 
            } else if(j >= 0) {
                 sum = Character.getNumericValue(num2.charAt(j--)); 
            }
            res.append((carry + sum)%10); 
            carry = (carry + sum)/10;
        }
         if(carry > 0) {
             res.append(carry);
         }
         return res.reverse().toString();
    }
}