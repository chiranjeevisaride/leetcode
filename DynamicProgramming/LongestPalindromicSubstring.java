class Solution {
  
  private static int lps(String str) {
    return lpsRec(str, 0, str.length()-1);
  }
  
  private static int lpsRec(String str, int startPtr, int endPtr) {
    if(startPtr > endPtr) return 0;
    if(startPtr == endPtr) return 1;
    else if(str.charAt(startPtr) == str.charAt(endPtr)) {
      int remainingStr = endPtr - startPtr - 1;
      if(remainingStr == lpsRec(str, startPtr + 1, endPtr - 1))
        return remainingStr + 2;
    }  
      int c1 = lpsRec(str, startPtr + 1, endPtr);
      int c2 = lpsRec(str, startPtr, endPtr - 1);
    return Math.max(c1,c2);
  }
  
  public static void main(String[] args) {
     System.out.println(lps("abdbca"));
     System.out.println(lps("aaaabbaa"));
  }
  
}
