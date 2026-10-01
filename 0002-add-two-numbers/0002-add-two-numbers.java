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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2,5 ->7
        // 4,6 -> 10, 0, carry  = 1
        // 3,4 -> 7, 1,  carry = 0,  

        // caculate sum = l1 + l2 + carry;
        // digit preserved = sum % 10;
        // carry = sum / 10

        // 999999
        // 1
        // 1. while loop condition
        // 2. one list is point to null.
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        dummy.next = cur;
        while (l1 != null || l2 != null || carry != 0){
            int digit1 = l1 == null ? 0 : l1.val;
            int digit2 = l2 == null ? 0 : l2.val;

            int sum = digit1 + digit2 + carry;
            int digitCur = sum % 10;
            carry = sum / 10;


            cur.next = new ListNode(digitCur);
            cur = cur.next;
            l1 = (l1!= null) ? l1.next : null;
            l2 = (l2!= null) ? l2.next : null;
            
        }
        return dummy.next;
    }
}