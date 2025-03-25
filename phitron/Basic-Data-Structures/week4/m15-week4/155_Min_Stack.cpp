class MinStack {
    public:
        stack<int> st;
        stack<int> st_min;
        MinStack() {
            
        }
        
        void push(int val) {
            st.push(val);
            if(st_min.empty()){
                st_min.push(val);
            }
            else if(st_min.top()>=val){
                st_min.push(val);
            }
        }
        
        void pop() {
            if(st_min.top() == st.top()){
                st_min.pop();
            }
            st.pop();
        }
        
        int top() {
            return st.top();
        }
        
        int getMin() {
            return st_min.top();
        }
    };
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack* obj = new MinStack();
     * obj->push(val);
     * obj->pop();
     * int param_3 = obj->top();
     * int param_4 = obj->getMin();
     */