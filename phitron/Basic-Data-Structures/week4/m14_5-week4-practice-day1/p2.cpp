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

class myStack {
    public:
        Node* head = NULL;
        Node* tail = NULL;
        int sz = 0;

        void push(int val)
        {
            sz++;
            Node* newNode = new Node(val);
            if(head == NULL){
                head = newNode;
                tail = newNode;
                return;
            }
            tail->next = newNode;
            newNode->prev=tail;
            tail = newNode;
        }
        
        void pop()
        {
            sz--;
            Node* deleteNode = tail;
            tail = tail->prev;
            delete deleteNode;
            if(tail == NULL){
                head = NULL;
                return;
            }
            tail->next = NULL;
        }
        
        int top()
        {
            return tail->val;
        }
       
        int size()
        {
            return sz;
        }

        bool empty(){
           return head == NULL;
        }
};


class myQueue
{
    public: 
    Node* head = NULL;
    Node* tail = NULL;
    int sz = 0;

    void push(int val){
        sz++;
        Node* newnode = new Node(val);
        if(head == NULL){
            head = newnode;
            tail = newnode;
            return;
        }
        tail->next = newnode;
        newnode->prev = tail;
        tail = newnode;
    }

    void pop(){
        sz--;
        Node* deleteNode = head;
        head = head->next;
        delete deleteNode;

        if(head == NULL){
            tail = NULL;
            return;
        }
        head->prev = NULL;
    }

    int front(){
        return head->val;
    }

    int back(){
        return tail->val;
    }
    
    int size(){
        return sz;
    }

    bool empty(){
        return head == NULL;
    }
};

int main()
{
    myStack st1;
    myQueue q1;

    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        st1.push(x);
    }
    
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        q1.push(x);
    }
    
    if(st1.size() != q1.size()){
        cout << "NO" << endl;
    }else{
        bool flag = true;
        while(!st1.empty()){
            if(st1.top() != q1.front()){
                flag = false;
                break;
            }else{
                st1.pop();
                q1.pop();
            }
        }

        if(flag == false){
            cout << "NO" << endl;   
        }else{
            cout << "YES" << endl;   
        }
    }

    return 0;
}