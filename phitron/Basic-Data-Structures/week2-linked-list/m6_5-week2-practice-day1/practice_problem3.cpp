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

int print_linked_list(Node* &head){
    Node* temp = head;
    int cnt = 0;
    while (temp != NULL)
    {
        cnt++;
        temp = temp->next;
    }

    return cnt;
}

int get_spc_ind(Node* &head, int index, int size){
    Node* temp = head;
    for(int i=1; i<size; i++){
        temp = temp->next;
        if(i == index){
            cout << temp->val << " ";
        }
    }
}

int main()
{
    Node* head = NULL;
    Node* tail = NULL;

    int val, ind=0;
    int arr[102] = {0};
    int frqArr[102] = {0};
    while (true)
    {
        cin >> val;
        arr[ind] = val;
        ind++;
        if(val == -1){
            break;
        }
        insert_at_tail(head, tail, val);
    }    

    int res = print_linked_list(head);

    int ind1, ind2;
    if(res%2 == 1){
        ind1 = res/2;
        get_spc_ind(head, ind1, res);
    }else{
        ind1 = res/2;
        ind2 = ind1 - 1;
        get_spc_ind(head, ind2, res);        
        get_spc_ind(head, ind1, res);
    }   

    return 0;
}