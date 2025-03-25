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

int cnt_linked_list(Node* head){
    Node* temp = head;
    int cnt =0;
    while(temp != NULL){
        cnt++;
        temp = temp->next;
    }
    return cnt;
}

int main()
{
    Node* head1 = NULL;
    Node* tail1 = NULL; 
    Node* head2 = NULL;
    Node* tail2 = NULL; 

    int val;
    while(true){
        cin >> val;
        if(val == -1){
            break;
        }
        insert_at_tail(head1, tail1, val);
    }
    
    while(true){
        cin >> val;
        if(val == -1){
            break;
        }
        insert_at_tail(head2, tail2, val);
    }

    int cnt1 = cnt_linked_list(head1);
    int cnt2 = cnt_linked_list(head2);

    if(cnt1 == cnt2){
        cout << "YES" << endl;
    }
    else {
        cout << "NO" << endl;
    }
    
    return 0;
}