#include <bits/stdc++.h> 
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
void getLeftViewHelper(TreeNode<int> *root, vector<int>& v, int level, int &maxLevel) {
    if (root == NULL) return; 

    // If this is the first node at this level, add it to the result
    if (level > maxLevel) {
        v.push_back(root->data);
        maxLevel = level;
    }

    // Recursive calls (Left first, then Right)
    getLeftViewHelper(root->left, v, level + 1, maxLevel);
    getLeftViewHelper(root->right, v, level + 1, maxLevel);
}

vector<int> getLeftView(TreeNode<int> *root) {
    vector<int> v;
    int maxLevel = -1; // Track the max level reached
    getLeftViewHelper(root, v, 0, maxLevel);
    return v;
}


