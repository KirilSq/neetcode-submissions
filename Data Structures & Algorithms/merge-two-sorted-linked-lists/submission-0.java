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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null) {
            return list1;
        }else if(list1.val < list2.val){
            mergeTwoListsHelper(list1.next, list2, list1);
            return list1;
        }else {
            mergeTwoListsHelper(list1, list2.next, list2);
            return list2;
        }
        
    }

    private void mergeTwoListsHelper(ListNode list1, ListNode list2, ListNode resultLast) {
        if(list1 == null){
            resultLast.next = list2;
            return;
        }else if(list2 == null) {
            resultLast.next = list1;
            return;
        }else if(list1.val < list2.val) {
            resultLast.next = list1;
            mergeTwoListsHelper(list1.next, list2, list1);
        }else {
            resultLast.next = list2;
            mergeTwoListsHelper(list1, list2.next, list2);
        }
    }
}