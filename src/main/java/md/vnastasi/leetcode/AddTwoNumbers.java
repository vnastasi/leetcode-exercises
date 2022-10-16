package md.vnastasi.leetcode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    public static void run() {
        var l1 = ListNode.of(Console.readInt("Enter number for l1: "));
        var l2 = ListNode.of(Console.readInt("Enter number for l2: "));

        Console.write("l1: %s", l1);
        Console.write("l2: %s", l2);

        var result = nodeSum(l1, l2, 0);
        assert result != null;
        Console.write("Result: %s (%d)", result, result.toInt());
    }

    private static @Nullable ListNode nodeSum(@Nullable ListNode left, @Nullable ListNode right, int overflow) {
        var optionalLeft = Optional.ofNullable(left);
        var optionalRight = Optional.ofNullable(right);

        if (optionalLeft.isEmpty() && optionalRight.isEmpty() && overflow > 0) {
            return new ListNode(overflow);
        } else if (optionalLeft.isEmpty() && optionalRight.isEmpty()) {
            return null;
        }

        var sum = optionalLeft.map(ListNode::val).orElse(0) + optionalRight.map(ListNode::val).orElse(0) + overflow;
        var nextLeft = optionalLeft.map(ListNode::next).orElse(null);
        var nextRight = optionalRight.map(ListNode::next).orElse(null);

        return new ListNode(sum % 10, nodeSum(nextLeft, nextRight, sum / 10));
    }

    public static void main(String[] args) {
        run();
    }
}

record ListNode(int val, @Nullable ListNode next) {

    public ListNode(int val) {
        this(val, null);
    }

    public int toInt() {
        var list = collectAsList();
        Collections.reverse(list);
        String numberString = list.stream().map(String::valueOf).collect(Collectors.joining(""));
        return Integer.parseInt(numberString);
    }

    @Override
    public String toString() {
        return collectAsList().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private List<Integer> collectAsList() {
        var currentNode = this;
        var list = new ArrayList<Integer>();

        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }

        return list;
    }

    public static @NotNull ListNode of(int number) {
        var array = String.valueOf(number).toCharArray();
        ListNode node = null;
        for (char value : array) {
            node = new ListNode(Character.digit(value, 10), node);
        }

        assert node != null;

        return node;
    }
}
