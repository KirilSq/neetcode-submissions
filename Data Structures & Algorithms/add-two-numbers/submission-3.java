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
        ListNode result = new ListNode(0);
        ListNode resultCurr = result;
        int remainder = 0;
        do {
            int sum = l1.val + l2.val + remainder;
            remainder = 0;
            if(sum >= 10){
                remainder = sum / 10;
                sum %= 10;             
            }
            resultCurr.next = new ListNode(sum);
            resultCurr = resultCurr.next;
            l1 = l1.next;
            l2 = l2.next;
        }while(l1 != null && l2 != null);

        if(l1 != null || l2 != null){
            ListNode left = l1 != null ? l1 : l2;
            do{
                int value = left.val;
                if(remainder != 0) {
                    value+=remainder;
                    remainder = value / 10;
                    value %= 10;
                }
                resultCurr.next = new ListNode(value);
                resultCurr = resultCurr.next;
                left = left.next;
            }while(left != null);
        }

        if(remainder != 0){
            resultCurr.next = new ListNode(remainder);
        }

        return result.next;
    }
}
