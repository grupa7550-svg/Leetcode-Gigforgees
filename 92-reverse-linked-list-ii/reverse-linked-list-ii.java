class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevLeft = dummy;

        for (int i = 1; i < left; i++) {
            prevLeft = prevLeft.next;
        }

        ListNode curr = prevLeft.next;
        ListNode prev = null;

        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode leftNode = prevLeft.next;

        prevLeft.next = prev;
        leftNode.next = curr;

        return dummy.next;
    }
}