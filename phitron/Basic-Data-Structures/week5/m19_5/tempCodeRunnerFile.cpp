rder(Node* root){
    queue<Node *> q;
    q.push(root);
    while(!q.empty()){
        Node *f = q.front();
        q.pop();

        cout << f->val << " ";

        if(f->left){
            q.push(f->left);
        }
        if(f->right){
            q.push(f->right);
        }
    }
}