package Hw4_22000081_NguyenTienDat.Ex5;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class checkPalindrome {

    // Hàm kiểm tra chuỗi có phải là Palindrome không
    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Đưa các ký tự vào stack và queue
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) { // Bỏ qua các ký tự không phải chữ và số
                ch = Character.toLowerCase(ch);  // Chuẩn hóa về chữ thường
                stack.push(ch);
                queue.add(ch);
            }
        }

        // So sánh từng ký tự từ stack và queue
        while (!queue.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                return false; // Nếu có sự khác biệt, không phải Palindrome
            }
        }

        return true; // Nếu không có sự khác biệt, chuỗi là Palindrome
    }

    // Hàm chính để chạy chương trình
    public static void main(String[] args) {
//        String testString = "A man, a plan, a canal, Panama";
        String testString = "1231321";
        if (isPalindrome(testString)) {
            System.out.println("\"" + testString + "\" là chuỗi Palindrome.");
        } else {
            System.out.println("\"" + testString + "\" không phải là chuỗi Palindrome.");
        }
    }
}
