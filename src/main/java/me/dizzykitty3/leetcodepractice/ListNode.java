package me.dizzykitty3.leetcodepractice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] vals) {
        this.val = vals[0];

        var length = vals.length;
        ListNode temp = null;
        for (int i = 1; i < length; i++) {
            var currentNode = new ListNode(vals[i]);
            if (i == 1) {
                this.next = currentNode;
                temp = currentNode;
            } else {
                temp.next = currentNode;
                temp = currentNode;
            }
        }
    }

    public static Object[] toArray(ListNode listNode) {
        var list = new ArrayList<Integer>(Collections.emptyList());
        list.add(listNode.val);
        while (listNode.next != null) {
            list.add(listNode.next.val);
            listNode = listNode.next;
        }
        return list.toArray();
    }
}