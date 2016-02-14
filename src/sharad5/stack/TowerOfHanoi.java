package sharad5.stack;

import java.util.Stack;

public class TowerOfHanoi {
	static class Tower extends Stack<Integer>{
		public char index;
		
		public Tower(char index) {
			this.index = index;
		}
		
		public char getIndex(){
			return index;
		}
	}
	public static void moveTop(Tower A, Tower B){
		System.out.println(A.getIndex()+" -> "+B.getIndex());
		int a = A.pop();
		B.push(a);
	}
	public static void towerOfHanoiSolution(int n, Tower A, Tower B, Tower C){
		if(n > 0){
			towerOfHanoiSolution(n-1, A, C, B);
			
			moveTop(A, C);
			
			towerOfHanoiSolution(n-1, B, A, C);
		}
	}
	public static void main(String[] args){
		Tower A=new Tower('A');
		Tower B=new Tower('B');
		Tower C=new Tower('C');
		
		int n = 3;
		for(int i=n;i>0;i--){
			A.push(i);
		}
		
		towerOfHanoiSolution(n, A, B, C);
	}
}
