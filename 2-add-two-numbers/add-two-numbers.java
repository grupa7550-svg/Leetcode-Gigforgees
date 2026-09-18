import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String s1 = "";
        String s2 = "";

        while (l1 != null) {
            s1 += l1.val;
            l1 = l1.next;
        }

        while (l2 != null) {
            s2 += l2.val;
            l2 = l2.next;
        }

        // Digits are reverse, so reverse them
        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();

        BigInteger n1 = new BigInteger(s1);
        BigInteger n2 = new BigInteger(s2);

        String result = n1.add(n2).toString();

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Result also needs to be reverse order
        for (int i = result.length() - 1; i >= 0; i--) {
            current.next = new ListNode(result.charAt(i) - '0');
            current = current.next;
        }

        return dummy.next;
    }
}