#include <bits/stdc++.h> 
queue<int> reverseElements(queue<int> q, int k)
{
    // 5 3
    // 1 2 3 4 5
    // 3 2 1 4 5

   stack<int> st;
   queue<int> q2;
   int i = 1;
   while(!q.empty() && k>=i){
       st.push(q.front());
       q.pop();
       i++;
   }

    while(!st.empty()){
        q2.push(st.top());
        st.pop();
    }

    while(!q.empty()){
       q2.push(q.front());
       q.pop();
    }

    return q2;

}
