// 3174. Clear Digits
public class Solution {
    public String clearDigits(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) && stack.length() > 0) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
