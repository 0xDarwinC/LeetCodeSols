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
import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(-1);
        ListNode p = answer;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int num3 = -1;
        int carry = 0;

        while(p1 != null && p2 != null){
            num3 = (p1.val+p2.val+carry);
            if (num3 >= 10){
                carry = 1;
                num3 -= 10;
            }
            else carry = 0;
            p.next = new ListNode(num3);
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1 != null){
            num3 = p1.val+carry;
            if (num3 == 10){
                p.next = new ListNode(0);
                carry = 1;
                p1 = p1.next;
                p = p.next;
            }
            else{
                p.next = new ListNode(num3);
                carry = 0;
                p1 = p1.next;
                p = p.next;
            }
        }
        while(p2 != null){
            num3 = p2.val+carry;
            if (num3 == 10){
                p.next = new ListNode(0);
                carry = 1;
                p2 = p2.next;
                p = p.next;
            }
            else{
                p.next = new ListNode(num3);
                carry = 0;
                p2 = p2.next;
                p = p.next;
            }
        }
        if (carry == 1){
            p.next = new ListNode(1);
            p = p.next;
        }
        answer = answer.next;
        return answer;
    }
}

