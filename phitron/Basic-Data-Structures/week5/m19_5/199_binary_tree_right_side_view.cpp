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
        void getRightSideView(TreeNode *root, vector<int>& v, int level, int &maxLevel) {
            if (root == NULL) return; 
    
            if (level > maxLevel) {
                v.push_back(root->val);
                maxLevel = level;
            }
    
            getRightSideView(root->right, v, level + 1, maxLevel);
            getRightSideView(root->left, v, level + 1, maxLevel);
        }
    
        vector<int> rightSideView(TreeNode* root) {
            vector<int> v;
            int maxLevel = -1;
            getRightSideView(root, v, 0, maxLevel);
            return v;
        }
    };