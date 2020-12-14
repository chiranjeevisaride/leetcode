class Solution {
    public int findDuplicate(int[] input) {
        int i = 0;
        while(i < input.length) {
         int j = input[i] - 1;
         if(input[i] != input[j])
           swap(input, i, j);
          else
            i++;
        }

        System.out.println(Arrays.stream(input).boxed().collect(Collectors.toList()));
        for(int index = 0; index < input.length; index++)
          if(input[index] != index + 1)
            return input[index];
        return -1;
    }
    
    private void swap(int[] input, int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }  
}