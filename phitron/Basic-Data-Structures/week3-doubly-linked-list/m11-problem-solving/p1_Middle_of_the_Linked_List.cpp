class Solution {
public:
    int size(ListNode *head){
        ListNode *temp = head;
        int cnt=0;
        while(temp != NULL){
            cnt++;
            temp = temp->next;
        }
        return cnt;
    }

    ListNode* middleNode(ListNode* head) {
        int sz = size(head);
        ListNode* tmp = head;
        for(int i=1; i<=(sz/2);i++){
            tmp = tmp->next;
        }
        return tmp;
    }
};