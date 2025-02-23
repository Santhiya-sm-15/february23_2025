class Solution {
    public TreeNode construct(int p1s,int p1e,int p2s,int p2e,int[] preorder,int[] postorder)
    {
        if(p1s>p1e)
            return null;
        if(p1s==p1e)
            return new TreeNode(preorder[p1s]);
        int l=preorder[p1s+1];
        int n=1;
        while(postorder[p2s+n-1]!=l)
            n++;
        TreeNode root=new TreeNode(preorder[p1s]);
        root.left=construct(p1s+1,p1s+n,p2s,p2e,preorder,postorder);      
        root.right=construct(p1s+n+1,p1e,p2s+n,p2e,preorder,postorder);
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int i,n=preorder.length;
        return construct(0,n-1,0,n-1,preorder,postorder);
    }
}