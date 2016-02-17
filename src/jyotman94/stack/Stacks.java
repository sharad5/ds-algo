package jyotman94.stack;

import java.util.*;

public class Stacks {
	public static void main(String args[]){
		
	}
	
	//Q1
	public static boolean areParenthesesBalanced(String s){
		Stack<Character> stack = new Stack<>();
		if(s.length() % 2 == 1)
			return false;
		char ch, pop;
		for(int i = 0; i < s.length(); i++){
			ch = s.charAt(i);
			if(ch == '[' || ch == '(' || ch == '{')
				stack.push(ch);
			else if(!stack.isEmpty()){
				pop = stack.pop();
				if(!((ch == ']' && pop == '[') || (ch == ')' && pop == '(') || (ch == '}' && pop == '{')))
					return false;
			}
			else
				return false;
		}
		return true;
	}
}

//Q2

class MyStack{
	int array[], top, length, minStack[], topMin;

	public MyStack(int length) {
		top = -1;
		this.length = length;
		array = new int[length];
		minStack = new int[length];
		topMin = -1;
	}
	
	public void push(int a){
		array[++top] = a;
		if(topMin == -1 || a < minStack[topMin])
			minStack[++topMin] = a;
	}
	
	public int pop(){
		if(array[top] == minStack[topMin])
			topMin--;
		return array[top--];
	}
	
	public int min(){
		return minStack[topMin];
	}
}