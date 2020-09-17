class Solution {
    public String simplifyPath(String path) {
        if(path.isEmpty()) return path;
        Stack<String> stack = new Stack<>();
        for(String dir : path.split("/")) {
            if(dir.isEmpty() || dir.equals("."))
                continue;
            else if(dir.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(dir);
        }
        StringBuffer result = new StringBuffer();
        for(String dir : stack) {
            result.append("/");
            result.append(dir);  
        }
        return result.length() > 0 ? result.toString() : "/";
    }
}