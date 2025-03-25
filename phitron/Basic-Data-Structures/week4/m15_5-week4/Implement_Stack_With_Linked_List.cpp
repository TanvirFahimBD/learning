/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
            int data;
            Node *next;
            Node()
            {
                this->data = 0;
                next = NULL;
            }
            Node(int data)
            {
                this->data = data;
                this->next = NULL;
            }
            Node(int data, Node* next)
            {
                this->data = data;
                this->next = next;
            }
        };


*****************************************************************/

class Stack
{
    Node *topNode;
    int size;
public:
    Stack()
    {
        topNode = NULL;
        size = 0;
    }

    int getSize()
    {
        return size;
    }

    bool isEmpty()
    {
       return size == 0;
    }

    void push(int data)
    {
        Node* newNode = new Node(data);
        newNode->next = topNode;
        topNode=newNode;
        size++;
    }

    void pop()
    {
        if (isEmpty()) return;
        Node* temp = topNode;
        topNode = topNode->next;
        delete temp;
        size--;
    }

    int getTop()
    {
        if (isEmpty()) return -1;
        return topNode->data;
    }
};