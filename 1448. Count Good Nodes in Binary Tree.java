// 2nd Method Time = O(n) Space - O(1)
class Solution {
    
    private void helper(TreeNode node, int max, int[] res) {
        if(node == null) return;
        if(node.val >= max) 
            res[0]++;
         max = Math.max(max, node.val);
       helper(node.left, max, res); 
       helper(node.right, max, res);
    }
    
    int[] res = {0};
    
    public int goodNodes(TreeNode root) {
        helper(root, root.val, res);
        return res[0];
    }
}



// 1st method - Time = O(n), Space = O(n)

class NodeMetaData {
    TreeNode node;
    int maxValue;
    NodeMetaData(TreeNode node, int maxValue) {
        this.node = node;
        this.maxValue = maxValue;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        int count = 0;
        if(root == null) return count;
        Stack<NodeMetaData> stack = new Stack<>();
        stack.push(new NodeMetaData(root, root.val));
        while(!stack.isEmpty()) {
            NodeMetaData metaData = stack.pop();
            if(metaData.node.val >= metaData.maxValue)
                count++;
            if(metaData.node.left != null)
                stack.push(new NodeMetaData(metaData.node.left, 
                                            Math.max(metaData.node.val, metaData.maxValue)));
            if(metaData.node.right != null)
                stack.push(new NodeMetaData(metaData.node.right, 
                                            Math.max(metaData.node.val, metaData.maxValue)));
        }
        return count;
    }
}

