package sharad5.stack;

import java.util.Stack;

public class NextGreatestElement {
	public static void printNextLargest(int[] arr){
		Stack<Integer> stack = new Stack<>();
		if(arr.length <=1 )
			return;
		stack.push(arr[0]);
		for(int i=1;i < arr.length; i++){
			int curr = arr[i];
			while(!stack.isEmpty() && curr > stack.peek()){
				System.out.println(stack.pop() + " -> " + curr);
			}
			stack.push(curr);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop() + " -> -1");
		}
	}
	public static void main(String[] args){
		int[] arr = {1,2,4,3,5,6,7};
		printNextLargest(arr);
	}
}
