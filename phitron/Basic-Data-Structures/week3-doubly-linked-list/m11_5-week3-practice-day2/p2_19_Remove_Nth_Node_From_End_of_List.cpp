class Solution {
public:
    int list_size(ListNode* head){
        ListNode* tmp = head;
        int cnt=0;
        while(tmp != NULL){
            cnt++;
            tmp=tmp->next;
        }
        return cnt;
    }

    void delete_at_head(ListNode* &head){
        ListNode* tmp = head;
        tmp = tmp->next;
        head = tmp;        
    }

    void delete_at_any(ListNode* head, int pos){
        ListNode* tmp = head;
        for(int i=1;i<pos;i++){
            tmp = tmp->next;
        }
        tmp->next = tmp->next->next;
    }

    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int size = list_size(head);
        int pos = size - n;
        if(pos == 0){
            delete_at_head(head);
        }else{
            delete_at_any(head, pos);
        }
        return head;
    }
};