#include <bits/stdc++.h>
class Node {
public:
    int data;
    Node* next;

    Node(int val) {
        data = val;
        next = NULL;
    }
};

class Queue {
private:
    Node* frontNode;
    Node* rearNode;
    int size;
public:
    Queue() {
        frontNode = NULL;
        rearNode = NULL;
        size = 0;
    }

    bool isEmpty() {
        return size == 0;
    }

    void enqueue(int data) {
        Node* newNode = new Node(data);
        if (rearNode == NULL) { // If queue is empty
            frontNode = rearNode = newNode;
        } else {
            rearNode->next = newNode;
            rearNode = newNode;
        }
        size++;
    }

    int dequeue() {
       if (isEmpty()) return -1;
        int frontData = frontNode->data;
        Node* temp = frontNode;
        frontNode = frontNode->next;
        if (frontNode == NULL) rearNode = NULL; // Queue becomes empty
        delete temp;
        size--;
        return frontData;
    }

    int front() {
        if (isEmpty()) return -1;
        return frontNode->data;
    }
};