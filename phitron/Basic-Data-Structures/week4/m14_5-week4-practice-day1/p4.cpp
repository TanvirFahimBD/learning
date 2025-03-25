#include <bits/stdc++.h>
using namespace std;

int main()
{
    queue<int> q1, q2;
    stack<int> st;
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int x;
        cin >> x;
        q1.push(x);
    }
    
    while(!q1.empty()){
        st.push(q1.front());
        q1.pop();
    }
    
    while(!st.empty()){
        q2.push(st.top());
        st.pop();
    }    
    
    while(!q2.empty()){
        cout << q2.front() << " ";
        q2.pop();
    }    

    return 0;
}