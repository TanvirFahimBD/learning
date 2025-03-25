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

void print_linked_list(Node* &head){
    Node* temp = head;
    int flag =0;
    while (temp->next != NULL)
    {
        if(temp->val > temp->next->val){
            flag =1;
            break;
        }
        temp = temp->next;
    }

    if(flag == 1){
        cout << "NO";
    }else{
        cout << "YES";
    }

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

    print_linked_list(head); 

    return 0;
}