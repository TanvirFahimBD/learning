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

    ListNode* swapNodes(ListNode* head, int k) {
        int n = list_size(head);
        int nxtPos = n-k;

        ListNode* tmp1 = head;
        for(int i=1; i<k; i++){
            tmp1 = tmp1->next;
        }

        ListNode* tmp2 = head;
        for(int i=1; i<=nxtPos; i++){
            tmp2 = tmp2->next;
        }

        swap(tmp1->val, tmp2->val);

        return head;
    }
};