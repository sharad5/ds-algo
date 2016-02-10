package sharad5.stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedParenthesis {
	public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	while( n--> 0){
		Stack<Character> stack = new Stack<>(); 	
		Boolean isBalanced = true;
		String s = br.readLine();
	    for(char c:s.toCharArray()){
            //System.out.println(c+" "+s);
	        if(c == '(' || c == '[' || c == '{')
	            stack.push(c);
	        else if(stack.isEmpty() && (c == ')' || c == '}' || c == ']'))
	            isBalanced = false;
	        else if((c == ')' && stack.pop() != '(') || (c == '}' && stack.pop() != '{') || (c == ']' && stack.pop() != '['))
	                isBalanced = false;
	        if(!isBalanced)
	            break;
	    }
	    if(!stack.isEmpty())
	        isBalanced = false;
	    if(isBalanced)
	        System.out.println("YES");
	    else
	        System.out.println("NO");
		}
	}
}