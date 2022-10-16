import java.util.*;


class BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                
                level.add(cur.val);
                
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            
            result.add(level);
        }
        
        return result;
    }
}
