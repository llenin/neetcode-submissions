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
        if(head == null || head.next == null){
            return head;
        }
        Stack<Integer> nums = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            nums.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while(!nums.isEmpty()){
            curr.val = nums.pop();
            curr = curr.next;
        }
        return head;
    }
}
