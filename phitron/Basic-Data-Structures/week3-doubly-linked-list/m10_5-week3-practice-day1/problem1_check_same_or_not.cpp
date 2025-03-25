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

int count(Node* head){
    Node* temp = head;
    int cnt = 0;
    while(temp != NULL){
        cnt++;
        temp = temp->next;
    }
    return cnt;
}

void same_check(Node* head, Node* head2){
    Node* temp = head;
    Node* temp2 = head2;
    bool flag = true;
    while(temp != NULL || temp2 != NULL){
        if(temp->val != temp2->val){
            flag = false;
            break;
        }
        temp = temp->next;
        temp2 = temp2->next;
    }
    
    if(flag == true){
        cout << "YES";
    }else{
        cout << "NO";
    }

}

int main()
{
    Node* head = NULL;
    Node* tail = NULL;

    Node* head2 = NULL;
    Node* tail2 = NULL;

    while (true)
    {
        int val;
        cin >> val;
        if(val == -1){
            break;
        }
        insert_at_tail(head, tail, val);
    }
    
    while (true)
    {
        int val;
        cin >> val;
        if(val == -1){
            break;
        }
        insert_at_tail(head2, tail2, val);
    }
    
    int res = count(head);
    int res2 = count(head2);

    if(res != res2){
        cout << "NO";
    }else{
        same_check(head, head2);
    }


    return 0;
}