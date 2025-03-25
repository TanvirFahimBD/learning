#include <bits/stdc++.h>
using namespace std;

class Node {
    public:
        int val;
        Node *next;
        Node *prev;

        Node(int val){
            this->val = val;
            this->next = NULL;
            this->prev = NULL;
        }
};

void insert_at_tail(Node* &head, Node* &tail, int val){
    Node* newNode = new Node(val);   
    if(head == NULL){
        head = newNode;
        tail = newNode;
        return;
    }

    tail->next= newNode;
    newNode->prev=tail;
    tail = newNode;
}

void print_forward(Node* head){
    Node* temp = head;
    while(temp != NULL){
        cout << temp->val << " ";
        temp = temp->next;
    }
    cout << endl;
}

void reverse_linked_list(Node* head, Node* tail){
    for (Node *i = head, *j = tail; i != j && i->prev != j; i=i->next, j=j->prev)
    {
        swap(i->val, j->val);
    }
    
}

int main()
{
    Node* head = NULL;
    Node* tail = NULL;

    while (true)
    {
        int val;
        cin >> val;
        if(val == -1){
            break;
        }
        insert_at_tail(head, tail, val);
    }

    reverse_linked_list(head, tail);
    print_forward(head);

    return 0;
}