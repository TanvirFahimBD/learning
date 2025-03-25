#include <bits/stdc++.h> 
stack<int> pushAtBottom(stack<int>& myStack, int x) 
{
    stack<int> st2;
    while(!myStack.empty()){
        st2.push(myStack.top());
        myStack.pop();
    }

    myStack.push(x);
    while(!st2.empty()){
        myStack.push(st2.top());
        st2.pop();
    }
   
    return myStack;
}
