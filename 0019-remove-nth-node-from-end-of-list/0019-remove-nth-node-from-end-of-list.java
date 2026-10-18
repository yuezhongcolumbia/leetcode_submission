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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1，2，3，4，5 n = 2
        // fast pointer is n + 1 node ahead
        // land on prev;
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i = 0; i < n + 1; i++){
            if (fast == null) break;
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;

        // edge case: [1] n = 1

        // dummy -> 1 -> null
        // slow          fast

        // dummy, 1,2,3,4,5  n =2
        // slow       f

        // [1,2] n = 1

        // dummy -> 1 -> null
        // s              f    

        


    }
}