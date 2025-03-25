/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    public:
        bool isUnivalTree(TreeNode* root) {
            if(root == NULL)
                return true;
            return isUnivalTreeHelper(root, root->val);
        }
    
        bool isUnivalTreeHelper(TreeNode* root, int val){
            if(root == NULL)
                return true;
            if(val != root->val)
                return false;
            return isUnivalTreeHelper(root->left, val) && isUnivalTreeHelper(root->right, val);
        }
    };