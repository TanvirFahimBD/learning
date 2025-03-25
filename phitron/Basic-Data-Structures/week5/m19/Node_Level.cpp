#include <bits/stdc++.h> 
/************************************************************

    Following is the TreeNode class structure

    template <typename T>
    class TreeNode {
       public:
        T val;
        bool isOriginal;
        TreeNode<T> *left;
        TreeNode<T> *right;
        
        TreeNode(T val) {
            this->val = val;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/
int findLevel(TreeNode<int>* root, int searchedValue, int level) {
    if (root == NULL) return 0; 
    if (root->val == searchedValue) return level;

    int left = findLevel(root->left, searchedValue, level + 1);
    if (left != 0) return left;

    return findLevel(root->right, searchedValue, level + 1);
}

int nodeLevel(TreeNode<int>* root, int searchedValue)
{
    return findLevel(root, searchedValue, 1);
}


