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
    // for (int i = 0; i < res; i++)
    // {
    //     cout << arr[i] << endl;
    // }
    
    int flag = 0;
    for (int i = 0; i < res; i++)
    {
        frqArr[arr[i]]++;
        if(frqArr[arr[i]] > 1){
            flag = 1;
            break;
        }
    }

    if(flag == 1){
        cout << "YES";
    }else{
        cout << "NO";
    }
    

    return 0;
}