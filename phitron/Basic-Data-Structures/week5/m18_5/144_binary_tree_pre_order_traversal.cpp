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
        vector<int> preorderTraversal(TreeNode* root) {
            vector<int> vec;
            preorderTraversalHelper(root, vec);
            return vec;
        }
    
        void preorderTraversalHelper(TreeNode* root, vector<int>& vec){
            if(root == NULL) return;
            vec.push_back(root->val);
            preorderTraversalHelper(root->left, vec);
            preorderTraversalHelper(root->right, vec);
        }
    };