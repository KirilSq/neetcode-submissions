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
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }

        int indexToRemove = size - 1 - (n - 1);
        if(indexToRemove == 0) {
            return head.next;
        }
        int i = 0;
        curr = head;
        while(i < indexToRemove - 1){
            i++;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
