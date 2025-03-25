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

void insert_at_head(Node* &head, Node* &tail, int val){
    Node* newNode = new Node(val);
    if(head == NULL){
        head = newNode;
        tail = newNode;
        return;
    }
    newNode->next = head;
    head = newNode;
}

void insert_at_any(Node* &head, Node* &tail, int val, int ind){
    Node* newNode = new Node(val);
    if(head == NULL){
        head = newNode;
        tail = newNode;
        return;
    }

    Node* temp = head;
    for (int i = 1; i < ind; i++)
    {
        temp = temp->next;
    }

    newNode->next = temp->next;
    temp->next = newNode;
}

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

void print_linked_list(Node* &head){
    Node* temp = head;

    while (temp != NULL)
    {
        cout << temp->val << " ";
        temp = temp->next;
    }

    cout << endl;
}

int count_linked_list(Node* &head){
    Node* temp = head;
    int cnt = 0;
    while (temp != NULL)
    {
        cnt++;
        temp = temp->next;
    }
    return cnt;
}

int main()
{
    Node* head = NULL;
    Node* tail = NULL;

    int val;
    while (true)
    {
        cin >> val;
        if(val == -1){
            break;
        }
        insert_at_tail(head, tail, val);
    }    
    // print_linked_list(head); 

    int ind, value;
    while(cin >> ind >> value){
        if(ind == 0){
            insert_at_head(head, tail, value);
            print_linked_list(head); 
        } 
        else if(count_linked_list(head) == ind){
            insert_at_tail(head, tail, value);
            print_linked_list(head); 
        }
        else if(ind>0 && count_linked_list(head)>= ind){
            insert_at_any(head, tail, value, ind);
            print_linked_list(head); 
        }else{
            cout << "Invalid" << endl;
        }
        // print_linked_list(head); 
        //outside length - invalid
    }    

    return 0;
}