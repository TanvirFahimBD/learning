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

void print_forward(Node* head){
    Node* temp = head;
    while(temp != NULL){
        cout << temp->val << " ";
        temp = temp->next;
    }
    cout << endl;
}

void insert_at_head(Node* &head, Node* &tail, int val){
    Node* newNode = new Node(val);   
    if(head == NULL){
        head = newNode;
        tail = newNode;
        return;
    }

    head->prev= newNode;
    newNode->next=head;
    head = newNode;
}

int main()
{
    // Node* head = new Node(10);
    // Node* a = new Node(20);
    // Node* tail = new Node(30);

    Node* head = NULL;
    Node* tail = NULL;

    insert_at_head(head, tail, 100);
    insert_at_head(head, tail, 300);
    print_forward(head);

    return 0;
}