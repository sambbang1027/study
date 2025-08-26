package basic;

import java.util.*;

/*
 * 정수를 저장하는 스택 
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top
 * */

public class Day21_Stack {
	static Stack<Integer> st = new Stack<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i ++) {
			String line = sc.next();
			order(line);
		}
	
	}
	
	private static void order(String line) {
		switch(line) {
			
			case "push" : {
				int n = sc.nextInt(); 
				st.push(n); 
				break;
				}
			case "pop" : {
				if(st.empty()) {
					System.out.println(-1);
				}else {
				System.out.println(st.pop());
				}
				break;
			}
			case "size" :{ System.out.println(st.size()); break;}
			case "empty" : {
				if(st.empty()) {System.out.println(1);}
				else {System.out.println(0);}
				break;
			}
			case "top" : {
				if(st.empty()) {System.out.println(-1);}
				else {System.out.println(st.peek());}
				break;
			}
		}
	}
	
	 

}
