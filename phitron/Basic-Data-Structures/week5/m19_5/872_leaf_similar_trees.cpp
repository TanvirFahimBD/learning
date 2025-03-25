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
        void getLeafValues(TreeNode* root, vector<int>& leaves) {
            if (root == NULL) return;
            
            if (root->left == NULL && root->right == NULL) {
                leaves.push_back(root->val);
                return;
            }
            
            getLeafValues(root->left, leaves);
            getLeafValues(root->right, leaves);
        }
    
    
    
        bool leafSimilar(TreeNode* root1, TreeNode* root2) {
            vector<int> v1, v2;
            getLeafValues(root1, v1);
            getLeafValues(root2, v2);
            return v1 == v2;
        }
    };