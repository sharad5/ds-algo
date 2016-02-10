package sharad5.stack;

import java.util.EmptyStackException;
import java.util.Stack;

//Q11. Implement a stack which in addtion to push and pop, also performs min operation which returns the minimum element. All 3 operations must work in O(1) time.
public class StackWithMin {
	static class StackV2 extends Stack<Integer>{
		private Stack<Integer> minStack;
		
		public StackV2() {
			minStack = new Stack<>();
		}
		public Integer push(Integer a){
			super.push(a);
			if(minStack.isEmpty() || (int)a < (int)minStack.peek())
				minStack.push(a);
			return a;
		}
		public Integer pop(){
			Integer a = super.pop();
			if(a == minStack.peek()){
				minStack.pop();
			}
			return a;
		}
		public Integer min(){
			if(minStack.isEmpty())
				throw new EmptyStackException();
			return minStack.peek();
		}
		public String toString(){
			return super.toString() + " min = "+minStack.peek();
		}
	}
	public static void main(String[] args){
		StackV2 stack = new StackV2();
		//System.out.println(stack);
		stack.push(5);
		System.out.println(stack);
		stack.push(6);
		System.out.println(stack);
		stack.push(3);
		System.out.println(stack);
		stack.push(7);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		stack.push(1);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		System.out.println(stack.min());
	}
}
