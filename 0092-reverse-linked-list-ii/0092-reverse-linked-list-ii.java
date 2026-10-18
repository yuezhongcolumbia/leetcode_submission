/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1.detach    
        // 2. reverse
        // 3. reattach
       
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        ListNode leftBridgeHead = dummy;
        ListNode rightBridgeHead = dummy;
        ListNode leftHead = dummy;
        ListNode rightHead = dummy;
        int idx = 0;
        
        while(cur != null){
            if (idx + 1 == left){
                leftBridgeHead = cur;
                leftHead = cur.next;
            }
            if (idx == right){
                rightHead = cur;
                rightBridgeHead = cur.next;    
            }
            cur = cur.next;
            idx++;
        }

        //reattach
        leftBridgeHead.next = reverse(leftHead, rightHead);
        leftHead.next = rightBridgeHead;
        return dummy.next;
    }

    public ListNode reverse(ListNode left, ListNode right){
        ListNode cur = left;
        ListNode curPrev = null;
        while(curPrev != right){
            ListNode tmp = cur.next;
            cur.next = curPrev;
            curPrev = cur;
            cur = tmp;
        }
        return curPrev;
    }
}