package Hw4_22000081_NguyenTienDat.Ex1;
import java.util.Stack;

public class testStack {
    public static void main(String[] args) {
        String hoten = "NguyenTienDat";
        Stack s = stackName(hoten);
        System.out.println(joinStack(s));
    }

    public static Stack stackName(String hoten) {s
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0) {
                s.push(hoten.charAt(i));
            }
            if (i % 3 == 0) {
                s.pop();
            }
            System.out.println(s);
        }
        return s;
    }

    public static String joinStack(Stack s){
        StringBuilder sb = new StringBuilder();
        for (Object element : s) {
            sb.append(element);
        }

        return sb.toString();
    }
}
