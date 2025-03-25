#include <bits/stdc++.h> 
string kevinStackProblem(string &s)
{
	// Write your code here.
	stack<char> st;
	string str;
	for(char c: s){
		st.push(c);
	}

	while(!st.empty()){
		str += st.top();
		st.pop();
	}
	return str;
}
