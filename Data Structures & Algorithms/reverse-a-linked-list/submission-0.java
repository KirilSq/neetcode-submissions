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
    public ListNode reverseList(ListNode head) {
       ListNode reversed = null;
       ListNode toReverse = head;

       while(toReverse != null){
        ListNode temp = toReverse.next;
        toReverse.next = reversed;
        reversed = toReverse;
        toReverse = temp;
       }

       return reversed;
    }

    
}
