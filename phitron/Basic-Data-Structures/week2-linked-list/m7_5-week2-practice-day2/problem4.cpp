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

void insert_at_tail(Node* &head, Node* &tail, int val){
    Node* newNode = new Node(val);
    if(head == NULL){
        head = newNode;
        tail = newNode;
        return;
    }

    tail->next = newNode;
    tail = newNode;
}


void print_linked_list(Node* head){
    Node* temp = head;
    while(temp != NULL){
        cout << temp->val << " ";
        temp = temp->next;
    }
}

void sort_desc(Node* head){
    Node* temp = head;
   for (Node* i = temp; i->next != NULL; i = i->next)
   {
    for (Node* j = i->next; j != NULL;  j=j->next)
    {
        if(i->val < j->val){
            swap(i->val, j->val);
        }
    }    
   }   
}

int main()
{
    Node* head1 = NULL;
    Node* tail1 = NULL; 

    int val;
    while(true){
        cin >> val;
        if(val == -1){
            break;
        }
        insert_at_tail(head1, tail1, val);
    }
    
    sort_desc(head1);
    print_linked_list(head1);
    return 0;
}