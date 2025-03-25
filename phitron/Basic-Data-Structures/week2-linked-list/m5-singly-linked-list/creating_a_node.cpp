#include <bits/stdc++.h>
using namespace std;

class Node {
    public:
        int val;
        Node *next;

        Node(int val){
            this->val = val;
            this->next = NULL;
        }
};

int main()
{
    // Node a(10),b(310),c(510);
    // // a.val = 10;
    // // b.val = 20;
    // // c.val = 30;

    // a.next = &b;
    // b.next = &c;
    // // c.next = NULL;
    
    // // cout << a.val << endl; 
    // // cout << b.val <<endl; 
    // // cout << c.val << endl;
    
    // cout << a.val << endl; 
    // cout << a.next->val <<endl; 
    // cout << a.next->next->val << endl;

    Node* head = new Node(10);
    Node* a = new Node(20);
    Node* b = new Node(30);
    Node* c = new Node(700);

    head->next = a;
    a->next = b;
    b->next = c;

    // cout << head->val << endl;
    // cout << head->next->val << endl;
    // cout << head->next->next->val << endl;
    // cout << head->next->next->next->val << endl;

    Node* temp = head;
    while(temp != NULL){
        cout << temp->val << endl;
        temp = temp->next;
    }

    temp = head;
    while(temp != NULL){
        cout << temp->val << endl;
        temp = temp->next;
    }

    return 0;
}