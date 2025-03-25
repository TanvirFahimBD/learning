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

void insert_at_any(Node* &head, Node* &tail, int val, int ind){
    Node* newNode = new Node(val);
    Node* temp  = head;
    for (int i = 1; i < ind; i++)
    {
        temp = temp->next;
    }    
   
    newNode->next=temp->next;
    temp->next->prev = newNode;
    temp->next = newNode;
    newNode->prev = temp;
}

void print_forward(Node* head){
    Node* temp = head;
    while(temp != NULL){
        cout << temp->val << " ";
        temp = temp->next;
    }
    cout << endl;
}

void print_backward(Node* tail){
    Node* temp = tail;
    while(temp != NULL){
        cout << temp->val << " ";
        temp = temp->prev;
    }
    cout << endl;
}

int count_total(Node* head){
    Node* temp = head;
    int count = 0;
    while(temp != NULL){
        count++;
        temp = temp->next;
    }
    return count;
}

int main()
{
    Node* head = NULL;
    Node* tail = NULL;

    int tc;
    cin >> tc;
    while (tc--)
    {
        int ind, val;
        cin >> ind >> val;
        if(val == -1){
            break;
        }

        int totalCnt = count_total(head);
        if(ind == 0){
            insert_at_head(head, tail, val);
            print_forward(head);
            print_backward(tail);
        }
        else if(ind == totalCnt){
            insert_at_tail(head, tail, val);
            print_forward(head);
            print_backward(tail);
        }
        else if(ind > totalCnt){
            cout << "Invalid" << endl;
        }
        else{
            insert_at_any(head, tail, val, ind);
            print_forward(head);
            print_backward(tail);
        }
    }
    return 0;
}