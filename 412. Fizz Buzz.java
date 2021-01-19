class Solution {
    public List<String> fizzBuzz(int n) {
        if(n <= 0) return new ArrayList<String>();
        List<String> result = new ArrayList<>();
        for(int index = 1; index <= n; index++) {
            if(index%3 == 0 && index%5 == 0)
                result.add("FizzBuzz");
            else if(index%3 == 0)
                result.add("Fizz");
            else if(index%5 == 0)
                result.add("Buzz");
            else
                result.add(String.valueOf(index));
        }
        return result;
    }
}