package sharad5.stack;

import java.util.Stack;

public class ReverseWithoutExtra {
	
	static class ModifiedStack extends Stack<Integer>{
		private void pushToBottom(int a){
			if(this.isEmpty()){
				this.push(a);
				return;
			}
			int temp = this.pop();
			this.pushToBottom(a);
			this.push(temp);
		}
		public void reverse(){
			if(this.isEmpty())
				return;
			int temp = this.pop();
			this.reverse();
			this.pushToBottom(temp);
		}
	}
	public static void main(String[] str){
		ModifiedStack stack = new ModifiedStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);
		stack.reverse();
		System.out.println(stack);
	}
}
