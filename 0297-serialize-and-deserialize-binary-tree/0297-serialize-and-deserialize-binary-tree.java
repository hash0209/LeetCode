/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null){
            String s= "+";
            s=s.concat("$");
            return s;
        }
        StringBuilder s = new StringBuilder();
        s = serial(root , s);
        return s.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        int[] idx= new int[1];
        String[] str = data.split("#");
        return deserial(str , idx);

        
    }

    public StringBuilder serial(TreeNode root , StringBuilder path ){
        if(root == null){
            path.append("#");
            path.append("+");
            path.append("$");
            return path;
        }


        if(path.length() > 0){
            path.append("#");
        }

        if(root.val >=0){
            path.append("+");
        }
        
        path.append(root.val);

        path = serial(root.left , path);
        path = serial(root.right , path);
        return path;
    }

    public TreeNode deserial(String[] data , int[] idx ){


        if(idx[0]  >= data.length || data[idx[0]].charAt(1) == '$'){
            return null;
        }

       
        int value = Integer.parseInt( data[idx[0]]);

        

        TreeNode node = new TreeNode(value);

      
        idx[0] =idx[0]+1;
        node.left = deserial(data, idx );
         idx[0] =idx[0]+1;
        node.right = deserial(data, idx);

        return node ;




            
    }


}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));