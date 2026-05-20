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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        while(lists.length > 1){
            List<ListNode> tempList = new ArrayList<>();
            for(int i = 0; i < lists.length; i+=2){
                if(i + 1 >= lists.length){
                    tempList.add(lists[i]);
                } else{
                    ListNode l1 = lists[i];
                    ListNode l2 = lists[i + 1];
                    ListNode dummy = new ListNode();
                    ListNode tail = dummy;
                    while(l1 != null && l2 != null){
                        if(l1.val < l2.val){
                            tail.next = l1;
                            l1 = l1.next;
                        } else{
                            tail.next = l2;
                            l2 = l2.next;
                        }
                        tail = tail.next;
                    }
                    if(l1 != null){
                        tail.next = l1;
                    } else if(l2 != null){
                        tail.next = l2;
                    }
                    tempList.add(dummy.next);
                }
            }
            lists = tempList.toArray(new ListNode[0]);
        }
        return lists[0];
    }
}
