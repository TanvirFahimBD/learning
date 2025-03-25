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
        cout << temp->val << endl;
        temp = temp->next;
    }
}

int print_max_value(Node* head){
    Node* temp = head;
    int max = 0;
    while(temp != NULL){
        if(max <temp->val){
            max = temp->val;
        }
        temp = temp->next;
    }

    return max;
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
    
    int res = print_max_value(head1);
    cout << res << endl;
    return 0;
}