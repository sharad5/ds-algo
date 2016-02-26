package jyotman94.stack;

import java.util.*;

public class Stacks {
	public static void main(String args[]) {

	}

	// Q1
	public static boolean areParenthesesBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		if (s.length() % 2 == 1)
			return false;
		char ch, pop;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (ch == '[' || ch == '(' || ch == '{')
				stack.push(ch);
			else if (!stack.isEmpty()) {
				pop = stack.pop();
				if (!((ch == ']' && pop == '[') || (ch == ')' && pop == '(') || (ch == '}' && pop == '{')))
					return false;
			} else
				return false;
		}
		return true;
	}

	// Q4
	public static void nextLargestEach(int array[]) {
		Stack<Integer> s = new Stack<>();
		s.push(array[0]);
		for (int i = 1; i < array.length; i++) {
			while (!s.isEmpty()) {
				if (s.peek() < array[i]) {
					System.out.println(s.pop() + " --> " + array[i]);
				} else
					break;
			}
			s.push(array[i]);
		}

		while (!s.isEmpty()) {
			System.out.println(s.pop() + " --> -1");
		}
	}

	// Q5
	public static void reverseStack(Stack<Integer> s) {
		int length = s.size() - 1;
		for (int i = 0; i < s.size() - 1; i++) {
			insertAtBottom(s, --length, s.pop());
		}
	}

	private static void insertAtBottom(Stack<Integer> s, int level, int element) {
		int temp = s.pop();
		if (level == 0)
			s.push(element);
		else
			insertAtBottom(s, level - 1, element);
		s.push(temp);
	}
	
	public static void printStack(Stack s){
		Stack ss = (Stack) s.clone();
		while(!ss.isEmpty())
			System.out.print(ss.pop() + " ");
		System.out.println();
	}
}

// Q2

class MyStack {
	int array[], top, length, minStack[], topMin;

	public MyStack(int length) {
		top = -1;
		this.length = length;
		array = new int[length];
		minStack = new int[length];
		topMin = -1;
	}

	public void push(int a) {
		array[++top] = a;
		if (topMin == -1 || a < minStack[topMin])
			minStack[++topMin] = a;
	}

	public int pop() {
		if (array[top] == minStack[topMin])
			topMin--;
		return array[top--];
	}

	public int min() {
		return minStack[topMin];
	}
}