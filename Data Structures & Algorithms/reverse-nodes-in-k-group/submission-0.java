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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode start = head;
        int counter = 0;
        while(curr != null){
            counter++;
            if(counter == k){
                ListNode temp = curr.next;
                reverseK(start, start.next, k-1);
                start.next = temp;
                prev.next = curr;
                counter = 0;
                prev = start;
                start = temp;
                curr = temp;
            }else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
    private void reverseK(ListNode reversed, ListNode toReverse, int k){
        if(k == 0) {
            return;
        }
        ListNode temp = toReverse.next;
        toReverse.next = reversed;
        reverseK(toReverse, temp, k - 1);
    }
    
}
