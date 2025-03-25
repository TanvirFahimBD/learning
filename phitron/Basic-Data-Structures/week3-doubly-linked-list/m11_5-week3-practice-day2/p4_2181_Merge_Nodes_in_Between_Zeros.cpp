class Solution {
public:
    ListNode* mergeNodes(ListNode* head) {
        ListNode* tmp = head->next;
        ListNode* tmp2 = new ListNode(0);
        ListNode* prev = tmp2;
        int sum=0;       
        while(tmp != NULL){
            if(tmp->val == 0){
                prev->next = new ListNode(sum);
                prev = prev->next;
                sum = 0;
            }
            else{
                sum += tmp->val;
            }      
            tmp = tmp->next;
        }
        return tmp2->next;
    }
};