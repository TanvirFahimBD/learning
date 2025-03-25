ListNode* tmp = head;
        if(tmp == NULL){
            return head;
        }
        while(tmp != NULL){
            if(tmp->val == val){
                if(tmp->next == NULL ){
                    tmp = NULL;
                }else if(tmp->next != NULL){
                    tmp->val = tmp->next->val;
                    tmp->next = tmp->next->next;   
                }
            }            
            else{
                tmp = tmp->next;
            }           
        }
        return head;