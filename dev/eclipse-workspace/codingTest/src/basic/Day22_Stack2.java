package basic;

import java.util.Scanner; 
import java.util.Stack;
/*올바른 괄호열을 VPS라고 할때
그 안에 올바른 괄호열을 넣어도 VPS이다
올바른 괄호열 x, y 가 접하여 xy가 되어도 vps이다
예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열
t번의 입력 데이터가 올바른 vps인지 확인하는 프로그램을 만들어라
결과는 "YES" / "NO" 로 표시한다
3
((
))
())(()
*
*/

public class Day22_Stack2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();

		for(int i = 0; i < t; i++) {
			String strs = sc.next();
			isVps(strs);
		}	
	}

	static void isVps(String strs) {
		
		Stack<Character> st = new Stack<>();
		
		for( int i = 0; i < strs.length(); i++) {
			char c = strs.charAt(i);
			
			if(c == '(' || st.empty()) {
				st.push(c);
			}else if(c == ')') {
				if(st.peek() == '(') {
					st.pop();
				}else {
					st.push(c);
				}
			}
		}
		if(st.empty()) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	} 
}
