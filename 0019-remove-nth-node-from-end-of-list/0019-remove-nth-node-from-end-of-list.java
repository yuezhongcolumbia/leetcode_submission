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
        // how to find the fucker?   if I want to do one pass, I need to use some extra memory
        // use hashmap to remember the position
        // and delete
        // k -1 - (n - 1) = k - n for 0 indexed
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;   
        int idx = 0;
        while (cur != null){
            map.put(idx, cur);
            cur = cur.next;
            idx++;
        } 
        ListNode deleted = map.get(idx - n);
        if (idx - n - 1 < 0) return deleted.next;
        ListNode prev = map.get(idx - n - 1);
        prev.next = prev.next.next;
        return head;
        
    }
}