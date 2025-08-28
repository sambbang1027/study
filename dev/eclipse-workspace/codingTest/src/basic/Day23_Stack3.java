package basic;

import java.util.Scanner;
import java.util.Stack;

public class Day23_Stack3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();

            if (line.equals(".")) break; // 종료 조건

            Stack<Character> st = new Stack<>();
            boolean valid = true;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == '(' || c == '[') {
                    st.push(c);
                } else if (c == ')') {
                    if (st.isEmpty() || st.peek() != '(') {
                        valid = false;
                        break;
                    }
                    st.pop();
                } else if (c == ']') {
                    if (st.isEmpty() || st.peek() != '[') {
                        valid = false;
                        break;
                    }
                    st.pop();
                }
            }

            // 스택이 비어있어야 균형잡힌 상태
            if (valid && st.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
