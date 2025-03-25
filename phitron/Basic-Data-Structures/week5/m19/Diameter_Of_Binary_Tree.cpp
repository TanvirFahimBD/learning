/************************************************************

    Following is the TreeNode class structure

    template <typename T>
    class TreeNode {
       public:
        T data;
        TreeNode<T> *left;
        TreeNode<T> *right;

        TreeNode(T data) {
            this->data = data;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/
int mx;
int max_height(TreeNode<int> *root){
    if(root == NULL) return 0;
    if(root->left == NULL && root->right == NULL) return 1;
    int l = max_height(root->left);
    int r = max_height(root->right);
    int m = l+r;
    mx = max(m, mx);
    return max(l,r)+1;
}

int diameterOfBinaryTree(TreeNode<int> *root){
	mx=0;
    int h = max_height(root);
    return mx;
}
