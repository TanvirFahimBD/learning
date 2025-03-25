#include <bits/stdc++.h> 
// Implement class for minStack.
class minStack
{
	// Write your code here.
	stack<int> st;
	stack<int> st2;
	public:
		
		// Constructor
		minStack() 
		{ 
			//return st2;
		}
		
		// Function to add another element equal to num at the top of stack.
		void push(int num)
		{
			st.push(num);
			if(st2.empty()){
				st2.push(num);
			}
			else if(st2.top()>=num){
				st2.push(num);
			}
		}


		// Function to remove the top element of the stack.
		int pop()
		{
			if(!st.empty()){
				if(st2.top() == st.top()){
					st2.pop();
				}
				int topElement = st.top();
				st.pop();
				return topElement;
			}else{
				return -1;
			}
		}
		
		// Function to return the top element of stack if it is present. Otherwise return -1.
		int top()
		{
			if(!st.empty()){
				return st.top();
			}else{
				return -1;
			}
		}
		
		// Function to return minimum element of stack if it is present. Otherwise return -1.
		int getMin()
		{
			if(!st.empty()){
				return st2.top();
			}else{
				return -1;
			}
		}
};