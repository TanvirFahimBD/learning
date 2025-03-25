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

void reverse_doubly(Node* head, Node* tail){
    for (Node *i = head, *j=tail; i!= j && i->prev != j; i=i->next,j=j->prev)
    {
        swap(i->val, j->val);
    }
   
}

int main()
{
    Node* head = new Node(10);
    Node* a = new Node(20);
    Node* b = new Node(30);
    Node* c = new Node(40);
    Node* d = new Node(50);

    head->next = a;
    // a->prev = head;
    a->next = b;
    // b->prev = a;
    b->next = c;
    // c->prev = b;
    c->next = d;
    // d->prev = c;
    d->next = NULL;
    
    Node* slow = head;
    Node* fast = head;

    bool flag = false;
    while(fast!=NULL && fast->next != NULL){
        slow = slow->next;
        fast = fast->next->next;
        if(slow == fast){
            flag = true;
            break;
        }
    }

    if(flag == true)
        cout << "cycle detected";
    else
        cout << "cycle not detected";

    return 0;
}