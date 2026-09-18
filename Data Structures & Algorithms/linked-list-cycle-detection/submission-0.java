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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }else {
            return hasCycleHelper(head, head.next.next);
        }
    }
    private boolean hasCycleHelper(ListNode slow, ListNode fast){
        if(fast == null || fast.next == null) {
            return false;
        }else if(fast.equals(slow)){
            return true;
        }else {
            return hasCycleHelper(slow.next, fast.next.next);
        }
    }
}
