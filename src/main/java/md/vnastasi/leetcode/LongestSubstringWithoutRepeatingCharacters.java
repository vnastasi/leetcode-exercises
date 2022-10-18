package md.vnastasi.leetcode;

/*
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void run() {
        var string = Console.readString("Enter string");

        var currentSubstring = "";
        var longestSubstring = currentSubstring;

        for (var i = 0; i < string.length(); i++) {
            var c = String.valueOf(string.charAt(i));
            var index = currentSubstring.indexOf(c);
            if (index > -1) {
                if (currentSubstring.length() > longestSubstring.length()) {
                    longestSubstring = currentSubstring;
                }
                currentSubstring = currentSubstring.substring(index + 1);
            }
            currentSubstring += c;
        }

        Console.write("Longest substring is '%s'", longestSubstring);
    }

    public static void main(String[] args) {
        run();
    }
}
