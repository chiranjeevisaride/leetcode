class Solution {
    public List<Integer> findDisappearedNumbers(int[] input) {
        int i = 0;
        while(i < input.length) {
         int j = input[i] - 1;
         if(input[i] != input[j])
           swap(input, i, j);
          else
            i++;
        }

        System.out.println(Arrays.stream(input).boxed().collect(Collectors.toList()));
        List<Integer> list = new LinkedList<>();
        for(int index = 0; index < input.length; index++)
          if(input[index] != index + 1) 
            list.add(index + 1);

        return list;
    }
    
     private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
      }  
}